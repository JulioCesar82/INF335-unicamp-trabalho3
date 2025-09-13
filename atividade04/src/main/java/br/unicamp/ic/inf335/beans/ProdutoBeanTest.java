package br.unicamp.ic.inf335.beans;

import org.junit.*;
import static org.junit.Assert.*;

public class ProdutoBeanTest {
    ProdutoBean produto = new ProdutoBean();

    @Test
    public void testGetAndSetCodigo() {
        produto.setCodigo("123456");
        String produtoCodigo = produto.getCodigo();
        assertEquals("123456", produtoCodigo);
    }

    @Test
    public void testGetAndSetNome() {
        produto.setNome("The Witcher 3");
        String produtoNome = produto.getNome();
        assertEquals("The Witcher 3", produtoNome);
    }

    @Test
    public void testGetAndSetDescricao() {
        produto.setDescricao("Terceiro jogo da série The Witcher 3");
        String produtoDescricao = produto.getDescricao();
        assertEquals("Terceiro jogo da série The Witcher 3", produtoDescricao);
    }

    @Test
    public void testGetAndSetValor() {
        Double novoValorProduto = 60.0;
        produto.setValor(novoValorProduto);
        Double produtoValor = produto.getValor();
        assertEquals(novoValorProduto, produtoValor);
    }

    @Test
    public void testGetAndSetEstado() {
        produto.setEstado("Disponivel");
        String produtoEstado = produto.getEstado();
        assertEquals("Disponivel", produtoEstado);
    }

    @Test
    public void testGetSerialversionuid() {
        // Expected serialVersionUID value
        long expectedSerialVersionUID = 1L;

        // Assert that the method returns the correct value
        assertEquals(expectedSerialVersionUID, AnuncioBean.getSerialversionuid());
    }

    @Test
    public void testCompareTo() {
        // Create ProdutoBean objects with different values
        ProdutoBean produto1 = new ProdutoBean("001", "Produto A", "Descrição A", 100.0, "Novo");
        ProdutoBean produto2 = new ProdutoBean("002", "Produto B", "Descrição B", 200.0, "Usado");
        ProdutoBean produto3 = new ProdutoBean("003", "Produto C", "Descrição C", 100.0, "Novo");

        // Test when produto1 < produto2
        assertEquals(-1, produto1.compareTo(produto2));

        // Test when produto2 > produto1
        assertEquals(1, produto2.compareTo(produto1));

        // Test when produto1 == produto3
        assertEquals(0, produto1.compareTo(produto3));
    }
}
