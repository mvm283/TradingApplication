package com.db.tradingapplication.controller;

import com.db.tradingapplication.service.SignalProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value ="api/v1/")
public class TradingApplicationController {
    Logger logger = LoggerFactory.getLogger(TradingApplicationController.class);
    private final SignalProcessorService signalProcessor;

    public TradingApplicationController(SignalProcessorService signalProcessor) {
        this.signalProcessor = signalProcessor;
    }

    @GetMapping("signal/{signal}")
    public ResponseEntity<?> handleSignal(@PathVariable("signal") int signal) {

        if (!signalProcessor.process(signal)){
            throw new RuntimeException("signal processing has failed");
        }
        return new ResponseEntity<>("Signal " + signal + " processed successfully", HttpStatus.OK);
    }


}