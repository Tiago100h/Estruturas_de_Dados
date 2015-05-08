package duplamente;
import dados.Atleta;
public class NoDuplaAtleta {
	private NoDuplaAtleta ant;
	private Atleta info;
	private NoDuplaAtleta prox;
	
	public NoDuplaAtleta (Atleta elem){
		this.info = elem;
	}
	
	public NoDuplaAtleta getAnt() {
		return ant;
	}
	public void setAnt(NoDuplaAtleta ant) {
		this.ant = ant;
	}
	public Atleta getInfo() {
		return info;
	}
	public void setInfo(Atleta info) {
		this.info = info;
	}
	public NoDuplaAtleta getProx() {
		return prox;
	}
	public void setProx(NoDuplaAtleta prox) {
		this.prox = prox;
	}
	
	

}
