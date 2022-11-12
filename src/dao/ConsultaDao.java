package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conecta;

public class ConsultaDao {

    private Connection con;

    public ConsultaDao() throws SQLException, ClassNotFoundException {
        con = Conecta.criarConexao();
    }

    public void consultaOpcao1() {
        try {
            String consulta = "SELECT p.id_cliente , p.id as id_pedido, c.nome , c.cpf , c.sexo , c.data_nasc , c.status as status_cliente , p.preco, p.data_pedido , p.status as status_pedido , p.forma_pagamento FROM cliente c INNER JOIN pedido p ON (p.id_cliente = c.id and p.preco is not null);";
            PreparedStatement preparador = con.prepareStatement(consulta);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                System.out.println("ID cliente : " + resultados.getInt("id_cliente"));
                System.out.println("ID pedido : " + resultados.getInt("id_pedido"));
                System.out.println("Nome do cliente: " + resultados.getString("nome"));
                System.out.println("cpf : " + resultados.getLong("cpf"));
                System.out.println("sexo : " + resultados.getString("sexo"));
                System.out.println("Data de nascimento : " + resultados.getDate("data_nasc"));
                System.out.println("Status do cliente : " + resultados.getString("status_cliente"));
                System.out.println("Status do pedido : " + resultados.getString("status_pedido"));
                System.out.println("data do pedido : " + resultados.getDate("data_pedido"));
                System.out.println("forma de pagamento do pedido : " + resultados.getString("forma_pagamento"));
                System.out.println("preço do pedido : " + resultados.getString("preco"));
                System.out.println(" ------------------- ");
            }

        } catch (SQLException e) {
            System.out.println("Não conseguiu realizar a consulta");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

    public void consultaopcao2() {
        try {
            String consulta = "select sum(p.preco) as soma_preco , c.nome , p.forma_pagamento from cliente c inner join pedido p on (p.id_cliente = c.id and p.preco is not null) group by P.preco, C.Nome, P.forma_pagamento;";
            PreparedStatement preparador = con.prepareStatement(consulta);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                System.out.println("Soma dos preços : " + resultados.getDouble("soma_preco"));
                System.out.println("nome do cliente: " + resultados.getString("nome"));
                System.out.println("forma de pagamento: " + resultados.getString("forma_pagamento"));
                System.out.println(" ------------------- ");
            }

        } catch (SQLException e) {
            System.out.println("Não conseguiu realizar a consulta");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

    public void consultaopcao3() {
        try {
            String consulta = "select c.nome , count(p.id) as qtd_pedidos from cliente c, pedido p where p.id_cliente = c.id group by c.id  having count(p.id) > 3;";
            PreparedStatement preparador = con.prepareStatement(consulta);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                System.out.println("nome do cliente: " + resultados.getString("nome"));
                System.out.println("Quantidade de pedidos: " + resultados.getInt("qtd_pedidos"));
                System.out.println(" ------------------- ");
            }

        } catch (SQLException e) {
            System.out.println("Não conseguiu realizar a consulta");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

    public void consultaopcao4() {
        try {
            String consulta = "SELECT p.id_cliente, c.nome,  p.preco , p.data_pedido , p.forma_pagamento , t.nome as nome_produto FROM cliente c INNER JOIN pedido p ON (p.id_cliente = c.id and p.preco is not null) INNER JOIN item_pedido i ON (i.id_pedido = p.id) INNER JOIN produto t ON (t.id = i.id_produto);";
            PreparedStatement preparador = con.prepareStatement(consulta);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                System.out.println("ID do cliente: " + resultados.getInt("id_cliente"));
                System.out.println("nome do cliente: " + resultados.getString("nome"));
                System.out.println("Preço do pedido: " + resultados.getDouble("preco"));
                System.out.println("Data do pedido: " + resultados.getDate("data_pedido"));
                System.out.println("Forma de pagamento: " + resultados.getString("forma_pagamento"));
                System.out.println("nome do produto: " + resultados.getString("nome_produto"));
                System.out.println(" ------------------- ");
            }

        } catch (SQLException e) {
            System.out.println("Não conseguiu realizar a consulta");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

    public void consultaopcao5() {
        try {
            String consulta = "select c.nome as nome_cliente , p.data_pedido , p.preco , case when p.preco > 100 then 'Grande' when p.preco between 50.00 and 99.99 then 'medio' when p.preco < 50 then 'Pequeno' else 'SEM TAMANHO' end  as tamanho_pedido from cliente c , pedido p where p.id_cliente = c.id and p.preco is not null;";
            PreparedStatement preparador = con.prepareStatement(consulta);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                System.out.println("nome do cliente: " + resultados.getString("nome_cliente"));
                System.out.println("Data do pedido: " + resultados.getDate("data_pedido"));
                System.out.println("Preço : " + resultados.getDouble("preco"));
                System.out.println("Tamanho do pedido: " + resultados.getString("tamanho_pedido"));
                System.out.println(" ------------------- ");
            }

        } catch (SQLException e) {
            System.out.println("Não conseguiu realizar a consulta");
        } finally {
            Conecta conecta = new Conecta();
            conecta.desconectar(con);
        }
    }

}
