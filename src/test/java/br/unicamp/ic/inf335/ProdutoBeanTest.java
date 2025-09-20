package br.unicamp.ic.inf335;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.ProdutoBean;

class ProdutoBeanTest {

	@Test
	@DisplayName("Testa o construtor padrao")
	void testProdutoBean() {
		ProdutoBean produto = new ProdutoBean();
		assertNotNull(produto);
		assertEquals("", produto.getCodigo());
		assertEquals("", produto.getNome());
		assertEquals("", produto.getDescricao());
		assertEquals(0.0, produto.getValor());
		assertEquals("", produto.getEstado());
	}

	@Test
	@DisplayName("Testa o construtor com parametros")
	void testProdutoBeanStringStringStringDoubleString() {
		ProdutoBean produto = new ProdutoBean("CD001", "Produto A", "Descricao A", 100.0, "Novo");
		assertNotNull(produto);
		assertEquals("CD001", produto.getCodigo());
		assertEquals("Produto A", produto.getNome());
		assertEquals("Descricao A", produto.getDescricao());
		assertEquals(100.0, produto.getValor());
		assertEquals("Novo", produto.getEstado());
	}

	@Test
	@DisplayName("Testa os metodos get e set")
	void testGetSetMethods() {
		ProdutoBean produto = new ProdutoBean();
		
		produto.setCodigo("CD002");
		assertEquals("CD002", produto.getCodigo());
		
		produto.setNome("Produto B");
		assertEquals("Produto B", produto.getNome());
		
		produto.setDescricao("Descricao B");
		assertEquals("Descricao B", produto.getDescricao());
		
		produto.setValor(200.0);
		assertEquals(200.0, produto.getValor());
		
		produto.setEstado("Usado");
		assertEquals("Usado", produto.getEstado());
	}

	@Test
	@DisplayName("Testa o metodo compareTo")
	void testCompareTo() {
		ProdutoBean p1 = new ProdutoBean("CD001", "Produto A", "Descricao A", 100.0, "Novo");
		ProdutoBean p2 = new ProdutoBean("CD002", "Produto B", "Descricao B", 200.0, "Usado");
		ProdutoBean p3 = new ProdutoBean("CD003", "Produto C", "Descricao C", 100.0, "Novo");
		
		assertTrue(p1.compareTo(p2) < 0); // p1.valor < p2.valor
		assertTrue(p2.compareTo(p1) > 0); // p2.valor > p1.valor
		assertEquals(0, p1.compareTo(p3)); // p1.valor == p3.valor
	}

}
