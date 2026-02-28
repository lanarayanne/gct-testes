package ifpe.services;

import ifpe.entidades.Larvicida;
import ifpe.entidades.Ovitrampa;
import ifpe.repositorios.OvitrampaRepositorio;

public class OvitrampaService {
    private OvitrampaRepositorio ovitrampaRepositorio;

    public OvitrampaService(OvitrampaRepositorio ovitrampaRepo){
        this.ovitrampaRepositorio = ovitrampaRepo;
    }

    public Ovitrampa buscarOvitrampa(int id){
        return this.ovitrampaRepositorio.buscarPorId(id);
    }

    public boolean validarLatitude(Double latitude){
        return latitude <= 90 && latitude >= -90;
    }

    public boolean validarLongitude(Double longitude){
        return longitude <= 180 && longitude >= -180;
    }

    public void editarLatitude(int id, Double novaLatitude) {
        if(novaLatitude == null){
            throw new IllegalArgumentException("A latitude é obrigatória");
        }

        if(!validarLatitude(novaLatitude)) throw new IllegalArgumentException("O valor inserido não é localização");

        Ovitrampa ovitrampa = buscarOvitrampa(id);

        ovitrampa.getLocalizacao().setLatitude(novaLatitude);

        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }

    public void editarLongitude(int id, Double novaLongitude) {

        if(novaLongitude == null){
            throw new IllegalArgumentException("A latitude é obrigatória");
        }

        if(!validarLongitude(novaLongitude)) throw new IllegalArgumentException("O valor inserido não é localização");


        Ovitrampa ovitrampa = buscarOvitrampa(id);
        ovitrampa.getLocalizacao().setLongitude(novaLongitude);

        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }

    public void editarLarvicida(int id, String novoLarvicida)  {

        if (novoLarvicida == null || novoLarvicida.isEmpty()){
            throw new IllegalArgumentException("Larvicida é obrigatório");
        }

        Larvicida larvicida = Larvicida.toLarvicida(novoLarvicida);

        if (larvicida.equals(Larvicida.VAZIO)){
            throw new IllegalArgumentException ("Substância Inválida");
        }

        Ovitrampa ovitrampa = buscarOvitrampa(id);
        ovitrampa.setLarvicida(larvicida);
        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }

    public void editarNome(int id, String novoNome){
        Ovitrampa ovitrampa = buscarOvitrampa(id);
        ovitrampa.setNome(novoNome);
        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }

    public void editarGrupo(int id, String novoGrupo){
        Ovitrampa ovitrampa = buscarOvitrampa(id);
        ovitrampa.setGrupo(novoGrupo);
        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }

    public Ovitrampa buscarPorNome(String nome){
        if (nome == null) throw new IllegalArgumentException("Campo vazio, insira um texto");
        Ovitrampa resultadoBusca = this.ovitrampaRepositorio.buscarPorNome(nome);
        if(resultadoBusca == null) {
            throw new NullPointerException("Ovitrampa não encontrada");
        }
        return resultadoBusca;

    }

    public Ovitrampa buscarPorLarvicida(String larvicidaStr){
        if (larvicidaStr == null) throw new IllegalArgumentException("Campo vazio, insira um texto");
        Larvicida larvicida = Larvicida.toLarvicida(larvicidaStr);

        if (larvicida == Larvicida.VAZIO) {
            throw new IllegalArgumentException("Substância Inválida");
        }

        Ovitrampa resultadoBusca = this.ovitrampaRepositorio.buscarPorLarvicida(larvicida);

        if (resultadoBusca == null) {
            throw new NullPointerException("Ovitrampa não encontrada");
        }

        return resultadoBusca;
    }

    public Ovitrampa buscarPorGrupo(String grupo){
        if (grupo == null) throw new IllegalArgumentException("Campo vazio, insira um texto");
        Ovitrampa resultado = this.ovitrampaRepositorio.buscarPorGrupo(grupo);
        if (resultado == null) throw new NullPointerException("Grupo não encontrado");
        return resultado;
    }

    public void cadastrar(Ovitrampa ovitrampa, int userId){
        if (ovitrampa.getLocalizacao() == null) throw new IllegalArgumentException("Informe as coordenadas geográficas");
        if (ovitrampa.getLocalizacao().getLongitude() == null) throw new IllegalArgumentException("Informe a longitude");
        if (ovitrampa.getLocalizacao().getLatitude() == null) throw new IllegalArgumentException("Informe a latitude");
        if (ovitrampa.getLarvicida() == null) throw new IllegalArgumentException("Selecione uma substância");
        if (!validarLatitude(ovitrampa.getLocalizacao().getLatitude())) throw new IllegalArgumentException("Coordenada inválida");

        this.ovitrampaRepositorio.cadastrar(ovitrampa, userId);
    }




}
