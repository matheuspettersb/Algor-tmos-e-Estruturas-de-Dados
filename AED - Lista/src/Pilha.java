
public interface Pilha<T> {
	//pilha = filo
	void push(T v);

	T pop();

	T peek();

	boolean estaVazia();

	void liberar();
}