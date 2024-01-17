package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.atualizacao.DadosAtualizacao.DadosAtualizacao;
import med.voll.api.endereco.Endereco;
import med.voll.api.pessoa.Pessoa;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String nome;
    private String email;
//    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private DadosEspecialidade especialidade;
//    @Embedded
//    private Endereco endereco;
    private Boolean ativo;

    @Embedded
    private Pessoa pessoa;

    public Medico(DadosCadastroMedico dadosMedicos) {
        this.ativo= true;
        this.pessoa.setNome(dadosMedicos.nome());
        this.email = dadosMedicos.email();
        this.pessoa.setTelefone(dadosMedicos.telefone());
        this.crm = dadosMedicos.crm();
        this.especialidade = dadosMedicos.especialidade();
        this.pessoa.setEndereco(new Endereco(dadosMedicos.endereco()));

    }

    public void desativar() {
        this.ativo= false;
    }

    public void atualizarInformacoes(DadosAtualizacao dados) {
       pessoa.atualizarInformacoes(dados);
    }
}
