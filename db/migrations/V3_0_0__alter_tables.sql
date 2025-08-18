ALTER TABLE activities
ADD COLUMN created_by_user_id int;

ALTER TABLE activities
ADD COLUMN created_at timestamp(6) DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE activities
ADD CONSTRAINT fk_created_by_user
FOREIGN KEY (created_by_user_id) REFERENCES users(id) ON DELETE SET NULL;