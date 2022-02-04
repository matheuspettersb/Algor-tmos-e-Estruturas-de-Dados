
public class teste {
	public static void main(String args[]) {
	NoArvore<Integer> n1 = new NoArvore<Integer>(1);
	NoArvore<Integer> n2 = new NoArvore<Integer>(2);
	NoArvore<Integer> n3 = new NoArvore<Integer>(3);
	NoArvore<Integer> n4 = new NoArvore<Integer>(4);
	NoArvore<Integer> n5 = new NoArvore<Integer>(5);
	NoArvore<Integer> n6 = new NoArvore<Integer>(6);
	NoArvore<Integer> n7 = new NoArvore<Integer>(7);
	NoArvore<Integer> n8 = new NoArvore<Integer>(8);
	NoArvore<Integer> n9 = new NoArvore<Integer>(9);
	NoArvore<Integer> n10 = new NoArvore<Integer>(10);
	
	n1.inserirFilho(n2);
	n1.inserirFilho(n6);
	n1.inserirFilho(n7);
	
	n2.inserirFilho(n3);
	n2.inserirFilho(n5);
	
	n3.inserirFilho(n4);
	
	n7.inserirFilho(n8);
	n7.inserirFilho(n9);
	
	n9.inserirFilho(n10);
	
	Arvore<Integer> a = new Arvore<>();
	a.setRaiz(n1);
	
	Arvore<Integer> aa = new Arvore<>();
	System.out.println(a.getQuantidadeDeNosFolha());
	System.out.println(aa.getQuantidadeDeNosFolha());
	
	System.out.println(aa.imprimePosOrdem());
	System.out.println(a.imprimePosOrdem());
	}
}
