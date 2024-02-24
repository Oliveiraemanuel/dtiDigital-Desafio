package teste;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static service.AlimentoService.combinacaoAlimentos;

public class AlimentoServiceTest {


    @Test
    public void testCombinacaoAlimentos() {

        String input = "2000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        combinacaoAlimentos(new Scanner(System.in));
        }
}
