package com.renan.hrworker.repositories;

import com.renan.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepositorie extends JpaRepository<Worker, Long> {
}
