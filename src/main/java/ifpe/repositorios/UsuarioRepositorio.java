package ifpe.repositorios;

import ifpe.entidades.Login;
import ifpe.entidades.Usuario;

public interface UsuarioRepositorio {
    Usuario buscarPorEmail(String email);
}
