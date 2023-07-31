package com.db.tradingapplication.signals.impl;

import com.db.tradingapplication.signals.General;
import com.db.tradingapplication.signals.Signals;
import org.springframework.stereotype.Component;

@Component("SignalAction")
public class SignalAction extends General implements Signals {
    @Override
    public boolean handleSignal() {
        return true;
    }
}