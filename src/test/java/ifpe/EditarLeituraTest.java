package ifpe;

import ifpe.entidades.Leitura;
import ifpe.entidades.Usuario;
import ifpe.repositorios.LeituraRepositorio;
import ifpe.services.LeituraService;
import ifpe.services.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EditarLeituraTest {
    @Mock
    private LeituraRepositorio leituraRepositorio;

    @InjectMocks
    private LeituraService leituraService;

    Leitura leitura;
    Usuario usuario;

    @BeforeEach
    public void initTestes(){
        this.leitura = new Leitura(520);
        leitura.setId(1);
        this.usuario = new Usuario();
        usuario.setId(1);
    }

    @Test
    public void EditarDataLeituraSucesso(){
        //Arrange
        Date novaData = new Date("December 17, 1995 03:24:00");

        //Act
        when(leituraRepositorio.buscarPorId(leitura.getId())).thenReturn(leitura);
        leituraService.editarData(leitura.getId(), novaData);

        //Assert
        verify(leituraRepositorio, times(1)).editarLeitura(leitura);
        Assertions.assertEquals(novaData, leitura.getData());

    }

    @Test
    public void EditarDataLeituraDuplicada(){
        //Arrange
        Date novaData = new Date("December 17, 1995 03:24:00");

        //Act
        when(leituraRepositorio.buscarPorId(leitura.getId())).thenReturn(leitura);
        leituraService.editarData(leitura.getId(), novaData);

        //Assert
        verify(leituraRepositorio, times(1)).editarLeitura(leitura);
        Assertions.assertEquals(novaData, leitura.getData());

    }

    @Test
    public void EditarDataLeituraVazia(){
        //Arrange
        Date novaData = null;

        //Act
        when(leituraRepositorio.buscarPorId(leitura.getId())).thenReturn(leitura);
        leituraService.editarData(leitura.getId(), novaData);

        //Assert
        verify(leituraRepositorio, times(1)).editarLeitura(leitura);
        Assertions.assertNotNull(leitura.getData());

    }

}
