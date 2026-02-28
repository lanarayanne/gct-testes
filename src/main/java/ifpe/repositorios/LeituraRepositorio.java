package ifpe.repositorios;

import ifpe.entidades.Leitura;

import java.util.Date;

public interface LeituraRepositorio {
    void editarLeitura(Leitura leitura);
    Leitura buscarPorId(int id);
    Leitura buscarPorData(Date data);
}
