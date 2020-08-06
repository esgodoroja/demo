package com.example.demo.repository;

import com.example.demo.model.PetEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends PagingAndSortingRepository<PetEntity, Long> {

}
