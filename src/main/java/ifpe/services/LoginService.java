package ifpe.services;

import ifpe.entidades.Login;
import ifpe.repositorios.LoginRepositorio;

public class LoginService {
    private LoginRepositorio loginRepositorio;

    public LoginService(LoginRepositorio repo){
        this.loginRepositorio = repo;
    }

    public Login fazerLogin(Login login){
        return this.loginRepositorio.fazerLogin(login);
    }
}
