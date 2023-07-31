package com.db.second.signals.impl;

import com.db.second.algo.Algo;
import com.db.second.signals.Signals;
import org.springframework.stereotype.Component;

@Component
public class SignalAction1 implements Signals {
    public Algo algo = new Algo();
    @Override
    public boolean handleSignal() {
        try {
            algo.setUp();
            algo.setAlgoParam(1, 60);
            algo.performCalc();
            algo.submitToMarket();
        } catch (RuntimeException e){
            return false;
        }
        return true;
    }
}