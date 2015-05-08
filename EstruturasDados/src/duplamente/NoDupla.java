package duplamente;

import dados.Item;

public class NoDupla {
	private Item info;
	private NoDupla ant;
	private NoDupla prox;
	
	public NoDupla (Item elem){
		this.info = elem;
		this.ant = null;
		this.prox = null;
	}

	public NoDupla getAnt() {
		return ant;
	}

	public void setAnt(NoDupla ant) {
		this.ant = ant;
	}

	public NoDupla getProx() {
		return prox;
	}

	public void setProx(NoDupla prox) {
		this.prox = prox;
	}

	public Item getInfo() {
		return info;
	}
	
	
}
