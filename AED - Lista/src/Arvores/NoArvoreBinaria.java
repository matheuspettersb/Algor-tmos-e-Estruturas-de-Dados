package Arvores;

public class NoArvoreBinaria<T> {
	private T info;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		super();
		this.info = info;
		this.esq = esq;
		this.dir = dir;
	}

	public NoArvoreBinaria(T info) {
		super();
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoArvoreBinaria<T> getEsq() {
		return esq;
	}

	public void setEsq(NoArvoreBinaria<T> esq) {
		this.esq = esq;
	}

	public NoArvoreBinaria<T> getDir() {
		return dir;
	}

	public void setDir(NoArvoreBinaria<T> dir) {
		this.dir = dir;
	}


	public String imprimePre() {
		String str = "<" + this.info; // trata raiz
		if (this.esq != null) {
			str += this.esq.imprimePre(); // percorre sae
		} else {
			str += "<>"; // subárvore vazia
		}
		if (this.dir != null) {
			str += this.dir.imprimePre(); // percorre sad
		} else {
			str += "<>"; // subárvore vazia
		}
		return str + ">";
	}

	public String imprimeCentral() {
		String str =  "";
		if (this.esq != null) {
			str += this.esq.imprimeCentral(); // percorre sae
		} 
		str += this.info.toString()+", "; // trata raiz
		if (this.dir != null) {
			str += this.dir.imprimeCentral(); // percorre sad
		} 
		return str;
	}

	public NoArvoreBinaria<T> pertence(T procurado) {
		if (this.info.equals(procurado)) { // tratar a raiz  
			return this;
		}
		NoArvoreBinaria<T> nabProcurado = null;
		if (this.esq != null) {
			nabProcurado = this.esq.pertence(procurado); // percorre a sae
		}
		if (nabProcurado == null) { // não encontrou na sae
			if (this.dir != null) {
				return this.dir.pertence(procurado); // percorre a sad
			}
		}
		return nabProcurado;
	}

	@Override
	public String toString() {
		return  this.info.toString() ;
	}

	
}