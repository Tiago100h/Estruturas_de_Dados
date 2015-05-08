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
	public boolean éVazia(){
		return (this.topo == 0);
	}
	public boolean éCheia(){
		return (this.topo == this.info.length);
	}
	public boolean empilhar(Item elem){
		if (éCheia()){
			return false;
		} else {
			this.info[this.topo] = elem;
			this.topo++;
			return true;
		}
	}		
	public Item desempilhar(){
		if (éVazia()){
			return null;
		} else {
			this.topo--;
			return this.info[this.topo];
		}
	}
	
	/* Exercício 8) 
	 * Uma frase pode ser representada por uma lista linear duplamente encadeada, 
	 * sendo que o campo de informação de cada nodo da lista contém um único caractere ou símbolo. 
	 * Implemente uma aplicação para realizar as operações descritas a seguir.
	 * a) Converta a lista encadeada em uma pilha contigua, cujos elementos são caracteres;
	 */
	public boolean converterEncadeadaParaPilha(ListaDupla lista){
		if (lista.éVazia()){
			return false;
		} else {
			NoDupla atual = lista.getPrim();
			while (atual != null && !this.éCheia()){
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
	 * b) Implemente uma função para saber ser a palavra que está armazenada na pilha encadeada é palindroma;
	 */
	public boolean éPalindroma(){
		ListaContigua aux = new ListaContigua(this.getTopo());
		while (!this.éVazia()){
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
	 * c) Implemente uma função que recebe como parâmetro dois caracteres, 
	 * I1 e I2 e a pilha contigua, e retorne uma nova lista duplamente encadeada, 
	 * representando a palavra que inicia com o caractere I1 e termina com o caractere I2 que esta na pilha.
	 */
	
	/*
	 * Exercício 9) 
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
			while (!this.éVazia()){
				aux += this.desempilhar().getChave();
			}
			return aux;
		}		
	}
	
	/*
	 * Exercício 10) 
	 * Faça um método que retire os valores maiores que 10 da pilha por contiguidade (obedecendo sua propriedade).
	 */
	public boolean removerMaioresQueDez(){
		if (this.éVazia()){
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
				while (!this.éVazia()){
					aux.empilhar(this.desempilhar());
				}
				while (!aux.éVazia()){
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
	 * Exercício 11) 
	 * Implemente um algoritmo que teste se duas pilhas são ou não iguais. 
	 * O algoritmo deve retornar 1 se as duas pilhas forem iguais, e 0 caso contrário. 
	 * Ao final da execução, as duas pilhas devem estar no mesmo estado em que estavam no início. 
	 */
	public boolean sãoIguais (PilhaContigua pilha){
		if (this.info.length != pilha.info.length){
			return false;
		} else {
			if (this.éVazia() && pilha.éVazia()){
				return true;
			} else {
				boolean iguais = true;
				PilhaContigua aux1 = new PilhaContigua(this.topo);
				PilhaContigua aux2 = new PilhaContigua(pilha.topo);
				while (!this.éVazia()){
					aux1.empilhar(this.desempilhar());
					aux2.empilhar(pilha.desempilhar());
				}
				while (!aux1.éVazia()){
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
	 * Exercício 12)
	 * Uma empresa precisa imprimir documentos em ordem crescente por número de CPF de seus clientes. 
	 * Faça um algoritmo para colocar os documentos na ordem que se pede. 
	 * Uma Lista Duplamente Encadeada contêm os documentos na ordem aleatória e uma Pilha deverá ser usada para auxiliar o processo de ordenação. 
	 * Ao final, a Lista deverá conter os documentos em ordem crescente e a Pilha deverá estar vazia.
	 */
	public boolean ordenarLista (ListaDupla lista){
		if (lista.getQuantNos() < 2 || this.info.length < lista.getQuantNos()){
			return false;
		} else {
			while (!lista.éVazia()){
				this.empilhar(lista.getPrim().getInfo());
				lista.removerNó(lista.getPrim());				
			}
			lista.inserirÚltimo(this.desempilhar());
			while (!this.éVazia()){
				if (this.info[this.topo - 1].getChave() <= lista.getPrim().getInfo().getChave()){
					lista.inserirPrimeiro(this.desempilhar());
				} else {
					if (this.info[this.topo - 1].getChave() >= lista.getUlt().getInfo().getChave()){
						lista.inserirÚltimo(this.desempilhar());
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
