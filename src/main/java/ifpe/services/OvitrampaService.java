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
        Ovitrampa ovitrampa = buscarOvitrampa(id);
        ovitrampa.setLatitude(novaLatitude);

        this.ovitrampaRepositorio.editarOvitrampa(ovitrampa);
    }
}
