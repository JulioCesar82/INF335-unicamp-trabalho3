package br.unicamp.ic.inf335.beans;
import org.junit.*;

import static org.junit.Assert.*;

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
    
        // Test with a valid desconto value
        anuncio.setDesconto(0.25); // 25% discount
        Double expectedValue = 200.0 - (200.0 * 0.25);
        assertEquals(expectedValue, anuncio.getValor(), 0.001);
    
        // Test with a desconto of 0.0 (no discount)
        anuncio.setDesconto(0.0);
        assertThrows(ArithmeticException.class, anuncio::getValor);
    
    
        // Test with a desconto of 1.0 (100% discount)
        anuncio.setDesconto(1.0);
        expectedValue = 200.0 - (200.0 * 1.0);
        assertEquals(expectedValue, anuncio.getValor(), 0.001);
    
        // Test with a null desconto
        anuncio.setDesconto(null);
        try {
            anuncio.getValor();
            fail("Expected NullPointerException due to null desconto");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }
}
