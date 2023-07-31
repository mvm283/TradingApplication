package com.db.tradingapplication.signals.impl;

import com.db.tradingapplication.algo.Algo;
import com.db.tradingapplication.signals.General;
import com.db.tradingapplication.signals.Signals;
import org.springframework.stereotype.Component;

@Component("SignalAction1")
public class SignalAction1 extends General implements Signals {
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