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
public class EditarOvitrampaTest {
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

    /*TC009*/
    @Test
    public void editarLatitudeOvitrampaSucesso(){
        //Arrange
        int id = 1;
        Double novaLatitude = -35.914;

        //Act
        when(ovitrampaRepositorio.buscarPorId(id)).thenReturn(ovitrampa);
        ovitrampaService.editarLatitude(id, novaLatitude);

        //Assert
        verify(ovitrampaRepositorio, times(1)).editarOvitrampa(ovitrampa);
        Assertions.assertEquals(novaLatitude, ovitrampa.getLocalizacao().getLatitude());

    }

    /*TC009*/
    @Test
    public void editarLongitudeOvitrampaSucesso(){
        //Arrange
        int id = 1;
        Double novaLongitude = -35.914;

        //Act
        when(ovitrampaRepositorio.buscarPorId(id)).thenReturn(ovitrampa);
        ovitrampaService.editarLongitude(id, novaLongitude);

        //Assert
        verify(ovitrampaRepositorio, times(1)).editarOvitrampa(ovitrampa);
        Assertions.assertEquals(novaLongitude, ovitrampa.getLocalizacao().getLongitude());

    }

    /*TC010*/
    @Test
    public void editarLatitudeOvitrampaComValorInvalido(){
        //Arrange
        int id = 1;
        Double novaLatitude = -35914.0;

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ovitrampaService.editarLatitude(id, novaLatitude);
        });
        Assertions.assertNotEquals(novaLatitude, ovitrampa.getLocalizacao().getLatitude());
        verify(ovitrampaRepositorio, never()).editarOvitrampa(ovitrampa);

    }

    /*TC010*/
    @Test
    public void editarLongitudeOvitrampaComValorInvalido(){
        //Arrange
        int id = 1;
        Double novaLongitude = -35914.0;

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ovitrampaService.editarLongitude(id, novaLongitude);
        });
        Assertions.assertNotEquals(novaLongitude, ovitrampa.getLocalizacao().getLongitude());
        verify(ovitrampaRepositorio, never()).editarOvitrampa(ovitrampa);

    }

    /*TC011*/
    @Test
    public void editarLatitudeOvitrampaRemover(){
        //Arrange
        int id = 1;
        Double novaLatitude = -35914.0;

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ovitrampaService.editarLatitude(id, novaLatitude);
        });
        Assertions.assertNotEquals(novaLatitude, ovitrampa.getLocalizacao().getLatitude());
        verify(ovitrampaRepositorio, never()).editarOvitrampa(ovitrampa);

    }

    /*TC011*/
    @Test
    public void editarLongitudeOvitrampaRemover(){
        //Arrange
        int id = 1;
        Double novaLongitude = null;

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ovitrampaService.editarLongitude(id, novaLongitude);
        });
        Assertions.assertNotEquals(novaLongitude, ovitrampa.getLocalizacao().getLongitude());
        verify(ovitrampaRepositorio, never()).editarOvitrampa(ovitrampa);

    }

    /*TC012*/
    @Test
    public void editarLarvicidaSucessoOE(){
        //Arrange
        int id = 1;
        Larvicida novoLarvicida = Larvicida.OLEO_ESSENCIAL;
        this.ovitrampa.setLarvicida(Larvicida.BTI);

        //Act
        when(ovitrampaRepositorio.buscarPorId(id)).thenReturn(ovitrampa);
        ovitrampaService.editarLarvicida(id, novoLarvicida);

        //Assert
        verify(ovitrampaRepositorio, times(1)).editarOvitrampa(ovitrampa);
        Assertions.assertEquals(novoLarvicida, ovitrampa.getLarvicida());

    }

    /*TC013*/
    @Test
    public void editarLarvicidaSucessoBTI(){
        //Arrange
        int id = 1;
        Larvicida novoLarvicida = Larvicida.BTI;
        this.ovitrampa.setLarvicida(Larvicida.OLEO_ESSENCIAL);

        //Act
        when(ovitrampaRepositorio.buscarPorId(id)).thenReturn(ovitrampa);
        ovitrampaService.editarLarvicida(id, novoLarvicida);

        //Assert
        verify(ovitrampaRepositorio, times(1)).editarOvitrampa(ovitrampa);
        Assertions.assertEquals(novoLarvicida, ovitrampa.getLarvicida());

    }
    /*TC014*/
    @Test
    public void editarLarvicidaInvalido(){
        //Arrange
        int id = 1;
        String novoLarvicida = "Outro";

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ovitrampaService.editarLarvicida(id, novoLarvicida);
        });
        Assertions.assertNotEquals(novoLarvicida, ovitrampa.getLarvicida());
        verify(ovitrampaRepositorio, never()).editarOvitrampa(ovitrampa);

    }

    /*TC015*/
    @Test
    public void editarLarvicidaRemover(){
        //Arrange
        int id = 1;
        String novoLarvicida = null;

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ovitrampaService.editarLarvicida(id, novoLarvicida);
        });
        Assertions.assertNotEquals(novoLarvicida, ovitrampa.getLarvicida());
        verify(ovitrampaRepositorio, never()).editarOvitrampa(ovitrampa);

    }




}
