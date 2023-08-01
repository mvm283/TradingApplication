package com.db.tradingapplication.controller;

import com.db.tradingapplication.service.ImplementationFactory;
import com.db.tradingapplication.signals.Signals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value ="api/v1/")
public class TradingApplicationController {
    Logger logger = LoggerFactory.getLogger(TradingApplicationController.class);
    private final ImplementationFactory implementationFactory;

    public TradingApplicationController(ImplementationFactory implementationFactory) {
        this.implementationFactory = implementationFactory;
    }

    @GetMapping("signal/{signal}")
    public ResponseEntity<?> handleSignal(@PathVariable("signal") int signal) {

        Signals implementation = implementationFactory.createInstance(signal);

        if(implementation==null){
            logger.error("Signal " + signal + " has not been implemented");
            return new ResponseEntity<>("Signal " + signal + " has not been implemented", HttpStatus.BAD_REQUEST);
        }

        implementation.handleSignal();

        logger.info("Signal " + signal + " processed successfully");
        return new ResponseEntity<>("Signal " + signal + " processed successfully", HttpStatus.OK);
    }
}