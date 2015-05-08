package arvores;


import dados.Cantor;

public class Arvore {
	private NoArv raiz;
	private int quantNos;

	public Arvore(){
		this.quantNos=0;
		this.raiz = null;
	}
	public boolean éVazia (){
		return (this.raiz == null);
	}
	public NoArv getRaiz(){
		return this.raiz;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	
	public boolean inserir (Cantor elem){
		if (pesquisar (elem.getChave())){
			return false;
		}else{
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	public NoArv inserir (Cantor elem, NoArv no){
		if (no == null){
			NoArv novo = new NoArv(elem);
			return novo;
		}else {
			if (elem.getChave() < no.getInfo().getChave()){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}
	public boolean pesquisar (int chave){
		if (pesquisar (chave, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	private NoArv pesquisar (int chave, NoArv no){
		if (no != null){
			if (chave < no.getInfo().getChave()){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getChave()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}
	public boolean remover (int chave){
		if (pesquisar (chave, this.raiz) != null){
			this.raiz = remover (chave, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoArv remover (int chave, NoArv arv){
		if (chave < arv.getInfo().getChave()){
			arv.setEsq(remover (chave, arv.getEsq()));
		}else{
			if (chave > arv.getInfo().getChave()){
				arv.setDir(remover (chave, arv.getDir()));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){ 
						return arv.getDir();
					}else{
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}
	private NoArv Arrumar (NoArv arv, NoArv maior){
		if (maior.getDir() != null){
			maior.setDir(Arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	public Cantor [] CamCentral (String genero){
		int []n= new int[1];
		n[0]=0;
		Cantor [] vet = new Cantor[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n, genero));
	}
	private Cantor [] FazCamCentral (NoArv arv, Cantor [] vet, int []n, String genero){
		if (arv != null) 
		{
			vet = FazCamCentral (arv.getEsq(),vet,n,genero);
			if(arv.getInfo().getGenero().equalsIgnoreCase(genero)) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
			vet = FazCamCentral (arv.getDir(),vet,n,genero);
		}
		return vet;
	}
	public Cantor [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		Cantor [] vet = new Cantor[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private Cantor [] FazCamPreFixado (NoArv arv, Cantor [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	public Cantor [] CamPosFixado (int anoInicial, int anoFinal){
		int []n= new int[1];
		n[0]=0;
		Cantor [] vet = new Cantor[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n, anoInicial, anoFinal));
	}
	private Cantor [] FazCamPosFixado (NoArv arv, Cantor[] vet, int []n, int anoInicial, int anoFinal){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n, anoInicial, anoFinal);
			vet = FazCamPosFixado (arv.getDir(), vet,n, anoInicial, anoFinal);
			if (arv.getInfo().getAnoMusica() >= anoInicial && arv.getInfo().getAnoMusica() <= anoFinal){
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
		}
		return vet;
	}
	public boolean alterar(int chave, String novoNome, String novaMusica, String novoGenero, int novoAnoMusica){
		if (this.éVazia()){
			return false;
		} else {
			String s = Integer.toString(novoAnoMusica);
			if (s.length() != 4){
				return false;
			} else {
				NoArv no = this.pesquisar(chave, this.raiz);
				if (no == null){
					return false;
				} else{
					no.getInfo().setNome(novoNome);
					no.getInfo().setMusica(novaMusica);
					no.getInfo().setGenero(novoGenero);
					no.getInfo().setAnoMusica(novoAnoMusica);
					return true;
				}
			}
		}
	}
	public String converterCaminhamentoParaString (Cantor[] vet){
		String arvoreImpressa = "";
		for (int i= 0; i <= vet.length - 1 &&  vet[i]!=null; i++){						
			arvoreImpressa += "Chave: " + vet[i].getChave() +
					" || Cantor: " + vet[i].getNome() +
					" || Música: " + vet[i].getMusica() +
					" || Gênero: " + vet[i].getGenero() + 
					" || Ano: " + vet[i].getAnoMusica() + "\n";
		}
		return arvoreImpressa;
	}
}