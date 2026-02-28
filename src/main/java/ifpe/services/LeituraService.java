package ifpe.services;

import ifpe.entidades.Leitura;
import ifpe.repositorios.LeituraRepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
