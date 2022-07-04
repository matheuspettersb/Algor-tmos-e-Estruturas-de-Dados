SELECT COUNT(*) from log_bairro;
SELECT COUNT(*) from log_grande_usuario;
SELECT COUNT(*) from log_localidade;
SELECT COUNT(*) from log_logradouro;
-- mostra a quantidade de registros em cada

SELECT * from log_bairro;
SELECT * from log_grande_usuario;
SELECT * from log_localidade;
SELECT * from log_logradouro;
-- mostra os registros em si

Atividade 1:
--a) Total de localidades por Unidade da Federação (UF);
	select COUNT(ufe_sg)
	AS qtd_uf, ufe_sg from log_localidade GROUP BY ufe_sg
	ORDER BY ufe_sg;

-- b) Qual é a UF que apresenta o maior número de municípios;
	SELECT COUNT(l1.ufe_sg) AS qtd_municipios, l1.ufe_sg FROM log_localidade l1
		WHERE l1.loc_in_tipo_localidade = 'M'
		GROUP BY l1.ufe_sg
		HAVING COUNT(l1.ufe_sg) >= ALL (SELECT COUNT(ufe_sg)
												AS qtd_municipios FROM log_localidade
												WHERE loc_in_tipo_localidade = 'M'
												GROUP BY ufe_sg)
--contornou o max
--select de baixo pega os numeros e o de cima configura a exibição + atua como o max
--mas tem outro jeito mais simples:
	SELECT COUNT(l1.ufe_sg) AS qtd_municipios, l1.ufe_sg FROM log_localidade l1
	WHERE l1.loc_in_tipo_localidade = 'M'
	GROUP BY l1.ufe_sg
	ORDER BY qtd_municipios DESC LIMIT 1 --limit funciona aqui mas não é mto padrao tho
	--se tivesse mais de um com o mesmo maior valor só mostraria um 
	 
--c) Qual o número de CEPs encontrados em cada UF ordenados pelo maior número;
	select COUNT(ufe_sg)
	AS qtd_ceps, ufe_sg FROM log_localidade l1
	GROUP BY ufe_sg
	ORDER BY qtd_ceps desc
	
	-- correção > criando uima view
	CREATE VIEW vw_qtde_ceps_por_ufvw_qtde_ceps_por_uf
	AS
	SELECT log.ufe_sg AS uf, COUNT(*) AS quantidade
	FROM log_logradouro log
	GROUP BY log.ufe_sg
	UNION
	SELECT loc.ufe_sg AS uf, COUNT(*) AS quantidade
	FROM log_localidade loc
	WHERE
	loc.cep IS NOT NULL and
	loc.loc_in_tipo_localidade = 'M'
	GROUP BY loc.ufe_sg
	UNION
	SELECT loc.ufe_sg AS uf, COUNT(*) AS quantidade
	FROM log_localidade loc, log_grande_usuario gru
	WHERE loc.loc_nu_sequencial = gru.loc_nu_sequencial
	GROUP BY loc.ufe_sg
	ORDER BY quantidade DESC;

	SELECT *
	FROM vw_qtde_ceps_por_uf
	
	-- mas nesse BD só fazer assim ja funciona
	Select COUNT(ufe_sg) AS qtd_ceps, ufe_sg 
	FROM log_logradouro
	GROUP BY ufe_sg
	ORDER BY qtd_ceps desc


--d) Qual o número de CEPs encontrados em cada município (loc_in_tipo_localidade = 'M'), com respectiva UF, ordenados pelo maior número (de CEPs listados);
	select COUNT(ufe_sg)
	AS qtd_municipios, ufe_sg FROM log_localidade l1
	WHERE l1.loc_in_tipo_localidade = 'M'
	GROUP BY ufe_sg
	ORDER BY qtd_municipios desc
	
--e) Qual(is) o(s) nome(s) do(s) logradouro(s) considerado(s) mais popular(es) no Brasil;
	SELECT COUNT(log_nome)
	as qtd, log_nome FROM log_logradouro
	GROUP BY log_nome
	ORDER BY qtd DESC LIMIT 1
	-- sem empate ent vamo de limit 1
	
--f) Quais os nomes das organizações (grandes usuários) da unidade da federação "SC" que possuem CEP exclusivo. Listar também o nome do município;
	SELECT l1.gru_no, l1.gru_endereco, l1.cep, l2.loc_no
	FROM log_grande_usuario l1, log_localidade l2
	WHERE l1.loc_nu_sequencial = l2.loc_nu_sequencial
	AND l1.ufe_sg = 'SC'
	
--g) Quais os nomes dos municípios com a respectiva UF que apresentam apenas um CEP;
	SELECT loc_no, ufe_sg
	FROM log_localidade
	WHERE loc_in_tipo_localidade = 'M'
	and cep IS NOT NULL

--h) Qual a localidade (nome) que apresenta o maior número de CEPs especiais (grandes usuários). Listar também a UF e a localidade;
	SELECT COUNT(cep)
	AS qtd, l1.cep, l1.gru_no, l1.ufe_sg
	FROM log_grande_usuario l1
	GROUP BY l1.cep
	--correção
	SELECT COUNT(*) AS ceps, l2.loc_no, l2.ufe_sg
	FROM log_grande_usuario l1, log_localidade l2
	WHERE l1.loc_nu_sequencial = l2.loc_nu_sequencial
	GROUP BY l1.loc_nu_sequencial
	HAVING COUNT(*) >= ALL (SELECT COUNT(*) AS ceps
	FROM log_grande_usuario l1, log_localidade l2
	WHERE l1.loc_nu_sequencial = l2.loc_nu_sequencial
	GROUP BY l1.loc_nu_sequencial)
	
--i) Quais municípios possuem distrito (loc_in_tipo_localidade = 'D'). Listar também, o número de distritos de cada município listado, ordenando pelo maior número encontrado;
	SELECT COUNT(l2.loc_in_tipo_localidade) AS distirtos, l1.loc_nosub
	FROM log_localidade l1, log_localidade l2
	WHERE l1.loc_nu_sequencial = l2.loc_nu_sequencial_sub
	and l2.loc_in_tipo_localidade = "D"
	AND l1.loc_in_tipo_localidade = "M"
	GROUP BY l1.loc_nosub
	ORDER BY 1 desc

--j) Listar o nome do, ou dos bairros mais populares (que mais são encontrados) no estado de "SC", caso tenhamos empate no número máximo associado;
	SELECT COUNT(bai_no)
	as qtd, bai_no FROM log_bairro l1
	WHERE l1.ufe_sg = "SC"
	GROUP BY bai_no
	ORDER BY qtd DESC LIMIT 1
	-- limit 1 pq não dava empate
	--correção
	SELECT bai_no, COUNT(*) AS popularidade
	FROM log_bairro where ufe_sg='SC'
	GROUP BY bai_no
	HAVING COUNT(*) >= ALL (SELECT COUNT(*)
							FROM log_bairro
							where ufe_sg='SC'
							GROUP BY bai_no)
-- tava certo antes mas começar a fazer sem limit é melhor

--k*) Qual o número de CEPs de cada bairro do município de "Blumenau" localizado na unidade da federação  "SC". Listar o nome do bairro, também. Ordenar pelo maior número de CEPs;
	--pqq o count tem q ser por l3 e não por l1? pq l3 (logradouro) é qua faz a vinculação com o bairro, não l1 (localidade)
	SELECT COUNT(l3.cep), l2.bai_no
	FROM log_localidade l1, log_bairro l2, log_logradouro l3
	WHERE l1.loc_nu_sequencial = l3.loc_nu_sequencial
	AND l3.bai_nu_sequencial_ini = l2.bai_nu_sequencial
	and l1.ufe_sg = "SC"
	AND l1.loc_no = "Blumenau"
	GROUP BY l2.bai_no
	ORDER BY count(l3.cep) DESC

--m) Qual o nome de logradouro mais popular encontrado nos municípios da UF "SC". Listar também o número de vezes encontrado, ordenando pelo maior número;
	SELECT COUNT(log_nome)
	as qtd, log_nome FROM log_logradouro l1
	WHERE l1.ufe_sg = "SC"
	GROUP BY log_nome
	ORDER BY qtd DESC
	-- coreeção necessaria
	SELECT l1.log_no, COUNT(*) AS logradouros
	FROM log_logradouro AS l1
	JOIN log_localidade AS l2 ON l1.loc_nu_sequencial = l2.loc_nu_sequencial
	WHERE l1.ufe_sg = 'SC'
	AND l2.loc_in_tipo_localidade = 'M'
	GROUP BY l1.log_no
	HAVING COUNT(*) >= ALL (SELECT COUNT(*)
								FROM log_logradouro AS l1
								JOIN log_localidade AS l2 ON l1.loc_nu_sequencial = l2.loc_nu_sequencial
								WHERE l1.ufe_sg = 'SC'
								AND l2.loc_in_tipo_localidade = 'M'
								GROUP BY l1.log_no)
	
--n) Quais nomes de municípios são encontrados e mais de uma unidade da federação. Listar também a quantidade de vezes em que o mesmo é encontrado;
-- pqq to usando sequencial_sub ao inves do sequencial normal? > pq tava fazendo errado
	SELECT COUNT(l1.loc_nosub), l2.loc_nosub FROM log_localidade l1, log_localidade l2
	WHERE l1.loc_nu_sequencial_sub = l2.loc_nu_sequencial_sub
	AND l1.loc_nosub = l2.loc_nosub
	AND l1.ufe_sg != l2.ufe_sg
	AND l1.loc_in_tipo_localidade = "M"
	GROUP BY l2.loc_nosub
	-- correção necessária
	SELECT *
	FROM (SELECT l1.loc_nosub, COUNT(*) as qntd
	FROM log_localidade AS l1
	WHERE l1.loc_in_tipo_localidade = 'M'
	GROUP BY l1.loc_nosub
	ORDER BY qntd DESC) AS sub
	WHERE sub.qntd > 1
-- ou
	SELECT loc_no AS municipio, COUNT(loc_no) as qtd_uf
	FROM log_localidade
	WHERE loc_in_tipo_localidade='M'
	GROUP BY municipio
	having qtd_uf > 1
	ORDER BY qtd_uf desc;

--o) Listar o nome da praça com a respectiva informação do município (nome e UF), ordenando pela UF, seguida pelo município;
	SELECT p.loc_nosub AS praça, loc.loc_nosub, loc.ufe_sg
	from log_localidade p, log_localidade loc
	WHERE p.loc_in_tipo_localidade = "P"
	AND loc.loc_in_tipo_localidade = "M"
	AND loc.loc_nu_sequencial = p.loc_nu_sequencial_sub -- tinha faltado essa linha pra bater as duas
	ORDER BY loc.ufe_sg asc


--p) Listar o nome distrito com a respectiva informação do município da UF "SC";
	SELECT dis.loc_nosub AS distrito, loc.loc_nosub
	from log_localidade dis, log_localidade loc
	WHERE dis.loc_in_tipo_localidade = "D"
	AND loc.loc_in_tipo_localidade = "M"
	AND dis.ufe_sg = 'SC'
	AND loc.loc_nu_sequencial = dis.loc_nu_sequencial_sub -- de novo tinha faltado essa


--q) Listar o nome de todos os bairros do município de "Blumenau", UF "SC";
	SELECT distinct bai.bai_no AS bairro, loc.loc_no
	from log_bairro AS bai, log_logradouro AS lgd, log_localidade loc
	WHERE lgd.bai_nu_sequencial_ini = bai.bai_nu_sequencial 	--essas linhas funcionam 
	AND lgd.loc_nu_sequencial = loc.loc_nu_sequencial			--como um join (se tirar o comentario funfa)
	AND bai.ufe_sg = 'SC'
	AND loc.loc_no = 'Blumenau'
	
--r) Qual(s) município(s) não possui(em) praça no cadastro de localidades;
	SELECT loc_no FROM log_localidade
	WHERE loc_nu_sequencial NOT IN (SELECT loc_nu_sequencial
	FROM log_localidade
	WHERE loc_in_tipo_localidade = 'P')
	AND loc_in_tipo_localidade = 'M'

--s) Quais os tipos de logradouros com a respectiva quantidade de logradouros associados (a cada tipo listado, ex.: Rua, quantas Ruas existem?);
	SELECT count(log_tipo_logradouro)
	as qtd, log_tipo_logradouro FROM log_logradouro
	GROUP BY log_tipo_logradouro
	ORDER BY qtd desc
	
--t) Quantos municípios há em cada UF que apresentam mais de um CEP associado ao seu cadastro. Ordenar pela UF de maior número.
	SELECT l1.ufe_sg, count(distinct l1.loc_nu_sequencial)
	FROM log_logradouro l1
	GROUP BY l1.ufe_sg
	ORDER BY 2 DESC