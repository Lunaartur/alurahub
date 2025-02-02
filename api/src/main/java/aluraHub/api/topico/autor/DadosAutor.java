package aluraHub.api.topico.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAutor(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email

        ) {
}
