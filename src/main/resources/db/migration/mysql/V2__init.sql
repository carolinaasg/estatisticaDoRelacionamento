create table if not exists pessoa(
	idPessoa integer auto_increment primary key,	
	nome varchar(255),	
	dataNascimento date,	
	horaNascimento time,	
	altura double,	
	peso double,	
	estadoNascimento varchar(255),	
	cidadeNascimento varchar(255),	
	orientacaoSexual varchar(255),
	paisDeOrigem varchar(255),	
	nacionalidade varchar(255),	
	adotivo varchar(2),	
	signo varchar(255),	
	descendencia varchar(255),	
	tamanhoPe integer,
	dataCriacao date,	
	dataAtualizacao date
)engine = innodb;

create table if not exists residencia(
	idResidencia integer auto_increment primary key ,
	idPessoa integer,
	idAmigo integer,
	endereco varchar(255),
	numero integer,
	complemento varchar(255),
	cep varchar(255),
	bairro varchar(255),
	pais varchar(255),	
	qtoTempoMora varchar(255),
	moraCom varchar(255),
	relacionamentoComVizinhos varchar(255),
	dataCriacao date,
	dataAtualizacao date	
)engine = innodb;

create table if not exists assuntosDeInteresse(
	idAssuntosDeInteresse integer auto_increment primary key,
	idPessoa integer,
	idFamilia integer,
	idAmigo integer,
	nivel varchar(255),
	assuntosInteresse varchar(500),
	dataCriacao date,
	dataAtualizacao date
)engine = innodb;

create table if not exists ondeConheci(
	idOndeConheci integer auto_increment primary key,
	idPessoa integer,
	idAmigo integer,
	app varchar(255),
	nomeLocal varchar(255),
	tipo varchar(255),
	descricao varchar(255),
	cidade varchar(255),
	Estado varchar(255),
	data date,
	hora time,	
	dataCriacao date,
	dataAtualizacao date
)engine = innodb;

create table if not exists profissao(
	idProfissao integer auto_increment primary key,	
	idPessoa integer,
	idAmigo integer,
	idFamilia integer,
	nomeEmpresa varchar(255),
	profissao varchar(255),
	cargo varchar(255),
	Descricao varchar(1000),
	tempoDeEmpresa integer,
	gostaDoQueFaz varchar(2),
	gostaDaEquipe varchar(2),
	gostaDoChefe varchar(2),
	salarioBruto double,
	salarioLiquido double,
	qtdSubordinados integer,
	dataDemissao date,
	dataContratacao date,	
	dataCriacao date,
	dataAtualizacao date
)engine = innodb;

create table if not exists dia(
	idDia integer auto_increment primary key,
	idPessoa integer,
	qtdHorasTrabalhadas double,
	qtdHorasDeSono double,
	horaAlmoco date,	
	horaJanta date,	
	descricao varchar(255),
	pontosPositivos varchar(255),
	pontosNegativos varchar(255),
	dataCriacao date, 
	dataAtualizacao date
)engine = innodb;

create table if not exists familia(
	idFamilia integer auto_increment primary key,
	idPessoa integer,		
	nome varchar(255),	
	dataNascimento date,	
	horaNascimento time,	
	altura double,	
	peso double,	
	estadoNascimento varchar(255),	
	cidadeNascimento varchar(255),	
	orientacaoSexual varchar(255),
	paisDeOrigem varchar(255),	
	nacionalidade varchar(255),	
	adotivo varchar(2),	
	signo varchar(255),	
	descendencia varchar(255),	
	tamanhoPe integer,
	grauDeParentesco varchar(255),	
	dataCriacao date,	
	dataAtualizacao date
)engine = innodb;

create table if not exists relacaoComFamilia(	
	idRelacaoFamilia integer auto_increment primary key,
	idFamilia integer,
	nome varchar(255),
	grauDeParentesco varchar(50),
	descricao varchar(4000),
	statusRelacao varchar(50),
	dataEvento date,
	pontosPositivos  varchar(2000),
	pontosNegativos  varchar(2000),	
	dataCriacao date,	
	dataAtualizacao date
)engine = innodb;

create table if not exists pontosPositivosFamilia(
	idPontosPositivosFamilia integer auto_increment primary key,
	idFamilia integer,
	pontosPositivos varchar(255),
	data date,
	motivo varchar(4000),	
	dataCriacao date,
	dataAtualizacao date
)engine = innodb;

create table if not exists pontosNegativosFamilia(
	idPontosNegativosFamilia integer auto_increment primary key,
	idFamilia integer,
	pontosNegativosFamilia varchar(255),
	data date,
	motivo varchar(4000),
	dataCriacao date,	
	dataAtualizacao date
)engine = innodb;

create table if not exists contatoComFamilia(
	idContatoComFamilia integer auto_increment primary key,
	idFamilia integer,
	dataEncontro date,
	virtualmente varchar(2),
	pessoalmente varchar(2),
	descricao varchar(4000),
	pais varchar(255),
	estado varchar(255),
	cidade varchar(255),
	local varchar(255),
	motivo varchar(4000),
	qtdHorasJuntos double,
	dataCriacao date,
	dataAtualizacao date
)engine = innodb;

create table if not exists falecimento(
	idFalecimento integer auto_increment primary key,
	idPessoa integer,
	idFamilia integer,
	idAmigo integer,
	motivo varchar(4000),
	data date,
	hora time,
	descricao varchar(4000),
	dataCriacao date,
	dataAtualizacao date
)engine = innodb;

create table if not exists veiculo(
	idVeiculo  integer auto_increment primary key,
	idPessoa integer,
	idFamilia integer,
	idAmigo integer,
	dataCompra date,
	dataVenda date,
	tipo varchar(255),
	marca varchar(255),
	modelo varchar(255),
	anoFabricacao integer,
	anoModelo integer,
	quilometragem integer,	
	dataCriacao date,
	dataAtualizacao date
)engine = innodb;

create table if not exists amigos(
	idAmigo integer auto_increment primary key,
	idPessoa integer,
	nome varchar(255),	
	dataNascimento date,	
	horaNascimento time,	
	altura double,	
	peso double,	
	estadoNascimento varchar(255),	
	cidadeNascimento varchar(255),	
	orientacaoSexual varchar(255),
	paisDeOrigem varchar(255),	
	nacionalidade varchar(255),	
	adotivo varchar(2),	
	signo varchar(255),	
	descendencia varchar(255),	
	tamanhoPe integer,
	dataCriacao date,	
	dataAtualizacao date
)engine = innodb;




alter table residencia add constraint fk_residencia foreign key (idPessoa) references pessoa (idPessoa);
alter table residencia add constraint fk_residenciaAmigo foreign key (idAmigo) references amigos (idAmigo);
alter table assuntosDeInteresse add constraint fk_assuntosDeInteresse foreign key (idPessoa) references pessoa (idPessoa); 
alter table assuntosDeInteresse add constraint fk_assuntosDeInteresseFamilia foreign key (idFamilia) references familia (idFamilia); 
alter table assuntosDeInteresse add constraint fk_assuntosDeInteresseAmigo foreign key (idAmigo) references amigos (idAmigo); 
alter table ondeConheci add constraint fk_ondeConheciPessoa foreign key (idPessoa) references pessoa (idPessoa);
alter table ondeConheci add constraint fk_ondeConheciAmigo foreign key (idAmigo) references amigos (idAmigo);
alter table profissao add constraint fk_profissao foreign key (idPessoa) references pessoa (idPessoa);
alter table profissao add constraint fk_profissaoFamilia foreign key (idFamilia) references familia (idFamilia);
alter table profissao add constraint fk_profissaoAmigo foreign key (idAmigo) references amigos (idAmigo);
alter table dia add constraint fk_dia foreign key (idPessoa) references pessoa (idPessoa);
alter table familia add constraint fk_familia foreign key (idPessoa) references pessoa (idPessoa);
alter table RelacaoComFamilia add constraint fk_relacaoComFamilia foreign key (idFamilia) references familia (idFamilia);
alter table PontosPositivosFamilia add constraint fk_pontosPositivosFamilia foreign key (idFamilia) references familia (idFamilia);
alter table PontosNegativosFamilia add constraint fk_pontosNegativosFamilia foreign key (idFamilia) references familia (idFamilia);
alter table contatoComFamilia add constraint fk_contatoComFamilia foreign key (idFamilia) references familia (idFamilia);
alter table falecimento add constraint fk_falecimentoPessoa foreign key (idPessoa) references pessoa (idPessoa);
alter table falecimento add constraint fk_falecimentoFamilia foreign key (idFamilia) references familia (idFamilia);
alter table falecimento add constraint fk_falecimentoAmigo foreign key (idAmigo) references amigos (idAmigo);
alter table veiculo add constraint fk_veiculoPessoa foreign key (idPessoa) references pessoa (idPessoa);
alter table veiculo add constraint fk_veiculoFamilia foreign key (idFamilia) references familia (idFamilia);
alter table veiculo add constraint fk_veiculoAmigo foreign key (idAmigo) references amigos (idAmigo);
alter table amigos add constraint fk_amigo foreign key (idPessoa) references pessoa (idPessoa);








	 
	 
	 
	 
	  
	 
	 

