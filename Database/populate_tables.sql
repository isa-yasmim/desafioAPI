-- TB_PESSOA
INSERT INTO TB_PESSOA (idPessoa, nome, cpf, dataNascimento) VALUES (seq_pessoa.nextval, 'Alessandra', '00100234501', TO_DATE('03/04/1990', 'DD/MM/YYYY'));
INSERT INTO TB_PESSOA (idPessoa, nome, cpf, dataNascimento) VALUES (seq_pessoa.nextval, 'Alexandre', '10100234591', TO_DATE('05/04/1992', 'DD/MM/YYYY'));
INSERT INTO TB_PESSOA (idPessoa, nome, cpf, dataNascimento) VALUES (seq_pessoa.nextval, 'Bruno', '20100234592', TO_DATE('15/07/1985', 'DD/MM/YYYY'));
INSERT INTO TB_PESSOA (idPessoa, nome, cpf, dataNascimento) VALUES (seq_pessoa.nextval, 'Camila', '30100234593', TO_DATE('22/11/1995', 'DD/MM/YYYY'));
INSERT INTO TB_PESSOA (idPessoa, nome, cpf, dataNascimento) VALUES (seq_pessoa.nextval, 'Daniel', '40100234594', TO_DATE('30/01/1988', 'DD/MM/YYYY'));

COMMIT;

-- TB_CONTA
INSERT INTO TB_CONTA (idConta, idPessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta, dataCriacao) 
VALUES (seq_conta.nextval, 1, 15000.00, 5000.00, 1, 1, TO_DATE('01/01/2020', 'DD/MM/YYYY'));

INSERT INTO TB_CONTA (idConta, idPessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta, dataCriacao) 
VALUES (seq_conta.nextval, 2, 5000.00, 3000.00, 1, 1, TO_DATE('15/03/2021', 'DD/MM/YYYY'));

INSERT INTO TB_CONTA (idConta, idPessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta, dataCriacao) 
VALUES (seq_conta.nextval, 3, 25000.50, 7000.00, 1, 2, TO_DATE('10/05/2019', 'DD/MM/YYYY'));

INSERT INTO TB_CONTA (idConta, idPessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta, dataCriacao) 
VALUES (seq_conta.nextval, 4, 800.00, 1000.00, 1, 1, TO_DATE('22/07/2022', 'DD/MM/YYYY'));

INSERT INTO TB_CONTA (idConta, idPessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta, dataCriacao) 
VALUES (seq_conta.nextval, 5, 12000.75, 5000.00, 1, 2, TO_DATE('05/09/2020', 'DD/MM/YYYY'));

COMMIT;

-- TB_TRANSACAO
INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 1, 1000.00, TO_DATE('10/01/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 1, -500.00, TO_DATE('15/01/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 2, 200.00, TO_DATE('20/03/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 2, -100.00, TO_DATE('25/03/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 3, 5000.00, TO_DATE('05/04/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 3, -2000.00, TO_DATE('10/04/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 4, 300.00, TO_DATE('15/05/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 4, -150.00, TO_DATE('20/05/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 5, 2500.00, TO_DATE('25/06/2023', 'DD/MM/YYYY'));

INSERT INTO TB_TRANSACAO (idTransacao, idConta, valor, dataTransacao) 
VALUES (seq_transacao.nextval, 5, -1000.00, TO_DATE('30/06/2023', 'DD/MM/YYYY'));

COMMIT;