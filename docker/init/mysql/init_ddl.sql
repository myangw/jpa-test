create table apply (
    id bigint not null auto_increment,
    user_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table apply_desired_date (
    apply_id bigint not null,
    desired_dates date not null
) engine=InnoDB;
