package ifpe.repositorios;

import ifpe.entidades.Leitura;

import java.util.Date;
import java.util.List;

public interface LeituraRepositorio {
    void editarLeitura(Leitura leitura);
    Leitura buscarPorId(int id);
    List<Leitura>buscarPorOvitrampaId(int id);
    Leitura buscarPorData(Date data);
}
