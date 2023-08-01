package com.db.tradingapplication.signals.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SignalActionTest {

    @InjectMocks
    private SignalAction signalAction;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void handleSignalTest(){
        Assertions.assertTrue(signalAction.handleSignal());
    }

}