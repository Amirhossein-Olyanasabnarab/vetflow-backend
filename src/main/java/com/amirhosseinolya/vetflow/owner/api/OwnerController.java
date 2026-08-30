package com.amirhosseinolya.vetflow.owner.api;

import com.amirhosseinolya.vetflow.owner.api.dto.CreateOwnerRequest;
import com.amirhosseinolya.vetflow.owner.api.dto.OwnerResponse;
import com.amirhosseinolya.vetflow.owner.application.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerResponse create(@Valid @RequestBody CreateOwnerRequest request){
        return ownerService.create(request);
    }

}
