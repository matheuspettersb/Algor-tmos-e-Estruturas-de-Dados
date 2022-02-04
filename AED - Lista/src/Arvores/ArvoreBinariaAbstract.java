package Arvores;
public abstract class ArvoreBinariaAbstract<T> {
	private NoArvoreBinaria raiz;

	public ArvoreBinariaAbstract() {
		super();
	}
	
	public NoArvoreBinaria getRaiz() {
		return this.raiz;
	}

	protected void setRaiz(NoArvoreBinaria<T> r) {
		this.raiz = r;
	}

	public boolean estaVazia() {
		if (raiz == null) {
			return true;
		}
		return false;
	}
	
	public NoArvoreBinaria pertence(T procurado) {
		if (this.estaVazia()) {
			return null;
		}
		return raiz.pertence(procurado);
	}
	
	public String toString() {
		if (this.estaVazia()) {
			return "<>";
		}
		return raiz.imprimePre();
	}
}
