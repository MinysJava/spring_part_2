insert into users (id, password, username)
  values (1, '$2a$10$CGamJWPYokRss2FX6WcBJOgFIDKyUoCYnrGtepfVQyDSTdngSxrzK', 'admin');

insert into users (id, password, username)
  values (2, '$2a$10$CGamJWPYokRss2FX6WcBJOgFIDKyUoCYnrGtepfVQyDSTdngSxrzK', 'user');

insert into roles (id, name)
  values (1, 'ROLE_ADMIN');

insert into roles (id, name)
  values (2, 'ROLE_GUEST');
  
insert into users_roles (user_id, role_id)
  values (1,1);

insert into users_roles (user_id, role_id)
  values (2,2);
