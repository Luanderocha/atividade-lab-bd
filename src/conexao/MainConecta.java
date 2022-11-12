package conexao;

import java.sql.SQLException;

import dao.ProdutoDao;

public class MainConecta {

    public static void main(String[] args) {

        ProdutoDao produtoDao = null;

        try {
            produtoDao = new ProdutoDao();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        produtoDao.consultaProdutos();
    }

}
