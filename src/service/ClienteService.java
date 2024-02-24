package service;

import domains.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteService {

    public static List<Cliente> clientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public static List<String> listarTodosOsClientes(){

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, clientes.get(i)));
        }
        return null;
    }

    public static void cadastrarCliente(Scanner in){

        System.out.println("Qual o nome do novo cliente?");
        String nome = in.next();

        System.out.println("Qual o endereço do novo cliente?");
        String endereco = in.next();

        System.out.println("Qual o telefone do novo cliente?");
        String telefone = in.next();

        System.out.println("Qual o email do novo cliente?");
        String email = in.next();

        System.out.println("Qual a data de nascimento do novo cliente?");
        String dataNascimento = in.next();

        Cliente cliente = new Cliente(nome, endereco, telefone, email, dataNascimento);

        adicionarCliente(cliente);
    }
}


