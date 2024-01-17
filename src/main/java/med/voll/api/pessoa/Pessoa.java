package med.voll.api.pessoa;

import jakarta.persistence.Embedded;
import jakarta.persistence.Inheritance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.atualizacao.DadosAtualizacao.DadosAtualizacao;
import med.voll.api.endereco.Endereco;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private String nome;
    private String telefone;
    @Embedded
    private Endereco endereco;

    public void atualizarInformacoes(DadosAtualizacao dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarEndereco(dados.endereco());
        }

    }
}

