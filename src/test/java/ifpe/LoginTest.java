package ifpe;

import ifpe.entidades.Login;
import ifpe.repositorios.LoginRepositorio;
import ifpe.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoginTest {
    @Mock
    private LoginRepositorio loginRepositorio;
    @InjectMocks
    private LoginService loginService;

    @BeforeEach
    public void initTestes() {
    }

    @Test
    public void realizarLoginComSucesso() {
        // Arrange
        String email = "usuario@usuario.com";
        String senha = "123456@f";

        // Act
        loginService.fazerLogin(email, senha);

        // Assert (Verificação)
        verify(loginRepositorio, times(1)).fazerLogin(email, senha);
    }
}
