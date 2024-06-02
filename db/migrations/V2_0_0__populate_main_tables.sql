-- TODO: maybe img_path is not needed, just check it in frontend

-- Countries
INSERT INTO countries (name, img_path)
VALUES
    ('Albania', 'albania.jpg'),
    ('Bosnia and Herzegovina', 'bosnia.jpg'),
    ('Bulgaria', 'bulgaria.jpg'),
    ('Croatia', 'croatia.jpg'),
    ('Greece', 'greece.jpg'),
    ('Montenegro','montenegro.jpg'),
    ('Serbia','serbia.jpg'),
    ('Romania','romania.jpg');


-- Destinations
INSERT INTO destinations (name, description, country_id, img_path, longitude, latitude)
VALUES
    ('Tirana', 'Explore the vibrant heart of Albania, where history meets modern culture.', 1, 'tirana.jpg', 19.8187, 41.3275),
    ('Sarajevo', 'Embark on a journey through the diverse culture and turbulent history of Bosnia and Herzegovina.', 2, 'sarajevo.jpg', 18.4131, 43.8563),
    ('Sofia', 'Discover Bulgaria''s blend of ancient treasures and contemporary charm amidst its capital city.', 3, 'sofia.jpg', 23.3219, 42.6977),
    ('Dubrovnik', 'Uncover the enchanting allure of Croatia''s coastal gem, where medieval walls guard timeless stories.', 4, 'dubrovnik.jpg', 18.0922, 42.6507),
    ('Athens', 'Embark on an odyssey through Greece''s ancient past and vibrant present in its bustling capital.', 5, 'athens.jpg', 23.7275, 37.9838),
    ('Kotor', 'Step into a fairy tale in Montenegro''s breathtaking coastal town, where history whispers through every stone.', 6, 'kotor.jpg', 18.7712, 42.4247),
    ('Belgrade', 'Experience the pulse of Serbia as you navigate the dynamic blend of history, culture, and nightlife.', 7, 'belgrade.jpg', 20.4489, 44.7866),
    ('Bucharest', 'Unravel the layers of Romania''s capital, where tradition and modernity converge in an eclectic tapestry.', 8, 'bucharest.jpg', 26.1025, 44.4268);


-- Activities / Experiences / What To Do
-- Activities for Tirana, Albania
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Skanderbeg Square Exploration', 'Discover the historic Skanderbeg Square and its surrounding landmarks.', 0, 90, 1, 'Culture'),
    ('Traditional Albanian Food Tour', 'Indulge in a culinary adventure through Tirana''s authentic Albanian cuisine.', 15, 120, 1, 'Gastronomy'),
    ('Mount Dajti Cable Car Ride', 'Ascend to breathtaking heights and enjoy panoramic views from Mount Dajti.', 10, 60, 1, 'Nature'),
    ('Local Handicrafts Workshop', 'Immerse yourself in Tirana''s artisan culture with a hands-on crafting experience.', 90, 20, 1, 'Leisure'),
    ('BunkArt 2 Museum Visit', 'Explore Tirana''s fascinating history with a visit to the BunkArt 2 museum, housed in a former nuclear bunker.', 5, 90, 1, 'Culture'),
    ('Lake Bovilla Picnic', 'Escape the city and enjoy a scenic picnic by the tranquil shores of Lake Bovilla, just outside Tirana.', 10, 120, 1, 'Nature'),
    ('Tirana Bike Tour', 'Discover Tirana''s hidden gems and vibrant neighborhoods on a guided bike tour through the city.', 15, 180, 1, 'Leisure');

-- Activities for Sarajevo, Bosnia and Herzegovina
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Old Town Walking Tour', 'Explore the cobblestone streets of Sarajevo''s Old Town and learn about its rich history.', 0, 120, 2, 'Culture'),
    ('Bosnian Cuisine Cooking Class', 'Learn the secrets of traditional Bosnian cooking in a local chef''s kitchen.', 25, 180, 2, 'Gastronomy'),
    ('Sarajevo War Tunnel Museum Visit', 'Journey back in time and discover the poignant history of the Sarajevo War Tunnel.', 5, 90, 2, 'Nature'),
    ('River Rafting Adventure', 'Embark on an adrenaline-pumping rafting excursion down the wild rivers of Bosnia.', 30, 180, 2, 'Leisure'),
    ('Latin Bridge Walking Tour', 'Stroll across the historic Latin Bridge, known for its role in the events leading to the start of World War I.', 0, 60, 2, 'Culture'),
    ('Sarajevo Brewery Tour', 'Sample a variety of locally brewed beers on a guided tour of Sarajevo''s renowned breweries.', 20, 90, 2, 'Gastronomy'),
    ('Trebević Mountain Hike', 'Embark on a scenic hike to the summit of Trebević Mountain for panoramic views of Sarajevo.', 0, 240, 2, 'Nature');


-- Activities for Sofia, Bulgaria
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('National History Museum Tour', 'Uncover Bulgaria''s fascinating past with a guided tour of the National History Museum.', 8, 90, 3, 'Culture'),
    ('Bulgarian Wine Tasting Experience', 'Savor the flavors of Bulgaria with a tasting journey through its renowned wineries.', 20, 120, 3, 'Gastronomy'),
    ('Vitosha Mountain Hike', 'Embark on a scenic trek through the stunning landscapes of Vitosha Mountain.', 0, 180, 3, 'Nature'),
    ('Sofia Pub Crawl', 'Experience Sofia''s vibrant nightlife with a guided pub crawl through the city''s top bars.', 15, 240, 3,'Leisure'),
    ('Alexander Nevsky Cathedral Visit', 'Marvel at the stunning architecture of the Alexander Nevsky Cathedral, an iconic symbol of Sofia.', 0, 60, 3, 'Religion'),
    ('Street Food Tour', 'Embark on a gastronomic adventure through Sofia''s bustling streets, sampling a variety of local delicacies.', 15, 120, 3, 'Gastronomy'),
    ('Botanical Garden Relaxation', 'Escape the urban hustle and unwind amidst the lush greenery of Sofia''s Botanical Garden.', 5, 90, 3, 'Nature');


-- Activities for Dubrovnik, Croatia
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Dubrovnik City Walls Tour', 'Walk along the ancient city walls of Dubrovnik and marvel at panoramic views.', 15, 120, 4, 'Culture'),
    ('Seafood Tasting Cruise', 'Embark on a gastronomic journey aboard a luxury yacht with a seafood tasting experience.', 50, 180, 4, 'Gastronomy'),
    ('Lokrum Island Nature Walk', 'Explore the natural beauty of Lokrum Island with a guided nature walk.', 10, 90, 4, 'Nature'),
    ('Game of Thrones Filming Locations Tour', 'Step into the world of Westeros with a guided tour of Dubrovnik''s Game of Thrones filming locations.', 25, 180, 4, 'Leisure'),
    ('Rector''s Palace Guided Tour', 'Step back in time with a guided tour of the Rector''s Palace, a well-preserved medieval landmark in Dubrovnik.', 10, 90, 4, 'Culture'),
    ('Wine Tasting at Pelješac Peninsula', 'Indulge in a wine tasting experience at the scenic Pelješac Peninsula, renowned for its vineyards and wineries.', 30, 180, 4, 'Gastronomy'),
    ('Banje Beach Relaxation', 'Soak up the sun and enjoy a relaxing day at Banje Beach, one of Dubrovnik''s most popular seaside spots.', 0, 180, 4, 'Leisure');

-- Activities for Athens, Greece
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Acropolis Guided Tour', 'Embark on a journey through ancient history with a guided tour of the Acropolis.', 20, 120, 5, 'Culture'),
    ('Greek Cooking Class', 'Learn the art of Greek cuisine from a local chef and savor the flavors of Greece.', 30, 180, 5, 'Gastronomy'),
    ('Mount Lycabettus Sunset Hike', 'Hike to the summit of Mount Lycabettus and witness a breathtaking sunset over Athens.', 0, 90, 5, 'Nature'),
    ('Athens Night Bike Tour', 'Experience Athens by night with a thrilling bike tour through its illuminated streets.', 25, 180, 5, 'Leisure'),
    ('Ancient Agora Exploration', 'Explore the ruins of the Ancient Agora, a central gathering place in ancient Athens steeped in history and mythology.', 5, 120, 5, 'Culture'),
    ('Olive Oil Tasting Experience', 'Learn about Greece''s rich olive oil tradition and sample a variety of premium olive oils at a local tasting.', 5, 60, 5, 'Gastronomy'),
    ('National Garden Picnic', 'Escape the urban bustle and enjoy a leisurely picnic amidst the lush greenery of Athens'' National Garden.', 5, 90, 5, 'Nature');

-- Activities for Kotor, Montenegro
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Kotor Old Town Guided Walk', 'Discover the medieval charm of Kotor''s Old Town with a knowledgeable local guide.', 0, 120, 6, 'Culture'),
    ('Bay of Kotor Boat Tour', 'Cruise along the stunning Bay of Kotor and visit picturesque coastal villages.', 35, 180, 6, 'Gastronomy'),
    ('Lovćen National Park Hike', 'Embark on a scenic hike through the rugged landscapes of Lovćen National Park.', 0, 180, 6, 'Nature'),
    ('Kotor Fortress Climb', 'Climb the ancient walls of Kotor Fortress and enjoy panoramic views of the bay.', 10, 90, 6, 'Leisure'),
    ('Church of Our Lady of Remedy Visit', 'Visit the historic Church of Our Lady of Remedy, perched on a hill overlooking the Bay of Kotor.', 0, 30, 6, 'Religion'),
    ('Bay of Kotor Kayaking Adventure', 'Paddle through the crystal-clear waters of the Bay of Kotor on an exciting kayaking excursion.', 25, 120, 6, 'Leisure'),
    ('Perast Boat Tour', 'Cruise to the charming town of Perast and explore its historic landmarks and picturesque waterfront.', 40, 180, 6, 'Leisure');

-- Activities for Belgrade, Serbia
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Belgrade Fortress Tour', 'Explore the historic Belgrade Fortress and learn about its significance throughout the centuries.', 0, 120, 7, 'Culture'),
    ('Serbian Cuisine Food Tour', 'Satisfy your taste buds with a culinary journey through Belgrade''s diverse flavors.', 20, 180, 7, 'Gastronomy'),
    ('Danube River Cruise', 'Relax and unwind on a leisurely cruise along the Danube River with stunning city views.', 30, 180, 7, 'Nature'),
    ('Belgrade Street Art Walk', 'Discover Belgrade''s vibrant street art scene with a guided walking tour through its colorful neighborhoods.', 0, 90, 7, 'Leisure'),
    ('Saint Sava Temple Visit', 'Visit the magnificent Saint Sava Temple, one of the largest Orthodox churches in the world, and admire its stunning architecture.', 0, 60, 7, 'Religion'),
    ('Skadarlija Bohemian Quarter Tour', 'Stroll through the cobbled streets of Skadarlija, Belgrade''s bohemian quarter, known for its lively atmosphere and traditional taverns.', 10, 90, 7, 'Culture'),
    ('Ada Ciganlija Recreation', 'Escape the city heat and enjoy a day of swimming, sunbathing, and recreational activities at Ada Ciganlija, Belgrade''s popular river island.', 5, 240, 7, 'Leisure');

-- Activities for Bucharest, Romania
INSERT INTO activities (name, description, cost, duration, destination_id, category)
VALUES
    ('Palace of the Parliament Tour', 'Explore one of the world''s largest administrative buildings with a guided tour of the Palace of the Parliament.', 15, 120, 8, 'Culture'),
    ('Romanian Wine Tasting Experience', 'Indulge in a tasting journey through Romania''s finest wines in the heart of Bucharest.', 20, 90, 8, 'Gastronomy'),
    ('Herastrau Park Relaxation', 'Unwind amidst the serene beauty of Herastrau Park with a leisurely stroll or picnic.', 0, 120, 8, 'Nature'),
    ('Bucharest Underground Tour', 'Descend into the hidden depths of Bucharest''s underground tunnels and uncover its secrets.', 10, 90, 8, 'Leisure'),
    ('Metelkova Art Center Exploration', 'Immerse yourself in Ljubljana''s vibrant street art scene at the eclectic Metelkova Art Center.', 0, 120, 8, 'Leisure'),
    ('Cotroceni Palace Tour', 'Discover the opulent Cotroceni Palace, the official residence of the President of Romania, with a guided tour of its magnificent interiors and gardens.', 10, 90, 8, 'Culture'),
    ('Coffee Tasting at Old Town Cafés', 'Savor the rich flavors of Romanian coffee culture with a tasting tour of Bucharest''s historic cafés in the charming Old Town.', 15, 60, 8, 'Gastronomy'),
    ('Cișmigiu Gardens Boat Ride', 'Relax and enjoy a peaceful boat ride on the tranquil lake of Cișmigiu Gardens, one of Bucharest''s oldest and most picturesque parks.', 8, 90, 8, 'Leisure');
