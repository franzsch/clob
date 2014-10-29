INSERT INTO users VALUES (1,'Christian','Henle','chris','$2a$10$WVPq/GcSLNcKECb.wIfGeuFD0etGZpkgh6cgxdzmdzlBGdgp7Jzh2','christian@test.de','Test GmbH','male','Test Town','asdfstreet 1','33333','016011111111');
INSERT INTO users VALUES (2,'Oliver','Roevekamp','oliver1','$2a$10$5GMyJxnb8405GyQ3rzhrQuke8DTtEoKJCq9Fhf8Y41zluFhPZa0Qi','asdf@asdf.de','asdf GmbH','male','asdftown','asdfstreet 1','33333','016011111111');
INSERT INTO users VALUES (3,'Oliver','Roevekamp','oliver2','$2a$10$5GMyJxnb8405GyQ3rzhrQuke8DTtEoKJCq9Fhf8Y41zluFhPZa0Qi','asdf@asdf.de','asdf GmbH','male','asdftown','asdfstreet 1','33333','016011111111');
INSERT INTO users VALUES (4,'test','test','test','$2a$10$5GMyJxnb8405GyQ3rzhrQuke8DTtEoKJCq9Fhf8Y41zluFhPZa0Qi','asdf@asdf.de','asdf GmbH','male','asdftown','asdfstreet 1','33333','016011111111');
INSERT INTO authority VALUES (1,'ROLE_ADMIN');
INSERT INTO authority VALUES (3,'ROLE_CUSTOMER');
INSERT INTO user_authority VALUES (1,1);
INSERT INTO user_authority VALUES (2,1);
INSERT INTO user_authority VALUES (3,3);
INSERT INTO user_authority VALUES (4,3);

INSERT INTO location VALUES(1, 'sample location', 'sample street', 'sample town', 'sample type');
INSERT INTO catering VALUES(1, 1, 'sample eating type', 12, 1, 12);
INSERT INTO audio VALUES(1, 1, 'sample audio', 12, 12);
INSERT INTO light VALUES(1, 1, 'sample lighting', 12, 12);
INSERT INTO rigging VALUES(1, 1, 'sample riggingtype', 'sample stageSize');
INSERT INTO security VALUES(1, 1, 12);
INSERT INTO specialty VALUES(1, 'sample subject', 'sample comment');

INSERT INTO event VALUES (1, 'sample event', '9999-12-31 23:59:59', 1, 1, 1, 1, 1, 1, 1, 2);