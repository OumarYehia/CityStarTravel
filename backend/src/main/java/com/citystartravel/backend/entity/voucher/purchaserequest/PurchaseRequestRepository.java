package com.citystartravel.backend.entity.voucher.purchaserequestvoucher;

import com.citystartravel.backend.entity.voucher.purchaserequestvoucher.PurchaseRequestVoucher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRequestVoucherRepository extends JpaRepository<PurchaseRequestVoucher, Long> {

    Optional<PurchaseRequestVoucher> findById(Long purchaseRequestVoucherId);

    List<PurchaseRequestVoucher> findByIdIn(List<Long> purchaseRequestVoucherId);

    List<PurchaseRequestVoucher> findByIdIn(List<Long> purchaseRequestVoucherId, Sort sort);
}
