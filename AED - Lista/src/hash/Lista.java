package hash;

//Matheus Petters Bevilaqua, Gabriel Rupp Kosilek Lopes e Marcos Antonio Mattedi
public interface Lista<K,T> {

	void inserir(K chave, T valor);

	int buscar(K chave);

	void retirar(T valor);

	String toString();

	boolean estaVazia();

	Lista<K,T> copiar();

	//void concatenar(Lista<K,T> outra);

	Lista<K,T> dividir();

	int getTamanho();

	T pegar(int posicao);
	
	// int getQuantidadeElementos();

}