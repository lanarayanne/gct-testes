package ifpe;

import ifpe.entidades.Login;
import ifpe.entidades.Usuario;
import ifpe.repositorios.LoginRepositorio;
import ifpe.repositorios.UsuarioRepositorio;
import ifpe.services.LoginService;
import ifpe.services.UsuarioService;
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
    @Mock
    private UsuarioRepositorio usuarioRepositorio;
    @InjectMocks
    private LoginService loginService;
    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void initTestes() {
    }

    /*TC001*/
    @Test
    public void realizarLoginComSucesso() {
        // Arrange
        Login login = new Login("usuario@usuario.com", "Senha@123");
        Usuario usuario = new Usuario();
        usuario.setEmail("usuario@usuario.com");
        usuario.setSenha("Senha@123");

        // Act
        when(usuarioRepositorio.buscarPorEmail(login.getEmail())).thenReturn(usuario);
        loginService.fazerLogin(login);

        // Assert (Verificação)
        verify(loginRepositorio, times(1)).fazerLogin(login);
    }

    /*TC002*/
    @Test
    public  void realizarLoginComEmailErrado(){
        //Arrange
        Login loginInvalido = new Login("email@email.com", "Senha@123");

        // Act
        when(usuarioRepositorio.buscarPorEmail(loginInvalido.getEmail())).thenReturn(null);

        //Assert
        Assertions.assertThrows(NullPointerException.class, ()-> {
            loginService.fazerLogin(loginInvalido);
        });

        verify(loginRepositorio, never()).fazerLogin(any(Login.class));

    }

    /*TC003*/
    @Test
    public  void realizarLoginComSenhaErrada(){
        //Arrange
        Login loginInvalido = new Login("email@email.com", "senhaErrada");
        Usuario usuario = new Usuario();
        usuario.setEmail("email@email.com");
        usuario.setSenha("Senha@123");

        // Act
        when(usuarioRepositorio.buscarPorEmail(loginInvalido.getEmail())).thenReturn(usuario);

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            loginService.fazerLogin(loginInvalido);
        });

        verify(loginRepositorio, never()).fazerLogin(any(Login.class));

    }

    /*TC004*/
    @Test
    public  void realizarLoginEmailNull(){
        //Arrange
        Login loginInvalido = new Login(null, "Senha@123");

        // Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            loginService.fazerLogin(loginInvalido);
        });

        verify(loginRepositorio, never()).fazerLogin(any(Login.class));

    }

//    @Test
//    public  void realizarLoginComEmailInvalidoSemArroba(){
//        //Arrange
//        Login loginInvalido = new Login("email_invalido.com", "123456@fF");
//
//        // Act
//        Login loginAct = loginService.fazerLogin(loginInvalido);
//
//        //Assert
//        Assertions.assertNull(loginAct, "Deve retornar null");
//
//        verify(loginRepositorio, never()).fazerLogin(any(Login.class));
//
//    }
//
//    @Test
//    public  void realizarLoginComEmailInvalidoSemCom(){
//        //Arrange
//        Login loginInvalido = new Login("email_invalido@", "123456@fF");
//
//        // Act
//        Login loginAct = loginService.fazerLogin(loginInvalido);
//
//        //Assert
//        Assertions.assertNull(loginAct, "Deve retornar null");
//
//        verify(loginRepositorio, never()).fazerLogin(any(Login.class));
//
//    }


}
