package simplismente;
import dados.Item;
public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;

	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public boolean éVazia (){
		return (this.prim == null);
	}
	public void inserirPrimeiro(Item elem){
		No novoNo = new No (elem);
		if (this.éVazia()){
			this.ult = novoNo;
		}
		novoNo.setProx(this.prim);
		this.prim = novoNo;
		this.quantNos++;
	}
	public void inserirUltimo (Item elem){
		No novoNo = new No (elem);
		if (this.éVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	public No pesquisarNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	public boolean removerNo (int chave) {
		No atual = this.prim;
		No ant = null;
		if (éVazia()){
			return false;
		} else {
			while ((atual != null)&&(atual.getInfo().getChave()!= chave)){
				ant = atual;
				atual = atual.getProx();
			}
			if (atual == null){
				return false;
			}
			else{
				if (atual == this.prim){
					if (this.prim == this.ult){
						this.ult = null;
					}
					this.prim = this.prim.getProx();
				} else {
					if (atual == this.ult){
						this.ult = ant;
					}
					ant.setProx(atual.getProx());
				}
				this.quantNos--;
				return true;
			}
		}
	}
	public String toString(){
		String msg = "";
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}	
	public boolean estaNaLista (int ch){
		if (!this.éVazia()){
			No atual = this.prim;
			while (atual.getInfo().getChave() < ch && atual.getProx() != null){
				atual = atual.getProx();
			}
			if (ch == atual.getInfo().getChave()){
				return true;
			} else{
				return false;
			}
		} else{
			return false;
		}

	}


	// Meus Métodos
	public void meuInserirPrimeiro(Item elem){
		No novoNo = new No(elem);
		if (éVazia()){
			this.ult = novoNo;			
		} 
		novoNo.setProx(this.prim);				
		this.prim = novoNo;
		this.quantNos++;
	}
	public void meuInserirUltimo(Item elem){
		No novoNo = new No(elem);
		if (éVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}		
		this.ult = novoNo;
		this.quantNos++;
	}	
	
	public boolean removerKesimo (int k){
		if (this.éVazia() || k > this.quantNos){
			return false;
		} else {
			if (this.quantNos == 1){
				this.prim = null;
				this.ult = null;
			} else {
				if (k == 1){
					No aux = this.prim.getProx();
					this.prim = aux;
				} else {
					int i = 2;
					No aux = this.prim;
					while (i != k){
						aux = aux.getProx();
						i++;
					}					
					aux.setProx(aux.getProx().getProx());
					if (k == this.quantNos){
						this.ult = aux.getProx();
					}
				}
			}
			this.quantNos--;
			return true;
		}
	}

	// Exercícios
	/*
	1)Considere a implementação de listas lineares utilizando apontadores.
		Considere que um dos campos do Item é uma chave do tipo inteiro.
		Escreva uma função
		public boolean EstaNaLista (int CH)
		que retorne true se CH estiver na lista e retorna false se CH não estiver na lista.
		Considere que não há ocorrência de chaves repetidas na lista. A lista está ordenada.
	*/
	public boolean meuEstaNaLista (int ch){
		if (this.éVazia()){
			return false;
		} else{
			No atual = this.prim;
			while (ch > atual.getInfo().getChave() && atual.getProx() != null){
				atual = atual.getProx();
			}
			if (atual.getInfo().getChave() == ch){
				return true;
			} else {
				return false;
			}
		}
	}

	/*
	3)Considere listas implementadas por encadeamento simples, então pede-se para implementar funções que:
	a)Localize o endereço (search) de elementos
	*/ 
	public No meuPesquisarNo (int chave){
		No atual = this.prim;
		while (chave != atual.getInfo().getChave() && atual.getProx() != null){
			atual = atual.getProx();
		}
		return atual;
	}
	// b) Concatenar duas listas
	public void concatenarListas (ListaSimples lista2){
		if (!lista2.éVazia()){
			if (this.éVazia()){
				this.prim = lista2.prim;				
			} else {
				this.ult.setProx(lista2.prim);
			}
			this.ult = lista2.ult;
			this.quantNos += lista2.quantNos;
			lista2.prim = null;
			lista2.ult = null;
			lista2.quantNos = 0;
		}
	}
	// c) Dividir uma lista em várias (k)
	public ListaSimples dividirLista (){
		if (this.quantNos < 2){
			return null;
		} else {
			ListaSimples nova = new ListaSimples();
			int cont = this.quantNos/2;
			No atual = this.prim;
			for (int i = 1; i < cont; i++){
				atual = atual.getProx();
			}
			nova.prim = atual.getProx();
			nova.ult = this.ult;
			this.ult = atual;
			this.ult.setProx(null);
			nova.quantNos = this.quantNos - (cont);
			this.quantNos = cont;
			return nova;
		}
	}
	// d) Copiar uma lista
	public ListaSimples copiarLista(){
		ListaSimples nova = new ListaSimples();
		No atual = this.prim;
		while (atual != null){
			nova.inserirUltimo(new Item (atual.getInfo().getChave()));
			atual = atual.getProx();
		}
		return nova;
	}
	
	/*
	4) Escreva uma função em Java para trocar os elementos m e n de uma lista simplesmente encadeada
	(m e n podem ser chaves ou mesmo ponteiros para os elementos – a escolha é sua).
	*/
	public boolean trocarChaves (int m, int n){
		if (this.quantNos < 2 || m == n){
			return false;
		} else {
			No auxM = null;
			No auxN = null;
			No aux = this.prim;
			while (aux != null || (auxM.getInfo().getChave() != m && auxN.getInfo().getChave() != n)){
				if (aux.getInfo().getChave() == m){
					auxM = aux;
				}
				if (aux.getInfo().getChave() == n){
					auxN = aux;
				}
				aux = aux.getProx();
			}
			if (auxM == null || auxN == null){
				return false;
			} else {
				Item auxItem = auxM.getInfo();
				auxM.setInfo(auxN.getInfo());
				auxN.setInfo(auxItem);				
				return true;
			}
		}
	}	
	public boolean trocarPonteiros (No m, No n){
		if (this.quantNos < 2){
			return false;
		} else {
			No aux = m;
			m = n;
			n = aux;
			return true;
		}
	}
	
	/*
	5) Escreva uma rotina, inssub(l1,i1,l2,i2,len) para inserir os elementos da lista l2,
	começando no elemento i2 e continuando por len elementos na lista l1, começando na posição i1.
	Nenhum elemento da lista l1 deverá ser removido ou substituído.
	Se i1 > length(l1) + 1 (onde length(l1) indica o número de nós na lista),
	ou se i2 + len – 1 > length(l2), ou se i1 < 1, ou se i2 < 1, imprima uma mensagem de erro.
	A lista l2 deve permanecer inalterada.
	*/
	public void inssub (int i1, int i2, int len, ListaSimples l2){
		if ((i1 > this.quantNos + 1) || (i2 + len - 1 > l2.quantNos) || (i1 < 1) || (i2 < 1)){
			System.out.println("erro");
		} else {
			int cont1 = 1;
			No aux1 = this.prim;
			while (cont1 < i1 - 1){
				aux1 = aux1.getProx();
				cont1++;
			}
			int cont2 = 1;
			No aux2 = l2.prim;
			while (cont2 != i2){
				aux2 = aux2.getProx();
				cont2++;
			}
			No auxLen = aux2;
			for (int j = 1; j <= len - 2; j++){
				auxLen = auxLen.getProx();
			}
			if (len == 1){
				aux2.setProx(aux1.getProx().getProx());
			} else {
				if (len == 2){
					aux2.getProx().setProx(aux1.getProx().getProx());
				} else {
					if (i1 == 1){
						auxLen.getProx().setProx(aux1.getProx());
					} else {
						auxLen.getProx().setProx(aux1.getProx().getProx());
					}
				}	
			}
			if (i1 == 1){
				this.prim.setProx(aux2);				
			} else {
				aux1.getProx().setProx(aux2);
			}
			if (i1 == this.quantNos){
				this.ult = l2.ult;
			}
			this.quantNos += len;
		}
	}
	
	/*
	6) Escreva uma função em Java, search(l,x), que receba um ponteiro l para uma lista de inteiros e um inteiro x,
	e retorne um ponteiro para um nó contendo x, se existir, e o ponteiro nulo, caso contrário.
	*/
	public No search (No l, int x){
		l = this.prim;
		while (l != null && l.getInfo().getChave() != x){
			l = l.getProx();
		}
		return l;		
	}
	/*
	6) Escreva outra função, searchinsert(l,x),
	que inclua x em l se ele não for encontrado, e retorne sempre um ponteiro para um nó contendo x.
	*/
	public No searchInsert (No l, int x){
		l = this.prim;
		while (l.getInfo().getChave() != x){
			l = l.getProx();
			if (l.getProx() == null){
				l.getInfo().setChave(x);
			}
		}
		return l;
	}
		
	/*
	7) Escreva uma função void MoveMenor(Tipo Lista encadeada) que,
	dada uma lista com um número qualquer de elementos, acha o menor elemento da lista e o move para o começo da lista. 
	(Obs. Não vale trocar apenas os campos item ou usar uma lista / fila / pilha auxiliar!
	Você deverá fazer a manipulação dos apontadores para trocar as células de posição).
	*/
	public void moverMenor (){
		if (!this.éVazia()){
			No menor = this.prim;
			No anterior = this.prim;
			No aux = this.prim;
			int i = 0;
			for (No atual = this.prim; atual != null; atual = atual.getProx()){
				if (atual.getInfo().getChave() < menor.getInfo().getChave()){
					menor = atual;
					anterior = aux;
				}
				if (i > 0){
					aux = aux.getProx();
				}
				i++;
			}
			if (menor != this.prim){
				anterior.setProx(menor.getProx());
				menor.setProx(this.prim);
				this.prim = menor;
			}
			if (menor == this.ult){
				this.ult = anterior;
			}
		}
	}

	/*
	8) Implemente uma função que utiliza duas Listas Lineares Simplesmente Encadeadas de inteiros, L1 e L2.
	Esta função deverá retornar VERDADEIRO se as listas forem idênticas (os mesmos elementos na mesma ordem),
	ou FALSO se pelo menos um elemento for diferente da ordem. Admita que as listas não estão vazias.
	*/
	public boolean saoIguais (ListaSimples lista2){
		boolean iguais = false;
		if (this.quantNos != lista2.quantNos){
			return iguais;
		}
		No aux1 = this.prim;
		No aux2 = lista2.prim;
		while (aux1 != null || aux2 != null){
			if(aux1.getInfo().getChave() != aux2.getInfo().getChave()){
				iguais = false;
			} else {
				iguais = true;
			}
			aux1 = aux1.getProx();
			aux2 = aux2.getProx();
		}
		return iguais;
	}
	
	/*
	9) Implemente um método que tenha duas Listas Lineares Simplesmente Encadeadas de inteiros, L1 e L2 ordenadas crescentemente.
	Este procedimento deverá gerar uma terceira lista, L3, que é o resultado da união de L1 e L2.
	Considere: L1, L2 e L3 são do mesmo tipo e L1 e L2 não estão vazias. L3 está vazia e deverá ficar também ordenada.
	*/
	public ListaSimples mesclarListas (ListaSimples L2){
		ListaSimples L3 = new ListaSimples();
		No atualL1 = this.prim;
		No atualL2 = L2.prim;
		while (atualL1 != null && atualL2 != null){
			if (atualL1.getInfo().getChave() < atualL2.getInfo().getChave()){
				L3.inserirUltimo(new Item(atualL1.getInfo().getChave()));
				atualL1 = atualL1.getProx();
			} else {
				L3.inserirUltimo(new Item(atualL2.getInfo().getChave()));
				atualL2 = atualL2.getProx();
			}
		}
		if (atualL1 == null){
			while (atualL2 != null){
				L3.inserirUltimo(new Item(atualL2.getInfo().getChave()));
				atualL2 = atualL2.getProx();
			}
		}
		if (atualL2 == null){
			while (atualL1 != null){
				L3.inserirUltimo(new Item(atualL1.getInfo().getChave()));
				atualL1 = atualL1.getProx();
			}
		}
		return L3;
	}
}

