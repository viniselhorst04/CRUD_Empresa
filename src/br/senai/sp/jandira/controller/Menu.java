package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Funcionario;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    FuncionarioController funcionario = new FuncionarioController();

    public void executarMenu() throws SQLException {

        boolean continuar = true;

        while (continuar) {

            System.out.println(" ------------------------------- ");
            System.out.println(" -             MENU            - ");
            System.out.println(" -------------------------------\n ");
            System.out.println(" 1- Cadastrar Funcionarios");
            System.out.println(" 2- Listar Funcionarios");
            System.out.println(" 3- Deletar Funcionarios");
            System.out.println(" 4- Consultar Funcionarios");
            System.out.println(" 5- Atualizar Funcionarios");
            System.out.println(" 6- Sair");
            System.out.println(" \n------------------------------- ");

            System.out.print("Escolha uma opção:");
            int escolhaUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (escolhaUsuario){

                case 1:

                    Funcionario newFuncionario = new Funcionario();
                    newFuncionario.cadastrarFuncionario();
                    funcionario.cadastrarFuncionario(newFuncionario);

                    break;

                case 2:
                    System.out.println("\n-       LISTA DE FUNCIONARIOS      -");
                    funcionario.listarFuncionarios();

                    break;

                case 3:
                    System.out.println("\n -      DELETAR FUNCIONARIO      - \n");
                    System.out.print("Informe o nome do funcionario que deseja deletar:");
                    String nomeDelete = scanner.nextLine();
                    funcionario.deletarFuncionario(nomeDelete);

                    break;

                case 4:

                    System.out.println("\n -      CONSULTAR FUNCIONÁRIO      - \n");
                    System.out.print("Informe o nome do funcionario que deseja consultar:");
                    String nomeConsulta = scanner.nextLine();
                    funcionario.consultarFuncionario(nomeConsulta);

                    break;


                case 5:

                    System.out.println("\n -      ATUALIZAR FUNCIONÁRIO      - \n");
                    System.out.print("Informe o nome do funcionario que deseja atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.println("\n Digite o novo sobrenome do funcionário");
                    String novoSobrenome = scanner.nextLine();
                    funcionario.atualizarFuncionario(nomeAtualizar,novoSobrenome);

                    break;


                case 6:

                    continuar = false;

                    break;




            }



        }

    }
}
