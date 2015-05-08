package contiguidade;

import dados.ItemNome;

public abstract class Testes {

	public static void main(String[] args) {
		ListaContiguaNome listaContigua = new ListaContiguaNome(10);
		
		listaContigua.inserirUltimo(new ItemNome('a', 123456789));
		listaContigua.inserirUltimo(new ItemNome('b', 741852963));
		listaContigua.inserirUltimo(new ItemNome('c', 147258369));
		listaContigua.inserirUltimo(new ItemNome('d', 753951456));
		listaContigua.inserirUltimo(new ItemNome('e', 987654322));
		
		System.out.println(listaContigua.toString());
		
		listaContigua.inserirAntesNome(new ItemNome('x', 999999999), 'b');
		
		System.out.println(listaContigua.toString());
	}

}
