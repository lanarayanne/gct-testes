package ifpe;

import ifpe.entidades.Larvicida;
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
        this.ovitrampa = new Ovitrampa(
                -8.056,
                -34.915,
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
        Assertions.assertEquals(novaLatitude, ovitrampa.getLatitude());

    }
}
