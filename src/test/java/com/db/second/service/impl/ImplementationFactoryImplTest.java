package com.db.second.service.impl;

import com.db.second.service.ImplementationFactory;
import com.db.second.signals.Signals;
import com.db.second.signals.impl.SignalAction;
import com.db.second.signals.impl.SignalAction1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import static org.mockito.Mockito.*;

public class ImplementationFactoryImplTest {

    private ImplementationFactory implementationFactory;
    private ApplicationContext mockApplicationContext;

    @BeforeEach
    public void setUp() {
        mockApplicationContext = mock(ApplicationContext.class);
        implementationFactory = new ImplementationFactoryImpl(mockApplicationContext);
    }

    @Test
    public void testCreateInstance_Success() {
        int signalNumber = 1;
        String className = SignalAction.class.getSimpleName() + signalNumber;
        Signals mockSignal = mock(SignalAction1.class);

        when(mockApplicationContext.getBean(className, Signals.class)).thenReturn(mockSignal);

        Signals result = implementationFactory.createInstance(signalNumber);

        Assertions.assertInstanceOf( SignalAction1.class,result);
    }


    @Test
    public void testCreateInstance_NoImplementation() {
        int signalNumber = 1;

        when(mockApplicationContext.getBean(any(), eq(Signals.class))).thenThrow(new RuntimeException());

        Assertions.assertThrows(RuntimeException.class, ()->
                implementationFactory.createInstance(signalNumber)
        );

    }
}
