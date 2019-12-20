insert into category ( name ) values ( 'Drama');
insert into category ( name ) values ( 'Fiction');
insert into category ( name ) values ( 'Mystery');
insert into category ( name ) values ( 'Fantasy');

insert into book (category_id, title, isbn, price) values (3, 'The Croaking Violin', '9781257703', 45.12);
insert into book (category_id, title, isbn, price) values (4, 'Soldier Of Fire', '0431816433', 12.34);
insert into book (category_id, title, isbn, price) values (4, 'Gods And Warriors', '1062699939', 11.12);
insert into book (category_id, title, isbn, price) values (4, 'Gangsters And Heirs', '1646541014', 33.11);
insert into book (category_id, title, isbn, price) values (1, 'Claw of Steel', '0175231192', 21.15);
insert into book (category_id, title, isbn, price) values (3, 'Crime of the Beheaded Mermaid ', '0171325562', 31.67);
insert into book (category_id, title, isbn, price) values (1, 'Fare Thee Well', '0113333666', 21.15);
insert into book (category_id, title, isbn, price) values (2, 'Dangerous Thirst', '0173636771', 21.15);
insert into book (category_id, title, isbn, price) values (4, 'Hairy Potter and the Barber', '122221445', 99.99);

insert into author (first_name, last_name, description) values ('John', 'Grisham', 'Suspense about law and lawyery stuff');
insert into author (first_name, last_name, description) values ('William', 'Shakespeare', 'Old stuff');
insert into author (first_name, last_name, description) values ('J.K.', 'Rowling', 'Magic is real people!!');
insert into author (first_name, last_name, description) values ('George', 'Orwell', 'It is becoming true');


insert into author_book (author_id, book_id) values (1, 1);
insert into author_book (author_id, book_id) values (1, 2);
insert into author_book (author_id, book_id) values (3, 9);

