drop table if exists s_users;

create table s_users (
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(100) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	status BOOLEAN
) Engine = InnoDB;

create table s_permissions (
	id INT PRIMARY KEY AUTO INCREMENT,
	id_user INT(11) NOT NULL REFERENCES s_users(id),
	user_role VARCHAR(255) NOT NULL
) Engine = InnoDB;