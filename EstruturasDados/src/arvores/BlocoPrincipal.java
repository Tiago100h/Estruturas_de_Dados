package arvores;
import io.InOut;
import dados.Cantor;
public class BlocoPrincipal {
	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		String cantor, musica, genero;
		int chave, anoMusica, opcao;
		Cantor[] vet;							
		
		arvore.inserir(new Cantor((int)(Math.random()*100), "Pharrell Williams", "Happy", "Neo soul", 2013));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Calvin Harris", "Summer", "House", 2014));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Coldplay", "Magic", "Pop", 2014));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Avicii", "Hey brother", "House", 2013));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Van Halen", "Can't Stop Lovin' You", "Rock", 1995));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Scorpions", "Wind of Change", "Rock", 1991));		
		
		arvore.inserir(new Cantor((int)(Math.random()*100), "Charlie Brown Jr.", "Dias De Luta, Dias De Glória", "Rock", 2010));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Skank", "Pacato Cidadão", "MPB", 2010));
		arvore.inserir(new Cantor((int)(Math.random()*100), "2 Chainz feat. Wiz Khalifa", "We Own It", "Hip Hop", 2014));
		arvore.inserir(new Cantor((int)(Math.random()*100), "The Red Hot Chili Peppers", "Scar Tissue", "Rock", 2008));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Jack Johnson", "Better Together", "Surf Music", 2004));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Marcelo D2", "À Procura da Batida Perfeita", "Rap", 2001));	
		
		arvore.inserir(new Cantor((int)(Math.random()*100), "Kanye West", "Stronger", "Hip Hop", 2013));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Jorge e Mateus", "Amor Pra Recomeçar", "Sertanejo", 2014));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Grupo Revelação", "Tá Escrito", "Pagode", 2014));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Bom Gosto", "Patricinha do Olho Azul", "Pagode", 2013));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Thiaguinho", "Caraca, Muleke!", "Pagode", 2103));
		arvore.inserir(new Cantor((int)(Math.random()*100), "Falamansa", "Rindo à Toa", "Forró", 2002));
		
		do {
			opcao = menu();
			switch (opcao){			
			case 0:
				InOut.MsgDeInformação("Tchau!","Fim do programa");
				break;
			case 1:
				chave = (int)(Math.random()*100);
				cantor = InOut.leString("Inserir um cantor \nDigite o cantor:");
				musica = InOut.leString("Inserir um cantor \nDigite a música:");
				genero = InOut.leString("Inserir um cantor \nDigite o gênero:");
				anoMusica = InOut.leInt("Inserir um cantor \nDigite o ano (YYYY) que a música foi criada:");
				String s = Integer.toString(anoMusica);
				if (s.length() == 4 && arvore.inserir(new Cantor(chave, cantor, musica, genero, anoMusica))){
					InOut.MsgDeInformação("Inserir um cantor","Inserção efetuada com sucesso");
				}else{
					InOut.MsgDeErro("Erro","Inserção não efetuada, chave já existe ou formato de ano inválido");
				}
				break;
			case 2:
				if (arvore.éVazia()){
					InOut.MsgDeErro("Erro","Árvore vazia");
				}else{
					int anoInicial = InOut.leInt("Listar por intervalo de ano\nDigite o ano (yyyy) inicial:");
					int anoFinal = InOut.leInt("Listar por intervalo de ano\nDigite o ano (yyyy) final:");
					String aI = Integer.toString(anoInicial);
					String aF = Integer.toString(anoFinal);
					if (aI.length() != 4 || aF.length() != 4){
						InOut.MsgDeErro("Erro",	"Formato de ano inválido");
					} else{
						vet = arvore.CamPosFixado(anoInicial, anoFinal);
						if (vet[0] == null){
							InOut.MsgDeAviso("Listar por intervalo de ano", "Nenhuma música no intervalo do ano de " + anoInicial + " ao ano de " + anoFinal);
						} else {							
							InOut.MsgDeInformação("Listar por intervalo de ano", arvore.converterCaminhamentoParaString(vet));
						}
					}					
				}
				break;
			case 3:
				if (arvore.éVazia()){
					InOut.MsgDeErro("Erro","Árvore vazia");
				}else {		
					vet = arvore.CamPreFixado();					
					chave = InOut.leInt(							
							"Excluir um cantor\n" +
							arvore.converterCaminhamentoParaString(vet) + "\n" +		
							"Escolha uma chave acima para excluir:"); 
					if (arvore.remover(chave)){
						InOut.MsgDeInformação("Excluir um cantor","Remoção efetuada");
					}else{
						InOut.MsgDeErro("Erro","Remoção não efetuada, chave não encontrada");
					}
				}	
				break;
			case 4:
				if (arvore.éVazia()){
					InOut.MsgDeErro("Erro", "Árvore vazia");
				} else {
					vet = arvore.CamPreFixado();
					chave = InOut.leInt(
							"Alterar cantor\n" + 
							arvore.converterCaminhamentoParaString(vet) + "\n" +		
							"Escolha uma chave acima para alterar o respectivo cantor:");
					if (!arvore.pesquisar(chave)){
						InOut.MsgDeErro("Erro", "Chave não encontrada");
					} else {
						cantor = InOut.leString("Alterar cantor\nDigite o novo cantor:");
						musica = InOut.leString("Alterar cantor\nDigite a nova música:");
						genero = InOut.leString("Alterar cantor\nDigite o novo gênero:");
						anoMusica = InOut.leInt("Alterar cantor\nDigite o novo ano(YYYY) que a música foi criada:");				
						if (arvore.alterar(chave, cantor, musica, genero, anoMusica)){
							InOut.MsgDeInformação("Alterar cantor", "Alteração efetuada");
						}
						else {
							InOut.MsgDeErro("Erro", "Formato de ano incorreto");
						}
					}
				}

				break;
			case 5:
				if (arvore.éVazia()){
					InOut.MsgDeAviso("Exibir árvore","Árvore vazia");
				}else{					
					vet = arvore.CamPreFixado();					
					InOut.MsgDeInformação("Exibir árvore", arvore.converterCaminhamentoParaString(vet));
				}	
				break;
				
			case 6:
				if (arvore.éVazia()){
					InOut.MsgDeAviso("Listar por gênero","A árvore está vazia");
				}else{			
					genero = InOut.leString("Insira o gênero desejado: ");
					vet = arvore.CamCentral(genero);
					if (vet[0] == null){
						InOut.MsgDeErro("Erro", "Gênero não encontrado");
					} else {
						InOut.MsgDeInformação("Listar por gênero", arvore.converterCaminhamentoParaString(vet));
					}
				}	
				break;
			default: 
				InOut.MsgDeErro("Erro","Opção inválida, tente novamente");
			}
		} while (opcao!=0);
		System.exit(0);
	}
	static int menu(){
		return InOut.leInt("-----♪--♪--FESTIVAL DE MÚSICA--♪--♪-----\n\nEscolha uma Opção:\n" +	
				"-----------------------------------------------------------\n"+
				"1. Inserir cantor\n" +
				"2. Listar por ano\n" +
				"3. Excluir cantor\n" +
				"4. Alterar cantor\n" +
				"5. Exibir árvore\n" +	
				"6. Listar por gênero\n" +				
				"0. Sair\n" +
				"-----------------------------------------------------------\n" +
				"Desenvolvedores\n"+
				"-> Arthur Salgado \n-> Guilherme Barreto \n-> Tiago Pereira");
	}
}