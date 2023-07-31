package com.db.second.signals.impl;

import com.db.second.algo.Algo;
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

    @BeforeEach
    public void setUp() {

    }
    @Test
    public void handleSignalTestSuccessfull(){
        Assertions.assertTrue(signalAction.handleSignal());
    }

    @Test
    public void handleSignalTestUnSuccessfull()  {

        doThrow(new RuntimeException()).when(algo).reverse();
        Assertions.assertFalse(signalAction.handleSignal());
    }

}