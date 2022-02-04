import java.util.ArrayList;

public class TesteListaEstatica {
	public static void main(String[] args) {
		Lista<Integer> lista = new ListaEstatica<>();
		Lista<String> compras = new ListaEstatica<>();
		ArrayList<Integer> listaParalela = new ArrayList<>();
		
		listaParalela.add(50);
		listaParalela.add(-15);
		listaParalela.add(12);
		listaParalela.add(28);
		listaParalela.add(91);
		System.out.println("Lista paralela = "+listaParalela);
		
		lista.inserir(50);
		lista.inserir(-15);
		lista.inserir(12);
		lista.inserir(28);
		lista.inserir(91);
		System.out.println("Lista original = "+lista);
		
		compras.inserir("agulhas");
		compras.inserir("vacina");
		compras.inserir("seringas");
		System.out.println("Lista de compras = "+compras);
		
		Lista<Integer> novaLista;
		novaLista = lista.dividir();
		System.out.println("Primeira lista (original pela metade) = "+lista);
		System.out.println("Lista criada pela divis�o = "+novaLista);

		novaLista.inserir(100);
		System.out.println("Lista A = "+novaLista);
		lista.inserir(200);
		System.out.println("Lista B = "+lista);
		novaLista.concatenar(lista);
		System.out.println("Lista concatenada (A+B) = "+novaLista);
		
		Lista<Integer> terceira = novaLista.copiar();
		System.out.println("Lista copiada = "+terceira);
		novaLista.retirar(100);
		terceira.retirar(200);
		System.out.println("Lista original (sem 100) = "+novaLista);
		System.out.println("Lista copiada (sem 200) = "+terceira);
	}

}