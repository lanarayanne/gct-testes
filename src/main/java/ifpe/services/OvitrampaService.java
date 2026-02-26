package ifpe.services;

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
        if(novaLongitude>90 || novaLongitude<-90){
            throw new IllegalArgumentException("O valor inserido não é localização");
        }

        Ovitrampa ovitrampa = buscarOvitrampa(id);
        ovitrampa.getLocalizacao().setLongitude(novaLongitude);

        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }
}
