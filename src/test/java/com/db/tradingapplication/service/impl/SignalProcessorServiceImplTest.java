package com.db.tradingapplication.service.impl;

import com.db.tradingapplication.service.SignalFactoryService;
import com.db.tradingapplication.signals.Signals;
import com.db.tradingapplication.signals.impl.SignalAction1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class SignalProcessorServiceImplTest {

    @Mock
    private SignalFactoryService signalFactory;
    @InjectMocks
    private SignalProcessorServiceImpl signalProcessorService;

    @BeforeEach
    public void setUp(){

    }
    @Test
    public void testProcess_Success() {
        int signalNumber = 1;
        Signals mockSignal = mock(SignalAction1.class);

        when(signalFactory.getInstance(signalNumber)).thenReturn(mockSignal);

        boolean result = signalProcessorService.process(signalNumber);

        Assertions.assertTrue(result);
    }

}
