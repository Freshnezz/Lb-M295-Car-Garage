package com.wiss.cargarage.repository;

import com.wiss.cargarage.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Integer> {
}

