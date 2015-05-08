package contiguidade;
import java.util.Scanner;
import dados.*;
public class BlocoPricipal {
static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("digite o tamanho m�ximo da lista \n");
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
					System.out.println("A Lista est� cheia \n");
				}
				break;
			case '2':
				if (lista.�Vazia()){
					System.out.println("A lista est� vazia \n");
				}
				else{
					System.out.println("Localizar um valor\nDigite o valor");
					valor = scan.nextInt();
					int pesqNo = lista.pesquisarNo(valor);
					if (pesqNo == lista.getFim()){
						System.out.println("o " + valor + " n�o foi encontrado \n");
					}
					else{
						System.out.println("o " + valor + " foi achado na lista na posi��o " + pesqNo + "\n");
					}
				}
				break;
			case '3':
				if (lista.�Vazia()){
					System.out.println("A lista est� vazia \n");
				}	
				else {
					System.out.println("Excluir um elemento da lista\nDigite um valor \n");
					valor = scan.nextInt();
					if (lista.removerNo(valor)){
						System.out.println("Remo��o efetuada \n");
					}
					else{
						System.out.println("Remo��o n�o efetuada, valor n�o encontrado \n");
					}	
				}
				break;
			case '4':
				if (lista.�Vazia()){
					System.out.println("A lista est� vazia \n");
				}
				else{
					System.out.println("Exibir a lista \n" + lista.toString());
				}
				break;
			case '5':
				int valor2;
				System.out.println("5. Inserir N� elem ap�s N� y \nDigite um valor elem a ser adicionado");
				valor = scan.nextInt();
				System.out.println("Digite um valor y da lista");
				valor2 = scan.nextInt();
				if (!lista.inserirElemAposY (new Item(valor), valor2)){
					System.out.println("Erro /nLista cheia ou valor y n�o consta na lista");
				}
				break;
			case '6':
				System.out.println("Fim do programa");
				break;
			default: 
				System.out.println("Op��o invalida, tente novamente \n");
			}
		} while (opcao!='6');
		System.exit(0);
	}
	public static char menu(){
		System.out.println("Escolha uma Op��o:\n"+
				"1. Inserir N� no final\n"+
				"2. Localizar N�\n"+
				"3. Excluir N�\n"+
				"4. Exibir lista\n"+
				"5. Inserir N� x ap�s N� y\n"+ 
				"6. Sair");
		return scan.next().charAt(0);

	}

}
