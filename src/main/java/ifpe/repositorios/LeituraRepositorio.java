package ifpe.repositorios;

import ifpe.entidades.Leitura;

public interface LeituraRepositorio {
    void editarLeitura(Leitura leitura);
    Leitura buscarPorId(int id);
}
