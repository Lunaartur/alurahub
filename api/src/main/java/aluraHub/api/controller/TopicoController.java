package aluraHub.api.controller;



import aluraHub.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) throws Exception {
        var mensagem = repository.encontrarTopicoDuplicadoPelaMensagen(dados.mensagem());
        var titulo = repository.encontrarTopicoDuplicadoPeloTitulo(dados.titulo());
        if (mensagem == null && titulo == null){
            var topico = new Topico(dados);
            repository.save(topico);
            var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
        }else {
            throw new Exception("Titulo e/ou mensagem já foram cadastrados");
        }
    }

    //Método de leitura
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(Pageable paginacao){
        var retorno = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/{id}")
    public DadosListagemTopicos listarPeloID(@PathVariable Long id) throws Exception {
        Optional<Topico> topicoBd = repository.findById(id);
        if (topicoBd.isPresent()){
            Topico topico = topicoBd.get();
            return new DadosListagemTopicos(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                    topico.getCurso(), topico.getStatus(), topico.getAutor(), topico.getData());
        }else {
            throw new Exception("Tópico não encontrado!");
        }
    }

    //Método de atualizar

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarTopico dados) throws Exception {
        var controleMensagem = false; //não estão contidas no bd aparentemente
        var controleTitulo = false;
        if (dados.mensagem() != null){
            var mensagem = repository.encontrarTopicoDuplicadoPelaMensagen(dados.mensagem());
            if (mensagem != null){
                controleMensagem = true;
            }
        }
        if (dados.titulo() != null){
            var titulo = repository.encontrarTopicoDuplicadoPeloTitulo(dados.titulo());
            if (titulo != null){
                controleTitulo = true;
            }
        }
        if (controleMensagem == false && controleTitulo == false){
            //carregar o tópico do banco de dados
            var topico = repository.getReferenceById(id);
            topico.atualizarInformacoes(dados);
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }else {
            throw new Exception("Título ou mensagem já existem");
        }
    }


    //Método de deletar está funcionando
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) throws Exception {
        var topico2 = repository.findById(id);
        if (topico2.isPresent()){
            var topico = repository.getReferenceById(id);
            topico.excluir();
            return ResponseEntity.noContent().build();
        }else {
            throw new Exception("Tópico não existe");
        }
    }
}



















