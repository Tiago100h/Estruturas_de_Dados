package simplismente;

import dados.Atleta;
import dados.Item;

public class ListaSimplesAtleta {
	private NoAtleta prim;
	private NoAtleta ult;
	private int quantNos;
	
	public ListaSimplesAtleta(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public NoAtleta getPrim() {
		return prim;
	}

	public NoAtleta getUlt() {
		return ult;
	}

	public int getQuantNos() {
		return quantNos;
	}
	
	public boolean ÈVazia (){
		return (this.prim == null);
	}
	
	public void inserirUltimo (Atleta atleta){
		NoAtleta novoNo = new NoAtleta (atleta);
		if (this.ÈVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	

}
