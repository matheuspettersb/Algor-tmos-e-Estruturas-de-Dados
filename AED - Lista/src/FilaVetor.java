public class FilaVetor<T> implements Fila<T> {
	private T[] info;
	private int limite;
	private int tamanho;
	private int inicio;

	public FilaVetor(int limite) {
		this.limite = limite;
		info = (T[]) new Object[this.limite];
		this.tamanho = 0;
		this.inicio = 0;
	}

	@Override
	public void inserir(T valor) {
		if (tamanho == limite)
			throw new RuntimeException("Fila está cheia");

		int posInserir = (inicio + tamanho) % limite;
		info[posInserir] = valor;
		tamanho++;
	}

	@Override
	public boolean estaVazia() {
		return tamanho == 0;
	}

	@Override
	public T peek() {
		if (estaVazia())
			throw new RuntimeException("Fila está vazia");

		return info[inicio];
	}

	@Override
	public T retirar() {
		T valor = this.peek();
		info[inicio] = null;
		inicio = (inicio + 1) % limite;
		tamanho--;
		return valor;
	}

	@Override
	public void liberar() {
		info = (T[]) new Object[this.limite];
		inicio = 0;
		tamanho = 0;
	}
	
	public String toString() {
		String str = "[";
		for (int i=0; i < this.tamanho; i++) {
			int posicao = (inicio+i) % limite;
			str += info[posicao]+", ";
		}
		return str+"]";	
	}
}