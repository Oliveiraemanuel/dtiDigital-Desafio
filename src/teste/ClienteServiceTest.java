package teste;

import domains.Consulta;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static service.ConsultaService.cadastrarConsulta;

public class ClienteServiceTest {
    private Consulta consulta;
    @BeforeEach
    public void setUp() {
        consulta = new Consulta();
    }

    @Test
    public void testCadastrarConsulta() {
        // Simulando entrada do usuário
        String input = "1\n22/02/2024\n10:00\n7.50\n20.0\nBem\nsim\nN\nN\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrada fornecida: " + input);

        // Método de teste
        consulta = cadastrarConsulta(scanner);

        // Verifica se a consulta foi adicionada corretamente
        assertEquals("22/02/2024", consulta.getData());
        assertEquals("10:00", consulta.getHorario());
        assertEquals(7.50, consulta.getPeso());
        assertEquals(20.0, consulta.getGorduraCorporal());
        assertEquals("Bem", consulta.getSensacaoFisica());
        assertEquals(1, consulta.getRestricoesAlimentares().size());
        assertEquals("N", consulta.getRestricoesAlimentares().get(0));
    }

}
