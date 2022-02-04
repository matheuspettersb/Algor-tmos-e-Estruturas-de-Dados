package Arvores;

public class NoArvoreNaria<T> {
	private T info;
	private NoArvoreNaria<T> filho;
	private NoArvoreNaria<T> irmao;

	public NoArvoreNaria(T info) {
		super();
		this.info = info;
		this.filho = null;
		this.irmao = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoArvoreNaria<T> getFilho() {
		return filho;
	}

	public void setFilho(NoArvoreNaria<T> filho) {
		this.filho = filho;
	}

	public NoArvoreNaria<T> getIrmao() {
		return irmao;
	}

	public void setIrmao(NoArvoreNaria<T> irmao) {
		this.irmao = irmao;
	}

	public String imprimePre() {
		String str = "<" + this.info;
		if (this.getFilho() != null) {
			str += this.getFilho().imprimePre();
		} else {
			str += ">"; // sem filhos
		}
		if (this.getIrmao() != null) {
			str += this.getIrmao().imprimePre();
		}
		return str + ">";
	}

	public void inserirFilho(NoArvoreNaria<T> sa) {
		if (sa != null) {
		sa.setIrmao(this.filho);
		this.setFilho(sa);
		}
	}

	public NoArvoreNaria<T> pertence(T procurado) {
		if (this.getInfo().equals(procurado)) {
			return this;
		}
		NoArvoreNaria<T> noProcurado = null;
			if (this.getFilho() != null) {
				noProcurado = this.getFilho().pertence(procurado);
			}
			if (noProcurado == null && this.getIrmao() != null) {
				noProcurado = this.getIrmao().pertence(procurado);
			}
		return noProcurado;
	}

}
