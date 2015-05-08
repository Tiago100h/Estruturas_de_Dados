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
	public boolean �Vazia (){
		return (this.tamanho == 0);
	}
	public boolean �Cheia (){
		return (this.tamanho == this.info.length);
	}
	public boolean enfileirar (Item elem){
		if (this.�Cheia()){
			return false;
		} else {
			this.info[this.tras] = elem;
			this.tras = ++this.tras % this.info.length;
			this.tamanho++;
			return true;
		}
	}
	public Item desenfileirar(){
		if (this.�Vazia()){
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
	 * Exerc�cio 14)
	 * Fa�a um m�todo que retire os valores negativos da fila circular (obedecendo sua propriedade).
	 */
	public boolean removerNegativos(){
		if (this.�Vazia()){
			return false;
		} else {
			FilaCircular aux = new FilaCircular(this.tamanho);
			while (!this.�Vazia()){
				aux.enfileirar(this.desenfileirar());
			}
			while (!aux.�Vazia()){
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
	 * Exerc�cio 15)
	 * Escreva uma fun��o que retorne a soma dos elementos de uma fila circular. 
	 * A fila cont�m dados e ao final dever� ficar vazia. Os elementos s�o do tipo inteiro.
	 */
	public int somarElementos (){
		int soma = 0;
		while (!this.�Vazia()){
			soma += this.desenfileirar().getChave();
		}
		return soma;
	}
	
	/*
	 * Exerc�cio 16)
	 * Fa�a uma simula��o em que uma impressora recebe todas as p�ginas de um arquivo e as imprime em ordem decrescente. 
	 * O procedimento deve utilizar uma Fila Circular para receber as p�ginas e uma Pilha para inverter a ordem de impress�o. 
	 * A p�gina � do tipo caracter. Ao final do procedimento a Fila dever� conter as p�ginas em ordem inversa e a Pilha dever� estar vazia.
	 */
	public boolean inverterOrdemDeImpress�o(){
		if (this.�Vazia()){
			return false;
		} else {
			PilhaContigua aux = new PilhaContigua(this.tamanho);
			while (!this.�Vazia()){
				aux.empilhar(this.desenfileirar());
			}
			while (!aux.�Vazia()){
				this.enfileirar(aux.desempilhar());
			}
			return true;
		}
	}
	
	/*
	 * Exerc�cio 17)
	 * Em um banco financeiro existem pessoas de todas as idades em uma fila de caixa para serem atendidas. 
	 * Retire desta fila as pessoas com idade maior e igual a 70 anos e as coloque em uma nova fila. 
	 * A fila original deve permanecer com as demais pessoas. Fa�a um m�todo para alcan�ar este objetivo usando fila circular. 
	 * Considere que existe um atributo chamado idade para verificar a sele��o e o tamanho m�ximo que a fila pode ter � de 100 posi��es.
	 */
	public FilaCircular criarFilaPreferencial() {
		FilaCircular idosos = new FilaCircular(100);
		FilaCircular aux = new FilaCircular(this.tamanho);
		while (!this.�Vazia()){
			aux.enfileirar(this.desenfileirar());
		}
		while (!aux.�Vazia()){
			if (aux.info[aux.frente].getChave() < 70 || idosos.�Cheia()){
				this.enfileirar(aux.desenfileirar());
			} else {
				idosos.enfileirar(aux.desenfileirar());
			}
		}
		return idosos;
	}
	
	/*
	 * Exerc�cio 18)
	 * Implemente um m�todo para transferir todos os elementos de uma Pilha por Contiguidade para uma Fila Circular. 
	 * O m�todo retornar� a Fila Circular preenchida com os elementos da Pilha. 
	 * Os elementos dever�o ser inseridos na Fila de forma que o primeiro que entrou na Pilha ser� o primeiro a entrar� na fila. 
	 * As duas estruturas cont�m um �nico campo inteiro.
	 */
	public boolean transferirPilhaParaFila (PilhaContigua pilha){
		if (pilha.�Vazia() || this.info.length < pilha.getTopo()){
			return false;
		} else {
			PilhaContigua aux = new PilhaContigua(pilha.getTopo());
			while (!pilha.�Vazia()){
				aux.empilhar(pilha.desempilhar());
			}
			while (!aux.�Vazia()){
				this.enfileirar(aux.desempilhar());
			}
			return true;
		}
	}
}
