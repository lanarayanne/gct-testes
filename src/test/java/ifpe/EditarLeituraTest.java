package ifpe;

import ifpe.entidades.Leitura;
import ifpe.entidades.Ovitrampa;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EditarLeituraTest {
    @Mock
    private LeituraRepositorio leituraRepositorio;

    @InjectMocks
    private LeituraService leituraService;

    List<Leitura> leituras = new ArrayList<>();
    Leitura leitura;
    Usuario usuario;
    Ovitrampa ovitrampa;

    @BeforeEach
    public void initTestes(){
        this.leitura = new Leitura(520);
        leitura.setId(1);
        this.usuario = new Usuario();
        usuario.setId(1);
        this.ovitrampa = new Ovitrampa();
        ovitrampa.setId(1);

        leituras.add(leitura);
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

    @Test
    public void EditarDataLeituraFutura(){
        //Arrange
        Date novaData = new Date("December 17, 2027 03:24:00");

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            leituraService.editarData(leitura.getId(), novaData);
        });
        verify(leituraRepositorio, never()).editarLeitura(leitura);

    }

    @Test
    public void EditarQuantidadeNegativa(){
        //Arrange
        int novaQuantidade = -10;

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            leituraService.editarQuantidade(leitura.getId(), novaQuantidade);
        });
        verify(leituraRepositorio, never()).editarLeitura(leitura);

    }

    @Test
    public void EditarQuantidadeSucesso(){
        //Arrange
        int novaQuantidade = 200;

        //Act
        when(leituraRepositorio.buscarPorId(leitura.getId())).thenReturn(leitura);
        leituraService.editarQuantidade(leitura.getId(), novaQuantidade);

        //Assert
        verify(leituraRepositorio, times(1)).editarLeitura(leitura);
        Assertions.assertEquals(novaQuantidade, leitura.getQuantidadeOvos());

    }
    @Test
    public void EditarQuantidadeVazia(){
        //Arrange
        Integer novaQuantidade = null;

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            leituraService.editarQuantidade(leitura.getId(), novaQuantidade);
        });
        verify(leituraRepositorio, never()).editarLeitura(leitura);

    }


}
