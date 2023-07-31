package com.db.tradingapplication.signals.impl;

import com.db.tradingapplication.signals.General;
import com.db.tradingapplication.signals.Signals;
import org.springframework.stereotype.Component;

@Component("SignalAction2")
public class SignalAction2 extends General implements Signals {
    @Override
    public boolean handleSignal() {
        try {
            algo.reverse();
            algo.setAlgoParam(1,80);
            algo.submitToMarket();
        } catch (RuntimeException e){
            return false;
        }
            return true;
    }
}