import java.util.Scanner;

import static service.AlimentoService.combinacaoAlimentos;
import static service.ClienteService.cadastrarCliente;
import static service.ConsultaService.cadastrarConsulta;
import static service.ConsultaService.listarTodasAsConsultas;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Integer menu;
        do {
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar consulta");
            System.out.println("3. Listar consultas");
            System.out.println("4. Listar combinações de alimentos");
            System.out.println("5. Sair");
            System.out.println("Digite a opção desejada: (Apenas o número)");
            menu = in.nextInt();

            switch (menu) {
                case 1:
                    cadastrarCliente(in);
                    break;
                case 2:
                    cadastrarConsulta(in);
                    break;
                case 3:
                    listarTodasAsConsultas();
                    break;
                case 4:
                    combinacaoAlimentos(in);
                    break;
                case 6:
                    System.out.println("Execução finalizada!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (menu != 6);
    }

}