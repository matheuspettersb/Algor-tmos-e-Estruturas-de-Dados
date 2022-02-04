
public class TesteArvoreNAria {
	public static void main(String args[]) {
		NoArvore<Integer> n9 = new NoArvore<Integer>(9);
		NoArvore<Integer> n10 = new NoArvore<Integer>(10);
		NoArvore<Integer> n4 = new NoArvore<Integer>(4);
		n4.inserirFilho(n10);
		n4.inserirFilho(n9);

		NoArvore<Integer> n8 = new NoArvore<Integer>(8);
		NoArvore<Integer> n3 = new NoArvore<Integer>(3);
		n3.inserirFilho(n8);

		NoArvore<Integer> n5 = new NoArvore<Integer>(5);
		NoArvore<Integer> n6 = new NoArvore<Integer>(6);
		NoArvore<Integer> n7 = new NoArvore<Integer>(7);

		NoArvore<Integer> n2 = new NoArvore<Integer>(2);
		n2.inserirFilho(n7);
		n2.inserirFilho(n6);
		n2.inserirFilho(n5);

		NoArvore<Integer> n1 = new NoArvore<Integer>(1);
		n1.inserirFilho(n4);
		n1.inserirFilho(n3);
		n1.inserirFilho(n2);

		Arvore<Integer> a = new Arvore<>();
		a.setRaiz(n1);
		System.out.println(a.toString());
		System.out.println("Buscando o 8 = " + a.pertence(8));
		System.out.println("Buscando o 10 = " + a.pertence(10));
		System.out.println("Buscando o 4 = " + a.pertence(4));
		System.out.println("Buscando o 1 = "+a.pertence(1));
		
		//arvore 2
		
		NoArvore<Integer> nn1 = new NoArvore<Integer>(1);
		NoArvore<Integer> nn2 = new NoArvore<Integer>(2);
		NoArvore<Integer> nn3 = new NoArvore<Integer>(3);
		NoArvore<Integer> nn4 = new NoArvore<Integer>(4);
		NoArvore<Integer> nn5 = new NoArvore<Integer>(5);
		NoArvore<Integer> nn6 = new NoArvore<Integer>(6);
		NoArvore<Integer> nn7 = new NoArvore<Integer>(7);
		NoArvore<Integer> nn8 = new NoArvore<Integer>(8);
		NoArvore<Integer> nn9 = new NoArvore<Integer>(9);
		NoArvore<Integer> nn10 = new NoArvore<Integer>(10);
		NoArvore<Integer> nn11 = new NoArvore<Integer>(11);
		NoArvore<Integer> nn12 = new NoArvore<Integer>(12);
		NoArvore<Integer> nn13 = new NoArvore<Integer>(13);
		NoArvore<Integer> nn14 = new NoArvore<Integer>(14);
		NoArvore<Integer> nn15 = new NoArvore<Integer>(15);
		
		nn1.inserirFilho(nn2);
		nn1.inserirFilho(nn3);
		
		nn2.inserirFilho(nn4);
		nn2.inserirFilho(nn5);
		nn2.inserirFilho(nn6);
		
		nn6.inserirFilho(nn9);
		nn6.inserirFilho(nn10);
		
		nn3.inserirFilho(nn7);
		nn3.inserirFilho(nn8);
		
		nn8.inserirFilho(nn11);
		
		nn11.inserirFilho(nn12);
		nn11.inserirFilho(nn13);
		nn11.inserirFilho(nn14);
		nn11.inserirFilho(nn15);
		
		Arvore<Integer> aa = new Arvore<>();
		aa.setRaiz(nn1);
		
		Arvore<Integer> aaa = new Arvore<>();
		// aaa.setRaiz(nn14); //testou certo (deu 0)

		System.out.println("Buscando o 20 = "+a.pertence(20));
		
		System.out.println("----TESTES PROVA-----");
		System.out.println("----arvore 1-----");
		System.out.println("grau no 4 = "+ a.getGrau(4));
		System.out.println("grau no 9 = "+ a.getGrau(9));
		System.out.println("grau no 2 = "+ a.getGrau(2));
		System.out.println("grau da arvore = "+ a.getGrauArvore());
		System.out.println("Altura maxima da arvore = "+ a.getAltura());
		
		System.out.println("----arvore 2-----");
		System.out.println("grau no 4 = "+ aa.getGrau(4));
		System.out.println("grau no 2 = "+ aa.getGrau(2));
		System.out.println("grau no 11 = "+ aa.getGrau(11));
		System.out.println("grau no 3 = "+ aa.getGrau(3));
		System.out.println("grau no 8 = "+ aa.getGrau(8));
		System.out.println("grau da arvore = "+ aa.getGrauArvore());
		System.out.println("Altura maxima da arvore = "+ aa.getAltura());
		System.out.println("grau no 26* = "+ aa.getGrau(26));
		System.out.println("altura da arvore 3* = "+ aaa.getAltura());
		System.out.println("grau arvore 3* = "+ aaa.getGrauArvore());
		
	}
}