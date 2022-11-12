package conexao;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import bean.Produto;
import dao.ProdutoDao;

public class MainConecta {

    public static void main(String[] args) {

        ProdutoDao produtoDao = null;
        Produto produto = new Produto();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        try {
            produtoDao = new ProdutoDao();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---*----*---");
        System.out.println("Digite a opção que deseja realizar :");
        System.out.println("1 - Inserir produto");
        System.out.println("2 - Atualizar produto");
        System.out.println("3 - Buscar todos produtos");
        System.out.println("4 - Buscar produto pelo seu ID");
        System.out.println("5 - Deletar produto");
        System.out.println("0 - Sair");
        System.out.println("_");
        int opcao = scanner.nextInt();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println("---*----*---");
                    System.out.println("Nome do produto : ");
                    String nome = scanner.next();
                    produto.setNome(nome);

                    System.out.println("valor do produto : ");
                    Double valor = scanner.nextDouble();
                    produto.setValor(valor);

                    System.out.println("Quantidade em estoque : ");
                    Integer estoque = scanner.nextInt();
                    produto.setEstoque(estoque);

                    System.out.println("nome da unidade de medida : ");
                    String unidade = scanner.next();
                    produto.setUnidade(unidade);

                    produtoDao.inserirProduto(produto);
                    break;
                case 2:
                    System.out.println("---*----*---");
                    System.out.println("ID do produto que deseja atualizar : ");
                    Integer idproduto = scanner.nextInt();
                    
                    System.out.println("Nome do produto que deseja atualizar : ");
                    String nomeA = scanner.next();
                    produto.setNome(nomeA);
                    
                    System.out.println("valor do produto que deseja atualizar : ");
                    Double valorA = scanner.nextDouble();
                    produto.setValor(valorA);
                    
                    System.out.println("Quantidade em estoque que deseja atualizar : ");
                    Integer estoqueA = scanner.nextInt();
                    produto.setEstoque(estoqueA);
                    
                    System.out.println("nome da unidade de medida que deseja atualizar : ");
                    String unidadeA = scanner.next();
                    produto.setUnidade(unidadeA);
                    
                    produtoDao.atualizarProduto(produto, idproduto);
                    break;
                case 3:
                    System.out.println("---*----*---");
                    System.out.println("----- * Produtos listados * ----");
                    produtoDao.consultaProdutos();
                    break;
                case 4:
                    System.out.println("---*----*---");
                    System.out.println("Digite o Id do produto que deseja consultar :");
                    Integer idProduto = scanner.nextInt();
                    produtoDao.consultaProdutoPorId(idProduto);
                    break;
                case 5:
                    System.out.println("---*----*---");
                    System.out.println("Digite o Id do produto que deseja deletar :");
                    Integer idProdutoD = scanner.nextInt();
                    produtoDao.deletaProduto(idProdutoD);
                    break;
                default:
                    System.out.println("---*----*---");
                    System.out.println("Opção inválida , digite novamente :");
                    break;
            }

            System.out.println("---*----*---");
            System.out.println("Digite a opção que deseja realizar novamente:");
            System.out.println("1 - Inserir produto");
            System.out.println("2 - Atualizar produto");
            System.out.println("3 - Buscar todos produtos");
            System.out.println("4 - Buscar produto pelo seu ID");
            System.out.println("5 - Deletar produto");
            System.out.println("0 - Finalizar");
            System.out.println("_");
            opcao = scanner.nextInt();
        }

        scanner.close();

    }

}
