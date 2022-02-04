public interface Lista<T> {

	void inserir(T valor);

	int buscar(T valor);

	void retirar(T valor);

	String toString();

	boolean estaVazia();

	Lista<T> copiar();

	void concatenar(Lista<T> outra);

	Lista<T> dividir();

	int getTamanho();

	T pegar(int posicao);

}