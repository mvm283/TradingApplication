package com.db.second.signals.impl;

import com.db.second.signals.Signals;
import org.springframework.stereotype.Component;

@Component
public class SignalAction implements Signals {

    @Override
    public boolean handleSignal() {
        return true;
    }
}