package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Funcionario {

    Scanner scanner = new Scanner(System.in);

    public void cadastrarFuncionario(){

        System.out.println("\n -      CADASTRO DE FUNCIONÁRIO      - \n");
        System.out.println("Informe o nome do funcionario: ");
        this.nome = scanner.nextLine();
        System.out.println("Informe o sobrenome do funcionario: ");
        this.sobrenome = scanner.nextLine();
        System.out.println("Informe o numero da matricula do funcionario: ");
        this.matricula = scanner.nextLine();
        System.out.println("Informe o ID do funcionario: ");
        this.idFuncionario = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe a permissão do funcionario: ");
        this.permissao = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o ID do Departamento do funcionario: ");
        this.departamento_FK = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n -        -------------------        - ");


    }

    private int idFuncionario,permissao, departamento_FK;
    private String nome,sobrenome,matricula;


    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public int getDepartamento_FK() {
        return departamento_FK;
    }

    public void setDepartamento_FK(int departamento_FK) {
        this.departamento_FK = departamento_FK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
