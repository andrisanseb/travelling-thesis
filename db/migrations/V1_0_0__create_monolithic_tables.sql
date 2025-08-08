create table if not exists users (
id serial primary key,
username text,
email text,
password text,
created_at timestamp(6) DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp(6)
);


create table if not exists countries (
id serial primary key,
name text
);


create table if not exists destinations (
id serial primary key,
name text,
description text,
country_id int,
img_path text,
FOREIGN KEY (country_id) REFERENCES countries(id) ON DELETE CASCADE
);


create table if not exists activities (
id serial primary key,
name text,
description text,
cost int,
duration int,
destination_id int,
category text,
FOREIGN KEY (destination_id) REFERENCES destinations(id) ON DELETE CASCADE
);


create table if not exists favorite_activities (
id serial primary key,
user_id int,
activity_id int,
favorited_at timestamp(6) DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (activity_id) REFERENCES activities(id) ON DELETE CASCADE
);

create table if not exists activity_reviews (
id serial primary key,
user_id int,
activity_id int,
stars int,
comment text DEFAULT NULL,
reviewed_at timestamp(6) DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (activity_id) REFERENCES activities(id) ON DELETE CASCADE
);


create table if not exists road_trips (
id serial primary key,
name text,
user_id int,
details text,   -- will include all data (route, days, ++)
route text DEFAULT NULL,     -- JSON with route data
days text DEFAULT NULL,      -- JSON includes actIds by day
created_at timestamp(6) DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp(6),
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
