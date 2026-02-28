package ifpe.entidades;

import java.util.Date;

public class Leitura {
    private int id;
    private int quantidadeOvos;
    private Date data;
    private int usuarioId;

    public Leitura(){
        this.data = new Date();

    }

    public Leitura(int quantidadeOvos){
        this.data = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeOvos() {
        return quantidadeOvos;
    }

    public void setQuantidadeOvos(int quantidadeOvos) {
        this.quantidadeOvos = quantidadeOvos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
