package br.unicamp.ic.inf335.beans;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.net.URL;

public class AnuncianteBeanTest {

    AnuncianteBean anunciante = new AnuncianteBean();
    ProdutoBean produto1 = new ProdutoBean();
    ArrayList<AnuncioBean> anuncios = new ArrayList<>();

    @Test
    public void testGetAndSetNome() {
        anunciante.setNome("Joao");
        String nome = anunciante.getNome();
        assertEquals("Joao", nome);
    }

    @Test
    public void testGetAndSetCPF() {
        anunciante.setCPF("965.192.970-70");
        String cpf = anunciante.getCPF();
        assertEquals("965.192.970-70", cpf);
    }

    @Test
    public void testGetAndSetAnuncios() {
        try {
        
            ProdutoBean produto1 = new ProdutoBean("123", "Mario Kart", "Jogo da Nintendo", 250.50, "Novo");

            ArrayList<URL> fotos = new ArrayList<>();
            fotos.add(new URL("https://rollingstone.com.br/media/uploads/2025/06/tudo-o-que-sabemos-sobre-a-nova-serie-de-carrie-para-o-prime-video_1178967679-2.jpg"));
            AnuncioBean anuncio1 = new AnuncioBean(produto1, fotos, 10.0);

            anuncios.add(anuncio1);
            anunciante.setAnuncios(anuncios);
    
            assertEquals(anuncios, anunciante.getAnuncios());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddAnuncios() {
        try {
        
            ProdutoBean produto1 = new ProdutoBean("123", "Mario Kart", "Jogo da Nintendo", 250.50, "Novo");

            ArrayList<URL> fotos = new ArrayList<>();
            fotos.add(new URL("https://rollingstone.com.br/media/uploads/2025/06/tudo-o-que-sabemos-sobre-a-nova-serie-de-carrie-para-o-prime-video_1178967679-2.jpg"));
            AnuncioBean anuncio1 = new AnuncioBean(produto1, fotos, 10.0);

            anuncios.add(anuncio1);
            assertEquals(anuncios.size(), 1);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveAnuncio() {
        try {
        
            ProdutoBean produto1 = new ProdutoBean("123", "Mario Kart", "Jogo da Nintendo", 250.50, "Novo");

            ArrayList<URL> fotos = new ArrayList<>();
            fotos.add(new URL("https://rollingstone.com.br/media/uploads/2025/06/tudo-o-que-sabemos-sobre-a-nova-serie-de-carrie-para-o-prime-video_1178967679-2.jpg"));
            AnuncioBean anuncio1 = new AnuncioBean(produto1, fotos, 10.0);

            anuncios.remove(anuncio1);
            assertEquals(anuncios.size(), 0);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testValorMedioAnuncios() {
        try {
            ProdutoBean produto1 = new ProdutoBean("123", "Mario Kart", "Jogo da Nintendo", 250.00, "Novo");

            
            ArrayList<URL> fotos = new ArrayList<>();
            fotos.add(new URL("https://rollingstone.com.br/media/uploads/2025/06/tudo-o-que-sabemos-sobre-a-nova-serie-de-carrie-para-o-prime-video_1178967679-2.jpg"));
            AnuncioBean anuncio1 = new AnuncioBean(produto1, fotos, 0.1);

            anuncios.add(anuncio1);

            ProdutoBean produto2 = new ProdutoBean("456", "Zeld Breath of the Wild", "Jogo da Nintendo", 250.00, "Novo");

            ArrayList<URL> fotos2 = new ArrayList<>();
            fotos2.add(new URL("https://rollingstone.com.br/media/uploads/2025/06/tudo-o-que-sabemos-sobre-a-nova-serie-de-carrie-para-o-prime-video_1178967679-2.jpg"));
            AnuncioBean anuncio2 = new AnuncioBean(produto2, fotos2, 0.1);

            anuncios.add(anuncio2);

            anunciante.setAnuncios(anuncios);
            assertEquals(Double.valueOf(225.0), Double.valueOf(anunciante.valorMedioAnuncios()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
