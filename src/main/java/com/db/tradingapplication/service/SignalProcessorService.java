package com.db.tradingapplication.service;

import org.springframework.stereotype.Service;

@Service
public interface SignalProcessorService {
    boolean process(int signal);

}
