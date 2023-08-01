package com.db.tradingapplication.signals.impl;

import com.db.tradingapplication.signals.General;
import com.db.tradingapplication.signals.Signals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("SignalAction2")
public class SignalAction2 extends General implements Signals {

    Logger logger = LoggerFactory.getLogger(SignalAction2.class);
    @Override
    public boolean handleSignal() {
        try {
            algo.reverse();
            algo.setAlgoParam(1,80);
            algo.submitToMarket();
        } catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
            return true;
    }
}