package com.db.tradingapplication.signals.impl;

import com.db.tradingapplication.signals.General;
import com.db.tradingapplication.signals.Signals;
import org.springframework.stereotype.Component;

@Component("SignalAction3")
public class SignalAction3 extends General implements Signals {
    @Override
    public boolean handleSignal() {
       try {
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
        } catch (RuntimeException e){
            return false;
        }

       return true;
    }
}