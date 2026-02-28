package ifpe;

import ifpe.entidades.Larvicida;
import ifpe.entidades.Localizacao;
import ifpe.entidades.Ovitrampa;
import ifpe.repositorios.OvitrampaRepositorio;
import ifpe.services.OvitrampaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuscarOvitrampaTest {
    @Mock
    private OvitrampaRepositorio ovitrampaRepositorio;
    @InjectMocks
    private OvitrampaService ovitrampaService;

    private Ovitrampa ovitrampa;

    @BeforeEach
    public void initTests() {
        Localizacao localizacao = new Localizacao(-8.056, -34.915);
        this.ovitrampa = new Ovitrampa(
                localizacao,
                Larvicida.BTI,
                "Cemitério da Várzea",
                "Grupo 1",
                1);

    }

    /*TC020*/
    @Test
    public void buscarOvitrampaNomeExistente(){
        //Arrange
        String nome = "Cemitério da Várzea";

        //Act
        when(ovitrampaRepositorio.buscarPorNome(nome)).thenReturn(ovitrampa);
        Ovitrampa resultadoBusca = ovitrampaService.buscarPorNome(nome);

        //Assert
        Assertions.assertNotNull(resultadoBusca);
        Assertions.assertSame(resultadoBusca, ovitrampa);
        verify(ovitrampaRepositorio, times(1)).buscarPorNome(nome);
    }

    /*TC021*/
    @Test
    public void buscarOvitrampaSubstanciaOE(){
        //Arrange
        String larvicidaStr = "Óleo Essencial";
        Larvicida larvicidaEnum = Larvicida.OLEO_ESSENCIAL;
        ovitrampa.setLarvicida(larvicidaEnum);

        //Act
        when(ovitrampaRepositorio.buscarPorLarvicida(larvicidaEnum)).thenReturn(ovitrampa);
        Ovitrampa resultadoBusca = ovitrampaService.buscarPorLarvicida(larvicidaStr);

        //Assert
        Assertions.assertNotNull(resultadoBusca);
        Assertions.assertSame(resultadoBusca, ovitrampa);
        verify(ovitrampaRepositorio, times(1)).buscarPorLarvicida(larvicidaEnum);
    }

    /*TC021*/
    @Test
    public void buscarOvitrampaSubstanciaBTI(){
        //Arrange
        String larvicidaStr = "BTI";
        Larvicida larvicidaEnum = Larvicida.BTI;
        ovitrampa.setLarvicida(larvicidaEnum);

        //Act
        when(ovitrampaRepositorio.buscarPorLarvicida(larvicidaEnum)).thenReturn(ovitrampa);
        Ovitrampa resultadoBusca = ovitrampaService.buscarPorLarvicida(larvicidaStr);

        //Assert
        Assertions.assertNotNull(resultadoBusca);
        Assertions.assertSame(resultadoBusca, ovitrampa);
        verify(ovitrampaRepositorio, times(1)).buscarPorLarvicida(larvicidaEnum);
    }

    /*TC022*/
    @Test
    public void buscarOvitrampaGrupoExistente(){
        //Arrange
        String grupo = "Grupo 1";

        //Act
        when(ovitrampaRepositorio.buscarPorGrupo(grupo)).thenReturn(ovitrampa);
        Ovitrampa resultadoBusca = ovitrampaService.buscarPorGrupo(grupo);

        //Assert
        Assertions.assertNotNull(resultadoBusca);
        Assertions.assertSame(resultadoBusca, ovitrampa);
        verify(ovitrampaRepositorio, times(1)).buscarPorGrupo(grupo);
    }

    /*TC023*/
    @Test
    public void buscarOvitrampaNomeInexistente(){
        //Arrange
        String nome = "teste_55dd5z";

        //Act
        when(ovitrampaRepositorio.buscarPorNome(nome)).thenReturn(null);

        //Assert
        Assertions.assertThrows(NullPointerException.class, ()-> {
            ovitrampaService.buscarPorNome(nome);
        });
        verify(ovitrampaRepositorio, times(1)).buscarPorNome(nome);
    }

    /*TC024*/
    @Test
    public void buscarOvitrampaSubstanciaInexistente(){
        //Arrange
        String larvicidaStr = "substancia1";
        Larvicida larvicidaEnum = Larvicida.toLarvicida(larvicidaStr);

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ovitrampaService.buscarPorLarvicida(larvicidaStr);
        });
        verify(ovitrampaRepositorio, never()).buscarPorLarvicida(larvicidaEnum);
    }

    /*TC022*/
    @Test
    public void buscarOvitrampaGrupoInexistente(){
        //Arrange
        String grupo = "Grupo 2";

        //Act
        when(ovitrampaRepositorio.buscarPorGrupo(grupo)).thenReturn(null);

        //Assert
        Assertions.assertThrows(NullPointerException.class, ()-> {
            ovitrampaService.buscarPorGrupo(grupo);
        });
        verify(ovitrampaRepositorio, times(1)).buscarPorGrupo(grupo);
    }





}
