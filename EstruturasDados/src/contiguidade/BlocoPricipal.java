package contiguidade;
import java.util.Scanner;
import dados.*;
public class BlocoPricipal {
static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("digite o tamanho máximo da lista \n");
		int quant = scan.nextInt();
		ListaContigua lista = new ListaContigua (quant);
		int valor;
		char opcao;
		do {
			opcao = menu();
			switch (opcao){
			case '1':
				System.out.println("Inserir um Valor no final da lista\nDigite um valor");
				valor = scan.nextInt();
				if (! lista.inserirUltimo(new Item(valor))){
					System.out.println("A Lista está cheia \n");
				}
				break;
			case '2':
				if (lista.éVazia()){
					System.out.println("A lista está vazia \n");
				}
				else{
					System.out.println("Localizar um valor\nDigite o valor");
					valor = scan.nextInt();
					int pesqNo = lista.pesquisarNo(valor);
					if (pesqNo == lista.getFim()){
						System.out.println("o " + valor + " não foi encontrado \n");
					}
					else{
						System.out.println("o " + valor + " foi achado na lista na posição " + pesqNo + "\n");
					}
				}
				break;
			case '3':
				if (lista.éVazia()){
					System.out.println("A lista está vazia \n");
				}	
				else {
					System.out.println("Excluir um elemento da lista\nDigite um valor \n");
					valor = scan.nextInt();
					if (lista.removerNo(valor)){
						System.out.println("Remoção efetuada \n");
					}
					else{
						System.out.println("Remoção não efetuada, valor não encontrado \n");
					}	
				}
				break;
			case '4':
				if (lista.éVazia()){
					System.out.println("A lista está vazia \n");
				}
				else{
					System.out.println("Exibir a lista \n" + lista.toString());
				}
				break;
			case '5':
				int valor2;
				System.out.println("5. Inserir Nó elem após Nó y \nDigite um valor elem a ser adicionado");
				valor = scan.nextInt();
				System.out.println("Digite um valor y da lista");
				valor2 = scan.nextInt();
				if (!lista.inserirElemAposY (new Item(valor), valor2)){
					System.out.println("Erro /nLista cheia ou valor y não consta na lista");
				}
				break;
			case '6':
				System.out.println("Fim do programa");
				break;
			default: 
				System.out.println("Opção invalida, tente novamente \n");
			}
		} while (opcao!='6');
		System.exit(0);
	}
	public static char menu(){
		System.out.println("Escolha uma Opção:\n"+
				"1. Inserir Nó no final\n"+
				"2. Localizar Nó\n"+
				"3. Excluir Nó\n"+
				"4. Exibir lista\n"+
				"5. Inserir Nó x após Nó y\n"+ 
				"6. Sair");
		return scan.next().charAt(0);

	}

}
