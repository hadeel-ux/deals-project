package com.deals.repository;

import com.deals.entity.Deals;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealRepository extends PagingAndSortingRepository<Deals, Long> {

    Optional<Deals> findByDealID(String dealId);

}
