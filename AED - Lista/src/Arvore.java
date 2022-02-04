/*	não é linear, tem hierarquia
	Nó raiz = topo, só tem um
	nó pai = nó que está logo acima de outro. Unico que n tem nó pai é o nó raiz
	nó filho = abaixo do pai
	>> todos tem um ÚNICO nó pai (fora a raiz, que n tem).
	grau de saida = numero de filhos de um nó
	grau de saida da árvore  = maior grau de saida encontrado na arvore
	folha = nó sem filhos, sem grau de saída. também chamado de "nó externo" (nó interno é qqr um q tenha filhos);
	nível / profundidade > raiz = nivel 0 e o nível da arvore é o nivel do nó mais baixo 
	altura da arvore = caminho mais longo da raiz até uma folha (arvore vazia = -1)
	arvore ordenada / desordenada
	[          A    	] DESORDENADA
	[      C       B	] >ordem "decrescente" (C e B)
 	[  D   E  F    G	]>ordem crescente (D E F G (ordem "certa")
	[ H I				]>= = (H I)
	
	[          A    	] ORDENADA
	[      B       C	]
 	[  D   E  F    G	] >tudo crescente
	[ H I				]
	
	Representação da Árvore: Diagrama de Venn, Hierarquica e Parenteses Aninhados
	Ex Ordenada em Parenteses aninhados: (A (B (D (H) (I)) (E) (F)) (C (G)))
	
	Árvore Cheia = quando todas os nós tem o grau de saída maximo.
	
	Arvore de Busca >> chave de busca > atributo para procura, que PRECISA SER COMPARAVEL

*/
public interface Arvore {

}
