package com.meetime.challenge.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email precisa ser válido")
    private String email;

    @NotBlank(message = "Primeiro nome é obrigatório")
    private String firstname;

    @NotBlank(message = "Último nome é obrigatório")
    private String lastname;
}