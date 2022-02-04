package hash;

// Matheus Petters Bevilaqua, Gabriel Rupp Kosilek Lopes e Marcos Antonio Mattedi
public class MapaDispersao<K, T> {
	private Lista<K, T> tabela[];

	public MapaDispersao(int quantidade) {
		quantidade = (int) (quantidade * 0.75); // Taxa de carga } boas praticas :)
		quantidade = proximoPrimo(quantidade); // primo }
		tabela = (Lista<K, T>[]) new Lista[quantidade];
	}

	private int calcularHash(K chave) {
		if (chave == null) {
			throw new IllegalArgumentException("chave não pode ser nula");
		}
		if (chave.hashCode()<0) {
			return ((-chave.hashCode())%tabela.length);
		}
			else {
		return (chave.hashCode()%tabela.length);
		}
	}

	public boolean inserir(K chave, T dado) {
		if (chave == null || dado == null) {
			throw new IllegalArgumentException("chave/dado não pode ser nula");
		}
		int posicao = this.calcularHash(chave);
		if (tabela[posicao]==null) { //não tem nada nessa posiçao
			Lista<K,T> a = new ListaEncadeada<K,T>();
			a.inserir(chave, dado);
			tabela[posicao] = a;
			return true;
		}
		else if(tabela[posicao].buscar(chave)== -1){ //busca a chave na lista da posição
			tabela[posicao].inserir(chave, dado); //se n tiver, adiciona
			return true;
			} else {
				return false; //não adiciona/retorna falso
			}
	}

	public T remover(K chave) {
		int posicao = this.calcularHash(chave);
		if (this.buscar(chave)==null) {
			return null;
		}
		else {
		T obj = this.buscar(chave);
		tabela[posicao].retirar(obj);
		return obj;
		}
	}

	public T buscar(K chave) {
		int posicao = this.calcularHash(chave);
		if (tabela[posicao]==null) { //não tem nada nessa posiçao
			return null;
		}
		else if(tabela[posicao].buscar(chave) == -1){ //busca a chave na lista da posição
			return null; //não existe
			} else {
				return tabela[posicao].pegar(tabela[posicao].buscar(chave)); //retorna o objeto que foi buscado na lista
			}
	}

	public int quantosElementos() {
		int contador =0;
		for (int i=0; i<tabela.length; i++) {
			if (tabela[i] != null)
			contador += tabela[i].getTamanho();
		}
		return contador;
	}

	private int proximoPrimo(int n) {
		while (ehPrimo(n) == false) {
			n++;
		}
		return n;
	}

	private static boolean ehPrimo(int numero) {
		for (int j = 2; j < numero; j++) {
			if (numero % j == 0)
				return false;
		}
		return true;
	}
}
