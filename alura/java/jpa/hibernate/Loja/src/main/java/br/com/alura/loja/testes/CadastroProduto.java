package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {

        Categoria categoria = new Categoria("Celulares");
        Produto celular = new Produto(
                "Readmi",
                "Muito legal",
                new BigDecimal("800"),
                categoria
        );

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();

        categoriaDAO.cadastrar(categoria);
        produtoDAO.cadastrar(celular);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
