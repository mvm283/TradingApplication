package com.db.tradingapplication.controller;

import com.db.tradingapplication.service.ImplementationFactory;
import com.db.tradingapplication.signals.impl.SignalAction1;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class TradingApplicationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ImplementationFactory implementationFactory;


    @Test
    public void handelSignalTestSuccessfullSignalRun() throws Exception {
        int signalNumber=1;

        when(implementationFactory.createInstance(signalNumber)).thenReturn(new SignalAction1());

        mockMvc.perform(get("/api/v1/signal/"+signalNumber))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.equalTo("Signal 1 processed successfully")));

        verify(implementationFactory).createInstance(signalNumber);
    }
    @Test
    public void handelSignalTestUnimplementedSignalNumber() throws Exception {
        int unimplementedSignalNumber=10000;

        when(implementationFactory.createInstance(unimplementedSignalNumber)).thenReturn(null);

        mockMvc.perform(get("/api/v1/signal/"+unimplementedSignalNumber))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.equalTo("Signal " + unimplementedSignalNumber + " has not been implemented")));

        verify(implementationFactory).createInstance(unimplementedSignalNumber);
    }


}