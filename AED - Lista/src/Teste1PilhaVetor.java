public class Teste1PilhaVetor {

	public static void main(String[] args) {
		PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(5);
		pilha.push(50);
		pilha.push(40);
		pilha.push(30);
		pilha.push(20);
		pilha.push(10);
		try {
			pilha.push(5);
			System.out.println("Não deveria ter chegado aqui!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(pilha);
		System.out.println("Consulta ao topo = 10 = " + pilha.peek());
		System.out.println("Retirada do topo = 10 = " + pilha.pop());
		System.out.println(pilha);
		System.out.println("Pilha vazia? " + pilha.estaVazia());
		pilha.liberar();
		System.out.println(pilha);
		System.out.println("Pilha vazia? " + pilha.estaVazia());
		try {
			pilha.pop();
			System.out.println("Não deveria ter chegado aqui!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------XXXX------");
		PilhaVetor<Integer> p2 = new PilhaVetor<Integer>(5);
	
		pilha.push(5);
		pilha.push(10);
		pilha.push(15);
		pilha.push(20);
		pilha.push(25);
		
		p2.push(5);
		p2.push(10);
		p2.push(15);
		p2.push(20);
		p2.push(25);
		
		System.out.println(pilha.toString());
		System.out.println(p2.toString());
		System.out.println(pilha.compara(p2)+" era pra dar 0");
		
		p2.pop();
		
		System.out.println(pilha.toString());
		System.out.println(p2.toString());
		System.out.println(pilha.compara(p2)+" era pra dar 1");
		
		p2.push(123);
		
		System.out.println(pilha.toString());
		System.out.println(p2.toString());
		System.out.println(pilha.compara(p2)+" era pra dar 2");
		
		pilha.pop();
		
		System.out.println(pilha.toString());
		System.out.println(p2.toString());
		System.out.println(pilha.compara(p2)+" era pra dar -1");
	}
}