package com.citystartravel.backend.entity.voucher.purchaserequest;

import com.citystartravel.backend.entity.voucher.VoucherRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {

    Optional<PurchaseRequest> findById(Long id);

    List<PurchaseRequest> findByIdIn(List<Long> id);

    List<PurchaseRequest> findByIdIn(List<Long> id, Sort sort);
}



/*public interface PurchaseRequestRepository<PurchaseRequest> extends VoucherRepository<PurchaseRequest> {

    Optional<PurchaseRequest> findById(Long id);

    List<PurchaseRequest> findByIdIn(List<Long> id);

    List<PurchaseRequest> findByIdIn(List<Long> id, Sort sort);
}*/


/*
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {

    Optional<PurchaseRequest> findById(Long id);

    List<PurchaseRequest> findByIdIn(List<Long> id);

    List<PurchaseRequest> findByIdIn(List<Long> id, Sort sort);
}
*/
