package com.citystartravel.backend.entity.voucher.item;

import com.citystartravel.backend.entity.voucher.purchaserequest.PurchaseRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoucherItemRepository extends JpaRepository<VoucherItem, Long> {

    Optional<VoucherItem> findById(Long id);

    List<PurchaseRequest> findByIdIn(List<Long> id);

    List<PurchaseRequest> findByIdIn(List<Long> id, Sort sort);
}
