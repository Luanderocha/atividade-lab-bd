package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                System.out.println("Nome : " + resultados.getString("nome"));
                System.out.println("Valor : " + resultados.getFloat("valor"));
                System.out.println("Qtd em estoque :" + resultados.getInt("estoque"));
                System.out.println("Unidade :" + resultados.getString("unidade"));
                System.out.println(" ------------------- ");
            }

        } catch (Exception e) {
            System.out.println("Não consegiu consultar os dados do produto");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

}
