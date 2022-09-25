create table servico
(
    id                   bigint auto_increment
        primary key,
    horas_banheiro       int            not null,
    horas_cozinha        int            not null,
    horas_outros         int            not null,
    horas_quarto         int            not null,
    horas_quintal        int            not null,
    horas_sala           int            not null,
    icone                varchar(14)    not null,
    nome                 varchar(50)    not null,
    posicao              int            not null,
    procentagem_comissao decimal(19, 2) not null,
    qtd_horas            int            not null,
    valor_banheiro       decimal(19, 2) not null,
    valor_cozinha        decimal(19, 2) not null,
    valor_minimo         decimal(19, 2) not null,
    valor_outros         decimal(19, 2) not null,
    valor_quarto         decimal(19, 2) not null,
    valor_quintal        decimal(19, 2) not null,
    valor_sala           decimal(19, 2) not null
);

