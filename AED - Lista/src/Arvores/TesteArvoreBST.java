package Arvores;

public class TesteArvoreBST {

	public static void main(String[] args) {
		ArvoreBST<Integer> arvore = new ArvoreBST<>();
		
		arvore.inserir(63);
		arvore.inserir(27);
		arvore.inserir(80);
		arvore.inserir(13);
		arvore.inserir(51);
		arvore.inserir(70);
		arvore.inserir(92);
		arvore.inserir(26);
		arvore.inserir(33);
		arvore.inserir(58);
		arvore.inserir(82);
		arvore.inserir(57);
		arvore.inserir(60);
		System.out.println(arvore);
//		System.out.println("aaa" + arvore.menorElemento());
//		System.out.println("aaa" + arvore.maiorElemento());
		System.out.println("antecessor 51 = " + arvore.antecessor(51)); // << ele ainda ta dando esse msm erro
		System.out.println("antecessor 58 = " + arvore.antecessor(58));
		
		System.out.println(arvore.buscar(80));
		System.out.println(arvore.buscar(57));
		System.out.println(arvore.buscar(100));
		arvore.retirar(58);
		arvore.retirar(100);
		arvore.retirar(13);
		arvore.retirar(63);
		System.out.println(arvore);
	}

}