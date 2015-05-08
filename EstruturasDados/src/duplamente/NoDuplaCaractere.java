package duplamente;

import dados.Caractere;

public class NoDuplaCaractere {
	private Caractere info;
	private NoDuplaCaractere ant;
	private NoDuplaCaractere prox;
	
	public NoDuplaCaractere (Caractere elem){
		this.info = elem;
		this.ant = null;
		this.prox = null;
	}

	public NoDuplaCaractere getAnt() {
		return ant;
	}

	public void setAnt(NoDuplaCaractere ant) {
		this.ant = ant;
	}

	public NoDuplaCaractere getProx() {
		return prox;
	}

	public void setProx(NoDuplaCaractere prox) {
		this.prox = prox;
	}

	public Caractere getInfo() {
		return info;
	}
}
