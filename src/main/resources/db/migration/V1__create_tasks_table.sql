create table tasks(
    id bigserial primary key,
    title varchar (120) not null,
    description varchar(500),
    status varchar(20) not null,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);