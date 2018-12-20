package com.citystartravel.backend.entity.voucher.stockreceived;

import com.citystartravel.backend.entity.voucher.purchaserequest.PurchaseRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockReceivedRepository extends JpaRepository<StockReceived, Long> {

    Optional<StockReceived> findById(Long id);

    List<StockReceived> findByIdIn(List<Long> id);

    List<StockReceived> findByIdIn(List<Long> id, Sort sort);
}
