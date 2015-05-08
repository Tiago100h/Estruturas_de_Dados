package dados;

public class Filme {
	private int codigo;
	private String titulo;
	private String classificacao;
	private String genero;
	public Filme(int codigo, String titulo, String classificacao, String genero) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.classificacao = classificacao;
		this.genero = genero;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	

}
