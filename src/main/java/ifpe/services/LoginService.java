package ifpe.services;

import ifpe.entidades.Login;
import ifpe.repositorios.LoginRepositorio;

public class LoginService {
    private LoginRepositorio loginRepositorio;

    public LoginService(LoginRepositorio repo){
        this.loginRepositorio = repo;
    }

    public Login fazerLogin(Login login){
        if (!login.getEmail().contains("@") || !login.getEmail().contains(".com")) {
            return null;
        }
        return this.loginRepositorio.fazerLogin(login);
    }
}
