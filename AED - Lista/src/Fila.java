
public interface Fila<T> {
	//fila = fifo
	void inserir(T valor);
	
	boolean estaVazia();
	
	T peek();
	
	T retirar();
	
	void liberar();
}
