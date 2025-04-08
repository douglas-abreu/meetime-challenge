package com.meetime.challenge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactDTO {
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email precisa ser válido")
    private String email;

    @NotBlank(message = "Primeiro nome é obrigatório")
    private String firstname;

    @NotBlank(message = "Último nome é obrigatório")
    private String lastname;
}