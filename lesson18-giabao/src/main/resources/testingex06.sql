use hib_comman_cache;
create table Test(
	id int auto_increment primary key,
    name nvarchar(50) not null,
    salary double,
    managerId int
);
INSERT INTO `hib_comman_cache`.`Test` (`id`, `name`, `salary`, `managerId`) VALUES ('1', 'Joe', '60000', '3');
INSERT INTO `hib_comman_cache`.`Test` (`id`, `name`, `salary`, `managerId`) VALUES ('2', 'A', '80000', '4');
INSERT INTO `hib_comman_cache`.`Test` (`id`, `name`, `salary`) VALUES ('3', 'B', '50000');
INSERT INTO `hib_comman_cache`.`Test` (`id`, `name`, `salary`) VALUES ('4', 'C', '90000');
INSERT INTO `hib_comman_cache`.`Test` (`id`, `name`, `salary`, `managerId`) VALUES ('5', 'D', '100000', '4');

SELECT * FROM Test AS employee
		WHERE employee.salary > (SELECT salary FROM Test AS temp 
									WHERE temp.id ==  employee.managerId);

                                