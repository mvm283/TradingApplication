package com.db.second.controller;

import com.db.second.service.ImplementationFactory;
import com.db.second.signals.impl.SignalAction1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.when;

@SpringBootTest
class TradingApplicationControllerTest {

    @Mock
    private ImplementationFactory implementationFactory;

    @InjectMocks
    private TradingApplicationController tradingApplicationController;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void handelSignalTestSuccessfullSignalRun(){
        int signalNumber=1;

        when(implementationFactory.createInstance(signalNumber)).thenReturn(new SignalAction1());

        ResponseEntity<?> responseEntity = tradingApplicationController.handleSignal(signalNumber);

        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        Assertions.assertEquals("Signal " + signalNumber + " processed successfully",responseEntity.getBody());
    }

    @Test
    public void handelSignalTestUnimplementedSignalNumber(){
        int signalNumber=1;
        int unimplementedSignalNumber=10000000;

        when(implementationFactory.createInstance(signalNumber)).thenReturn(new SignalAction1());

        ResponseEntity<?> responseEntity = tradingApplicationController.handleSignal(unimplementedSignalNumber);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
        Assertions.assertEquals("Signal " + unimplementedSignalNumber + " has not been implemented",responseEntity.getBody());
    }
}