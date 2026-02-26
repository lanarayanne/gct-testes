package ifpe.repositorios;

import ifpe.entidades.Ovitrampa;

public interface OvitrampaRepositorio {
    Ovitrampa buscarPorId(int id);
    void editarOvitrampa(Ovitrampa ovitrampa);
    void editarNome(Ovitrampa ovitrampa);

}
