package duplamente;
import simplismente.ListaSimples;
import simplismente.ListaSimplesAtleta;
import dados.Atleta;
import dados.Item;
public class BlocoPrincipal {

	public static void main(String[] args) {
		
		ListaSimplesAtleta listaS = new ListaSimplesAtleta();
		
		listaS.inserirUltimo(new Atleta("fulanoA", 2.00));
		listaS.inserirUltimo(new Atleta("fulanoB", 1.90));
		listaS.inserirUltimo(new Atleta("fulanoC", 1.92));
		listaS.inserirUltimo(new Atleta("fulanoD", 2.05));
		
		ListaDuplaAtletas lista = new ListaDuplaAtletas();
				
		lista.copiarDeListaSimplesOrdenado(listaS);
		
		System.out.println(lista.toStringAtletas());
		


	}

}
