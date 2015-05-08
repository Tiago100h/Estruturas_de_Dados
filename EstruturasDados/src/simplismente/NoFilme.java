package simplismente;
import dados.Filme;;
public class NoFilme {
	private Filme info;
	private NoFilme prox;
	
	public NoFilme (Filme elem){
		this.info = elem;
	}

	public Filme getInfo() {
		return this.info;
	}

	public void setInfo(Filme elem) {
		this.info = elem;
	}

	public NoFilme getProx() {
		return this.prox;
	}

	public void setProx(NoFilme _no) {
		this.prox = _no;
	}
	

}
