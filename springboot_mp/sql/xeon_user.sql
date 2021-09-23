create table user
(
    id          bigint auto_increment,
    name        varchar(20) default '' null comment '姓名',
    age         tinyint     default 0  null comment '年龄',
    gender      enum ('男', '女')        not null comment '性别 ',
    create_time datetime               not null comment '创建日期',
    update_time datetime               not null comment '更新时间',
    enable      tinyint     default 1  not null comment '是否可用 1可用 否则不可用',
    constraint user_id_uindex
        unique (id)
)
    comment '用户表';

alter table user
    add primary key (id);

INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (1, 'xeon', 28, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (2, 'yzq', 18, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (3, 'yzq', 18, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (104, 'KLgJ6', 33, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 0);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (105, 'LpIzP', 8, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (106, '1zs0J', 8, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (107, '4TSEy', 89, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (108, '3Axnl', 47, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (109, 'Algu2', 1, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (110, 'L9DyP', 87, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (111, 'cFKDy', 69, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (112, 'TUg09', 74, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (113, 'Qev35', 6, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (114, 'Lp5nr', 34, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (115, 'ybuJc', 14, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (116, 'zokPr', 8, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (117, 'nsEeU', 86, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (118, 'bGDqz', 16, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (119, 'pS6wR', 19, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (120, '4e04F', 40, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (121, 'AbiQD', 66, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (122, 'rTEsR', 83, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (123, 'LEzB5', 25, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (124, '5F2nx', 9, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (125, 's1NJY', 45, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (126, 'NOANo', 96, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (127, 'x685R', 34, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (128, '9n2dM', 19, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (129, 'oB1oa', 16, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (130, 'ALXoB', 26, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (131, 'GgJCQ', 54, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (132, 't6vyX', 92, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (133, 'wWcN0', 3, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (134, 'jBJLU', 61, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (135, '4t8uC', 34, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (136, '2VkmF', 81, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (137, 'tKD91', 0, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (138, 'xsJQ7', 30, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (139, 'ED5Rz', 61, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (140, 'Oxcyp', 0, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (141, 'yZWsg', 78, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (142, 'jywsN', 22, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (143, 'yBubi', 14, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (144, 'bLaC5', 1, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (145, 'etqfw', 10, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (146, 'DHnqu', 52, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (147, 'gFhg6', 37, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (148, 'IQgQd', 53, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (149, 'CH58w', 41, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (150, '7hldl', 71, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (151, 'ZYTkh', 58, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (152, 'gtEW2', 51, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (153, '4JVqm', 91, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (154, '0ZAKY', 87, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (155, 'u7Qs3', 29, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (156, 'pcA5s', 73, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (157, 'SB81R', 46, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (158, 'UhP4m', 93, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (159, 'PiSbD', 81, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (160, '3pVRZ', 59, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (161, '9I9U0', 27, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (162, 'gfHxA', 51, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (163, '5nVIw', 59, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (164, 'exChw', 22, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (165, 'na6jf', 99, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (166, 'aKTTw', 99, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (167, 'E5jeq', 28, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (168, 'oMFwS', 94, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (169, 'Otz4A', 13, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (170, 'nSyRF', 42, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (171, '2g8eL', 85, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (172, 'oOnbF', 68, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (173, '1nPhB', 52, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (174, '3XKl4', 95, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (175, 'Nqzap', 4, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (176, 'FsUcX', 61, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (177, 'uuNbJ', 19, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (178, 'JRFAH', 69, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (179, 'eiVLS', 96, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (180, '89YIg', 31, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (181, 'wFAIr', 60, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (182, 'RFsbB', 24, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (183, 'SyLPQ', 39, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (184, 'pbofy', 8, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (185, 'ItkT7', 28, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (186, 'ah25P', 13, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (187, 'uHpx2', 97, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (188, 'idVbG', 74, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (189, 'coOmY', 83, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (190, 'lYB5X', 70, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (191, 'Xd57X', 16, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (192, 'DcYz8', 90, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (193, 'yukIS', 71, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (194, 'gPOLY', 28, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (195, 'ThlEI', 98, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (196, 'CNsm7', 5, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (197, 'UNRNO', 36, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (198, '0CE09', 23, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (199, '616h8', 73, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (200, 'uodateName', 20, '男', '2021-09-23 14:06:19', '2021-09-23 15:21:23', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (201, 'PQTC1', 79, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (202, '4HKmy', 46, '女', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (203, 'hBtYp', 43, '男', '2021-09-23 14:06:19', '2021-09-23 14:06:19', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (204, 'KA5', 19, '男', '2021-09-23 14:18:38', '2021-09-23 14:18:38', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (205, 'uodateName', 20, '男', '2021-09-23 15:23:19', '2021-09-23 15:44:47', 1);
INSERT INTO xeon.user (id, name, age, gender, create_time, update_time, enable) VALUES (206, 'xGk', 16, '男', '2021-09-23 20:24:58', '2021-09-23 20:24:58', 1);