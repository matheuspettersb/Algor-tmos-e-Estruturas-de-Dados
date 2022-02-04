// Marcos Antonio Mattedi e Matheus Petters Bevilaqua

public class Arvore<T> {
	private NoArvore<T> raiz;

	public Arvore() {
	}

	public NoArvore<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}

	public boolean vazia() {
		return this.getRaiz() == null;
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return this.getRaiz().imprimirPre();
	}

	public NoArvore<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return this.getRaiz().pertence(info);
	}

	public int getGrau(T info) {
		if (this.pertence(info) == null) {
			return -1; // não está na arvore
		}
		NoArvore<T> procurado = this.pertence(info);
		return procurado.getGrau();
	}

	public int getGrauArvore() {
		if (vazia()) {
			return -1;
		}
		return raiz.getGrauSubarvore();
	}

	public int getAltura() {
		// altura da arvore
		if (vazia()) {
			return -1;
		}
		return (raiz.getAlturaSubarvore());
	}
}
