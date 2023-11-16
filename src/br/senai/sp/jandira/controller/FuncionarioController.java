package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionarioController {

    Conexao conexao = new Conexao();
    Connection objConnection = conexao.getConnection();



    public void listarFuncionarios() throws SQLException {

        //Responsavel por Executar a Query
        Statement statement = objConnection.createStatement();
        //Query (COMANDO PRO BANCO)
        String queryConsulta = "SELECT * FROM funcionario";

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()){
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            funcionario.setSobrenome(resultSet.getString("sobrenome"));
            funcionario.setPermissao(resultSet.getInt("permissao"));
            funcionario.setMatricula(resultSet.getString("matricula"));
            funcionario.setDepartamento_FK(resultSet.getInt("departamento_FK"));


            System.out.println("\n-  " + funcionario.getNome() + "  -\n");
            System.out.println("ID do Funcionario: " + funcionario.getIdFuncionario());
            System.out.println("Nome do Funcionario: " + funcionario.getNome() + " " + funcionario.getSobrenome());
            System.out.println("Matricula do Funcionario: " + funcionario.getMatricula());
            System.out.println("Permissão do Funcionario: " + funcionario.getPermissao());
            System.out.println("ID do Departamento do Funcionario: " + funcionario.getDepartamento_FK());
            System.out.println("\n -------------------------------\n");

        }
    }

    public void deletarFuncionario(String nome) throws SQLException {

        //Executa a Query no BANCO
        Statement statement = objConnection.createStatement();

        String queryDelete = " DELETE FROM funcionario WHERE nome = '" + nome + "'";

        try {
            statement.executeUpdate(queryDelete);
            System.out.println("\nFuncionario " + nome + " deletado!");
        }catch (Exception erro){
            System.out.println(erro);
        }

    }

    public void consultarFuncionario(String nome) throws SQLException {

        //Executa a Query no BANCO
        Statement statement = objConnection.createStatement();

        String queryPesquisa = "SELECT * FROM funcionario WHERE nome = '" + nome + "'";

        ResultSet resultSet = statement.executeQuery(queryPesquisa);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()){
            funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setSobrenome(resultSet.getString("sobrenome"));
            funcionario.setMatricula(resultSet.getString("matricula"));

            System.out.println("\n-  " + funcionario.getNome() + "  -\n");
            System.out.println("ID do Funcionario: " + funcionario.getIdFuncionario());
            System.out.println("Nome do Funcionario: " + funcionario.getNome() + " " + funcionario.getSobrenome());
            System.out.println("Matricula do Funcionario: " + funcionario.getMatricula());
            System.out.println("\n -------------------------------\n");

        }
    }

    public void cadastrarFuncionario(Funcionario newfuncionario) throws SQLException {

        Statement statement = objConnection.createStatement();

        String queryCadastro = "INSERT INTO funcionario (idFuncionario, nome, sobrenome, matricula, permissao, departamento_FK) values("
                + newfuncionario.getIdFuncionario() + ",'" + newfuncionario.getNome() + "','" + newfuncionario.getSobrenome() + "','" + newfuncionario.getMatricula()+
                "'," + newfuncionario.getPermissao() + "," + newfuncionario.getDepartamento_FK();

        statement.executeUpdate(queryCadastro);
        System.out.println("\n Usuário Cadastro com Sucesso! \n");


    }

    public void atualizarFuncionario(String nome, String sobrenome) throws SQLException {

        Statement statement = objConnection.createStatement();

        String queryAtualiza = "UPDATE funcionario SET sobrenome = '"+ sobrenome + "' WHERE nome = '" + nome + "'";

        statement.executeUpdate(queryAtualiza);
        System.out.println("\n Funcionario Atualizado com Sucesso! \n");
    }


}
