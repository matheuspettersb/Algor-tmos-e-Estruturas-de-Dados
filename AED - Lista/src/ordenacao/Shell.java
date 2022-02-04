//Matheus Petters Bevilaqua, Gabriel Rupp Kosilek Lopes e Giovane dos Santos.

package ordenacao;

public class Shell<T extends Comparable<T>> implements Sort<T> {

	public void sort(T[] vetor) {
		int h = 1;
		int tamanho = vetor.length;
		
		while (h < tamanho) {
			h = (h*3)+1;
		}
		h = h/3;
		
		T dado;
		int j;
		while (h>0) {
			for (int i=h; i<tamanho; i ++) {
				dado = vetor[i];
				j=i;
				while (j>=h && vetor[j-h].compareTo(dado)>0) {
					vetor[j] = vetor[j-h];
					j=j-h;
				}
				vetor[j] = dado;
			}
			h = h/2;
		}
	}

}
