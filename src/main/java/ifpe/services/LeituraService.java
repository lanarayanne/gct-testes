package ifpe.services;

import ifpe.entidades.Leitura;
import ifpe.repositorios.LeituraRepositorio;

import java.util.Date;

public class LeituraService {
    private LeituraRepositorio leituraRepositorio;

    public LeituraService(LeituraRepositorio leituraRepo){
        this.leituraRepositorio = leituraRepo;
    }

    public void editarData(int id, Date novaData){
        Leitura leitura = this.leituraRepositorio.buscarPorId(id);
        leitura.setData(novaData);
        this.leituraRepositorio.editarLeitura(leitura);
    }
}
