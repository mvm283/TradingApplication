package com.db.tradingapplication.signals.impl;

import com.db.tradingapplication.signals.General;
import com.db.tradingapplication.signals.Signals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("SignalAction1")
public class SignalAction1 extends General implements Signals {

    Logger logger = LoggerFactory.getLogger(SignalAction1.class);
    @Override
    public boolean handleSignal() {
        try {
            algo.setUp();
            algo.setAlgoParam(1, 60);
            algo.performCalc();
            algo.submitToMarket();
        } catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return true;
    }
}