package com.sda.shop.repository;

import com.sda.shop.entities.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {
}
