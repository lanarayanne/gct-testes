package ifpe.repositorios;

import ifpe.entidades.Ovitrampa;

public interface OvitrampaRepositorio {
    Ovitrampa buscarPorId(int id);
    void editarOvitrampa(Ovitrampa ovitrampa);
    Ovitrampa buscarPorNome(String nome);
    Ovitrampa buscarPorLarvicida(String larvicida);
    Ovitrampa buscarPorGrupo(String grupo);
}
