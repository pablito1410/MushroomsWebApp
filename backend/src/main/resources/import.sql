
SET IDENTITY_INSERT MushroomsUser ON
insert into MushroomsUser (Id, age, email, gender, nick, passwordHash, role) values (1, 20, 'pablito@gmail.com', 'MALE', 'pablito', '$2a$10$jnlQ9TeBc6RlxqtRciPzVuWhTm4A.NkAN7AGBhaJfoPx5vQRaDYG2', 'USER');
SET IDENTITY_INSERT MushroomsUser OFF

SET IDENTITY_INSERT Trip ON
insert into Trip (id, dateTime, place) values (1, GETDATE(), 'Warszawa');
SET IDENTITY_INSERT Trip OFF

insert into TripParticipant values (1, 1);

SET IDENTITY_INSERT MushroomSpecie ON
insert into MushroomSpecie (id, name) values (1, 'Pieczarka');
SET IDENTITY_INSERT MushroomSpecie OFF

SET IDENTITY_INSERT Discovery ON
insert into Discovery (id, dateTime, photoId, userId, x, y, mushroomSpecie_Id, trip_id) values (1, GETDATE(), 1, 1, 99, 99, 1, 1);
SET IDENTITY_INSERT Discovery OFF


