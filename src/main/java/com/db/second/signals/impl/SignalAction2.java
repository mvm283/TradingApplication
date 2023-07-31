package com.db.second.signals.impl;

import com.db.second.signals.General;
import com.db.second.signals.Signals;
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