create table if not exists pessoa(
	idPessoa long auto_increment,	
	nome varchar2(255),	
	dataNascimento date,	
	horaNascimento date,	
	altura double,	
	peso double,	
	estadoNascimento varchar2(255),	
	cidadeNascimento varchar2(255),	
	orientacaoSexual varchar2(255),
	paisDeOrigem varchar2(255),	
	nacionalidade varchar2(255),	
	adotivo varchar(2)2,	
	signo varchar2(255),	
	descendencia varchar2(255),	
	dataCriacao date,	
	dataAtualizacao date,
	primary key (idPessoa)
);

create table if not exists residencia(
	idResidencia long auto_increment,
	idPessoa long foreign key references pessoa(idPessoa),
	String endereco varchar2(255),
	numero number,
	complemento varchar2(255),
	cep varchar2(255),
	bairro varchar2(255),
	pais varchar2(255),	
	qtoTempoMora varchar2(255),
	moraCom varchar2(255),
	relacionamentoComVizinhos varchar2(255),
	dataCriacao date,
	dataAtualizacao date,
	primary key (idResidencia)
);

create table if not exists assuntosDeInteresse(
	idAssuntosDeInteresse long auto_increment,
	idPessoa long foreign key references pessoa(idPessoa),
	nivel varchar2(255),
	assuntosInteresse varchar2(500),
	dataCriacao date,
	dataAtualizacao date,
	primary key (idAssuntosDeInteresse)
);

create table if not exists ondeConheci(
	idOndeConheci long auto_increment,
	idPessoa long foreign key references pessoa(idPessoa),
	app varchar2(255),
	nomeLocal varchar2(255),
	tipo varchar2(255),
	descricao varchar2(255),
	cidade varchar2(255),
	Estado varchar2(255),
	data date,
	hora date,	
	dataCriacao date,
	dataAtualizacao date,
	primary key (idOndeConheci)
);

