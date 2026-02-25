package ifpe.repositorios;

import ifpe.entidades.Login;

public interface LoginRepositorio {
    Login fazerLogin(String email, String senha);
}
