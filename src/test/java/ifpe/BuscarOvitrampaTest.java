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
        String larvicida = "Óleo Essencial";
        ovitrampa.setLarvicida(Larvicida.OLEO_ESSENCIAL);

        //Act
        when(ovitrampaRepositorio.buscarPorLarvicida(larvicida)).thenReturn(ovitrampa);
        Ovitrampa resultadoBusca = ovitrampaService.buscarPorLarvicida(larvicida);

        //Assert
        Assertions.assertNotNull(resultadoBusca);
        Assertions.assertSame(resultadoBusca, ovitrampa);
        verify(ovitrampaRepositorio, times(1)).buscarPorLarvicida(larvicida);
    }

}
