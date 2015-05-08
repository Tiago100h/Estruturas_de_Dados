package duplamente;

public class ListaDuplaCaractere {
	private NoDuplaCaractere prim;
	private NoDuplaCaractere ult;
	private int quantNos;
	
	ListaDuplaCaractere(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public NoDuplaCaractere getPrim() {
		return this.prim;
	}

	public NoDuplaCaractere getUlt() {
		return this.ult;
	}

	public int getQuantNos() {
		return this.quantNos;
	}
	
	public boolean ÈVazia() {
		return (this.prim == null);
	}
}
