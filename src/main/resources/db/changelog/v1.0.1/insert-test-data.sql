-- liquibase formatted sql

-- changeSet Danil:1
insert into specialization(name) values ('Сборщик'), ('Менеджер');

-- changeSet Danil:2
insert into warehouse(warehouse_information, details_information) values ('Склад №1', 'Морозильные камеры'),
                                                                         ('Склад №2', 'Металлические каркасы');
-- changeSet Danil:3
insert into employee(first_name, second_name, middle_name, phone_number, warehouse_id, spec_id) values
                                                                                                    ('Иван', 'Иванов', 'Иванович', '84951111111', 1, 1),
                                                                                                    ('Мария', 'Савранова', 'Александровна', '84952222222', 1, 2),
                                                                                                    ('Игорь', 'Попов', 'Иванович', '84953333333', 2, 1),
                                                                                                    ('Никита', 'Сидоров', 'Иванович', '84954444444', 2, 2);
-- changeSet Danil:4
insert into item(name, quantity, warehouse_id) values ('Изделие №1', 10, 1), ('Изделие №2', 12, 1), ('Изделие №3', 12, 1),
                                                      ('Изделие №4', 9, 2), ('Изделие №5', 9, 1), ('Изделие №6', 11, 2);

-- changeSet Danil:5
insert into piece(name, quantity, warehouse_id) values ('Компоненты №1', 13, 2), ('Компоненты №2', 15, 1);

-- changeSet Danil:6
insert into detail(name, quantity, warehouse_id) values ('Деталь №1', 5, 1), ('Деталь №2', 6, 2);

-- changeSet Danil:7
insert into customer(first_name, second_name, middle_name, phone_number) VALUES
                                                                             ('Данил', 'Данилов', 'Данилович', '84951111111'),
                                                                             ('Александра', 'Александрова', 'Александровна', '84952222222'),
                                                                             ('Игорь', 'Попов', 'Евгеньевич', '84953333333'),
                                                                             ('Никита', 'Никитов', 'Никитович', '84954444444');

-- changeSet Danil:8
insert into application(customer_id, employee_id, creation_date) values (2, 1, '2019-06-22 19:10:25-07'),
                                                                        (3, 2, '2021-03-17 10:11:20-06');

-- changeSet Danil:9
insert into product(item_name, item_information) values ('Сибирь', 'Холодильник №1'), ('Красная звезда', 'Холодильник №2');

-- changeSet Danil:10
insert into application_composition(quantity, application_id, product_id) values (4, 2, 1), (3, 1, 2);