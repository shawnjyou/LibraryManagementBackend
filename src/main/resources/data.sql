INSERT INTO users (phone, password, name, registration_time, last_login_time) VALUES ('0911111111', '11111111', 'User1', EXTRACT(EPOCH FROM CURRENT_TIMESTAMP), EXTRACT(EPOCH FROM CURRENT_TIMESTAMP));
INSERT INTO users (phone, password, name, registration_time, last_login_time) VALUES ('0922222222', '22222222', 'User2', EXTRACT(EPOCH FROM CURRENT_TIMESTAMP), EXTRACT(EPOCH FROM CURRENT_TIMESTAMP));
INSERT INTO users (phone, password, name, registration_time, last_login_time) VALUES ('0933333333', '33333333', 'User3', EXTRACT(EPOCH FROM CURRENT_TIMESTAMP), EXTRACT(EPOCH FROM CURRENT_TIMESTAMP));

INSERT INTO books (isbn, author, introduction, name) VALUES (1234567890, 'John Doe', 'An interesting book about something', 'Book 1');
INSERT INTO books (isbn, author, introduction, name) VALUES (9876543210, 'Jane Smith', 'A captivating novel', 'Book 2');
INSERT INTO books (isbn, author, introduction, name) VALUES (1112233445, 'Alice Johnson', 'A guide to something', 'Book 3');