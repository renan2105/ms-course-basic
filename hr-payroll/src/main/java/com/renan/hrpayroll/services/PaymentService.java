package com.renan.hrpayroll.services;

import com.renan.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){

        return new Payment("Renan", 200.0, days);

    }
}
