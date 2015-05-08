package filaCircular;

import pilha.PilhaContigua;
import dados.Item;

public class FilaCircular {
	private Item [] info;
	private int frente;
	private int tras;
	private int tamanho;

	public FilaCircular(int qte){
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new Item [qte];
	}
	public Item getInfo(){
		return this.info[this.frente];
	}
	public int getFrente(){
		return this.frente;
	}
	public boolean ÈVazia (){
		return (this.tamanho == 0);
	}
	public boolean ÈCheia (){
		return (this.tamanho == this.info.length);
	}
	public boolean enfileirar (Item elem){
		if (this.ÈCheia()){
			return false;
		} else {
			this.info[this.tras] = elem;
			this.tras = ++this.tras % this.info.length;
			this.tamanho++;
			return true;
		}
	}
	public Item desenfileirar(){
		if (this.ÈVazia()){
			return null;
		} else {
			Item aux = this.info[this.frente];
			this.frente = ++this.frente % this.info.length;
			this.tamanho--;
			return aux;
		}
	}
	public String toString(){
		String msg="";
		int aux= this.frente;
		for (int i=0; i<this.tamanho; i++){
			msg+= this.info[aux].getChave()+" ";
			aux = ++aux % this.info.length;
		}
		return msg;
	}
	
	/*
	 * ExercÌcio 14)
	 * FaÁa um mÈtodo que retire os valores negativos da fila circular (obedecendo sua propriedade).
	 */
	public boolean removerNegativos(){
		if (this.ÈVazia()){
			return false;
		} else {
			FilaCircular aux = new FilaCircular(this.tamanho);
			while (!this.ÈVazia()){
				aux.enfileirar(this.desenfileirar());
			}
			while (!aux.ÈVazia()){
				if (aux.info[aux.frente].getChave() < 0){
					aux.desenfileirar();
				} else {
					this.enfileirar(aux.desenfileirar());
				}
			}
			return true;
		}
	}
	
	/*
	 * ExercÌcio 15)
	 * Escreva uma funÁ„o que retorne a soma dos elementos de uma fila circular. 
	 * A fila contÈm dados e ao final dever· ficar vazia. Os elementos s„o do tipo inteiro.
	 */
	public int somarElementos (){
		int soma = 0;
		while (!this.ÈVazia()){
			soma += this.desenfileirar().getChave();
		}
		return soma;
	}
	
	/*
	 * ExercÌcio 16)
	 * FaÁa uma simulaÁ„o em que uma impressora recebe todas as p·ginas de um arquivo e as imprime em ordem decrescente. 
	 * O procedimento deve utilizar uma Fila Circular para receber as p·ginas e uma Pilha para inverter a ordem de impress„o. 
	 * A p·gina È do tipo caracter. Ao final do procedimento a Fila dever· conter as p·ginas em ordem inversa e a Pilha dever· estar vazia.
	 */
	public boolean inverterOrdemDeImpress„o(){
		if (this.ÈVazia()){
			return false;
		} else {
			PilhaContigua aux = new PilhaContigua(this.tamanho);
			while (!this.ÈVazia()){
				aux.empilhar(this.desenfileirar());
			}
			while (!aux.ÈVazia()){
				this.enfileirar(aux.desempilhar());
			}
			return true;
		}
	}
	
	/*
	 * ExercÌcio 17)
	 * Em um banco financeiro existem pessoas de todas as idades em uma fila de caixa para serem atendidas. 
	 * Retire desta fila as pessoas com idade maior e igual a 70 anos e as coloque em uma nova fila. 
	 * A fila original deve permanecer com as demais pessoas. FaÁa um mÈtodo para alcanÁar este objetivo usando fila circular. 
	 * Considere que existe um atributo chamado idade para verificar a seleÁ„o e o tamanho m·ximo que a fila pode ter È de 100 posiÁıes.
	 */
	public FilaCircular criarFilaPreferencial() {
		FilaCircular idosos = new FilaCircular(100);
		FilaCircular aux = new FilaCircular(this.tamanho);
		while (!this.ÈVazia()){
			aux.enfileirar(this.desenfileirar());
		}
		while (!aux.ÈVazia()){
			if (aux.info[aux.frente].getChave() < 70 || idosos.ÈCheia()){
				this.enfileirar(aux.desenfileirar());
			} else {
				idosos.enfileirar(aux.desenfileirar());
			}
		}
		return idosos;
	}
	
	/*
	 * ExercÌcio 18)
	 * Implemente um mÈtodo para transferir todos os elementos de uma Pilha por Contiguidade para uma Fila Circular. 
	 * O mÈtodo retornar· a Fila Circular preenchida com os elementos da Pilha. 
	 * Os elementos dever„o ser inseridos na Fila de forma que o primeiro que entrou na Pilha ser· o primeiro a entrar· na fila. 
	 * As duas estruturas contÈm um ˙nico campo inteiro.
	 */
	public boolean transferirPilhaParaFila (PilhaContigua pilha){
		if (pilha.ÈVazia() || this.info.length < pilha.getTopo()){
			return false;
		} else {
			PilhaContigua aux = new PilhaContigua(pilha.getTopo());
			while (!pilha.ÈVazia()){
				aux.empilhar(pilha.desempilhar());
			}
			while (!aux.ÈVazia()){
				this.enfileirar(aux.desempilhar());
			}
			return true;
		}
	}
}
