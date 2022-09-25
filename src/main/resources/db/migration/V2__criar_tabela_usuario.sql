create table usuario
(
    id            bigint auto_increment
        primary key,
    email         varchar(255) not null,
    nome_completo varchar(255) not null,
    senha         varchar(255) not null,
    tipo_usuario  varchar(8)   not null,
    constraint UK_5171l57faosmj8myawaucatdw
        unique (email)
);
