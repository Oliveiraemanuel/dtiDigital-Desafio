package service;

import domains.Consulta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static service.ClienteService.listarTodosOsClientes;

public class ConsultaService {

    public static List<Consulta> consultas = new ArrayList<>();

    public static void adicionarConsulta(Consulta consulta){
        consultas.add(consulta);
    }
    
    private static Consulta consulta;

    public static void listarTodasAsConsultas(){

        for (int i = 0; i < consultas.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, consultas.get(i)));
        }
    }


    public static Consulta cadastrarConsulta(Scanner in) {
        in.useLocale(Locale.US);
        System.out.println("Selecione o cliente:");
        listarTodosOsClientes();
        Integer indiceCliente = in.nextInt() - 1;
        in.nextLine(); // Consumir a quebra de linha pendente
        System.out.print("Digite a data da consulta (dd/MM/yyyy): ");
        String data = in.nextLine();
        System.out.print("Digite o horário da consulta (HH:mm): ");
        String horario = in.nextLine();
        System.out.print("Digite o peso do paciente: ");
        Double peso = in.nextDouble();// Consumir a quebra de linha pendente

        System.out.print("Digite a % de gordura corporal do paciente: ");
        Double gorduraCorporal = in.nextDouble();
        in.nextLine(); // Consumir a quebra de linha pendente

        System.out.print("Digite a sensação física do paciente: ");
        String sensacaoFisica = in.nextLine();
        in.nextLine();
        Boolean maisRestricao = false;

        List<String> restricoes = new ArrayList<>();

        do {
            System.out.print("Digite a restrição alimentar do paciente: ");
            String restricaoAlimentar = in.nextLine();

            restricoes.add(restricaoAlimentar);

            System.out.println("Deseja adiconar mais restrições? (Digite \"S\" para adicionar mais restrições e \"N\", para finalizar)");
            Character opcao = in.nextLine().charAt(0);

            if (opcao.equals('N')) maisRestricao = true;

        }while (!maisRestricao);

        Consulta novaConsulta = new Consulta(data, horario, peso, gorduraCorporal, sensacaoFisica);
        novaConsulta.setRestricoesAlimentares(restricoes);

        adicionarConsulta(novaConsulta);

        novaConsulta.setRestricoesAlimentares(restricoes);
        
        adicionarConsulta(novaConsulta);

        return novaConsulta;
    }
}
