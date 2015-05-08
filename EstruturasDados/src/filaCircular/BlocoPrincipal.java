package filaCircular;

import pilha.PilhaContigua;
import dados.Item;

public class BlocoPrincipal {

	public static void main(String[] args) {
		FilaCircular fila = new FilaCircular(100);
		PilhaContigua pilha = new PilhaContigua(100);
		pilha.empilhar(new Item(2));
		pilha.empilhar(new Item(4));
		pilha.empilhar(new Item(1));
		pilha.empilhar(new Item(7));
		fila.transferirPilhaParaFila(pilha);
		System.out.println(fila.toString());
		
	}

}
