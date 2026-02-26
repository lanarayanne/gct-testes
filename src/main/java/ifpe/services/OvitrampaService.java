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

    public void editarLatitude(int id, Double novaLatitude) {
        if(novaLatitude == null){
            throw new IllegalArgumentException("A latitude é obrigatória");
        }
        if(novaLatitude>90 || novaLatitude<-90){
            throw new IllegalArgumentException("O valor inserido não é localização");
        }

        Ovitrampa ovitrampa = buscarOvitrampa(id);

        ovitrampa.getLocalizacao().setLatitude(novaLatitude);

        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }

    public void editarLongitude(int id, Double novaLongitude) {

        if(novaLongitude == null){
            throw new IllegalArgumentException("A latitude é obrigatória");
        }

        if(novaLongitude>180 || novaLongitude<-180){
            throw new IllegalArgumentException("O valor inserido não é localização");
        }

        Ovitrampa ovitrampa = buscarOvitrampa(id);
        ovitrampa.getLocalizacao().setLongitude(novaLongitude);

        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }

    public void editarLarvicida(int id, Larvicida novoLarvicida)  {

        Ovitrampa ovitrampa = buscarOvitrampa(id);
        ovitrampa.setLarvicida(novoLarvicida);
        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }

    public void editarLarvicida(int id, String novoLarvicida)  {

        if (novoLarvicida == null || novoLarvicida.isEmpty()){
            throw new IllegalArgumentException("Larvicida é obrigatório");
        }

        Larvicida larvicida;

        if (novoLarvicida.equalsIgnoreCase("Óleo Essencial")){
            larvicida = Larvicida.OLEO_ESSENCIAL;
        } else if (novoLarvicida.equalsIgnoreCase("BTI")){
            larvicida = Larvicida.BTI;
        } else {
            larvicida = Larvicida.VAZIO;
        }

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




}
