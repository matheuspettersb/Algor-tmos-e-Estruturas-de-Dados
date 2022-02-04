package Arvores;

public class ArvoreBST<T extends Comparable> extends ArvoreBinariaAbstract<T> {

	public void inserir(T info) {
		if (this.estaVazia()) {
			this.setRaiz(new NoArvoreBST<>(info));
		} else {
			((NoArvoreBST<T>) this.getRaiz()).inserir(info);
		}
	}

	public NoArvoreBST<T> buscar(T procurado) {
		if (this.estaVazia()) {
			return null;
		} else {
			return ((NoArvoreBST<T>) this.getRaiz()).buscar(procurado);
		}
	}

	public void retirar(T info) {
		NoArvoreBST<T> noARemover = this.buscar(info);
		if (noARemover != null) {
			this.retirar(noARemover);
		}
	}

	private void retirar(NoArvoreBST<T> noARemover) {
		if (noARemover == this.getRaiz()) {
			// caso 1 - nó folha
			if (noARemover.getEsq() == null && noARemover.getDir() == null) {
				this.setRaiz(null);
			} else {
				// caso 2 - nó com 1 filho
				if (noARemover.getEsq() == null || noARemover.getDir() == null) {
					if (noARemover.getEsq() != null) { // filho está à esquerda
						this.setRaiz(noARemover.getEsq());
					} else { // filho está à direita
						this.setRaiz(noARemover.getDir());
					}
				} else {
					// caso 3 - nó com 2 filhos
					NoArvoreBST<T> sucessor = this.sucessor(noARemover);
					T info = sucessor.getInfo();
					this.retirar(sucessor);
					this.getRaiz().setInfo(info);
				}
			}
		} else { // noARemover não é raiz
			NoArvoreBST<T> pai = this.descobrirPai(noARemover);
			// caso 1 - nó folha
			if (noARemover.getEsq() == null && noARemover.getDir() == null) {
				if (pai.getEsq() == noARemover) {
					pai.setEsq(null);
				} else {
					pai.setDir(null);
				}
			} else if (noARemover.getEsq() == null || noARemover.getDir() == null) {
				// caso 2 - nó com 1 filho
				NoArvoreBST<T> filho;
				if (noARemover.getEsq() != null) { // filho está à esquerda
					filho = (NoArvoreBST<T>) noARemover.getEsq();
				} else {
					filho = (NoArvoreBST<T>) noARemover.getDir();
				}
				if (pai.getEsq() == noARemover) {
					pai.setEsq(filho);
				} else {
					pai.setDir(filho);
				}
			} else {
				// caso 3 - nó com 2 filhos
				NoArvoreBST<T> sucessor = this.sucessor(noARemover);
				T info = sucessor.getInfo();
				this.retirar(sucessor);
				noARemover.setInfo(info);
			}
		}
	}

	private NoArvoreBST<T> descobrirPai(NoArvoreBST<T> filho) {
		if (filho == null || this.getRaiz() == filho) {
			return null;
		}
		NoArvoreBST<T> pai = (NoArvoreBST<T>) this.getRaiz();
		while (pai != null) {
			if (pai.getEsq() == filho || pai.getDir() == filho) {
				return pai;
			}
			if (pai.getInfo().compareTo(filho.getInfo()) > 0) {
				pai = (NoArvoreBST<T>) pai.getEsq();
			} else {
				pai = (NoArvoreBST<T>) pai.getDir();
			}
		}
		return null;
	}

	public NoArvoreBST<T> maiorElemento() {
		if (this.estaVazia()) {
			return null;
		}
		NoArvoreBST<T> maior = (NoArvoreBST<T>) this.getRaiz();
		while (maior.getDir() != null) {
			maior = (NoArvoreBST<T>) maior.getDir();
		}
		return maior;
	}

	public NoArvoreBST<T> menorElemento() {
		if (this.estaVazia()) {
			return null;
		}
		NoArvoreBST<T> menor = (NoArvoreBST<T>) this.getRaiz();
		while (menor.getEsq() != null) {
			menor = (NoArvoreBST<T>) menor.getEsq();
		}
		return menor;
	}

	// uma segunda implementação para encontrar o menor. Esta usa recursividade nos
	// NoArvoreBST.
	public NoArvoreBST<T> buscarMenor() {
		if (this.estaVazia()) {
			return null;
		}
		return ((NoArvoreBST<T>) this.getRaiz()).buscarMenor();
	}

	public NoArvoreBST<T> antecessor(NoArvoreBST<T> no) {
		if (this.estaVazia()) {
			return null;
		} else {
			if (no.getEsq() != null) { // antecessor está abaixo dele
				NoArvoreBST<T> antecessor = (NoArvoreBST<T>) no.getEsq();
				while (antecessor.getDir() != null) {
					antecessor = (NoArvoreBST<T>) antecessor.getDir();
				}
				return antecessor;
			} else { // antecessor está acima dele
				NoArvoreBST<T> antecessor = this.descobrirPai(no);
				while (antecessor != null && antecessor.getInfo().compareTo(no.getInfo()) > 0) {
					antecessor = this.descobrirPai(antecessor);
				}
				return antecessor;
			}
		}
	}

	public NoArvoreBST<T> sucessor(NoArvoreBST<T> no) {
		if (this.estaVazia()) {
			return null;
		} else {
			if (no.getDir() != null) { // sucessor está abaixo dele
				NoArvoreBST<T> sucessor = (NoArvoreBST<T>) no.getDir();
				while (sucessor.getEsq() != null) {
					sucessor = (NoArvoreBST<T>) sucessor.getEsq();
				}
				return sucessor;
			} else { // sucessor está acima dele
				NoArvoreBST<T> sucessor = this.descobrirPai(no);
				while (sucessor != null && sucessor.getInfo().compareTo(no.getInfo()) < 0) {
					sucessor = this.descobrirPai(sucessor);
				}
				return sucessor;
			}
		}
	}

	
	public String toStringOrdered() {
		if (this.estaVazia()) {
			return "";
		}
		return this.getRaiz().imprimeCentral();
	}
	
	public String toStringOrdered2() {
		if (this.estaVazia()) {
			return "";
		}
		NoArvoreBST<T> sucessor = this.buscarMenor();
		String s = "";
		while (sucessor != null) {
			s += sucessor.getInfo()+", ";
			sucessor = this.sucessor(sucessor);
		}
		return s;
	}
}