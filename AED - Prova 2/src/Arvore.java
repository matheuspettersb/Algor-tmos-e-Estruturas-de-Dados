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
		NoArvore<T> noInfo = null;
		noInfo = this.pertence(info);
		if (noInfo != null) {
			return noInfo.getGrau();
		} else {
			return -1;
		}
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
	
	public int getQuantidadeDeNosFolha() {
		int folhas = 0;
		if (vazia()) {
			return folhas;
		}
		return raiz.getFolhas();
	}

	public String imprimePosOrdem() {
		String str = "";
		if (vazia()) {
			return str;
		}
		str += raiz.imprimirPos();
		str = str.substring(0, str.length() - 2);
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}