/*	n�o � linear, tem hierarquia
	N� raiz = topo, s� tem um
	n� pai = n� que est� logo acima de outro. Unico que n tem n� pai � o n� raiz
	n� filho = abaixo do pai
	>> todos tem um �NICO n� pai (fora a raiz, que n tem).
	grau de saida = numero de filhos de um n�
	grau de saida da �rvore  = maior grau de saida encontrado na arvore
	folha = n� sem filhos, sem grau de sa�da. tamb�m chamado de "n� externo" (n� interno � qqr um q tenha filhos);
	n�vel / profundidade > raiz = nivel 0 e o n�vel da arvore � o nivel do n� mais baixo 
	altura da arvore = caminho mais longo da raiz at� uma folha (arvore vazia = -1)
	arvore ordenada / desordenada
	[          A    	] DESORDENADA
	[      C       B	] >ordem "decrescente" (C e B)
 	[  D   E  F    G	]>ordem crescente (D E F G (ordem "certa")
	[ H I				]>= = (H I)
	
	[          A    	] ORDENADA
	[      B       C	]
 	[  D   E  F    G	] >tudo crescente
	[ H I				]
	
	Representa��o da �rvore: Diagrama de Venn, Hierarquica e Parenteses Aninhados
	Ex Ordenada em Parenteses aninhados: (A (B (D (H) (I)) (E) (F)) (C (G)))
	
	�rvore Cheia = quando todas os n�s tem o grau de sa�da maximo.
	
	Arvore de Busca >> chave de busca > atributo para procura, que PRECISA SER COMPARAVEL

*/
public interface Arvore {

}
