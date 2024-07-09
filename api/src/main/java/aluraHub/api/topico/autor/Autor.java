package aluraHub.api.topico.autor;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

       private String nome;
       private String email;

       public Autor(DadosAutor dados) {
              this.nome = dados.nome();
              this.email = dados.email();
       }
}
