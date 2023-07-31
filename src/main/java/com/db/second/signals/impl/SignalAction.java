package com.db.second.signals.impl;

import com.db.second.signals.General;
import com.db.second.signals.Signals;
import org.springframework.stereotype.Component;

@Component("SignalAction")
public class SignalAction extends General implements Signals {
    @Override
    public boolean handleSignal() {
        return true;
    }
}