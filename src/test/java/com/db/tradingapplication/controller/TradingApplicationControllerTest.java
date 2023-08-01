package com.db.tradingapplication.controller;

import com.db.tradingapplication.service.SignalProcessorService;
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
    private SignalProcessorService signalProcessorService;

    @InjectMocks
    private TradingApplicationController tradingApplicationController;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void handelSignalTestSuccessfullSignalRun(){
        int signalNumber=1;

        when(signalProcessorService.process(signalNumber)).thenReturn(true);

        ResponseEntity<?> responseEntity = tradingApplicationController.handleSignal(signalNumber);

        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    @Test
    public void handelSignalTest_UnSuccessfullSignalRun(){
        int signalNumber=1;

        when(signalProcessorService.process(signalNumber)).thenReturn(false);

        Assertions.assertThrows(RuntimeException.class, ()->
                        tradingApplicationController.handleSignal(signalNumber)
        );
    }
}