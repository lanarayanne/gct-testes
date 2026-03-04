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
        Date hoje = new Date();
        if (novaData == null) novaData = hoje;

        if (novaData.after(hoje)) {
            throw new IllegalArgumentException("A data da leitura não pode ser futura");
        }

        Leitura leitura = this.leituraRepositorio.buscarPorId(id);

        leitura.setData(novaData);
        this.leituraRepositorio.editarLeitura(leitura);
    }

    public void editarQuantidade(int id, Integer novaQuantidade){
        if (novaQuantidade == null) throw new IllegalArgumentException("Dados de quantidade inválidos");
        if (novaQuantidade < 0) throw new IllegalArgumentException("Dados de quantidade inválidos");
        Leitura leitura = this.leituraRepositorio.buscarPorId(id);
        leitura.setQuantidadeOvos(novaQuantidade);
        this.leituraRepositorio.editarLeitura(leitura);
    }




}
