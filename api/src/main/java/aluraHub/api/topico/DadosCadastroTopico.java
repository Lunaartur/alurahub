package aluraHub.api.topico;

import aluraHub.api.topico.autor.DadosAutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String curso,


        //Caso eu precise de uma máscara: @pattern(regexp = "")
        @NotNull
        @Valid
        DadosAutor autor) {
}
