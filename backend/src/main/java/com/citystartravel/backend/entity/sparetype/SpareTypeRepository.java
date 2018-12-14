package com.citystartravel.backend.entity.sparetype;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpareTypeRepository extends JpaRepository<SpareType, Long> {

    Optional<SpareType> findById(Long spareTypeId);

    List<SpareType> findByIdIn(List<Long> busIds);

    List<SpareType> findByIdIn(List<Long> busIds, Sort sort);

    SpareType getOne(Long aLong);
}
