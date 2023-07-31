package com.db.second.service;

import com.db.second.signals.Signals;
import org.springframework.stereotype.Service;

@Service
public interface ImplementationFactory {
     Signals createInstance(int signal);
}
