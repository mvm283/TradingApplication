package com.db.tradingapplication.signals.impl;

import com.db.tradingapplication.signals.General;
import com.db.tradingapplication.signals.Signals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("SignalAction3")
public class SignalAction3 extends General implements Signals {

    Logger logger = LoggerFactory.getLogger(SignalAction3.class);

    @Override
    public boolean handleSignal() {
       try {
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
        } catch (Exception e){
           logger.error(e.getMessage());
           throw e;
        }

       return true;
    }
}