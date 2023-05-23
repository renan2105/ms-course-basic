package com.renan.hrworker.controller;

import com.renan.hrworker.entities.Worker;
import com.renan.hrworker.repositories.WorkerRepositorie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepositorie workerRepositorie;


    @GetMapping
    public ResponseEntity<List<Worker>> listAllWorker(){
        List<Worker> workerList = workerRepositorie.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findWorkerById(@PathVariable Long id){

        /*
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */

        logger.info("PORT = " + environment.getProperty("local.server.port"));

        Worker worker = workerRepositorie.findById(id).get();
        return ResponseEntity.ok(worker);
    }

}
