package com.sda.shop.repository;

import com.sda.shop.entities.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<HouseEntity, Integer> {
}
