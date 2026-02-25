package ifpe.services;

import ifpe.entidades.Login;
import ifpe.entidades.Usuario;
import ifpe.repositorios.LoginRepositorio;
import ifpe.repositorios.UsuarioRepositorio;

public class LoginService {
    private LoginRepositorio loginRepositorio;
    private UsuarioRepositorio usuarioRepositorio;

    public LoginService(LoginRepositorio loginRepo, UsuarioRepositorio usuarioRepo){
        this.loginRepositorio = loginRepo;
        this.usuarioRepositorio=usuarioRepo;
    }

    public boolean verificarSenha(String senhaSalva, String senha){
        if (senhaSalva.equals(senha)){
            return true;
        }
        return  false;
    }



    public Login fazerLogin(Login login) {
        String email = login.getEmail();
        Usuario usuario = this.usuarioRepositorio.buscarPorEmail(email);
        if(usuario == null){
            throw new NullPointerException ("Usuário não encontrado");
        }

        String senhaSalva = usuario.getSenha();
        boolean verificarSenha = verificarSenha(senhaSalva, login.getSenha());

        if(!verificarSenha){
            throw new IllegalArgumentException ("Senha Inválida");
        }

        return this.loginRepositorio.fazerLogin(login);
    }
}
