package med.voll.api.atualizacao.DadosAtualizacao;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacao(
                               @NotNull
                               Long id,
                               String nome,
                               String telefone,
                               DadosEndereco endereco) {
}
