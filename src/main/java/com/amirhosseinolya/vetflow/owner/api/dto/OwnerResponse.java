package com.amirhosseinolya.vetflow.owner.api.dto;

import com.amirhosseinolya.vetflow.owner.domain.Owner;

import java.time.Instant;
import java.util.UUID;

public record OwnerResponse(
        UUID id,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String address,
        Instant createdAt
) {
    public static OwnerResponse from(Owner owner){
        return new OwnerResponse(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getPhoneNumber(),
                owner.getEmail(),
                owner.getAddress(),
                owner.getCreatedAt()
        );
    }
}
