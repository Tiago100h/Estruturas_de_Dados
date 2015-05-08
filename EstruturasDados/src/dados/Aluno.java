package dados;

public class Aluno {
	private int matricula;
	private String nome;
	private String enderešo;
	private String telefone;
	public Aluno(int matricula, String nome, String enderešo, String telefone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.enderešo = enderešo;
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
	public String getEnderešo() {
		return enderešo;
	}
	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
