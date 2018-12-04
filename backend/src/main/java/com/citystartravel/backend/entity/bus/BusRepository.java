package com.citystartravel.backend.entity.bus;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    
    Optional<Bus> findById(Long busId);

    List<Bus> findByIdIn(List<Long> busIds);

    List<Bus> findByIdIn(List<Long> busIds, Sort sort);
}
