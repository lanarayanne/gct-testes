package ifpe;

import ifpe.entidades.Login;
import ifpe.repositorios.LoginRepositorio;
import ifpe.services.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

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
        Login login = new Login("usuario@usuario.com", "123456@f");

        // Act
        loginService.fazerLogin(login);

        // Assert (Verificação)
        verify(loginRepositorio, times(1)).fazerLogin(login);
    }

    @Test
    public  void realizarLoginComEmailInvalidoSemArroba(){
        //Arrange
        Login loginInvalido = new Login("email_invalido.com", "123456@f");

        // Act
        Login loginAct = loginService.fazerLogin(loginInvalido);

        //Assert
        Assertions.assertNull(loginAct, "Deve retornar null");

        verify(loginRepositorio, never()).fazerLogin(any(Login.class));

    }

    @Test
    public  void realizarLoginComEmailInvalidoSemCom(){
        //Arrange
        Login loginInvalido = new Login("email_invalido@", "123456@f");

        // Act
        Login loginAct = loginService.fazerLogin(loginInvalido);

        //Assert
        Assertions.assertNull(loginAct, "Deve retornar null");

        verify(loginRepositorio, never()).fazerLogin(any(Login.class));

    }
}
