package com.db.tradingapplication.service.impl;

import com.db.tradingapplication.service.SignalFactoryService;
import com.db.tradingapplication.service.SignalProcessorService;
import com.db.tradingapplication.signals.Signals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SignalProcessorServiceImpl implements SignalProcessorService {
    Logger logger = LoggerFactory.getLogger(SignalProcessorServiceImpl.class);
    private final SignalFactoryService signalFactory;

    public SignalProcessorServiceImpl(SignalFactoryService signalFactory) {
        this.signalFactory = signalFactory;
    }

    @Override
    public boolean process(int signal) {
        Signals instance = signalFactory.getInstance(signal);
        instance.handleSignal();
        logger.info("Signal " + signal + " processed successfully");
        return true;
    }
}
