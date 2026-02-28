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
    public Usuario buscarPorId(int id){
        return this.usuarioRepositorio.buscarPorId(id);
    }

    public void redefinirSenha(int usuarioId, String novaSenha, String repetirSenha){
        Usuario usuario = this.usuarioRepositorio.buscarPorId(usuarioId);
        this.usuarioRepositorio.redefinirSenha(novaSenha);
    }

}
