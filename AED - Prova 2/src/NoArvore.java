// Marcos Antonio Mattedi e Matheus Petters Bevilaqua
public class NoArvore<T> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;

	public NoArvore(T info) {
		this.setInfo(info);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public String imprimirPre() {
		String str = "<" + this.info; // trata raiz
		if (this.getFilho() != null) {
			str += this.getFilho().imprimirPre();
		}
		str += ">";
		if (this.getIrmao() != null) {
			str += this.getIrmao().imprimirPre();
		}
		return str;
	}

	public void inserirFilho(NoArvore<T> noAInserir) {
		if (noAInserir != null) {
			noAInserir.setIrmao(this.filho);
			this.setFilho(noAInserir);
		}
	}

	public NoArvore<T> pertence(T procurado) {
		if (this.getInfo().equals(procurado)) {
			return this;
		}
		NoArvore<T> noProcurado = null;
		if (this.getFilho() != null) {
			noProcurado = this.getFilho().pertence(procurado);
		}
		if (noProcurado == null && this.getIrmao() != null) {
			noProcurado = this.getIrmao().pertence(procurado);
		}
		return noProcurado;
	}

	public NoArvore<T> getFilho() {
		return filho;
	}

	public void setFilho(NoArvore<T> filho) {
		this.filho = filho;
	}

	public NoArvore<T> getIrmao() {
		return irmao;
	}

	public void setIrmao(NoArvore<T> irmao) {
		this.irmao = irmao;
	}

	public int getGrau() {
		int retorno = 0;
		if (this.getFilho() == null) {// nenhum filho
			return retorno;
		} else {
			retorno++;
			NoArvore<T> outro = this.getFilho();
			while (outro.getIrmao() != null) {// conta quantos irmãos
				retorno++;
				outro = outro.getIrmao();
			}
		}
		return retorno;
	}

	public int getGrauSubarvore() {
		int grau = this.getGrau(); // contador do maior
		if (this.getFilho() != null) { // percorre filhos
			int j = this.getFilho().getGrauSubarvore();
			if (j > grau) {
				grau = j;
			}
		}
		if (this.getIrmao() != null) {// percorre irmao
			int j = this.getIrmao().getGrauSubarvore();
			if (j > grau) {
				grau = j;
			}
		}
		return grau;
	}

	public int getAlturaSubarvore() {
		int alturaMaxima = 0;
		if (this.getFilho() != null) {
			alturaMaxima++;
			int i = this.getFilho().getAlturaSubarvore();
			alturaMaxima = alturaMaxima + i;
		}
		if (this.getIrmao() != null) {
			int i = this.getIrmao().getAlturaSubarvore();
			if (i > alturaMaxima) {
				alturaMaxima = i;
			}
		}
		return alturaMaxima;
	}
	
	public int getFolhas() {
		int folhas=0;
		if (this.getFilho() != null) {
			folhas += this.getFilho().getFolhas();
		} else {
			folhas++;
		}
		
		if (this.getIrmao() != null) {
			folhas += this.getIrmao().getFolhas();
			}
	
		return folhas;
	}
	
	public String imprimirPos() {
		// sae, sad, raiz
		String str = "";
		
		if (this.getFilho() != null) {
			str += this.getFilho().imprimirPos();
			}
		
		if (this.getIrmao() != null) {
			str += this.getIrmao().imprimirPos();
			}
	
		str += this.getInfo() +"; ";
		return str;
	}

	@Override
	public String toString() {
		return info.toString();
	}
	
}