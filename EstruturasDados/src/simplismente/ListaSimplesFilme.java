package simplismente;
import dados.Filme;
public class ListaSimplesFilme {
	private NoFilme prim;
	private NoFilme ult;
	private int quantNos;
	
	public ListaSimplesFilme(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
		
	}

	public NoFilme getPrim() {
		return this.prim;
	}

	public NoFilme getUlt() {
		return this.ult;
	}

	public int getQuantNos() {
		return this.quantNos;
	}
	
	public boolean ÈVazia (){
		return (this.prim == null);
	}
	
	public void inserirFilme(Filme elem){
		NoFilme novoNo = new NoFilme(elem);
		if (ÈVazia()){
			this.prim = novoNo;			
		} else{
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	
	public String listarFilmesGenero(String genero){
		if (this.ÈVazia()){
			return "Lista Vazia";
		} else{
			NoFilme atual = this.prim;
			String resp = "";
			while (atual != null){
				if(atual.getInfo().getGenero().equalsIgnoreCase(genero)){
					resp += atual.getInfo().getTitulo() + "\n";
				}
				atual = atual.getProx();
			}
			if (resp.equals("")){
				return "N„o h· filmes do gÍnero " + genero;
			} else{
				return resp;				
			}
		}
	}
}
