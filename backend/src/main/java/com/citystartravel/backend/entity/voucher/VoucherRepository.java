package com.citystartravel.backend.entity.voucher;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    Optional<Voucher> findById(Long id);

    List<Voucher> findByIdIn(List<Long> id);

    List<Voucher> findByIdIn(List<Long> id, Sort sort);
}
