package com.db.tradingapplication.service;

import com.db.tradingapplication.signals.Signals;
import org.springframework.stereotype.Service;

@Service
public interface ImplementationFactory {
     Signals createInstance(int signal);
}
