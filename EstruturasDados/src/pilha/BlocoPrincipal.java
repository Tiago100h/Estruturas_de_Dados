package pilha;

import dados.Item;
import duplamente.ListaDupla;

public class BlocoPrincipal {

	public static void main(String[] args) {
		PilhaContigua pilha1 = new PilhaContigua(100);
		
		ListaDupla lista1 = new ListaDupla();
		lista1.inserirÚltimo(new Item(5));
		lista1.inserirÚltimo(new Item(4));
		lista1.inserirÚltimo(new Item(3));
		lista1.inserirÚltimo(new Item(2));
		
		pilha1.ordenarLista(lista1);
		System.out.println(lista1.toString());
		
		
	}

}
