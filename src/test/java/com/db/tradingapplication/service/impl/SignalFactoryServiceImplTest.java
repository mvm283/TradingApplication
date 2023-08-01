package com.db.tradingapplication.service.impl;

import com.db.tradingapplication.service.SignalFactoryService;
import com.db.tradingapplication.signals.Signals;
import com.db.tradingapplication.signals.impl.SignalAction;
import com.db.tradingapplication.signals.impl.SignalAction1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import static org.mockito.Mockito.*;

public class SignalFactoryServiceImplTest {

    @InjectMocks
    private SignalFactoryServiceImpl signalFactory;

    private ApplicationContext mockApplicationContext;

    @BeforeEach
    public void setUp() {
        mockApplicationContext = mock(ApplicationContext.class);
        signalFactory = new SignalFactoryServiceImpl(mockApplicationContext);
    }

    @Test
    public void testGetInstance_Success() {
        int signalNumber = 1;
        String className = SignalAction.class.getSimpleName() + signalNumber;
        Signals mockSignal = mock(SignalAction1.class);

        when(mockApplicationContext.getBean(className, Signals.class)).thenReturn(mockSignal);

        Signals result = signalFactory.getInstance(signalNumber);

        Assertions.assertInstanceOf( SignalAction1.class,result);
    }
    @Test
    public void testGetInstance_NoImplementation() {
        int signalNumber = 1;

        when(mockApplicationContext.getBean(any(), eq(Signals.class))).thenThrow(new NoSuchBeanDefinitionException(String.valueOf(signalNumber)));

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()->
                signalFactory.getInstance(signalNumber)
        );
    }
    @Test
    public void testGetInstance_NullBean() {
        int signalNumber = 1;

        when(mockApplicationContext.getBean(any(), eq(Signals.class))).thenReturn(null);

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()->
                signalFactory.getInstance(signalNumber)
        );
    }
}
