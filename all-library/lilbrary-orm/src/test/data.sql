insert into Author (ID, LAST_NAME , MIDDLE_NAME , SUR_NAME) values (1, 'Test1', 'Test1', 'Testovich1');
insert into Author (ID, LAST_NAME , MIDDLE_NAME , SUR_NAME) values (2, 'Test2', 'Test2', 'Testovich2');

insert into GENRE (ID, TYPE ) values (1, 'BUSINESS_BOOKS');
insert into GENRE (ID, TYPE ) values (2, 'CLASSIC_LITERATURE');
insert into GENRE (ID, TYPE ) values (3, 'FOREIGN_LITERATURE');
insert into GENRE (ID, TYPE ) values (4, 'RUSSIAN');
insert into GENRE (ID, TYPE ) values (5, 'FICTION');
insert into GENRE (ID, TYPE ) values (6, 'MODERN_PROSE');
insert into GENRE (ID, TYPE ) values (7, 'ADVENTURE');
insert into GENRE (ID, TYPE ) values (8, 'HORROR');
insert into GENRE (ID, TYPE ) values (9, 'MYSTERY');

insert into BOOK  (ID, NAME, GENRE_ID) values (1, 'TestBook1', 1);
insert into BOOK  (ID, NAME, GENRE_ID) values (2, 'TestBook2', 1);
insert into BOOK  (ID, NAME, GENRE_ID) values (3, 'TestBook3', 1);

insert into BOOK_AUTHORS (BOOK_ID , AUTHOR_ID ) values (1, 1);
insert into BOOK_AUTHORS (BOOK_ID , AUTHOR_ID ) values (2, 2);
insert into BOOK_AUTHORS (BOOK_ID , AUTHOR_ID ) values (2, 1);
insert into BOOK_AUTHORS (BOOK_ID , AUTHOR_ID ) values (3, 2);

insert into Comment (ID , TEXT , BOOK_ID ) values(1, '1', 1);
insert into Comment (id, text, book_id) values(2, '2', 1);
insert into Comment (id, text, book_id) values(3, '3', 1);
insert into Comment (id, text, book_id) values(4, '3', 2);
insert into Comment (id, text, book_id) values(5, '4', 2);
insert into Comment (id, text, book_id) values(6, '5', 2);
insert into Comment (id, text, book_id) values(7, '6', 2);
insert into Comment (id, text, book_id) values(8, '17', 1);