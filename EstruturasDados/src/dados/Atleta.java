package dados;

public class Atleta {
	private String nome;
	private double altura;
	public Atleta(String nome, double altura) {
		super();
		this.nome = nome;
		this.altura = altura;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}
