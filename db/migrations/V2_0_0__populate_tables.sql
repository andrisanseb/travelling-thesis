INSERT INTO countries (name)
VALUES
('Greece'),
('Italy'),
('Netherlands');


INSERT INTO airports (code, name, country_id)
VALUES
('ATH', 'Athens International Airport',1),
('SKG', 'Thessaloniki Airport',1),
('HER', 'Heraklion International Airport',1),
('RHO', 'Rhodes International Airport',1),
('Chania', 'Chania International Airport',1),
('FCO', 'Leonardo da Vinci–Fiumicino Airport',2),
('MXP', 'Milan Malpensa Airport',2),
('FCO', 'Rome Ciampino Airport',2),
('LIN', 'Milan Linate Airport',2),
('NAP', 'Naples International Airport',2),
('AMS', 'Amsterdam Airport Schiphol',3),
('RTM', 'Rotterdam The Hague Airport',3),
('EIN', 'Eindhoven Airport',3),
('EIN', 'Maastricht Aachen Airport',3),
('GRQ', 'Groningen Airport Eelde',3);


INSERT INTO destinations (name, description, nearest_airport_id)
VALUES
('Athens', 'The cradle of Western civilization with ancient ruins.',1),
('Rome', 'The Eternal City, filled with history and culture.',6),
('Amsterdam', 'Known for its picturesque canals and historic architecture.',10);


INSERT INTO users (username, email, password, first_name, last_name, nearest_airport_id,  created_at, updated_at)
VALUES
('andrisanseb', 'seb@gmail.com', 'pass123', 'Sebastian', 'Andrisan', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('wesley10', 'theo7@hotmail.com', 'easy123', 'Wesley', 'Snejder', 10,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

