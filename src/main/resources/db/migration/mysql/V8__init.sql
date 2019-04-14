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
	dataCriacao date,	
	dataAtualizacao date
)engine = innodb;

create table if not exists residencia(
	idResidencia integer auto_increment primary key ,
	idPessoa integer,
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
	nivel varchar(255),
	assuntosInteresse varchar(500),
	dataCriacao date,
	dataAtualizacao date
)engine = innodb;

create table if not exists ondeConheci(
	idOndeConheci integer auto_increment primary key,
	idPessoa integer,
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

alter table residencia add constraint fk_residencia foreign key (idPessoa) references pessoa (idPessoa);
alter table assuntosDeInteresse add constraint fk_assuntosDeInteresse foreign key (idPessoa) references pessoa (idPessoa); 
alter table ondeConheci add constraint fk_ondeConheci foreign key (idPessoa) references pessoa (idPessoa);

