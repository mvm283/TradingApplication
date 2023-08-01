package com.db.tradingapplication.controller;

import com.db.tradingapplication.service.SignalProcessorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class TradingApplicationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SignalProcessorService signalProcessorService;


    @Test
    public void handelSignalTestSuccessfullSignalRun() throws Exception {
        int signalNumber=1;

        when(signalProcessorService.process(signalNumber)).thenReturn(true);

        mockMvc.perform(get("/api/v1/signal/"+signalNumber))
                .andExpect(status().isOk());

        verify(signalProcessorService).process(signalNumber);
    }
    @Test
    public void handelSignalTestUnSuccessfullSignalRun() throws Exception {
        int signalNumber=1;

        when(signalProcessorService.process(signalNumber)).thenReturn(false);

        mockMvc.perform(get("/api/v1/signal/"+signalNumber))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof RuntimeException));

        verify(signalProcessorService).process(signalNumber);
    }


}