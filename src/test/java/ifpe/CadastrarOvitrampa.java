package ifpe;

import ifpe.entidades.Larvicida;
import ifpe.entidades.Localizacao;
import ifpe.entidades.Ovitrampa;
import ifpe.entidades.Usuario;
import ifpe.repositorios.OvitrampaRepositorio;
import ifpe.repositorios.UsuarioRepositorio;
import ifpe.services.LoginService;
import ifpe.services.OvitrampaService;
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
public class CadastrarOvitrampa {
    @Mock
    private OvitrampaRepositorio ovitrampaRepositorio;
    @InjectMocks
    private OvitrampaService ovitrampaService;
    @Mock
    private UsuarioRepositorio usuarioRepositorio;
    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;


    @BeforeEach
    public void initTests() {
        this.usuario = new Usuario();
        usuario.setId(1);
    }

    /*TC028*/
    @Test
    public void CadastrarOvitrampaSucesso(){
        //Arrange
        Localizacao localizacao = new Localizacao(-8.056, -34.915);
        Ovitrampa ovitrampa = new Ovitrampa(
                localizacao,
                Larvicida.BTI,
                "Cemitério da Várzea",
                "Grupo 1",
                1);

        //Act
        ovitrampaService.cadastrar(ovitrampa, this.usuario.getId());

        //Assert
        verify(ovitrampaRepositorio, times(1)).cadastrar(ovitrampa, this.usuario.getId());

    }

    /*TC028*/
    @Test
    public void CadastrarOvitrampaSemLocalizacao(){
        //Arrange
        Ovitrampa ovitrampa = new Ovitrampa();
        ovitrampa.setLocalizacao(null);
        ovitrampa.setLarvicida(Larvicida.BTI);
        ovitrampa.setNome("Cemitério da Várzea");
        ovitrampa.setGrupo("Grupo 1");

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ovitrampaService.cadastrar(ovitrampa, this.usuario.getId());
        });
        verify(ovitrampaRepositorio, never()).cadastrar(ovitrampa, this.usuario.getId());

    }




}
