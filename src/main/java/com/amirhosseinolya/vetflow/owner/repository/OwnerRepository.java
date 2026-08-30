package com.amirhosseinolya.vetflow.owner.repository;

import com.amirhosseinolya.vetflow.owner.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerRepository extends JpaRepository<Owner, UUID> {
    boolean existsByPhoneNumber(String phoneNumber);
}
