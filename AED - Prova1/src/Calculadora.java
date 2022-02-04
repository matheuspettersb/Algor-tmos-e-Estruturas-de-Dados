import java.util.Scanner;

public class Calculadora {
	private Pilha<Integer> pilha;
	
	//get/set pilha
	public Pilha<Integer> getPilha() {
		return pilha;
	}

	public void setPilha(Pilha<Integer> p) {
		this.pilha = p;
	}

	//leitura
	public void leitura(String str) {
		Scanner sc = new Scanner(str);
		pilha.liberar();
		
		if (str.charAt(0)==' ') {
			sc.close();
			throw new IllegalArgumentException("Não deve começar com espaço");
		}
		while (sc.hasNext() == true) {
			if (sc.hasNextInt()) {
				pilha.push(sc.nextInt());
			}
			
			String pattern = "\\+";
			if (sc.hasNext(pattern)) {
				adiciona();
				sc.next();
			}
			pattern = "-";
			if (sc.hasNext(pattern)) {
				subtrai();
				sc.next();
			}
			pattern = "\\*";
			if (sc.hasNext(pattern)) {
				multiplica();
				sc.next();
			}
			pattern = "/";
			if (sc.hasNext(pattern)) {
				divide();
				sc.next();
			}
		}
		sc.close();
	}
	
	// operações
	public void adiciona() {
		int adicao = (pilha.pop()+pilha.pop());
		pilha.push(adicao);
	}
	
	public void subtrai() {
		int subtracao;
		int x = pilha.pop();
		subtracao = (pilha.pop()-x);
		pilha.push(subtracao);
	}
	
	public void multiplica() {
		int multiplicacao = (pilha.pop()*pilha.pop());
		pilha.push(multiplicacao);
	}
	
	public void divide() {
		int divisao;
		int x = pilha.pop();
		divisao = (pilha.pop()/x);
		pilha.push(divisao);
	}
}
