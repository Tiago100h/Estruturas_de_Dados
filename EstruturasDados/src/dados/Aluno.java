package dados;

public class Aluno {
	private int matricula;
	private String nome;
	private String endereço;
	private String telefone;
	public Aluno(int matricula, String nome, String endereço, String telefone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereço = endereço;
		this.telefone = telefone;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
