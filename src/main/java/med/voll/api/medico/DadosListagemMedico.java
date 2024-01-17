package med.voll.api.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm,DadosEspecialidade especialidade) {
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getPessoa().getNome(), medico.getEmail(), medico.getCrm(),
                medico.getEspecialidade());
    }
}
