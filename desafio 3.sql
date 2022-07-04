-- Matheus Petters Bevilaqua


-- item e)
-- criando tabelas de log
CREATE TABLE log_insert_hospedagem (data DATE, hora TIME, usuario VARCHAR(30), operacao VARCHAR(100));
CREATE TABLE log_delete_hospedagem (data DATE, hora TIME, usuario VARCHAR(30), operacao VARCHAR(100));
CREATE TABLE log_update_hospedagem (data DATE, hora TIME, usuario VARCHAR(30), operacao VARCHAR(100));

CREATE TABLE log_insert_hos_servico (data DATE, hora TIME, usuario VARCHAR(30), operacao VARCHAR(100));
CREATE TABLE log_delete_hos_servico (data DATE, hora TIME, usuario VARCHAR(30), operacao VARCHAR(100));
CREATE TABLE log_update_hos_servico (data DATE, hora TIME, usuario VARCHAR(30), operacao VARCHAR(100));

-- triggers para fazer registros de log
delimiter $
CREATE OR REPLACE TRIGGER tgr_ins_hos
AFTER INSERT ON hospedagem
FOR EACH ROW
BEGIN
INSERT INTO log_insert_hospedagem (DATA, hora, usuario, operacao)
VALUES (CURDATE(),CURTIME(),USER(),CONCAT('Inserção de nova hospedagem > ',NEW.cd_hospedagem));
END;

delimiter $
CREATE OR REPLACE TRIGGER tgr_del_hos AFTER DELETE ON hospedagem
FOR EACH ROW
BEGIN
INSERT INTO log_delete_hospedagem (DATA, hora, usuario, operacao)
VALUES (CURDATE(),CURTIME(),USER(),CONCAT('Exclusão de uma hospedagem > ',OLD.cd_hospedagem));
END;

delimiter $
CREATE OR REPLACE TRIGGER tgr_updt_hos AFTER UPDATE ON hospedagem
FOR EACH ROW
BEGIN
INSERT INTO log_update_hospedagem (DATA, hora, usuario, operacao)
VALUES (CURDATE(),CURTIME(),USER(),CONCAT('Alteração em hospedagem > ',OLD.cd_hospedagem));
END;

delimiter $
CREATE OR REPLACE TRIGGER tgr_ins_hos_ser
AFTER INSERT ON hospedagem_servico
FOR EACH ROW
BEGIN
INSERT INTO log_insert_hos_servico (DATA, hora, usuario, operacao)
VALUES (CURDATE(),CURTIME(),USER(),CONCAT('Inserção de novo serviço na hospedagem > ',NEW.cd_hospedagem));
END;

delimiter $
CREATE OR REPLACE TRIGGER tgr_del_hos_ser AFTER DELETE ON hospedagem_servico
FOR EACH ROW
BEGIN
INSERT INTO log_delete_hos_servico (DATA, hora, usuario, operacao)
VALUES (CURDATE(),CURTIME(),USER(),CONCAT('Exlcusão de serviço na hospedagem > ',OLD.cd_hospedagem));
END;

delimiter $
CREATE OR REPLACE TRIGGER tgr_updt_hos_ser AFTER UPDATE ON hospedagem_servico
FOR EACH ROW
BEGIN
INSERT INTO log_update_hos_servico (DATA, hora, usuario, operacao)
VALUES (CURDATE(),CURTIME(),USER(),CONCAT('Update de serviço na hospedagem > ',OLD.cd_hospedagem));
END;

-- testando triggers
INSERT INTO hospedagem (cd_hospedagem, dt_entrada, dt_saida, fl_situacao, cd_cliente, cd_funcionario, nr_quarto)
	VALUES(1, '2022-03-31', '2022-04-01', 'O', 1, 1, 101);
	
UPDATE hospedagem
SET cd_hospedagem = 2
WHERE cd_hospedagem = 1;

UPDATE hospedagem
SET cd_hospedagem = 1
WHERE cd_hospedagem = 2;

DELETE from hospedagem WHERE cd_hospedagem =1;

INSERT INTO hospedagem_servico (cd_hospedagem, cd_servico, nr_sequencia, dt_solicitacao)
	VALUES(1, 1, 1, '2022-04-01');

UPDATE hospedagem_servico
SET nr_sequencia = 2
WHERE cd_hospedagem = 1;
-- testes aparecem o cd_hospedagem como identificador, mas tem q trocar outro atributo dado a pk

DELETE from hospedagem_servico WHERE cd_hospedagem =1;

-- item a)
-- pequeno povoamento para testes
INSERT INTO reserva (nr_reserva, dt_reserva, dt_entrada, qt_diarias, fl_situacao, cd_cliente, nr_quarto, cd_funcionario)
	VALUES(1, '2022-03-31', '2022-04-01', 3, 'R', 1, 102, 1);
INSERT INTO reserva (nr_reserva, dt_reserva, dt_entrada, qt_diarias, fl_situacao, cd_cliente, nr_quarto, cd_funcionario)
	VALUES(2, '2022-04-30', '2022-05-01', 4, 'R', 2, 103, 1);
INSERT INTO reserva (nr_reserva, dt_reserva, dt_entrada, qt_diarias, fl_situacao, cd_cliente, nr_quarto, cd_funcionario)
	VALUES(3, '2022-05-01', '2022-05-22', 6, 'R', 3, 104, 1);
	
DELIMITER $$
CREATE OR REPLACE PROCEDURE ChecaDisponibilidade (IN datacheck DATE)
BEGIN
SELECT q1.nr_quarto FROM quarto q1, reserva r1
WHERE r1.nr_quarto = q1.nr_quarto
AND NOT datacheck = r1.dt_entrada;
END $$

-- não consegui pensar em uma lógica que funcionasse pra essa
-- isso foi o que talvez tenha chego mais perto

CALL ChecaDisponibilidade('2022-04-01');

-- item b)
DELIMITER $$
CREATE PROCEDURE addHospedagem (IN dt_ent DATE, dt_sai DATE, cd_cli INT, nr_qua INT)
BEGIN 
INSERT INTO hospedagem (dt_entrada, dt_saida, fl_situacao, cd_cliente, cd_funcionario, nr_quarto)
	VALUES(dt_ent, dt_sai, 'O', cd_cli, 1, nr_qua);
END $$

-- teste
CALL addHospedagem ('2022-05-21', '2022-05-22', 4, 302);

-- item c)
DELIMITER $$
CREATE OR REPLACE PROCEDURE addServicoHospedagem (IN cd_hos int, cd_serv int)
BEGIN 
DECLARE numero INT DEFAULT 0;
SELECT MAX(nr_sequencia) INTO numero FROM hospedagem_servico
WHERE cd_hospedagem = cd_hos;
SET numero = numero +1;
INSERT INTO hospedagem_servico (cd_hospedagem, cd_servico, nr_sequencia, dt_solicitacao)
	VALUES(cd_hos, cd_serv, numero, CURDATE());
END $$

CALL addServicoHospedagem (3, 1);

-- item d)
DELIMITER $$
CREATE OR REPLACE PROCEDURE updateSituacao (IN cd_hos int)
BEGIN 
UPDATE hospedagem
SET fl_situacao = 'F'
WHERE cd_hospedagem = cd_hos;
END $$

-- teste
CALL updateSituacao (1);


