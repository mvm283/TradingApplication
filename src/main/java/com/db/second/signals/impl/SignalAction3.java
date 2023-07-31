package com.db.second.signals.impl;

import com.db.second.algo.Algo;
import com.db.second.signals.Signals;
import org.springframework.stereotype.Component;

@Component
public class SignalAction3 implements Signals {
    public Algo algo = new Algo();
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