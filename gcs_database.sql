create table if not exists gift_certificates (
    id serial primary key,
    name varchar(120) not null,
    description varchar(255),
    price float not null,
    duration int not null,
    create_date TIMESTAMP not null,
    last_update_date TIMESTAMP not null
);

create table if not exists tags (
    id serial primary key,
    name varchar(120) not null
);

create table giftCertificate_tag (
    gift_certificate_id int not null,
    tag_id int not null,
    primary key (gift_certificate_id, tag_id),
    foreign key (gift_certificate_id) references gift_certificates (id),
    foreign key (tag_id) references tags (id)
)