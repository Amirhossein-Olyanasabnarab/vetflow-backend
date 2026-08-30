package com.amirhosseinolya.vetflow.owner.application;

import com.amirhosseinolya.vetflow.owner.api.dto.CreateOwnerRequest;
import com.amirhosseinolya.vetflow.owner.api.dto.OwnerResponse;
import com.amirhosseinolya.vetflow.owner.domain.Owner;
import com.amirhosseinolya.vetflow.owner.repository.OwnerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerResponse create(CreateOwnerRequest request){
        Owner owner = Owner.create(
                request.firstName(),
                request.lastName(),
                request.phoneNumber(),
                request.email(),
                request.address()
        );

        Owner saveOwner = ownerRepository.save(owner);
        return OwnerResponse.from(saveOwner);
    }
}
