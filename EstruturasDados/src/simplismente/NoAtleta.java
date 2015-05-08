package simplismente;
import dados.Atleta;
public class NoAtleta {	
	private Atleta info;
	private NoAtleta prox;
	
	public NoAtleta (Atleta elem){
		this.info = elem;		
	}
	
	public Atleta getInfo() {
		return info;
	}

	public void setInfo(Atleta info) {
		this.info = info;
	}

	public NoAtleta getProx() {
		return prox;
	}

	public void setProx(NoAtleta prox) {
		this.prox = prox;
	}
	

}
