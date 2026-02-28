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
public class UsarioTest {
    @Mock
    private UsuarioRepositorio usuarioRepositorio;
    @InjectMocks
    private UsuarioService usuarioService;

    Usuario usuario;

    @BeforeEach
    public void initTestes() {
        this.usuario = new Usuario("email@email.com", "Senha@1234");
        usuario.setId(1);
    }

    /*TC037*/
    @Test
    public void RedefinirSenhaSucesso() {
        // Arrange
        String senhaAtual = "Senha@1234";
        String novaSenha = "Senha@4567";
        String repetirNovaSenha = "Senha@4567";

        // Act
        when(usuarioRepositorio.buscarPorId(usuario.getId())).thenReturn(usuario);
        usuarioService.redefinirSenha(usuario.getId(), senhaAtual, novaSenha, repetirNovaSenha);

        // Assert (Verificação)
        verify(usuarioRepositorio, times(1)).redefinirSenha(novaSenha);
    }

    /*TC038*/
    @Test
    public void RedefinirSenhaAtualIncorreta() {
        // Arrange
        String senhaAtual = "Senhaincorreta";
        String novaSenha = "Senha@4567";
        String repetirNovaSenha = "Senha@4567";

        // Act
        when(usuarioRepositorio.buscarPorId(usuario.getId())).thenReturn(usuario);


        // Assert (Verificação)
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            usuarioService.redefinirSenha(usuario.getId(), senhaAtual, novaSenha, repetirNovaSenha);
        });
        verify(usuarioRepositorio, never()).redefinirSenha(novaSenha);
    }

    /*TC039*/
    @Test
    public void RedefinirSenhaSemSenhaAtual() {
        // Arrange
        String senhaAtual = null;
        String novaSenha = "Senha@4567";
        String repetirNovaSenha = "Senha@4567";

        // Act


        // Assert (Verificação)
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            usuarioService.redefinirSenha(usuario.getId(), senhaAtual, novaSenha, repetirNovaSenha);
        });
        verify(usuarioRepositorio, never()).redefinirSenha(novaSenha);
    }

    /*TC040*/
    @Test
    public void RedefinirSenhaCaracteresInsuficientes() {
        // Arrange
        String senhaAtual = "Senha@1234";
        String novaSenha = "S@45";
        String repetirNovaSenha = "S@45";

        // Act


        // Assert (Verificação)
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            usuarioService.redefinirSenha(usuario.getId(), senhaAtual, novaSenha, repetirNovaSenha);
        });
        verify(usuarioRepositorio, never()).redefinirSenha(novaSenha);
    }

    /*TC040*/
    @Test
    public void RedefinirSenhaSemMaiuscula() {
        // Arrange
        String senhaAtual = "Senha@1234";
        String novaSenha = "senha@456";
        String repetirNovaSenha = "senha@456";

        // Act


        // Assert (Verificação)
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            usuarioService.redefinirSenha(usuario.getId(), senhaAtual, novaSenha, repetirNovaSenha);
        });
        verify(usuarioRepositorio, never()).redefinirSenha(novaSenha);
    }

    /*TC042*/
    @Test
    public void RedefinirSenhaSemCaractereEspecial() {
        // Arrange
        String senhaAtual = "Senha@1234";
        String novaSenha = "Senha456";
        String repetirNovaSenha = "Senha456";

        // Act


        // Assert (Verificação)
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            usuarioService.redefinirSenha(usuario.getId(), senhaAtual, novaSenha, repetirNovaSenha);
        });
        verify(usuarioRepositorio, never()).redefinirSenha(novaSenha);
    }

    /*TC041*/
    @Test
    public void RedefinirSenhaSemNovaSenha() {
        // Arrange
        String senhaAtual = "Senha@1234";
        String novaSenha = null;
        String repetirNovaSenha = "Senha@456";

        // Act


        // Assert (Verificação)
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            usuarioService.redefinirSenha(usuario.getId(), senhaAtual, novaSenha, repetirNovaSenha);
        });
        verify(usuarioRepositorio, never()).redefinirSenha(novaSenha);
    }
}
