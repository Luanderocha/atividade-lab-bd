package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import bean.Produto;
import conexao.Conecta;

public class ProdutoDao {

    private Connection con;

    public ProdutoDao() throws SQLException, ClassNotFoundException {
        con = Conecta.criarConexao();
    }

    public void consultaProdutos() {

        try {
            String consulta = "select * from produto";
            PreparedStatement preparador = con.prepareStatement(consulta);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                System.out.println("ID : " + resultados.getString("id"));
                System.out.println("Nome : " + resultados.getString("nome"));
                System.out.println("Valor : " + resultados.getDouble("valor"));
                System.out.println("Qtd em estoque :" + resultados.getInt("estoque"));
                System.out.println("Unidade :" + resultados.getString("unidade"));
                System.out.println(" ------------------- ");
            }

        } catch (SQLException e) {
            System.out.println("Não consegiu consultar os dados do produto");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

    public void consultaProdutoPorId(int id) {

        try {
            String consulta = "select * from produto p where p.id = " + id;
            PreparedStatement preparador = con.prepareStatement(consulta);
            ResultSet resultado = preparador.executeQuery();

            while (resultado.next()) {
                System.out.println("Nome : " + resultado.getString("nome"));
                System.out.println("Valor : " + resultado.getDouble("valor"));
                System.out.println("Qtd em estoque :" + resultado.getInt("estoque"));
                System.out.println("Unidade :" + resultado.getString("unidade"));
            }

        } catch (SQLException e) {
            System.out.println("Não consegiu consultar os dados do produto");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

    public void inserirProduto(Produto produto) {
        try {
            String consulta = "insert into produto(nome,valor,estoque,unidade) values(?,?,?,?)";
            PreparedStatement preparador = con.prepareStatement(consulta);
            preparador.setString(1, produto.getNome());
            preparador.setDouble(2, produto.getValor());
            preparador.setInt(3, produto.getEstoque());
            preparador.setString(4, produto.getUnidade());
            int retorno = preparador.executeUpdate();
            if (retorno > 0) {
                System.out.println("Registro inserido");
            } else {
                System.out.println("registro não inserido");
            }

        } catch (SQLException e) {
            System.out.println("Não consegiu inserir os dados do produto");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

    public void atualizarProduto(Produto produto, int id) {
        try {
            String consulta = "update produto set nome = ? , valor = ? , estoque = ? , unidade = ? where id = ?";
            PreparedStatement preparador = con.prepareStatement(consulta);
            preparador.setString(1, produto.getNome());
            preparador.setDouble(2, produto.getValor());
            preparador.setInt(3, produto.getEstoque());
            preparador.setString(4, produto.getUnidade());
            preparador.setInt(5, id);
            int retorno = preparador.executeUpdate();
            if (retorno > 0) {
                System.out.println("Registro atualizado");
            } else {
                System.out.println("Registro não atualizado");
            }

        } catch (SQLException e) {
            System.out.println("Não consegiu atualizar os dados do produto");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }

    }

    public void deletaProduto(int id) {
        try {
            String consulta = "delete from produto where id = ?";
            PreparedStatement preparador = con.prepareStatement(consulta);
            preparador.setInt(1, id);
            int retorno = preparador.executeUpdate();
            System.out.println("retorno" + retorno);
            if (retorno > 0) {
                System.out.println("Registro deletado");
            } else {
                System.out.println("Registro não foi deletado ou não existe");
            }

        } catch (SQLException e) {
            System.out.println("Não consegiu deletar os dados do produto");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

}
