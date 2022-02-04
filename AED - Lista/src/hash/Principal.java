package hash;

//Matheus Petters Bevilaqua, Gabriel Rupp Kosilek Lopes e Marcos Antonio Mattedi
public class Principal {

	public static void main(String[] args) {
		Veiculo v = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");
		Veiculo v2 = new Veiculo("AMJ-1231", "Renault Duster", 2013, "Paulo Azevedo");
		Veiculo v3 = new Veiculo("MMD-5611", "Citroen C4", 2010, "Isadora Ora");
		Veiculo v4 = new Veiculo("ACD-6354", "Toyota Corolla", 2018, "Maria Silva");
		
		Veiculo v7 = new Veiculo("BCC-1234", "Dodge Charger RT", 1979, "Mattedi");
		Veiculo v8 = new Veiculo("CCB-4321", "Ferrari", 2021, "Marcel");
		Veiculo v9 = new Veiculo("ASS-2020", "Celta tunado rebaixado", 2018, "Gabriel");
		Veiculo v10 = new Veiculo("INF-5923", "Carro do Kevin", 2018, "Matheus");
		//criando veiculos
		
		Veiculo v5 = new Veiculo("ACD-6354", "Palio", 2018, "Marina Silva");
		Veiculo v6 = new Veiculo("AAA-0123", "Fusca", 1978, "Mattedi");
		//criando veiculo com a mesma placa
		
		
		MapaDispersao<String,Veiculo>mp = new MapaDispersao(10);
		//criando mapa a exemplo do ava, mas menor, pois adicionamos menos
		
		System.out.println("Inserindo v1 "+mp.inserir(v.getPlaca(), v));
		System.out.println("Inserindo v2 "+mp.inserir(v2.getPlaca(), v2));
		System.out.println("Inserindo v3 "+mp.inserir(v3.getPlaca(), v3));
		System.out.println("Inserindo v4 "+mp.inserir(v4.getPlaca(), v4));
		System.out.println("Inserindo v5 "+mp.inserir(v5.getPlaca(), v5)); //é pra dar false, tem placa repetida
		System.out.println("Inserindo v6 "+mp.inserir(v6.getPlaca(), v6)); //é pra dar false, tem placa repetida
		System.out.println("Inserindo v7 "+mp.inserir(v7.getPlaca(), v7));
		System.out.println("Inserindo v8 "+mp.inserir(v8.getPlaca(), v8));
		System.out.println("Inserindo v9 "+mp.inserir(v9.getPlaca(), v9));
		System.out.println("Inserindo v10 "+mp.inserir(v10.getPlaca(), v10));
		
		System.out.println("\nQuantos elementos "+mp.quantosElementos()); //Quantos foram inseridos
		
		System.out.println(mp.buscar(v.getPlaca()));	//testes de busca por placa
		System.out.println(mp.buscar(v2.getPlaca()));
		System.out.println(mp.buscar(v3.getPlaca()));
		System.out.println(mp.buscar(v4.getPlaca()));
		System.out.println(mp.buscar(v7.getPlaca()));
		System.out.println(mp.buscar(v8.getPlaca()));
		System.out.println(mp.buscar(v9.getPlaca()));
		System.out.println(mp.buscar(v10.getPlaca()));
		
		
		mp.remover(v2.getPlaca());
		System.out.println("\nQuantos elementos "+mp.quantosElementos());
		mp.remover(v.getPlaca());
		System.out.println("Quantos elementos "+mp.quantosElementos());
		mp.remover(v3.getPlaca());
		System.out.println("Quantos elementos "+mp.quantosElementos());
		mp.remover(v4.getPlaca());
		System.out.println("Quantos elementos "+mp.quantosElementos());
		mp.remover(v7.getPlaca());
		System.out.println("Quantos elementos "+mp.quantosElementos());
		mp.remover(v8.getPlaca());
		System.out.println("Quantos elementos "+mp.quantosElementos());
		mp.remover(v9.getPlaca());
		System.out.println("Quantos elementos "+mp.quantosElementos());
		//removendo todos menos o v10
		
	}

}
