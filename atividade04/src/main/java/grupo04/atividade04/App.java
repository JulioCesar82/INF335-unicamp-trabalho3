package grupo04.atividade04;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    { 
        ExibirAnunciosPorAnunciante(Anunciante01());         
    }

	private static AnuncianteBean Anunciante01() {
		AnuncianteBean anunciante = new AnuncianteBean();
        
        ArrayList<AnuncioBean> anuncios = new ArrayList<>();        
         anuncios.add(AnuncioDeProduto01());
         anuncios.add(AnuncioDeProduto02());
         
         anunciante.setAnuncios(anuncios);
         
		return anunciante;
	}
	

	private static AnuncioBean AnuncioDeProduto01() {
		ProdutoBean produto = new ProdutoBean("123", "Mario Kart", "Jogo da Nintendo", 250.50, "Novo");

         ArrayList<URL> fotos = new ArrayList<>();
         
         try {
			fotos.add(new URL("https://rollingstone.com.br/media/uploads/2025/06/tudo-o-que-sabemos-sobre-a-nova-serie-de-carrie-para-o-prime-video_1178967679-2.jpg"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         return new AnuncioBean(produto, fotos, 10.0);
	}
	
	private static AnuncioBean AnuncioDeProduto02() {
		ProdutoBean produto = new ProdutoBean("456", "Zeld Breath of the Wild", "Jogo da Nintendo", 250.00, "Novo");

         ArrayList<URL> fotos = new ArrayList<>();
         
         try {
			fotos.add(new URL("https://rollingstone.com.br/media/uploads/2025/06/tudo-o-que-sabemos-sobre-a-nova-serie-de-carrie-para-o-prime-video_1178967679-2.jpg"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         return new AnuncioBean(produto, fotos, 4.0);
	}

	
	
	
	private static void ExibirAnunciosPorAnunciante(AnuncianteBean anunciante) {
		int index = 0;
          for (AnuncioBean anuncio : anunciante.getAnuncios()) {
        	  index++;
        	  
        	  ProdutoBean produto = anuncio.getProduto();
        	  
        	  System.out.println( "Anuncio " + index + ": Valor final já descotado R$ " + anuncio.getValor() + ". Desconto: R$ " + anuncio.getDesconto() );
        	  System.out.println( produto.getCodigo() + " - " + produto.getNome() );
        	  System.out.println( produto.getDescricao() );
        	  System.out.println( );        	          	  
		}
	}
}
