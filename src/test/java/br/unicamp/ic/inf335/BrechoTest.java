package br.unicamp.ic.inf335;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.ProdutoBean;

class BrechoTest {

	private ArrayList<ProdutoBean> produtos;

	@BeforeEach
	void setUp() {
		produtos = new ArrayList<>();
		produtos.add(new ProdutoBean("CD001", "Produto A", "Descricao A", 100.0, "Novo"));
		produtos.add(new ProdutoBean("CD002", "Produto B", "Descricao B", 200.0, "Usado"));
		produtos.add(new ProdutoBean("CD003", "Produto C", "Descricao C", 50.0, "Novo"));
	}

	@Test
	@DisplayName("Testa a adicao de produtos")
	void testAdicionarProdutos() {
		assertEquals(3, produtos.size());
		produtos.add(new ProdutoBean("CD004", "Produto D", "Descricao D", 150.0, "Usado"));
		assertEquals(4, produtos.size());
	}

	@Test
	@DisplayName("Testa a ordenacao de produtos")
	void testOrdenarProdutos() {
		Collections.sort(produtos);
		assertEquals("CD003", produtos.get(0).getCodigo()); // 50.0
		assertEquals("CD001", produtos.get(1).getCodigo()); // 100.0
		assertEquals("CD002", produtos.get(2).getCodigo()); // 200.0
	}

	@Test
	@DisplayName("Testa o calculo da media de valores")
	void testCalcularMediaValores() {
		Double media = 0.0;
		for (ProdutoBean produto : produtos) {
			media += produto.getValor();
		}
		media = media / produtos.size();
		assertEquals(116.666, media, 0.001); // 100 + 200 + 50 = 350 / 3 = 116.666...
	}

}
