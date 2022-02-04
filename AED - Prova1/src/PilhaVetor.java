
public class PilhaVetor<T> implements Pilha<T> {

	private T[] info;
	private int tamanho;
	private int limite;

	public PilhaVetor(int limite) {
		this.limite = limite;
		this.info = (T[]) new Object[this.limite];
		this.tamanho = 0;
	}

	@Override
	public void push(T valor) {
		if (tamanho == limite)
			throw new RuntimeException("Limite atingido. Pilha cheia.");
		info[tamanho] = valor;
		tamanho++;
	}

	@Override
	public T pop() {
		T valor = this.peek();
		tamanho--;
		info[tamanho] = null;
		return valor;
	}

	@Override
	public T peek() {
		if (this.estaVazia()) {
			throw new RuntimeException("Pilha está vazia");
		}
		return info[tamanho - 1];
	}

	@Override
	public boolean estaVazia() {
		return tamanho == 0;
	}

	@Override
	public void liberar() {
		info = (T[]) new Object[this.limite];
		tamanho = 0;
	}

	public String toString() {
		String str = "[Topo ";
		for (int i = tamanho - 1; i >= 0; i--) {
			str += info[i] + ", ";
		}
		return str + "base]";
	}

}
