//MATHEUS PETTERS BEVILAQUA E GABRIEL RUPP KOSILEK LOPES
public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdeElementos;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
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
	public int buscar(T valor) {
		NoLista<T> p = this.primeiro;
		int posicao = 0;
		while (p != null) {
			if (p.getInfo() == valor) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = this.primeiro;

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
		ListaEncadeada<T> nova = new ListaEncadeada<>();
		NoLista<T> p = this.primeiro;
		while (p != null) {
			nova.inserir(p.getInfo());
			p = p.getProximo();
		}
		return nova;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	
	public Lista<T> dividir1() {
		ListaEncadeada<T> nova = new ListaEncadeada<>();

		int qtde = this.getTamanho() / 2;

		int qtdeCopiados = 0;
		T[] copiados = (T[]) new Object[this.getTamanho()];

		for (int i = qtde; i < this.getTamanho(); i++) {
			nova.inserir(this.pegar(i));
			copiados[qtdeCopiados] = this.pegar(i);
			qtdeCopiados++;
		}

		for (int j = 0; j < qtdeCopiados; j++) {
			this.retirar(copiados[j]);
		}

		return nova;
	}

	@Override
	public Lista<T> dividir() {
		ListaEncadeada<T> nova = new ListaEncadeada<>();
		int qtde = this.getTamanho() / 2;
		NoLista<T> nl = this.primeiro;
		NoLista<T> anterior=null;
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

	private NoLista<T> getPrimeiro() {
		return primeiro;
	}
	
	private void setPrimeiro(NoLista<T> primeiro) {
		this.primeiro = primeiro;
	}

	@Override
	public T pegar(int posicao) {
		if (posicao >= this.qtdeElementos) { // posição inválida
			throw new ArrayIndexOutOfBoundsException("Posição inválida " + posicao);
		}
		NoLista<T> p = this.primeiro;
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
	
	public int ultimoIndiceDe(T x) {
		NoLista<T> p = this.primeiro;
		int ultimoIndice = -1; //caso n seja encontrado
		int posicao = 0;
		while (p != null) {
			if (p.getInfo().equals(x)) {
				ultimoIndice = posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return ultimoIndice;
	}
	
	public ListaEncadeada<T> intercala(ListaEncadeada<T> outra){
		ListaEncadeada<T> resultado = new ListaEncadeada<>();
		NoLista<T> p = this.primeiro;
		NoLista<T> p2 = outra.getPrimeiro();
		
		while (p != null || p2 != null) {
			if (p != null) {
			resultado.inserir(p.getInfo());
			p = p.getProximo();
			}
			
			if (p2 != null) {
			resultado.inserir(p2.getInfo());
			p2 = p2.getProximo();
			}
		}
		return resultado;
	}	
}
