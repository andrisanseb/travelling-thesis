-- Countries
INSERT INTO countries (name)
VALUES
    ('Albania'),
    ('Bosnia and Herzegovina'),
    ('Bulgaria'),
    ('Croatia'),
    ('Greece'),
    ('Montenegro'),
    ('Serbia'),
    ('Romania');


-- Destinations
INSERT INTO destinations (name, description, country_id, img_path)
VALUES
    ('Tirana', 'Explore the vibrant capital of Albania, where colorful architecture, lively markets, and rich history come together in a dynamic urban experience.', 1, 'tirana.jpg'), -- 1
    ('Himare', 'Relax on the stunning beaches of Himare, a coastal gem in southern Albania known for its crystal-clear waters and laid-back atmosphere.', 1, 'himare.jpg'), -- 2
    ('Sarajevo', 'Experience the unique blend of East and West in Sarajevo, a city shaped by diverse cultures and a deeply layered history.', 2, 'sarajevo.jpg'), -- 3
    ('Sofia', 'Discover Bulgaria''s capital, where ancient ruins, historic churches, and modern city life coexist beautifully.', 3, 'sofia.jpg'), -- 4
    ('Dubrovnik', 'Step into a medieval masterpiece in Dubrovnik, where ancient walls and Adriatic views create an unforgettable experience.', 4, 'dubrovnik.jpg'), -- 5
    ('Athens', 'Explore the cradle of Western civilization in Athens, where iconic landmarks meet vibrant modern culture.', 5, 'athens.jpg'), -- 6
    ('Kotor', 'Wander through Montenegro''s fairy-tale coastal town, surrounded by mountains and filled with medieval charm.', 6, 'kotor.jpg'), -- 7
    ('Belgrade', 'Dive into Belgrade''s energetic spirit, with its mix of history, nightlife, and riverside culture.', 7, 'belgrade.jpg'), -- 8
    ('Bucharest', 'Explore Romania’s eclectic capital, a city of contrasts blending grand architecture, history, and modern vibes.', 8, 'bucharest.jpg'), -- 9
    ('Suceava', 'Discover Suceava, a picturesque region in northern Romania renowned for its UNESCO-listed painted monasteries, rolling hills, dense forests, and authentic rural traditions that offer a glimpse into a timeless way of life.', 8, 'suceava.jpg'); -- 10


-- Activities / Experiences / What To Do

-- Activities for Tirana (destination_id = 1)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Skanderbeg Square Exploration', 'Discover the historic Skanderbeg Square and its surrounding landmarks.', 0, 90, 1, 'Culture'),
    ('Traditional Albanian Food Tour', 'Indulge in a culinary adventure through Tirana''s authentic Albanian cuisine.', 15, 120, 1, 'Gastronomy'),
    ('Mount Dajti Cable Car Ride', 'Ascend to breathtaking heights and enjoy panoramic views from Mount Dajti.', 10, 60, 1, 'Nature'),
    ('Local Handicrafts Workshop', 'Immerse yourself in Tirana''s artisan culture with a hands-on crafting experience.', 20, 90, 1, 'Leisure'),
    ('BunkArt 2 Museum Visit', 'Explore Tirana''s history with a visit to the BunkArt 2 museum.', 5, 90, 1, 'Culture'),
    ('Lake Bovilla Picnic', 'Enjoy a scenic picnic by Lake Bovilla.', 10, 120, 1, 'Nature'),
    ('Tirana Bike Tour', 'Discover Tirana''s neighborhoods on a guided bike tour.', 15, 180, 1, 'Leisure');


-- Activities for Himare (destination_id = 2)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Beach Day at Livadhi', 'Relax and swim at Livadhi Beach.', 0, 240, 2, 'Nature'),
    ('Kayaking Adventure', 'Explore the coastline by kayak.', 20, 120, 2, 'Leisure'),
    ('Himare Castle Visit', 'Climb to Himare Castle.', 5, 90, 2, 'Culture'),
    ('Seafood Tasting Tour', 'Enjoy fresh seafood.', 25, 90, 2, 'Gastronomy'),
    ('Snorkeling Experience', 'Discover underwater life.', 15, 60, 2, 'Nature'),
    ('Sunset Cruise', 'Watch the sunset at sea.', 30, 120, 2, 'Leisure'),
    ('Olive Grove Walk', 'Walk through olive groves.', 0, 60, 2, 'Culture'),
    ('Paragliding Over Himare', 'Enjoy aerial views.', 50, 45, 2, 'Leisure'),
    ('Traditional Albanian Cooking Class', 'Cook local dishes.', 20, 120, 2, 'Gastronomy'),
    ('Visit to Porto Palermo Castle', 'Explore the historic castle.', 10, 90, 2, 'Culture');


-- Activities for Sarajevo (destination_id = 3)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Old Town Walking Tour', 'Explore Sarajevo''s Old Town.', 0, 120, 3, 'Culture'),
    ('Bosnian Cooking Class', 'Learn Bosnian cuisine.', 25, 180, 3, 'Gastronomy'),
    ('War Tunnel Museum Visit', 'Learn about wartime history.', 5, 90, 3, 'Culture'),
    ('River Rafting Adventure', 'Experience rafting.', 30, 180, 3, 'Leisure'),
    ('Latin Bridge Walk', 'Visit historic bridge.', 0, 60, 3, 'Culture'),
    ('Sarajevo Brewery Tour', 'Taste local beers.', 20, 90, 3, 'Gastronomy'),
    ('Trebević Mountain Hike', 'Hike for panoramic views.', 0, 240, 3, 'Nature');


-- Activities for Sofia (destination_id = 4)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('National History Museum Tour', 'Explore Bulgaria''s history.', 8, 90, 4, 'Culture'),
    ('Wine Tasting Experience', 'Taste Bulgarian wines.', 20, 120, 4, 'Gastronomy'),
    ('Vitosha Mountain Hike', 'Hike scenic trails.', 0, 180, 4, 'Nature'),
    ('Sofia Pub Crawl', 'Enjoy nightlife.', 15, 240, 4, 'Leisure'),
    ('Alexander Nevsky Cathedral Visit', 'Visit iconic cathedral.', 0, 60, 4, 'Religion'),
    ('Street Food Tour', 'Taste local food.', 15, 120, 4, 'Gastronomy'),
    ('Botanical Garden Relaxation', 'Relax in nature.', 5, 90, 4, 'Nature');


-- Activities for Dubrovnik (destination_id = 5)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('City Walls Tour', 'Walk Dubrovnik''s walls.', 15, 120, 5, 'Culture'),
    ('Seafood Cruise', 'Seafood tasting at sea.', 50, 180, 5, 'Gastronomy'),
    ('Lokrum Island Walk', 'Explore island nature.', 10, 90, 5, 'Nature'),
    ('Game of Thrones Tour', 'Visit filming locations.', 25, 180, 5, 'Leisure'),
    ('Rector''s Palace Tour', 'Visit historic palace.', 10, 90, 5, 'Culture'),
    ('Wine Tasting', 'Taste regional wines.', 30, 180, 5, 'Gastronomy'),
    ('Banje Beach Relaxation', 'Relax at the beach.', 0, 180, 5, 'Leisure');


-- Activities for Athens (destination_id = 6)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Acropolis Tour', 'Explore the Acropolis.', 20, 120, 6, 'Culture'),
    ('Greek Cooking Class', 'Learn Greek cooking.', 30, 180, 6, 'Gastronomy'),
    ('Lycabettus Sunset Hike', 'Watch sunset from hill.', 0, 90, 6, 'Nature'),
    ('Night Bike Tour', 'Bike through Athens at night.', 25, 180, 6, 'Leisure'),
    ('Ancient Agora Visit', 'Visit historic site.', 5, 120, 6, 'Culture'),
    ('Olive Oil Tasting', 'Taste olive oils.', 5, 60, 6, 'Gastronomy'),
    ('National Garden Picnic', 'Relax in garden.', 5, 90, 6, 'Nature');


-- Activities for Kotor (destination_id = 7)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Old Town Walk', 'Explore medieval town.', 0, 120, 7, 'Culture'),
    ('Boat Tour', 'Cruise the bay.', 35, 180, 7, 'Leisure'),
    ('Lovćen Hike', 'Hike mountains.', 0, 180, 7, 'Nature'),
    ('Fortress Climb', 'Climb for views.', 10, 90, 7, 'Leisure'),
    ('Church Visit', 'Visit historic church.', 0, 30, 7, 'Religion'),
    ('Kayaking', 'Paddle the bay.', 25, 120, 7, 'Leisure'),
    ('Perast Tour', 'Visit nearby town.', 40, 180, 7, 'Leisure');


-- Activities for Belgrade (destination_id = 8)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Fortress Tour', 'Explore Belgrade Fortress.', 0, 120, 8, 'Culture'),
    ('Food Tour', 'Taste Serbian cuisine.', 20, 180, 8, 'Gastronomy'),
    ('Danube Cruise', 'Cruise the river.', 30, 180, 8, 'Nature'),
    ('Street Art Walk', 'See urban art.', 0, 90, 8, 'Leisure'),
    ('Saint Sava Temple', 'Visit temple.', 0, 60, 8, 'Religion'),
    ('Skadarlija Walk', 'Explore bohemian quarter.', 10, 90, 8, 'Culture'),
    ('Ada Ciganlija', 'Relax on river island.', 5, 240, 8, 'Leisure');


-- Activities for Bucharest (destination_id = 9)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Parliament Tour', 'Visit massive building.', 15, 120, 9, 'Culture'),
    ('Wine Tasting', 'Taste Romanian wines.', 20, 90, 9, 'Gastronomy'),
    ('Herastrau Park', 'Relax in park.', 0, 120, 9, 'Nature'),
    ('Underground Tour', 'Explore tunnels.', 10, 90, 9, 'Leisure'),
    ('Cotroceni Palace', 'Visit presidential palace.', 10, 90, 9, 'Culture'),
    ('Coffee Tour', 'Taste local coffee.', 15, 60, 9, 'Gastronomy'),
    ('Cismigiu Gardens Boat Ride', 'Boat ride in park.', 8, 90, 9, 'Leisure');


-- Activities for Suceava (destination_id = 10)
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Painted Monasteries Tour', 'Visit UNESCO monasteries.', 20, 240, 10, 'Culture'),
    ('Voronet Monastery Visit', 'See famous blue fresco.', 5, 90, 10, 'Religion'),
    ('Village Walk', 'Explore rural life.', 0, 120, 10, 'Culture'),
    ('Egg Painting Workshop', 'Learn traditional craft.', 15, 120, 10, 'Culture'),
    ('Rarau Mountains Hike', 'Hike scenic mountains.', 0, 240, 10, 'Nature'),
    ('Cheese & Wine Tasting', 'Taste local products.', 20, 90, 10, 'Gastronomy'),
    ('Carriage Ride', 'Ride through countryside.', 15, 60, 10, 'Leisure'),
    ('Suceava Fortress Tour', 'Visit medieval fortress.', 10, 90, 10, 'Culture'),
    ('Forest Foraging', 'Gather wild food.', 10, 120, 10, 'Nature'),
    ('Traditional Cooking', 'Cook local dishes.', 25, 150, 10, 'Gastronomy');