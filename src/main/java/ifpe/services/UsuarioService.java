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

    public void redefinirSenha(int usuarioId, String senhaAtual, String novaSenha, String repetirSenha){
        if(senhaAtual == null) throw new IllegalArgumentException("Senha Atual não correspondente, Tente novamente");
        if(novaSenha == null) throw new IllegalArgumentException("Informe a senha");
        if(novaSenha.length()<8) throw new IllegalArgumentException("Número de caracteres inválido!");

        if(repetirSenha == null) throw new IllegalArgumentException("As senhas não coincidem");
        if(!novaSenha.equals(repetirSenha)) throw new IllegalArgumentException("As senhas não coincidem");


        String regexComplexa = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*]).*$";
        if (!novaSenha.matches(regexComplexa)) {
            throw new IllegalArgumentException("Formato inválido");
        }

        Usuario usuario = this.usuarioRepositorio.buscarPorId(usuarioId);
        if (!usuario.getSenha().equals(senhaAtual)) {
            throw new IllegalArgumentException("Senha Atual não correspondente, Tente novamente");
        }

        this.usuarioRepositorio.redefinirSenha(novaSenha);
    }

}
