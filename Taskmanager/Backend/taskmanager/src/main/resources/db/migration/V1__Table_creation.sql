create table roles (role_id bigserial primary key ,
              role_name varchar not null ,created_on timestamp default CURRENT_TIMESTAMP,
              updated_on timestamp default CURRENT_TIMESTAMP);

create table status (status_id bigserial primary key ,status_name varchar not null );

create table users (user_id bigserial primary key ,user_name varchar not null ,password varchar not null ,
                   role_id bigint references roles(role_id),created_on timestamp default CURRENT_TIMESTAMP,
                   updated_on timestamp default CURRENT_TIMESTAMP);

create table tasks(task_id bigserial primary key ,task_name varchar not null,
                   created_on timestamp default CURRENT_TIMESTAMP,updated_on timestamp default CURRENT_TIMESTAMP);

create table task_progress(id bigserial primary key ,user_id bigint references users(user_id),task_id bigint references tasks(task_id),
                           status_id bigint  references status(status_id) not null default 1,assigned_date date not null default CURRENT_DATE,due_date date not null,
                           over_due_by int not null default 0,created_on timestamp default CURRENT_TIMESTAMP,
                           updated_on timestamp default CURRENT_TIMESTAMP );