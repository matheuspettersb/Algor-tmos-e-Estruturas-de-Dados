
public interface TabelaDeDispers�o {
//	tabela de dispers�o, tamb�m conhecida por
//	-mapa de dispers�o
//	-tabela de espalhamento
//	-tabela hash
//	-mapa hash (HASHMAP)
//	
//	> opera��es de busca remo��o e insers�o rapidas pq o tempo de execu��o � constante
//	> busca em vetores (+vloecidade)
//	> compacta��o de valores (tentar manter 75% a 50% de ocupa��o) (operador %) (numero primo proximo a isso)
//	
//	colis�es > tratamento por enderea�amento aberto ou separado
//	endere�amento aberto: quando n pode por ele no lugar certo procura outra posi��o pra ele. Pode ser por:
//	-explora��o linear: 	procura o proximo espa�o livre (x+1, x+2, x+3...)
//	-explora��o quadratica:	evita cluters procurando o quadrado do valor (x+1�, x+2�, x+3�...)
//	-hash duplo:			
//
//	endere�amento separado:
//	- n�o guarda na posi��o, mas a posi��o aponta pra uma lista encadeada que tem todos os elementos que tem a mesma
//	posi��o no resto da divis�o (%)
	
//	Desvantagens do hashmap:
//	baseia se em vetor (dificil de expandir)
//	pode ter desempenho reduzido (requer que o programador saiba +- a quantidade de dados previamente)
//	nao tem uma maneira conveniente de visitar os itens
	
}
