package duplamente;

import simplismente.ListaSimples;
import simplismente.No;
import dados.Item;

public class ListaDupla {
	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;
	
	public ListaDupla(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public NoDupla getPrim() {
		return this.prim;
	}

	public NoDupla getUlt() {
		return this.ult;
	}

	public int getQuantNos() {
		return this.quantNos;
	}
		
	public void setQuantNos(int quantNos) {
		this.quantNos = quantNos;
	}

	public boolean éVazia() {
		return (this.prim == null);
	}
	
	public void inserirPrimeiro(Item elem) {
		NoDupla novoNo = new NoDupla(elem);
		this.quantNos++;
		if (this.éVazia()){
			this.ult = novoNo;
		} else {
			this.prim.setAnt(novoNo);
			novoNo.setProx(this.prim);
		}		
		this.prim = novoNo;
	}
	
	public void inserirÚltimo(Item elem) {
		NoDupla novoNo = new NoDupla(elem);
		this.quantNos++;
		if (this.éVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
			novoNo.setAnt(this.ult);
		}
		this.ult = novoNo;
	}
	
	public NoDupla pesquisarNo(int chave) {
		NoDupla atual = this.prim;
		while (atual.getInfo().getChave() != chave && atual != null){
			atual = atual.getProx();
		}
		return atual;
	}
	
	public boolean removerElem(int chave) {
		if (this.éVazia()){
			return false;
		} else {
			if (this.prim.getInfo().getChave() ==  chave){
				if (this.quantNos == 1){
					this.prim = null;
					this.ult = null;
				} else {
					this.prim = this.prim.getProx();
					this.prim.setAnt(null);
				}				
			} else {
				if (this.ult.getInfo().getChave() == chave){
					this.ult.getAnt().setProx(null);
				} else {
					NoDupla atual = this.prim.getProx();
					while (atual.getInfo().getChave() != chave && atual != this.ult){
						atual = atual.getProx();
					}
					if (atual == this.ult){
						return false;
					} else {
						atual.getProx().setAnt(atual.getAnt());
						atual.getAnt().setProx(atual.getProx());
					}
				}
			}
			this.quantNos--;
			return true;
		}
	}
	
	public boolean removerNó(NoDupla no){
		if (this.éVazia()){
			return false;
		} else {
			if (no == this.prim){
				if (this.quantNos == 1){
					this.prim = null;
					this.ult = null;
				} else {
					this.prim.getProx().setAnt(null);
					this.prim = this.prim.getProx();
				}
			} else {
				if (no == this.ult){
					this.ult.getAnt().setProx(null);
					this.ult = this.ult.getAnt();
				} else {
					NoDupla atual = this.prim.getProx();
					while (no != atual && atual != this.ult){						
						atual = atual.getProx();
					}
					if (no == atual){
						atual.getProx().setAnt(atual.getAnt());
						atual.getAnt().setProx(atual.getProx());
					} else {
						return false;
					}
				}
			}
			this.quantNos--;
			return true;
		}
	}
	
	public String toString(){
		String msg = "";
		NoDupla atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}
	
	public boolean removerKésimo(int k){
		if (k > this.quantNos || k < 1){
			return false;
		} else {
			if (k == 1){
				if (this.quantNos == 1){					
					this.ult = null;
				} else {
					this.prim.getProx().setAnt(null);
				}
				this.prim = this.prim.getProx();
			} else {
				if (k == this.quantNos){
					this.ult.getAnt().setProx(null);
					this.ult = this.ult.getAnt();
				} else {
					NoDupla atual = this.prim.getProx();
					for (int i = 2; i != k; i++){
						atual = atual.getProx();
					}
					atual.getProx().setAnt(atual.getAnt());
					atual.getAnt().setProx(atual.getProx());
				}
			}
			this.quantNos--;
			return true;
		}
	}
	
	/* Exercício 1)
	 * Implemente um algoritmo que procure o maior elemento e calcule a
	 * média aritmética de uma lista duplamente encadeada, com descritor.
	 */
	public int procurarMaior(){
		int maior = -1;
		if (this.éVazia()){
			return maior;
		} else {
			if (this.quantNos == 1){
				return this.prim.getInfo().getChave();
			} else {
				NoDupla atual = this.prim.getProx();
				maior = this.prim.getInfo().getChave();
				for (int i = 2; i <= this.quantNos; i++){
					if (atual.getInfo().getChave() > maior){
						maior = atual.getInfo().getChave();
					}
					atual = atual.getProx();
				}
				return maior;
			}
		}
	}
	public double média(){
		double media = -1;
		if (this.éVazia()){
			return media;
		} else {
			if (this.quantNos == 1){
				return this.prim.getInfo().getChave();
			} else {
				media = this.prim.getInfo().getChave();
				NoDupla atual = this.getPrim().getProx();
				for (int i = 2; i <= this.quantNos; i++){
					media += atual.getInfo().getChave();
				}
				media = media / this.quantNos;
				return media;
			}
		}
	}
	
	/* Exercício 2)
	 * Escreva um método que recebe uma lista duplamente 
	 * encadeada e troca o primeiro elemento com o último.
	 */
	public boolean trocarPrimeiroÚltimo(){
		if (this.quantNos < 2){
			return false;
		} else {
			this.prim.setAnt(this.ult.getAnt());
			this.ult.setProx(this.prim.getProx());
			this.prim.getProx().setAnt(this.ult);
			this.ult.getAnt().setProx(this.prim);
			this.prim.setProx(null);
			this.ult.setAnt(null);
			NoDupla aux = this.prim;
			this.prim = this.ult;
			this.ult = aux;
			return true;
		}
	}
	
	/* Exercício 3)
	 * Escreva um método que retira os valores repetidos de uma lista duplamente encadeada.
	 */
	public boolean removerRepetidos(){
		if (this.quantNos < 2){
			return false;
		} else {
			for (NoDupla atual = this.prim; atual != null; atual = atual.getProx()){
				int cont = 0;
				for (NoDupla aux = this.prim; aux != null; aux = aux.getProx()){
					if (aux.getInfo().getChave() == atual.getInfo().getChave()){
						cont++;
					}
					if (cont > 1){
						this.removerNó(aux);
					}
				}
			}
			return true;
		}
	}
	
	/* Exercício 5)
	 * Implemente uma função que receba como parâmetro uma lista simplesmente encadeada 
	 * e retorne uma lista duplamente encadeada, resultante da cópia dos valores da lista simplesmente encadeada.
	 */
	public ListaDupla copiarDeListaSimples (ListaSimples listaSimples){
		if (!listaSimples.éVazia()){
			if (!this.éVazia() || listaSimples.éVazia()){
				for (NoDupla atual = this.prim; atual != null; this.removerNó(atual)){					
				}
			}
			for (No atual = listaSimples.getPrim(); atual != null; atual = atual.getProx()){
				Item valor = new Item(atual.getInfo().getChave()); // DÚVIDA!!!
				this.inserirÚltimo(valor);
			}
		}		
		return this;
	}
	
	/* Exercício 7)
	 * Escreva um algoritmo que a partir de uma Lista Duplamente Encadeada denominada L1, 
	 * identifique nesta lista todos os produtos enlatados e insira-os em uma outra Lista Duplamente Encadeada denominada L2. 
	 * Considerações:
	 *  Este método deverá ser escrito na classe da ListaDupla.
	 *  A lista L1 não está vazia e a L2 já está instanciada e vazia.
	 *  Se o valor do campo chave for maior do que 1000 são produtos enlatados.
	 */
	public boolean inserirEmL2 (ListaDupla L2){
		for (NoDupla atual = this.prim; atual != null; atual = atual.getProx()){
			if (atual.getInfo().getChave() > 1000){
				Item produto = new Item(atual.getInfo().getChave());
				L2.inserirÚltimo(produto);				
			}
		}
		if (L2.éVazia()){
			return false;
		} else {
			return true;
		}
	}
		
}
