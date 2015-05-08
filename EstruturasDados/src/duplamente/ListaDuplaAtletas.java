package duplamente;

import dados.Atleta;
import simplismente.ListaSimplesAtleta;
import simplismente.NoAtleta;

public class ListaDuplaAtletas {
	
	private NoDuplaAtleta prim;
	private NoDuplaAtleta ult;
	private int quantNos;
	
	public ListaDuplaAtletas(){
		this.prim = null;
		this. ult = null;
		this.quantNos = 0;
	}
	
	public NoDuplaAtleta getPrim() {
		return prim;
	}
	public NoDuplaAtleta getUlt() {
		return ult;
	}
	public int getQuantNos() {
		return quantNos;
	}
	
	public boolean éVazia(){
		return this.prim == null;
	}
	
	public String toStringAtletas(){
		String msg = "";
		NoDuplaAtleta atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getNome() + "\n" + atual.getInfo().getAltura() + "\n\n";
			atual = atual.getProx();
		}
		return msg;
	}
	
	public void inserirÚltimo (Atleta atleta){
		NoDuplaAtleta novoNo = new NoDuplaAtleta(atleta);
		if (this.éVazia()){
			this.prim = novoNo;			
		} else{
			this.ult.setProx(novoNo);
			novoNo.setAnt(this.ult);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	public boolean removerNó(NoDuplaAtleta no){
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
					NoDuplaAtleta atual = this.prim.getProx();
					while (atual != no && atual != this.ult){
						atual = atual.getProx();
					}
					if (atual == no){
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
	
	/* Exercício 6)
	 * 6) Os dados de um grupo de atletas foram organizados em uma lista linear simplesmente encadeada. 
	 * O campo de informação de cada elemento da lista apresenta o nome e a altura de um atleta. 
	 * A lista está organizada em ordem alfabética de atletas. Implemente uma aplicação para:
	 * a)	gerar uma segunda lista, duplamente encadeada, cujo deverão estar as mesmas informações da primeira lista, 
	 * porém organizadas por ordem decrescente de alturas;
	 */
	public ListaDuplaAtletas copiarDeListaSimplesOrdenado (ListaSimplesAtleta listaAtletas){		
		this.inserirÚltimo(new Atleta(listaAtletas.getPrim().getInfo().getNome(), listaAtletas.getPrim().getInfo().getAltura()));
		NoAtleta atual = listaAtletas.getPrim().getProx();
		while (this.quantNos != listaAtletas.getQuantNos()){
			if (atual.getInfo().getAltura() > this.prim.getInfo().getAltura()){
				NoDuplaAtleta novoNo = new NoDuplaAtleta(new Atleta(atual.getInfo().getNome(), atual.getInfo().getAltura()));
				this.prim.setAnt(novoNo);
				novoNo.setProx(this.prim);
				this.prim = novoNo;
				this.quantNos++;
			} else {
				if (atual.getInfo().getAltura() < this.ult.getInfo().getAltura()){
					this.inserirÚltimo(new Atleta(atual.getInfo().getNome(), atual.getInfo().getAltura()));
				} else {
					NoDuplaAtleta novoNo = new NoDuplaAtleta(new Atleta(atual.getInfo().getNome(), atual.getInfo().getAltura()));
					NoDuplaAtleta aux = this.prim;
					while (atual.getInfo().getAltura() < aux.getInfo().getAltura()){
						aux = aux.getProx();
					}
					aux.getAnt().setProx(novoNo);
					novoNo.setAnt(aux.getAnt());
					aux.setAnt(novoNo);
					novoNo.setProx(aux);
					this.quantNos++;
				}
			}
			atual = atual.getProx();
		}
		return this;
	}
	/* b)	excluir da lista duplamente encadeada o no do correspondente a um determinado atleta (nome passado como parâmetro).*/
	public boolean removerAtleta (String nome){
		if (this.éVazia()){
			return false;
		} else {
			if (nome == this.prim.getInfo().getNome()){
				if (this.quantNos == 1){
					this.prim = null;
					this.ult = null;
				} else {
					this.prim.getProx().setAnt(null);
					this.prim = this.prim.getProx();
				}
			} else {
				if (nome == this.ult.getInfo().getNome()){
					this.ult.getAnt().setProx(null);
					this.ult = this.ult.getAnt();
				} else {
					NoDuplaAtleta atual = this.prim.getProx();
					while (nome != atual.getInfo().getNome() && atual != this.ult){
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

}
