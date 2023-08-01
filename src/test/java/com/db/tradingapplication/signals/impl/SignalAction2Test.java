package com.db.tradingapplication.signals.impl;

import com.db.tradingapplication.algo.Algo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.doThrow;

@SpringBootTest
class SignalAction2Test {

    @Mock
    private Algo algo;
    @InjectMocks
    private SignalAction2 signalAction;

    @Test
    public void handleSignalTestSuccessfull(){
        Assertions.assertTrue(signalAction.handleSignal());
    }

    @Test
    public void handleSignalTestUnSuccessfull()  {

        doThrow(new RuntimeException()).when(algo).reverse();
        Assertions.assertThrows(Exception.class,()->
            signalAction.handleSignal()
        );
    }

}