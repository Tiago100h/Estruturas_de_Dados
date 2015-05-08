package dados;

public class ItemNome {
	private char nome;
	private int cpf;
	public ItemNome(char nome, int cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public char getNome() {
		return nome;
	}
	public void setNome(char nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}	
}
