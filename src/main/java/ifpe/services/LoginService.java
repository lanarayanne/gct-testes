package ifpe.services;

import ifpe.entidades.Login;
import ifpe.repositorios.LoginRepositorio;

public class LoginService {
    private LoginRepositorio loginRepositorio;

    public LoginService(LoginRepositorio repo){
        this.loginRepositorio = repo;
    }

    public Login fazerLogin(Login login) {
        if (!login.getEmail().contains("@") || !login.getEmail().contains(".com")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        String senha = login.getSenha();
        String regexComplexa = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*]).*$";
        if (senha == null || !senha.matches(regexComplexa)) {
            return null;
        }
        return this.loginRepositorio.fazerLogin(login);
    }
}
