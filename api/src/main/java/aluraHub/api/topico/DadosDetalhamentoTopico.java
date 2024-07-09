package aluraHub.api.topico;

import aluraHub.api.topico.autor.Autor;
import aluraHub.api.topico.autor.DadosAutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico( Long id, String titulo, String mensagem, String curso, Autor autor)
{
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getCurso(), topico.getAutor());
    }
}
