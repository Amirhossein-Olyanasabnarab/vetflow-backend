package com.amirhosseinolya.vetflow.owner.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateOwnerRequest(
        @NotBlank
        @Size(max = 100)
        String firstName,

        @NotBlank
        @Size(max = 100)
        String lastName,

        @NotBlank
        @Size(max = 30)
        String phoneNumber,

        @Email
        @Size(max = 255)
        String email,

        @Size(max = 500)
        String address
) {

}
