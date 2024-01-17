package med.voll.api.paciente;

public record DadosListagemPaciente(Long id,String nome,String email, String cpf) {
    public DadosListagemPaciente( Paciente paciente){
        this(paciente.getId(), paciente.getPessoa().getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
