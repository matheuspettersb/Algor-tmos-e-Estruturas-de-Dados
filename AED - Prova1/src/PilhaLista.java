
public class PilhaLista<T> implements Pilha<T> {

	private ListaEncadeada lista;

	public PilhaLista() {
		lista = new ListaEncadeada();
	}

	@Override
	public void push(T v) {
		lista.inserir(v);
	}

	@Override
	public T pop() {
		T valor = this.peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("PilhaLista Vazia");
		}
		return (T) this.lista.pegar(0);
	}

	@Override
	public boolean estaVazia() {
		if (lista.estaVazia()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada();
	}

	public String toString() {
		return lista.toString();
	}

}
