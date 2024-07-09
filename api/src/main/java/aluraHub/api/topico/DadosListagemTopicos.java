package aluraHub.api.topico;

import aluraHub.api.topico.autor.Autor;
import aluraHub.api.topico.autor.DadosAutor;

import java.time.LocalDateTime;

public record DadosListagemTopicos(Long Id,String titulo, String mensagem, String curso, String status, Autor autor,  LocalDateTime data) {

    public DadosListagemTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getCurso(), topico.getStatus(), topico.getAutor(),  topico.getData());
    }

}
