
-- 1- insert evidência 

insert into policia_db.evidencia (descc) values ('pistol kolibri'); 
insert into policia_db.evidencia (descc) values ('pistol russa');
insert into policia_db.evidencia (descc) values ('pistol skorpion');
insert into policia_db.evidencia (descc) values ('pistol sig');
insert into policia_db.evidencia (descc) values ('glock');

insert into policia_db.evidencia (descc) values ('cel Motorola');
insert into policia_db.evidencia (descc) values ('samsumg');
insert into policia_db.evidencia (descc) values ('cel Quantum - Fulanilda');
insert into policia_db.evidencia (descc) values ('cel Quantum - Gestavo');

insert into policia_db.evidencia (descc) values ('sub 1');
insert into policia_db.evidencia (descc) values ('sub 2');

insert into policia_db.evidencia (descc) values ('nota fiscal'); 
insert into policia_db.evidencia (descc) values ('Olha a tesoura');
insert into policia_db.evidencia (descc) values ('espada Samurai');

insert into policia_db.evidencia (descc) values ('toyota imposto não pago');
insert into policia_db.evidencia (descc) values ('honda motorista sem carta');
insert into policia_db.evidencia (descc) values ('ford roubado');
insert into policia_db.evidencia (descc) values ('hyundai apreendida');
insert into policia_db.evidencia (descc) values ('fiat pra fuga');

-- 2- insert evidencia - arma (5)

insert into policia_db.arma values
(1, 1239193, 2.7, 	'kolibri', 						'2mm kolibri'),
(2, 1264590, 9.0 , 	'Izhevsk Mechanical Plant', 	'Makarov pistol'),
(3, 9138838, 0.32 , 'Ceska Zbrojovka Uhersky Brod', 'Skorpion vz. 61'),
(4, 1239193, 0.40, 	'Swiss Arms AG', 				'SIG P229'),
(5, 9292993, 19, 	'Glock Ges.m.b.H.', 			'Glock 17');

-- 3- insert evidência - celular (4)

insert into policia_db.celular values 
(6, 19291391239, 5567999998888, 'Motorola', 	'Moto Z 3 Play XT1929', 	'19231931932', 'Adeclir Norovis'),
(7, 12320100203, 5567999998765, 'Samsumg', 		'Galaxy J6 SM-J600', 		'10001931932', 'Fulanildo Merinclevis'),
(8, 12320100203, 5511987648765, 'Quantum', 		'YOU E', 					'10001973007', 'Fulanilda daclivis'),
(9, 12320100203, 5563999992222, 'Quantum', 		'YOU E', 					'10023977007', 'Gestavo daclondis');

-- 4- insert evidencia - substancia -> dimensão (3)

insert into policia_db.dimensao 
(largura, 	comprimento, 	altura) values 
(1.23, 		1.25, 			0.5),
(0.23, 		0.25, 			0.5),
(0.03, 		0.05, 			0.05);

-- 5- insert evidencia - substancia (2)

insert into policia_db.substancia values 
(10, 1, 'svl dadlq eslsl', 	200, 	'alsdal dlalala', 	3, 	1),
(11, 2, 'pqwiazc aosid', 	1000, 	'alasdlalalalalal', 10, 2);

-- 6- insert evidencia - objeto (3)

insert into policia_db.objeto values 
(12, 1, 'notas fiscais', 	'Foi realizado fraudação de notas fiscais pra não tributação de impostos'),
(13, 2, 'tesoura', 			'Ameaçou a vitima com este objeto pontiagudo'),
(14, 3, 'espada samurai', 	'Preso este objeto - simbolo da mafia japonesa');

-- 7- insert evidencia - veiculo (5)

insert into policia_db.veiculo values
(15, '193592040234-420340204', 'SSS-3103', 1994, 1993, 'Toyota', 	'Corolla', 	'preto'		),
(16, '191023103020-111140204', 'HHH-4103', 2007, 2007, 'Honda', 	'Civic', 	'branco'	),
(17, '110101010101-222240204', 'LLL-5103', 2004, 2003, 'Ford', 		'EcoSport', 'amarelo'	),
(18, '995393954949-333340204', 'PPP-6103', 2006, 2005, 'Hyundai', 	'Tucson', 	'prata'		),
(19, '301023012300-444440204', 'TTT-7103', 2007, 2007, 'FIAT', 		'Punto', 	'laranja'	);

-- 8- insert cidade_estado (10)

insert into policia_db.cidade_estado (cidade, estado) values 
('Campo Grande', 		'MS'),
('Terenos', 			'MS'),
('São Paulo', 			'SP'),
('Jequié', 				'BA'),
('Curitiba', 			'PR'),
('Rio Branco', 			'AC'),
('Camapuã', 			'MS'),
('Ribas do Rio Pardo', 	'MS'),
('Caracol', 			'PR'),
('Anaurilandia', 		'MS');

-- 9- insert naturalidade (10)

insert into policia_db.naturalidade (cid_estado) values
(1), (2), (1), (3), (3), (5), (10), (1), (2), (1);

-- 10- insert nacionalidade (10)

insert into policia_db.nacionalidade (nacionalidade) values 
('brasileira'), ('norte americana'), ('italiana'), ('alemã'), ('hungaro'),
('russa'), ('portuguesa'), ('argentina'), ('chilena'), ('moçambiquense');

-- 11- insert delegacia (3)

insert into policia_db.delegacia (sigla, nome) values
('DERF', 'Delegacia Especializada de Roubos e Furtos'),
('DEFURV', 'Policia Civil'),
('DECO', 'Del Espec de Combate ao Crime Organizado');

-- 12- insert endereco (20)

insert into policia_db.endereco (logradouro, numero, bairro, complemento, cep, referencia, cid_est) values 
('jão marques', 				400, 	'Parati', 			null, 43254570, 'Rua da divisão', 1),
('luzia jão', 					4000, 	'Colibri', 			null, 11254570, null, 1),
('amazonas', 					4330, 	'Moreninhas I', 	null, 334254570, 'saida SP', 1),
('acre terra dos dinossauro',	40, 	'Moreninhas II', 	null, 55254570, 'saida SP', 1),
('acre não é bullying', 		4, 		'COHAB', 			null, 66254570, null, 1),
('Presidente bolsonabo', 		4231, 	'Vila Carlota', 	'é o cara que imita!', 77254570, null, 1),
('cachaça raiz', 				233, 	'Jardim Paulista', 	'Jardim Paulista', 88254570, null, 1),
('dom quixote', 				2577, 	'Monte Libano', 	'Monte Libano', 99254570, null, 1),
('coloca nome nessa rua', 		125, 	'Nova Era', 		null, 400254570, 'portão azul', 1),
('heavy metal é op', 			123, 	'Centro', 			null, 41154570, null, 1),
('no céu tem pão?', 			3945, 	'Iracy Coelho', 	null, 42254570, null, 1),
('senador <insira o nome>', 	943, 	'Pioneiros', 		null, 43354570, null, 1),
('andrade ou hadaad', 			5, 		'Vila Sobrinho', 	null, 44454570, null, 1),
('pameiras não tem mundial', 	579, 	'Vila Nhá Nhá', 'Escreve assim?', 45554570, null, 1),
('corintienses é mas inteligente q os oto', 203, 'São Conrado', null, 46654570, null, 1),
('tesla conhece?', 				2934, 	'Jardim Autonomista', null, 47754570, null, 1),
('Rua dos doidos', 				23, 	'Nova Lima', 		null, 48854570, null, 1),
('Praça dos Enfartados', 		444, 	'Jardim Anache', 	'existe mesmo essa rua', 49954570, null, 1),
('Rua do Corno', 				55, 	'Caicara',  		'existe mesmo essa rua', 44004570, null, 1),
('pelégolas', 					1111, 	'Guanandi', 		null, 44114570, null, 1);

-- 13- insert pessoa (16)

insert into policia_db.Pessoa values
(12345678901 , 'Teclasio ildo', 19948884949, '1994-06-05', 'ajundaiuna braria', 'jão perifastoc'),
(09876543210 , 'belasio rodribel', 312319239123, '1990-04-03', 'be rodribel', 'lasio rodribel'),
(19394923492 , 'castebrino brosguesg', 23123123 , '1883-02-09', 'caste brosguesg', 'brino brosguesg'),
(29342934929 , 'trunbefita gallianni', 523424241 , '1886-03-04', 'trunb gallianni', 'efita gallianni'),
(10231023020 , 'loucrevi varridra', 453453453 , '1886-03-04', 'lou varridra', 'crevi varridra'),
(59595995959 , 'missbrivia brosbev', 453534345 , '1886-03-04', 'mis brosbev', 'sbrivia brosbev'),
(20202020203 , 'gaspuwa couawa', 777778432 , '1886-03-04', 'gas couawa', 'puwa couawa'),
(40040404040 , 'uqitovasqui mesri', 17345385 , '1886-03-04', 'uqito mesri', 'vasqui mesri'),
(49324102302 , 'equarro orra', 34234238999 , '1886-03-04', 'equ orra', 'arro orra'),
(03403403040 , 'beibrani machirto',  23212356388, '1886-03-04', 'beib machirto', 'rani machirto'),
(23023023020 , 'eklauvs sorota', 8888888 , '1886-03-04', 'ek sorota', 'lauvs sorota'),
(20202020023 , 'jubistotia palico', 555658798 , '1886-03-04', 'jubis palico', 'totia palico'),
(19191919191 , 'retreb trumaldo', 23236890667 , '1886-03-04', 'retre trumaldo', 'b trumaldo'),
(49320358323 , 'cassiolo matruso', 3489789456 , '1886-03-04', 'cassio matruso', 'lo matruso'),
(03220020202 , 'kerinaldo bombrevs', 3493949 , '1886-03-04', 'keri bombrevs', 'naldo bombrevs'),
(30200000003 , 'gespetronio vestravi', 394020220 , '1886-03-04', 'ges vestravi', 'petronio vestravi');

-- 14- insert policial (5)

insert into policia_db.policial values
(29342934929 , 52342424100 , '5567999995555'),
(10231023020 , 45345345300 , '5567999995555'),
(59595995959 , 45353434500 , '5567999995555'),
(20202020203 , 77777843200 , '5567999995555'),
(40040404040 , 17345385000 , '5567999995555');

-- 15- insert cidadão (10)

insert into policia_db.cidadao values
(49324102302 , 'equarro', '5567999995555' , 'desaparecido', 4, 1),
(03403403040 , 'beibrani',  '5567999995555', 'ativo', 1, 2),
(23023023020 , 'eklauvs', '5567999995555' , 'ativo', 3, 3),
(20202020023 , 'jubistotia', '5567999995555' , 'ativo', 5, 4),
(19191919191 , 'retreb', '5567999995555' , 'ativo', 1, 5),
(49320358323 , 'cassiolo', '5567999995555' , 'ativo', 2, 6),
(03220020202 , 'kerinaldo', '5567999995555', 'ativo', 7, 7),
(30200000003 , 'gespetronio', '5567999995555' , 'ativo', 1, 8),
(12345678901 , 'Teclasio', '5567999995555', 'ativo', 1, 9),
(09876543210 , 'belasio', '5567999995555', 'ativo', 1, 10),
(19394923492 , 'castebrino', '5567999995555' , 'falecido', 3, 11);

-- 16- insert delegado

insert into policia_db.delegado values
(45345345300);

-- 21 insert nacionalidade_pessoa
insert into policia_db.nac_pessoa (cpf, id_nacionalidade) values
(10231023020, 1),
(10231023020, 5),
(10231023020, 2),
(03403403040, 1);

-- 17- insert evidencia_ocorrencia (não pode) -> aplicação deve ser capaz

-- 18- insert pessoa_envolvida (não pode) -> aplicação deve ser capaz

-- 19- insert ocorrencia (não pode) -> aplicação deve ser capaz

-- 20- insert equipe (não pode) -> aplicação deve ser capaz
