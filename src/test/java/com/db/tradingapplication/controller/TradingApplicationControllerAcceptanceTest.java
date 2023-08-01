package com.db.tradingapplication.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TradingApplicationControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void handelSignalTestSuccessfullSignalRun() throws Exception {
        int signalNumber=1;

        mockMvc.perform(get("/api/v1/signal/"+signalNumber))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.equalTo("Signal 1 processed successfully")));

    }
    @Test
    public void handelSignalTestUnimplementedSignalNumber() throws Exception {
        int unimplementedSignalNumber=10000;

        mockMvc.perform(get("/api/v1/signal/"+unimplementedSignalNumber))
                .andExpect(content().string(Matchers.equalTo(
                        "No bean named 'There is no implementation for the Signal number : "+unimplementedSignalNumber+"' available")));

    }


}