package com.citystartravel.backend.entity.voucher.stockissue;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockIssueRepository extends JpaRepository<StockIssue, Long> {

    Optional<StockIssue> findById(Long id);

    List<StockIssue> findByIdIn(List<Long> id);

    List<StockIssue> findByIdIn(List<Long> id, Sort sort);
}



/*public interface StockIssueRepository<StockIssue> extends VoucherRepository<StockIssue> {

    Optional<StockIssue> findById(Long id);

    List<StockIssue> findByIdIn(List<Long> id);

    List<StockIssue> findByIdIn(List<Long> id, Sort sort);
}*/


/*
public interface StockIssueRepository extends JpaRepository<StockIssue, Long> {

    Optional<StockIssue> findById(Long id);

    List<StockIssue> findByIdIn(List<Long> id);

    List<StockIssue> findByIdIn(List<Long> id, Sort sort);
}
*/
