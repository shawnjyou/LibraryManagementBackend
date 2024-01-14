-- User
INSERT INTO users (phone, password, name, registration_time, last_login_time) VALUES ('0911111111', 'OiQdK0SPuqgiJ/N03nayR7ZHAM49iuYuMimbZnpcCwI=', 'User1', EXTRACT(EPOCH FROM CURRENT_TIMESTAMP), EXTRACT(EPOCH FROM CURRENT_TIMESTAMP));
INSERT INTO users (phone, password, name, registration_time, last_login_time) VALUES ('0922222222', 'CYCzzPcVk4hLN+viUA+6ppRRBlo6pgu79K55aQPvTTM=', 'User2', EXTRACT(EPOCH FROM CURRENT_TIMESTAMP), EXTRACT(EPOCH FROM CURRENT_TIMESTAMP));
INSERT INTO users (phone, password, name, registration_time, last_login_time) VALUES ('0933333333', 'hMMq2ZfGFWQCyUPbuTiv9vbWcWr0Qx9PqQtLZJ1RenM=', 'User3', EXTRACT(EPOCH FROM CURRENT_TIMESTAMP), EXTRACT(EPOCH FROM CURRENT_TIMESTAMP));
-- Book
INSERT INTO books (isbn, author, introduction, name) VALUES (1234567890, 'John Doe', 'An interesting book about something', 'Book 1');
INSERT INTO books (isbn, author, introduction, name) VALUES (9876543210, 'Jane Smith', 'A captivating novel', 'Book 2');
INSERT INTO books (isbn, author, introduction, name) VALUES (1112233445, 'Alice Johnson', 'A guide to something', 'Book 3');
-- Inventory
INSERT INTO inventories (isbn, store_time, status) VALUES (1234567890, EXTRACT(EPOCH FROM CURRENT_TIMESTAMP), 'AVAILABLE');
-- BorrowRecord
INSERT INTO borrow_records (user_id, inventory_id, borrow_date) VALUES (1, 1, EXTRACT(EPOCH FROM CURRENT_TIMESTAMP));