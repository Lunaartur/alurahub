package aluraHub.api.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(

        String titulo,

        String mensagem,

        String curso) {
}
