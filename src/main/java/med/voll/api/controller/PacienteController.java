package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.atualizacao.DadosAtualizacao.DadosAtualizacao;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPacientes(@RequestBody DadosCadastroPaciente dadosPacientes) {
        repository.save(new Paciente(dadosPacientes));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar (@RequestBody @Valid DadosAtualizacao dados){
        var paciente = repository.getReferenceById(dados.id());
        //paciente.getPessoa().atualizarInformacoes(dados);
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar (@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.desativar();
    }

//    public void deletar (@PathVariable Long id){
//        repository.deleteById(id);
//    }




}

