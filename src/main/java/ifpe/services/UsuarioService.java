package ifpe.services;

import ifpe.entidades.Login;
import ifpe.entidades.Usuario;
import ifpe.repositorios.LoginRepositorio;
import ifpe.repositorios.UsuarioRepositorio;

public class UsuarioService {
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioService(UsuarioRepositorio repo){
        this.usuarioRepositorio =repo;
    }

    public Usuario buscarPorEmail(String email){
        return this.usuarioRepositorio.buscarPorEmail(email);
    }

}
