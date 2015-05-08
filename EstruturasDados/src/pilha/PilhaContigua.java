package pilha;

import contiguidade.ListaContigua;
import dados.Item;
import duplamente.ListaDupla;
import duplamente.NoDupla;

public class PilhaContigua {	
	private Item[] info;
	private int topo;	
	public PilhaContigua (int quantidade){
		this.topo = 0;
		this.info = new Item[quantidade];
	}
	public Item getInfo() {
		return this.info[this.topo];
	}
	public void setInfo(int i, Item elem) {
		this.info[i] = elem;
	}
	public int getTopo() {
		return this.topo;
	}	
	public boolean �Vazia(){
		return (this.topo == 0);
	}
	public boolean �Cheia(){
		return (this.topo == this.info.length);
	}
	public boolean empilhar(Item elem){
		if (�Cheia()){
			return false;
		} else {
			this.info[this.topo] = elem;
			this.topo++;
			return true;
		}
	}		
	public Item desempilhar(){
		if (�Vazia()){
			return null;
		} else {
			this.topo--;
			return this.info[this.topo];
		}
	}
	
	/* Exerc�cio 8) 
	 * Uma frase pode ser representada por uma lista linear duplamente encadeada, 
	 * sendo que o campo de informa��o de cada nodo da lista cont�m um �nico caractere ou s�mbolo. 
	 * Implemente uma aplica��o para realizar as opera��es descritas a seguir.
	 * a) Converta a lista encadeada em uma pilha contigua, cujos elementos s�o caracteres;
	 */
	public boolean converterEncadeadaParaPilha(ListaDupla lista){
		if (lista.�Vazia()){
			return false;
		} else {
			NoDupla atual = lista.getPrim();
			while (atual != null && !this.�Cheia()){
				this.empilhar(new Item(atual.getInfo().getChave()));
				atual = atual.getProx();
			}
			if (atual == null){
				return false;
			} else{
				return true;
			}
		}
	}
	/*
	 * b) Implemente uma fun��o para saber ser a palavra que est� armazenada na pilha encadeada � palindroma;
	 */
	public boolean �Palindroma(){
		ListaContigua aux = new ListaContigua(this.getTopo());
		while (!this.�Vazia()){
			aux.inserirUltimo(this.desempilhar());
		}
		int i = 0;
		int j = aux.getFim() - 1;
		while (i != j){
			if (aux.getInfo(i) == aux.getInfo(j)){
				i++;
				j--;
			} else {
				return false;
			}			
		}
		return true;
	}
	/*
	 * c) Implemente uma fun��o que recebe como par�metro dois caracteres, 
	 * I1 e I2 e a pilha contigua, e retorne uma nova lista duplamente encadeada, 
	 * representando a palavra que inicia com o caractere I1 e termina com o caractere I2 que esta na pilha.
	 */
	
	/*
	 * Exerc�cio 9) 
	 * Utilizando a estrutura de uma pilha por contiguidade, leia uma palavra ou frase e a exiba na ordem inversa.
	 */
	public String inverter (String palavraOUfrase){
		String aux = "";
		if (palavraOUfrase.length() > this.info.length){
			return aux;
		} else {
			for (int i = 0; i < palavraOUfrase.length(); i++){
				this.empilhar(new Item(palavraOUfrase.charAt(i)));
			}
			while (!this.�Vazia()){
				aux += this.desempilhar().getChave();
			}
			return aux;
		}		
	}
	
	/*
	 * Exerc�cio 10) 
	 * Fa�a um m�todo que retire os valores maiores que 10 da pilha por contiguidade (obedecendo sua propriedade).
	 */
	public boolean removerMaioresQueDez(){
		if (this.�Vazia()){
			return false;
		} else {
			if (this.topo == 1){
				if (this.info[this.topo - 1].getChave() > 10){
					this.desempilhar();
					return true;
				} else {
					return false;
				}
			} else {
				PilhaContigua aux = new PilhaContigua(this.topo);
				while (!this.�Vazia()){
					aux.empilhar(this.desempilhar());
				}
				while (!aux.�Vazia()){
					if (aux.info[this.topo - 1].getChave() > 10){
						aux.desempilhar();
					} else {
						this.empilhar(aux.desempilhar());
					}
				}
			}
			return true;
		}
	}
	
	/*
	 * Exerc�cio 11) 
	 * Implemente um algoritmo que teste se duas pilhas s�o ou n�o iguais. 
	 * O algoritmo deve retornar 1 se as duas pilhas forem iguais, e 0 caso contr�rio. 
	 * Ao final da execu��o, as duas pilhas devem estar no mesmo estado em que estavam no in�cio. 
	 */
	public boolean s�oIguais (PilhaContigua pilha){
		if (this.info.length != pilha.info.length){
			return false;
		} else {
			if (this.�Vazia() && pilha.�Vazia()){
				return true;
			} else {
				boolean iguais = true;
				PilhaContigua aux1 = new PilhaContigua(this.topo);
				PilhaContigua aux2 = new PilhaContigua(pilha.topo);
				while (!this.�Vazia()){
					aux1.empilhar(this.desempilhar());
					aux2.empilhar(pilha.desempilhar());
				}
				while (!aux1.�Vazia()){
					if (aux1.info[aux1.topo - 1].getChave() != aux2.info[aux2.topo - 1].getChave()){
						iguais = false;
					}
					this.empilhar(aux1.desempilhar());
					pilha.empilhar(aux2.desempilhar());
				}
				return iguais;
			}
		}
	}
	
	/*
	 * Exerc�cio 12)
	 * Uma empresa precisa imprimir documentos em ordem crescente por n�mero de CPF de seus clientes. 
	 * Fa�a um algoritmo para colocar os documentos na ordem que se pede. 
	 * Uma Lista Duplamente Encadeada cont�m os documentos na ordem aleat�ria e uma Pilha dever� ser usada para auxiliar o processo de ordena��o. 
	 * Ao final, a Lista dever� conter os documentos em ordem crescente e a Pilha dever� estar vazia.
	 */
	public boolean ordenarLista (ListaDupla lista){
		if (lista.getQuantNos() < 2 || this.info.length < lista.getQuantNos()){
			return false;
		} else {
			while (!lista.�Vazia()){
				this.empilhar(lista.getPrim().getInfo());
				lista.removerN�(lista.getPrim());				
			}
			lista.inserir�ltimo(this.desempilhar());
			while (!this.�Vazia()){
				if (this.info[this.topo - 1].getChave() <= lista.getPrim().getInfo().getChave()){
					lista.inserirPrimeiro(this.desempilhar());
				} else {
					if (this.info[this.topo - 1].getChave() >= lista.getUlt().getInfo().getChave()){
						lista.inserir�ltimo(this.desempilhar());
					} else {
						NoDupla atual = lista.getPrim();
						NoDupla novoNo = new NoDupla(this.desempilhar());
						while (atual.getInfo().getChave() < novoNo.getInfo().getChave() ){
							atual = atual.getProx();
						}
						novoNo.setProx(atual);
						novoNo.setAnt(atual.getAnt());
						atual.getAnt().setProx(novoNo);
						atual.setAnt(novoNo);
						lista.setQuantNos(lista.getQuantNos() + 1);
					}
				}
			}
			return true;
		}
	}
	
	
		
}
