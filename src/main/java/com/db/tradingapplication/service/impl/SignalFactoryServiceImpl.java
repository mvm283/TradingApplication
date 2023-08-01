package com.db.tradingapplication.service.impl;

import com.db.tradingapplication.service.SignalFactoryService;
import com.db.tradingapplication.signals.Signals;
import com.db.tradingapplication.signals.impl.SignalAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SignalFactoryServiceImpl implements SignalFactoryService {
    Logger logger = LoggerFactory.getLogger(SignalFactoryServiceImpl.class);
    private final ApplicationContext context;

    @Autowired
    public SignalFactoryServiceImpl(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Signals getInstance(int signalNumber) {
        String erroMessage = "There is no implementation for the Signal number : " + signalNumber;
        String className= SignalAction.class.getSimpleName()+signalNumber;

        try {
            logger.info("getting signal processor");
            Signals bean = context.getBean(className, Signals.class);

            if(bean==null) {
                throw new NoSuchBeanDefinitionException(erroMessage);
            }

            logger.info("getting signal processor has done");
            return bean;
        }
        catch (NoSuchBeanDefinitionException e) {
            throw new NoSuchBeanDefinitionException(erroMessage);
        }
    }
}
