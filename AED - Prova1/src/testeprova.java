
public class testeprova {
	public static void main(String[] args) {	
	Calculadora c = new Calculadora();
	PilhaVetor<Integer> p = new PilhaVetor<Integer>(10);
	c.setPilha(p);
	
	String str = "2";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2654";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2 3";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2 3 +";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2 1 - 3 4 + *";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "6 3 /";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "6 2 / 3 *";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "25 425 - 13 +";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2 3 * 3  35 + -";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	PilhaLista<Integer> p2 = new PilhaLista<Integer>();
	c.setPilha(p2);
	
	str = "2";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2654";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2 3";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2 3 +";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2 1 - 3 4 + *";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "6 3 /";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "6 2 / 3 *";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "25 425 - 13 +";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	str = "2 3 * 3  35 + -";
	c.leitura(str);
	System.out.println("pilha: "+c.getPilha().toString());
	
	}
}
