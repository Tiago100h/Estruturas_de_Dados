package dados;

public class Aluno {
	private int matricula;
	private String nome;
	private String endere�o;
	private String telefone;
	public Aluno(int matricula, String nome, String endere�o, String telefone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endere�o = endere�o;
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
	public String getEndere�o() {
		return endere�o;
	}
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
