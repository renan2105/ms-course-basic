package com.renan.hrpayroll.services;

import com.renan.hrpayroll.entities.Payment;
import com.renan.hrpayroll.entities.Worker;
import com.renan.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findWorkerById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);

    }
}
