package dados;

public class Item {
	private int chave;
	/* aqui podem ser declarados outros atributos conforme sua necessidade */
	/**
	 * Construtor de objetos da classe Item
	 */	
	public Item(int ch) {
		this.chave = ch;
	}
	public void setChave (int ch){
		this.chave = ch;
	}
	public int getChave ( ){
		return chave;
	}
}