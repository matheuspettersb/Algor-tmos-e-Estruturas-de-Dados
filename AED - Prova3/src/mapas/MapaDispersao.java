package mapas;

import java.math.BigInteger;

/*
 * Esta implementação de MapaDispersao não realiza o tratamento de colisão.
 * @author Marcel Hugo
 * 
 * Trio: Matheus Petters Bevilaqua, Gabriel Rupp Kosilek Lopes e Giovane dos Santos
 */

public class MapaDispersao<K, T> {

	private ObjetoMapa<K, T>[] tabela;

	public MapaDispersao(int quantidade) {
		BigInteger bi = BigInteger.valueOf(quantidade * 2);
		this.tabela = new ObjetoMapa[bi.nextProbablePrime().intValue()];
	}

	private int calcularHash(K chave) {
		// calcula índice do vetor
		return (chave.hashCode() & 0x7fffffff) % tabela.length;
	}

	public boolean inserir(K chave, T valor) {
		int index = calcularHash(chave);

		if (tabela[index] == null) { // se posição estiver vazia, guarda o par<chave,valor>
			ObjetoMapa<K, T> om = new ObjetoMapa<K, T>();
			om.setChave(chave);
			om.setValor(valor);
			tabela[index] = om;
			return true;
		} else { // já possui um objeto na posição
			while (tabela[index] != null) {
				if (tabela[index].getChave().equals(chave) == true) {
					return false;
				}
				index++;
			}
			ObjetoMapa<K, T> om = new ObjetoMapa<K, T>();
			om.setChave(chave);
			om.setValor(valor);
			tabela[index] = om;
			return true;
		}
	}

	public T buscar(K chave) {
		int index = calcularHash(chave);
		
		if (tabela[index] == null) {
			return null; // posição nula
		}
		while (tabela[index].getChave().equals(chave) == false) { 	//enquanto a chave na posição for diferente da chave procurada
			if (tabela[index] == null) {
				return null;	// não está na tabela
			}
			index++;	//aumenta o indice até achar
		}
		return tabela[index].getValor();
	}

	public T remover(K chave) {
		int index = calcularHash(chave);
		if (tabela[index] == null) {
			return null;
		}
		T temp = tabela[index].getValor();
		tabela[index] = null;
		return temp;
	}
}