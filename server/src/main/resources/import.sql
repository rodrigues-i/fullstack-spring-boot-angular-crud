INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('1234567890123', 'Produto A', 10, 100.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('2345678901234', 'Produto B', 20, 50.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('3456789012345', 'Produto C', 15, 75.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('4567890123456', 'Produto D', 5, 200.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('5678901234567', 'Produto E', 30, 150.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('6789012345678', 'Produto F', 12, 180.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('7890123456789', 'Produto G', 8, 90.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('8901234567890', 'Produto H', 25, 125.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('9012345678901', 'Produto I', 18, 300.00);
INSERT INTO tb_produtos (codigo_de_barras, nome, quantidade_minima, saldo_inicial) VALUES ('0123456789012', 'Produto J', 7, 80.00);


INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('ENTRADA', 10, NOW(), 'New stock', 'DOC-123456', 1);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('SAIDA', 5, NOW(), 'Sales', 'DOC-789012', 1);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('ENTRADA', 20, NOW(), 'New stock', 'DOC-345678', 2);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('SAIDA', 10, NOW(), 'Sales', 'DOC-901234', 2);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('ENTRADA', 15, NOW(), 'New stock', 'DOC-567890', 3);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('SAIDA', 5, NOW(), 'Sales', 'DOC-123456', 3);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('ENTRADA', 30, NOW(), 'New stock', 'DOC-789012', 4);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('SAIDA', 20, NOW(), 'Sales', 'DOC-345678', 4);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('ENTRADA', 25, NOW(), 'New stock', 'DOC-901234', 5);
INSERT INTO tb_movimentacoes (tipo, quantidade, data, motivo, documento, produto_id) VALUES ('SAIDA', 10, NOW(), 'Sales', 'DOC-567890', 5);
