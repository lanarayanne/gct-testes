package ifpe.entidades;

import java.util.Date;

public class Ovitrampa {
    private int id;
    private Localizacao localizacao;
    private Larvicida larvicida;
    private String nome;
    private String grupo;
    private int id_usuario;
    private Date dataCadastro;

    public Ovitrampa(){

    }

    public Ovitrampa(Localizacao localizacao,
                     Larvicida larvicida,
                     String nome,
                     String grupo,
                     int id_usuario){
        this.localizacao = localizacao;
        this.larvicida = larvicida;
        this.nome = nome;
        this.grupo = grupo;
        this.id_usuario = id_usuario;
        this.dataCadastro = new Date();
    }

    public Ovitrampa(Localizacao localizacao,
                     Larvicida larvicida,
                     int id_usuario){
        this.localizacao = localizacao;
        this.larvicida = larvicida;

        this.id_usuario = id_usuario;
        this.dataCadastro = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Larvicida getLarvicida() {
        return larvicida;
    }

    public void setLarvicida(Larvicida larvicida) {
        this.larvicida = larvicida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
