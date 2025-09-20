package br.unicamp.ic.inf335.beans;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;



public class AnuncioBeanTest {

    ArrayList<AnuncioBean> anuncios = new ArrayList<>();

    @Test
    public void testGetAndTestProduto() {
        ProdutoBean produto1 = new ProdutoBean("123", "Mario Kart", "Jogo da Nintendo", 250.50, "Novo");

        // Create an AnuncioBean object
        AnuncioBean anuncio = new AnuncioBean();

        // Set the ProdutoBean object in the AnuncioBean
        anuncio.setProduto(produto1);

        // Retrieve the ProdutoBean object using getProduto
        ProdutoBean retrievedProduto = anuncio.getProduto();

        // Assert that the retrieved object is the same as the one set
        assertEquals(produto1, retrievedProduto);

    }

    @Test
    public void testGetAndSetURLs() {
        try {
            ArrayList<URL> fotos = new ArrayList<>();
            fotos.add(new URL("https://rollingstone.com.br/media/uploads/2025/06/tudo-o-que-sabemos-sobre-a-nova-serie-de-carrie-para-o-prime-video_1178967679-2.jpg"));

            // Create an AnuncioBean object
            AnuncioBean anuncio = new AnuncioBean();
            anuncio.setFotosUrl(fotos);

            assertEquals(anuncio.getFotosUrl(), fotos);

        } catch (MalformedURLException e) {
                e.printStackTrace();
        }
    }


    @Test
    public void testSetAndGetDesconto() {
        // Create an AnuncioBean object
        AnuncioBean anuncio = new AnuncioBean();

        // Test setting and getting a valid desconto value
        Double descontoValue = 0.25;
        anuncio.setDesconto(descontoValue);
        assertEquals(descontoValue, anuncio.getDesconto());

        // Test setting desconto to 0.0
        descontoValue = 0.0;
        anuncio.setDesconto(descontoValue);
        assertEquals(descontoValue, anuncio.getDesconto());

        // Test setting desconto to 1.0
        descontoValue = 1.0;
        anuncio.setDesconto(descontoValue);
        assertEquals(descontoValue, anuncio.getDesconto());

        // Test setting desconto to null
        anuncio.setDesconto(null);
        assertNull(anuncio.getDesconto());
    }

    @Test
    public void testGetValor() {
        // Create a ProdutoBean object with a specific value
        ProdutoBean produto = new ProdutoBean("001", "Produto Teste", "Descrição do Produto", 200.0, "Novo");
    
        // Create an AnuncioBean object and set the ProdutoBean and desconto
        AnuncioBean anuncio = new AnuncioBean();
        anuncio.setProduto(produto);
    
        // Test with a valid desconto value (25% discount)
        anuncio.setDesconto(0.25);
        Double expectedValue = 200.0 * (1 - 0.25); // 150.0
        assertEquals(expectedValue, anuncio.getValor(), 0.001);
    
        // Test with a desconto of 0.0 (no discount)
        anuncio.setDesconto(0.0);
        expectedValue = 200.0 * (1 - 0.0); // 200.0
        assertEquals(expectedValue, anuncio.getValor(), 0.001);
    
        // Test with a desconto of 1.0 (100% discount)
        anuncio.setDesconto(1.0);
        expectedValue = 200.0 * (1 - 1.0); // 0.0
        assertEquals(expectedValue, anuncio.getValor(), 0.001);
    
        // Test with a null desconto (should return original value)
        anuncio.setDesconto(null);
        expectedValue = 200.0; // Original value
        assertEquals(expectedValue, anuncio.getValor(), 0.001);

        // Test with invalid discount values
        anuncio.setDesconto(-0.1);
        assertThrows(IllegalArgumentException.class, anuncio::getValor);

        anuncio.setDesconto(1.1);
        assertThrows(IllegalArgumentException.class, anuncio::getValor);

        // Test with null product or product value
        // Test with null product
        AnuncioBean anuncioNullProduct = new AnuncioBean();
        anuncioNullProduct.setProduto(null); // Explicitly set product to null
        assertThrows(IllegalStateException.class, anuncioNullProduct::getValor);

        // Test with product having null valor
        ProdutoBean produtoWithNullValor = new ProdutoBean();
        produtoWithNullValor.setValor(null); // Explicitly set valor to null
        anuncioNullProduct.setProduto(produtoWithNullValor);
        assertThrows(IllegalStateException.class, anuncioNullProduct::getValor);
    }
}
