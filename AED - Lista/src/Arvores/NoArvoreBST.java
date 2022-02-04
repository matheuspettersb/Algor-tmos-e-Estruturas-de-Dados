package Arvores;

public class NoArvoreBST<T extends Comparable> extends NoArvoreBinaria<T> {

	public NoArvoreBST(T info) {
		super(info);
	}

	public NoArvoreBST<T> buscar(T procurado) {
		if (procurado.equals(this.getInfo())) {
			return this;
		} else {
			if (procurado.compareTo(this.getInfo()) < 0) {
				if (this.getEsq() == null) {
					return null;
				}
				return ((NoArvoreBST<T>) this.getEsq()).buscar(procurado);
			} else {
				if (this.getDir() == null) {
					return null;
				}
				return ((NoArvoreBST<T>) this.getDir()).buscar(procurado);
			}
		}
	}

	public void inserir(T info) {
		if (info.compareTo(this.getInfo()) < 0) {
			// esquerda
			if (this.getEsq() == null)
				this.setEsq(new NoArvoreBST<>(info));
			else
				((NoArvoreBST<T>) this.getEsq()).inserir(info);
		} else {
			// direita
			if (this.getDir() == null)
				this.setDir(new NoArvoreBST<>(info));
			else
				((NoArvoreBST<T>) this.getDir()).inserir(info);
		}

	}

	public NoArvoreBST<T> buscarMenor() {
		if (this.getEsq() != null) {
			return ((NoArvoreBST<T>)this.getEsq()).buscarMenor();
		}
		else 
			return this;
	}
	
}