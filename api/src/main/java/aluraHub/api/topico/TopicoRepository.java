package aluraHub.api.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {


    Page<Topico> findAllByAtivoTrue(Pageable paginacao);

    @Query("SELECT t.mensagem FROM Topicos t WHERE LOWER(t.mensagem) LIKE LOWER(CONCAT('%', :mensagem, '%'))")
    String encontrarTopicoDuplicadoPelaMensagen(@Param("mensagem") String mensagem);

    @Query("SELECT t.titulo FROM Topicos t WHERE LOWER(t.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
    String encontrarTopicoDuplicadoPeloTitulo(@Param("titulo") String titulo);




}
