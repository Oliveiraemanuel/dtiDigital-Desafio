package teste;

import domains.Consulta;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static service.ConsultaService.cadastrarConsulta;

public class ConsultaServiceTest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

    @Before
    public void setUpInput() {
        testIn = new ByteArrayInputStream("1\n01/01/2024\n08:00\n70.5\n20.0\nBem\nSim\nIntolerância a lactose\nN".getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }


    @Test
    public void testCadastrarConsulta() {
        Scanner scanner = new Scanner(System.in);

        Consulta consulta = cadastrarConsulta(scanner);

        assertEquals("01/01/2024", consulta.getData());
        assertEquals("08:00", consulta.getHorario());
        assertEquals(70.5, consulta.getPeso(), 0.01);
        assertEquals(20.0, consulta.getGorduraCorporal(), 0.01);
        assertEquals("Bem", consulta.getSensacaoFisica());
        assertEquals(1, consulta.getRestricoesAlimentares().size());
        assertEquals("Intolerância a lactose", consulta.getRestricoesAlimentares().get(0));
    }
}
