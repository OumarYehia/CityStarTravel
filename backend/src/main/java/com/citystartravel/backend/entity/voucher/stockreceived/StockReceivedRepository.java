package com.citystartravel.backend.entity.voucher.purchaserequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {

    Optional<PurchaseRequest> findById(Long purchaseRequestVoucherId);

    List<PurchaseRequest> findByIdIn(List<Long> purchaseRequestVoucherId);

    List<PurchaseRequest> findByIdIn(List<Long> purchaseRequestVoucherId, Sort sort);
}
