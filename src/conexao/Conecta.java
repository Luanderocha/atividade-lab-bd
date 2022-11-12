package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {

    static final String URL = "jdbc:h2:tcp://localhost/~/test";
    static final String USER = "sa";
    static final String PASS = "";

    public static Connection criarConexao() throws ClassNotFoundException, SQLException {
        Connection conecta = null;
        try {
            Class.forName("org.h2.Driver");
            conecta = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectou no banco de dados");
        } catch (SQLException e) {
            System.out.println("Não conseguiu conectar no banco de dados");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Não encontrou o driver do banco de dados");
        }
        return conecta;
    }

    public void desconectar(Connection conecta) {
        try {
            if (conecta != null && conecta.isClosed()) {
                conecta.close();
                System.out.println("Desconectou do banco de dados");
            }
        } catch (SQLException e) {
            System.out.println("Não conseguiu desconectar do banco de dados");
        }
    }

}
