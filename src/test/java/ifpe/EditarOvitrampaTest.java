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
}
