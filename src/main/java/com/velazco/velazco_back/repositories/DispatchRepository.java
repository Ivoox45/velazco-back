package com.velazco.velazco_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.velazco.velazco_back.model.Dispatch;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
}