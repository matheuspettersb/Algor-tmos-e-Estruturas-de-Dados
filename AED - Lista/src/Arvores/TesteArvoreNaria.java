package Arvores;

public class TesteArvoreNaria {

	public static void main(String[] args) {
		NoArvoreNaria<Integer> n9 = new NoArvoreNaria < Integer > (9);
		NoArvoreNaria<Integer> n10 = new NoArvoreNaria < Integer > (10);
		NoArvoreNaria<Integer> n4 = new NoArvoreNaria < Integer > (4);
		n4.inserirFilho(n10);
		n4.inserirFilho(n9);
		NoArvoreNaria<Integer> n8 = new NoArvoreNaria < Integer > (8);
		NoArvoreNaria<Integer> n3 = new NoArvoreNaria < Integer > (3);
		n3.inserirFilho(n8);
		NoArvoreNaria<Integer> n5 = new NoArvoreNaria < Integer > (5);
		NoArvoreNaria<Integer> n6 = new NoArvoreNaria < Integer > (6);
		NoArvoreNaria<Integer> n7 = new NoArvoreNaria < Integer > (7);
		NoArvoreNaria<Integer> n2 = new NoArvoreNaria < Integer > (2);
		n2.inserirFilho(n7);
		n2.inserirFilho(n6);
		n2.inserirFilho(n5);
		NoArvoreNaria<Integer> n1 = new NoArvoreNaria < Integer > (1);
		n1.inserirFilho(n4);
		n1.inserirFilho(n3);
		n1.inserirFilho(n2);
		
		ArvoreNaria<Integer> ar = new ArvoreNaria<Integer>();
		ar.setRaiz(n1);
		
		
		System.out.println(ar.toString());
		System.out.println("busca8"+ar.pertence(8));
		System.out.println("busca1"+ar.pertence(1));
		System.out.println("busca9"+ar.pertence(9));
		System.out.println("busca4"+ar.pertence(4));
		
		int  tamanho = (int) (50/0.75);
		System.out.println(tamanho);
	}

}
