package hash;

//Matheus Petters Bevilaqua, Gabriel Rupp Kosilek Lopes e Marcos Antonio Mattedi

public class ListaEncadeada<K,T> implements Lista<K,T> {
	private NoLista<K,T> primeiro;
	private NoLista<K,T> ultimo;
	private int qtdeElementos;

	@Override
	public void inserir(K chave, T valor) {
		NoLista<K,T> novo = new NoLista<>();
		novo.setInfo(valor);
		novo.setChave(chave);
		qtdeElementos++;
		// para inserção no final (a lista fica de acordo com a ordem de inserção)
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		/*
		 * para inserção no início (a lista fica ao contrário)
		 * novo.setProximo(this.primeiro); this.primeiro = novo;
		 */
	}

	public String toString() {
		String toString = "[";
		NoLista p = this.primeiro;
		while (p != null) {
			toString += p.getInfo() + ", ";
			p = p.getProximo();
		}
		toString += "]";
		return toString;
	}

	@Override
	public int buscar(K chave) {
		NoLista<K,T> p = this.primeiro;
		int posicao = 0;
		while (p != null) {
			if (p.getChave() == chave) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		NoLista<K,T> anterior = null;
		NoLista<K,T> p = this.primeiro;

		while (p != null && p.getInfo() != valor) {
			anterior = p;
			p = p.getProximo();
		}
		if (p != null) {
			if (anterior == null) {
				this.primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
			this.qtdeElementos--;
		}
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null); // (ultimo == null) ou (qtdeElementos == 0)
	}

	@Override
	public Lista copiar() {
		ListaEncadeada<K,T> nova = new ListaEncadeada<>();
		NoLista<K,T> p = this.primeiro;
		while (p != null) {
			nova.inserir(p.getChave(), p.getInfo());
			p = p.getProximo();
		}
		return nova;
	}


//	public void concatenar(Lista<K,T> outra) {
//		for (int i = 0; i < outra.getTamanho(); i++) {
//			this.inserir(outra.pegar(i));
//		}
//	}

	
//	public Lista<K,T> dividir1() {
//		ListaEncadeada<K,T> nova = new ListaEncadeada<>();
//
//		int qtde = this.getTamanho() / 2;
//
//		int qtdeCopiados = 0;
//		T[] copiados = (T[]) new Object[this.getTamanho()];
//
//		for (int i = qtde; i < this.getTamanho(); i++) {
//			nova.inserir(this.pegar(i));
//			copiados[qtdeCopiados] = this.pegar(i);
//			qtdeCopiados++;
//		}
//
//		for (int j = 0; j < qtdeCopiados; j++) {
//			this.retirar(copiados[j]);
//		}
//
//		return nova;
//	}

	@Override
	public Lista<K,T> dividir() {
		ListaEncadeada<K,T> nova = new ListaEncadeada<>();
		int qtde = this.getTamanho() / 2;
		NoLista<K,T> nl = this.primeiro;
		NoLista<K,T> anterior=null;
		int index = 0;
		while (index < qtde) {
			anterior = nl;
			nl = nl.getProximo();
			index++;
		}

		// atualizando a nova lista
		nova.primeiro = nl;
		nova.ultimo = this.ultimo;
		nova.qtdeElementos = this.qtdeElementos - qtde;
		
		// atualizando a lista atual
		this.ultimo = anterior;
		ultimo.setProximo(null);
		this.qtdeElementos = qtde;
		
		return nova;
	}

	@Override
	public int getTamanho() {
		return this.qtdeElementos;
	}

	private NoLista<K,T> getPrimeiro() {
		return primeiro;
	}
	
	private void setPrimeiro(NoLista<K,T> primeiro) {
		this.primeiro = primeiro;
	}


	public T pegar(int posicao) {
		if (posicao >= this.qtdeElementos) { // posição inválida
			throw new ArrayIndexOutOfBoundsException("Posição inválida " + posicao);
		}
		NoLista<K,T> p = this.primeiro;
		int contPosicao = 0;
		while (p != null) {
			if (contPosicao == posicao) {
				return p.getInfo();
			}
			contPosicao++;
			p = p.getProximo();
		}
		// pela lógica nunca deve chegar aqui
		return null;
	}
	
//	public int ultimoIndiceDe(T x) {
//		NoLista<K,T> p = this.primeiro;
//		int ultimoIndice = -1; //caso n seja encontrado
//		int posicao = 0;
//		while (p != null) {
//			if (p.getInfo().equals(x)) {
//				ultimoIndice = posicao;
//			}
//			posicao++;
//			p = p.getProximo();
//		}
//		return ultimoIndice;
//	}
	
//	public ListaEncadeada<K,T> intercala(ListaEncadeada<K,T> outra){
//		ListaEncadeada<K,T> resultado = new ListaEncadeada<>();
//		NoLista<K,T> p = this.primeiro;
//		NoLista<K,T> p2 = outra.getPrimeiro();
//		
//		while (p != null || p2 != null) {
//			if (p != null) {
//			//resultado.inserir(p.getInfo());
//			p = p.getProximo();
//			}
//			
//			if (p2 != null) {
//			resultado.inserir(p2.getChave(),p2.getInfo());
//			p2 = p2.getProximo();
//			}
//		}
//		return resultado;
//	}	
}
