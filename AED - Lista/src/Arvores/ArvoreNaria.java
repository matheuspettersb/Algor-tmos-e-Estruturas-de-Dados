package Arvores;

public class ArvoreNaria <T> {
	private NoArvoreNaria<T> raiz;

	public ArvoreNaria() {
		super();
		this.raiz = null;
	}

	public NoArvoreNaria<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvoreNaria<T> raiz) {
		this.raiz = raiz;
	}
	
	public String toString() {
		if (vazia()) {
			return "<>";
		}
		return raiz.imprimePre();
	}
	
	public boolean vazia() {
		if (raiz == null) {
			return true;
		}
		return false;
	}
	
	public NoArvoreNaria<T> pertence(T info){
		if (vazia()) {
			return null;
		}
		return raiz.pertence(info);
	}
}
