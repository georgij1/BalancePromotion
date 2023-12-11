create table if not exists balance (
    id serial primary key not null,
    id_client int not null,
    balance int not null
)