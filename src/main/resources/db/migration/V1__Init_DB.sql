    create table product (
       id bigint not null auto_increment,
        cost decimal(19,2),
        title varchar(255),
        primary key (id)
    );

    create table roles (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    );

    create table users (
       id bigint not null auto_increment,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table users_roles (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    );

    alter table roles
       add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);

    alter table users
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table users_roles
       add constraint FKj6m8fwv7oqv74fcehir1a9ffy
       foreign key (role_id)
       references roles (id);

    alter table users_roles
       add constraint FK2o0jvgh89lemvvo17cbqvdxaa
       foreign key (user_id)
       references users (id);