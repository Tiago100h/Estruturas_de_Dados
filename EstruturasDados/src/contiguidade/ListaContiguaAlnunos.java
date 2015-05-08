package contiguidade;
import dados.Aluno;
public class ListaContiguaAlnunos {
	private int fim;
	private Aluno [] info;
	
	public ListaContiguaAlnunos (int qtd){
		this.fim = 0;
		this.info = new Aluno [qtd];
	}

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public Aluno getInfo(int i) {
		return this.info[i];
	}

	public void setInfo(int i, Aluno info) {
		this.info[i] = info;
	}
	
	public boolean ÈVazia(){
		return (this.fim == 0);
	}
	
	public boolean ÈCheia(){
		return (this.fim == this.info.length);
	}
	
	public boolean inserirAluno(Aluno info){
		if (ÈCheia()){
			return false;
		} else {
			this.info[this.fim] = info;
			this.fim++;
			return true;
		}
	}
	
	public boolean removerAluno(int matricula){
		if (ÈVazia()){
			return false;
		} else {
			int i = 0;
			while (this.info[i].getMatricula() != matricula && i < this.fim){
				i++;
			}
			if (i == this.fim){
				return false;
			} else {
				for (int j = i; j < this.fim - 1; j++){
					this.info[j] = this.info[j + 1];
				}
				this.fim--;
				return true;
			}
		}
	}
	
	public boolean transferirAluno(int matricula, ListaContiguaAlnunos transferidos){
		if (transferidos.ÈCheia() || this.ÈVazia()){
			return false;
		} else {
			int i = 0;
			while (this.info[i].getMatricula() != matricula && i < this.fim){
				i++;
			}
			if (i == this.fim){
				return false;
			} else {
				if (transferidos.ÈVazia()){
					transferidos.info[transferidos.fim] = this.info[i];
					transferidos.fim++;
					for (; i < this.fim - 1; i++){
						this.info[i] = this.info[i + 1];
					}
					this.fim--;
					return true;
				} else {
					int j = 0;
					while (matricula <= transferidos.getInfo(j).getMatricula() && j < transferidos.fim){
						j++;
					}
					if (j == transferidos.fim){
						transferidos.info[j] = this.info[i];
						transferidos.fim++;
						for (; i < this.fim - 1; i++){
							this.info[i] = this.info[i + 1];
						}
						this.fim--;
						return true;
					} else {					
						for (int j2 = transferidos.fim; j2 > j; j2--){
							transferidos.info[j2] = transferidos.info[j2 - 1];
						}
						transferidos.info[j] = this.info[i];
						transferidos.fim++;
						for (; i < this.fim - 1; i++){
							this.info[i] = this.info[i + 1];
						}
						this.fim--;
						return true;
					}
				}
			}
		}
	}
	
	public String localizarAluno(String nome, ListaContiguaAlnunos transferidos){
		String mensagem = "";
		int i = 0;
		while (nome != this.info[i].getNome() && i < this.fim){
			i++;
		}
		if (i < this.fim){
			mensagem = "Aluno matriculado";
		} else {
			i = 0;
			while (nome != transferidos.info[i].getNome() && i < transferidos.fim){
				i++;
			}
			if (i < transferidos.fim){
				mensagem = "Aluno transferido";
			} else {
				mensagem = "Aluno n„o encontrado";
			}
		}
		return mensagem;
	}
	
	public String imprimirDados(String nome){
		String mensagem = "";
		if (this.ÈVazia()){
			mensagem = "Lista vazia";
			return mensagem;
		} else {
			int i = 0;
			while (nome != this.info[i].getNome() && i < this.fim){
				i++;
			}
			if (i == this.fim){
				mensagem = "Aluno n„o encontrado";
				return mensagem;
			} else {
				mensagem = this.info[i].getMatricula() +
						"\n" + this.info[i].getNome() +
						"\n" + this.info[i].getTelefone() +
						"\n" + this.info[i].getEndereÁo();
				return mensagem;
			}
		}
	}

}
