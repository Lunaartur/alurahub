package aluraHub.api.topico;


import aluraHub.api.topico.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private Boolean ativo;

    @Column(name = "data", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime data;

    private String curso;

    private String status;

    @Embedded
    private Autor autor;



    public Topico(DadosCadastroTopico dados) {
        this.ativo = true;
        this.status = "Aberto";
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
//        this.dataCriacao = LocalDateTime.now();
        this.curso = dados.curso();
        this.autor = new Autor(dados.autor());
    }

    @PrePersist
    protected void onCreate() {
        this.data = LocalDateTime.now();
    }

    public void atualizarInformacoes(DadosAtualizarTopico dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() != null){
            this.curso = dados.curso();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
