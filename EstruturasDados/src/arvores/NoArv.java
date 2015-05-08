package arvores;

import dados.Cantor;

public class NoArv {
	private Cantor info; // o tipo Cantor está declarado no capítulo 1
	private NoArv esq, dir;

	public NoArv(Cantor elem){
		this.info = elem;
	}
	public NoArv getEsq(){
		return this.esq;
	}
	public NoArv getDir(){
		return this.dir;
	}
	public Cantor getInfo(){
		return this.info;
	}
	public void setEsq(NoArv elem){
		this.esq = elem;
	}
	public void setDir(NoArv elem){
		this.dir = elem;
	}
	public void setInfo(Cantor elem){
		this.info = elem;
	}

}
