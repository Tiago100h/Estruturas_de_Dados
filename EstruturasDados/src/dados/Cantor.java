package dados;

public class Cantor {
	private int chave;	
	private String nome;
	private String musica;
	private String genero;
	private int anoMusica;
	
	public Cantor(int chave, String nome, String musica, String genero, int anoMusica) {
		super();
		this.chave = chave;
		this.nome = nome;
		this.musica = musica;
		this.genero = genero;
		this.anoMusica = anoMusica;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMusica() {
		return musica;
	}

	public void setMusica(String musica) {
		this.musica = musica;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnoMusica() {
		return anoMusica;
	}

	public void setAnoMusica(int anoMusica) {
		this.anoMusica = anoMusica;
	}	
	
}
