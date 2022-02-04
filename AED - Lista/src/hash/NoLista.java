package hash;

//Matheus Petters Bevilaqua, Gabriel Rupp Kosilek Lopes e Marcos Antonio Mattedi

public class NoLista<K,T> {
	private K chave;
	private T info;
	private NoLista proximo;
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NoLista getProximo() {
		return proximo;
	}
	public void setProximo(NoLista proximo) {
		this.proximo = proximo;
	}
	public K getChave() {
		return chave;
	}
	public void setChave(K chave) {
		this.chave = chave;
	}
	
}