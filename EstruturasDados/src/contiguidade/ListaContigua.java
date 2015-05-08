package contiguidade;
import simplismente.ListaSimples;
import simplismente.No;
import dados.Item;
public class ListaContigua {
	private int fim;
	private Item [] info; // o tipo Item est· declarado no capÌtulo 1

	public ListaContigua(int qte){
		this.fim = 0;
		this.info = new Item [qte];
	}
	public Item getInfo(int i){
		return this.info[i];
	}
	public void setInfo(int i, Item elem){
		this.info[i]=elem;
	}
	public int getFim(){
		return this.fim;
	}
	public void setFim(int _fim){
		this.fim = _fim;
	}
	public boolean ÈVazia (){
		return (this.fim == 0);
	}
	public boolean ÈCheia (){
		return (this.fim == this.info.length);
	}
	public boolean inserirUltimo (Item elem){
		if (ÈCheia()){
			return false;
		} else {
			this.info[this.fim]= elem;
			this.fim++;
			return true;
		}
	}	
	public int pesquisarNo (int chave){
		int i = 0;
		while ((i < this.fim) && (this.info[i].getChave()!= chave)){
			i++;
		}
		return i;
	}
	public boolean removerNo (int chave){
		int i = 0;
		int j;
		while ((i < this.fim) && (this.info[i].getChave()!= chave)){
			i++;
		}
		if (i == this.fim){
			return false;
		}
		else{
			for (j = i; j < this.fim-1 ;j++){
				this.info[j] = this.info[j+1];
			}
			this.fim--;	
			return true;
		}
	}	
	public String toString(){
		String msg="";
		int i;
		for  (i=0; i < this.fim; i++){
			msg += this.info[i].getChave()+"\n";
		}
		return msg;
	}

	// ExercÌcio 1) c) (modificado)
	public boolean inserirElemAposY (Item elem, int y){
		if (this.ÈCheia()){
			return false;
		} else {
			int aux = 0;
			while (y != this.info[aux].getChave() && aux < this.fim){
				aux++;
			}
			if (aux > this.fim){
				return false;
			} else {
				for (int i = this.fim; i >= aux; i--){
					this.info[i + 1] = this.info[i];
				}
				this.info[aux] = elem;
				this.fim += 1;
				return true;
			}
		}
	}
	
	// ExercÌcio 1) e) (modificado)
	public boolean removerIguais (int chave){
		if (ÈVazia()){
			return false;
		} else {
			for (int i = 0; i < this.fim; i++){
				if (this.info[i].getChave() == chave){
					for (int j = i; j < this.fim - 1; j++){
						this.info[j] = this.info[j + 1];
						this.fim--;
						i--;
					}
				}
			}
			return true;
		}
	}
	
	// ExercÌcio 2) (modificado)
	public ListaContigua removerMaiores (int chave){
		ListaContigua removidos = new ListaContigua(this.fim);
		if (this.ÈVazia()){
			return removidos;
		} else {
			for (int i = 0; i < this.fim; i++){
				if (this.info[i].getChave() > chave){
					removidos.inserirUltimo(this.info[i]);
					this.removerNo(i);
					i--;
				}
			}
			return removidos;
		}
	}
	
	// ExercÌcio 3)
	public boolean eliminarRepetidos (int chave){
		if (this.ÈVazia()){
			return false;
		} else {
			int j = 0;
			for (int i = 0; i < this.fim; i++){
				if (this.info[i].getChave() == chave){
					j++;
					if (j > 1){
						this.removerNo(i);
					}
				}
			}
			if (j > 1){
				return true;
			} else {
				return false;
			}
		}
	}
	
	// ExercÌcio 4)
	public boolean transferir (ListaSimples LLE){
		if (LLE.getQuantNos() > this.info.length - this.fim){
			return false;
		} else {
			ListaContigua listaAux = new ListaContigua(LLE.getQuantNos());
			No aux1 = LLE.getPrim();
			int menor;
			for (int i = 0; i < listaAux.fim; i++){
				menor = LLE.getPrim().getInfo().getChave();
				for (; aux1.getProx() != null; aux1 = aux1.getProx()){
					if (aux1.getInfo().getChave() < menor){
						menor = aux1.getInfo().getChave();
					}
				}
				listaAux.info[i].setChave(menor);
				LLE.removerNo(menor);
			}
			return true;	
		}		
	}
}
