create table if not exists balance
(
    id              uuid primary key,
    card_id         int  not null,
    value           int  not null,
    exp             date not null,
    date_create_upd date not null
)