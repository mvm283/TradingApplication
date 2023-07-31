package com.db.second.service.impl;

import com.db.second.service.ImplementationFactory;
import com.db.second.signals.Signals;
import com.db.second.signals.impl.SignalAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ImplementationFactoryImpl implements ImplementationFactory {
    private final ApplicationContext context;

    @Autowired
    public ImplementationFactoryImpl(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Signals createInstance(int signalNumber) {
        String className= SignalAction.class.getSimpleName()+signalNumber;
        try {
            return context.getBean(className, Signals.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is no implementation for the Signal number : " +signalNumber);
        }
    }
}
