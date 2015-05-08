package contiguidade;

import dados.ItemNome;

public class ListaContiguaNome {
	private int fim;
	private ItemNome[] info;
	
	public ListaContiguaNome (int tamanho){
		this.fim = 0;
		this.info = new ItemNome[tamanho];
	}

	public int getFim() {
		return this.fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public ItemNome getInfo(int indice) {
		return this.info[indice];
	}

	public void setInfo(int indice, ItemNome info) {
		this.info[indice] = info;
	}
	public boolean ÈVazia (){
		return (this.fim == 0);
	}
	public boolean ÈCheia (){
		return (this.fim == this.info.length);
	}
	public boolean inserirUltimo (ItemNome elem){
		if (ÈCheia()){
			return false;
		} else {
			this.info[this.fim]= elem;
			this.fim++;
			return true;
		}
	}
	public boolean inserirAntesNome (ItemNome elem, char nome){
		if (this.ÈCheia() || this.ÈVazia()){
			return false;
		} else {
			int contador = 0;
			while (contador < this.fim && nome != this.info[contador].getNome()){
				contador++;
			}
			for (int i = this.fim; i > contador; i--) {
				this.info[i] = this.info[i - 1];
			}
			this.info[contador] = elem;
			this.fim++;
			return true;
		}
	}
	public String toString(){
		String msg="";
		for  (int indice = 0; indice < this.fim; indice++){
			msg += this.info[indice].getNome() + " " + this.info[indice].getCpf() + "\n";
		}
		return msg;
	}
}
