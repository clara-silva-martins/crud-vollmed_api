package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.atualizacao.DadosAtualizacao.DadosAtualizacao;
import med.voll.api.endereco.Endereco;
import med.voll.api.pessoa.Pessoa;


@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String email;
    private String cpf;
//    private String nome;
//    private String telefone;
//    @Embedded
//    private Endereco endereco;
    private Boolean ativo;

    @Embedded
    private Pessoa pessoa;

    public Paciente(DadosCadastroPaciente dadosPacientes) {
        this.ativo=true;
        this.email = dadosPacientes.email();
        this.cpf = dadosPacientes.cpf();
        this.pessoa.setTelefone(dadosPacientes.telefone());
        this.pessoa.setNome(dadosPacientes.nome());
        this.pessoa.setEndereco(new Endereco(dadosPacientes.endereco()));
    }


    public void atualizarInformacoes(DadosAtualizacao dados) {
        pessoa.atualizarInformacoes(dados);
    }

    public void desativar() {
        this.ativo = false;
    }
}



