package simplismente;

import dados.*;

public class BlocoPrincipal {

	public static void main(String[] args) {
		
		
		ListaSimples lista1 = new ListaSimples();
		lista1.inserirUltimo(new Item(1));
		lista1.inserirUltimo(new Item(3));
		lista1.inserirUltimo(new Item(5));
		lista1.inserirUltimo(new Item(7));
		
		lista1.removerKesimo(3);
		System.out.println(lista1.toString());

		
		}
}


