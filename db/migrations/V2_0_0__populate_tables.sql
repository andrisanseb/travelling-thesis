-- Countries
INSERT INTO countries (name, img_path)
VALUES
    ('Albania', 'albania.jpg'),
    ('Bosnia and Herzegovina', 'bosnia.jpg'),
    ('Bulgaria', 'bulgaria.jpg'),
    ('Croatia', 'croatia.jpg'),
    ('Greece', 'greece.jpg'),
    ('Montenegro','montenegro.jpg'),
    ('Serbia','serbia.jpg');
--    ('North Macedonia','macedonia.jpg'),
--    ('Romania','romania.jpg'),
--    ('Kosovo', 'kosovo.jpg'),
--    ('Slovenia','slovenia.jpg');


INSERT INTO destinations (name, description, country_id, img_path, longitude, latitude)
VALUES
    -- Albania 1
    ('Tirana', 'Capital city known for its vibrant culture and historical landmarks.', 1, 'albania/tirana.jpg', 19.8189, 41.3275),
    ('Berat', 'City of a thousand windows, known for its well-preserved Ottoman architecture.', 1, 'albania/berat.jpg', 19.9567, 40.7072),
    ('Sarandë', 'Coastal town famous for its beaches and proximity to archaeological sites like Butrint.', 1, 'albania/sarande.jpg', 20.0122, 39.8785),
    -- Bosnia and Herzegovina 2
    ('Sarajevo', 'Capital city known for its historical sites and vibrant culture.', 2, 'bosnia/sarajevo.jpg', 18.4131, 43.8563),
    -- Bulgaria 3
    ('Sofia', 'Capital city known for its history, landmarks, and vibrant atmosphere.', 3, 'bulgaria/sofia.jpg', 23.3219, 42.6977),
    -- Croatia 4
    ('Dubrovnik', 'Historic city known for its old town and walls.', 4, 'croatia/dubrovnik.jpg', 18.0922, 42.6507),
    ('Split', 'Coastal city known for its beaches, Diocletian’s Palace, and vibrant nightlife.', 4, 'croatia/split.jpg', 16.4425, 43.5081),
    -- Greece 5
    ('Athens', 'Historical capital city known for its ancient landmarks like the Acropolis.', 5, 'greece/athens.jpg', 23.7275, 37.9838),
    -- Montenegro 6
    ('Kotor', 'Picturesque coastal town known for its medieval old town and stunning bay views.', 6, 'montenegro/kotor.jpg', 18.7712, 42.4247),
    ('Budva', 'Coastal town known for its beaches, medieval walled city, and vibrant nightlife.', 6, 'montenegro/budva.jpg', 18.8376, 42.2917),
    -- Serbia 7
    ('Belgrade', 'Capital city known for its nightlife, riverside clubs, and historical sites like Belgrade Fortress.', 7, 'serbia/belgrade.jpg', 20.4489, 44.7866);


INSERT INTO activities (name, description, cost, duration, destination_id)
VALUES
    ('Explore Skanderbeg Square', 'Visit the main square and see the Skanderbeg Monument.', 0, 60, 1),
    ('Bunk''Art 2 Museum', 'Explore an underground museum showcasing Albania''s history.', 5, 90, 1),
    ('Dajti Express Cable Car', 'Take a cable car ride for panoramic views of Tirana.', 8, 60, 1),
    ('Visit the Pyramid of Tirana', 'Explore the unique architectural structure and its history.', 0, 45, 1),
    ('National History Museum', 'Discover Albania''s history through exhibits and artifacts.', 3, 120, 1),
    ('Tirana Free Tour', 'Join a free walking tour to explore the city with local guides.', 0, 120, 1),
    ('Tirana Castle (Kalaja e Tiranes)', 'Visit the historic fortress for scenic views.', 0, 60, 1),
    ('Blloku District', 'Explore the trendy area with cafes, restaurants, and boutiques.', 0, 90, 1),
    ('Et''hem Bey Mosque', 'Visit the beautifully decorated mosque in the city center.', 0, 30, 1),
    ('Pyramid of Tirana', 'Experience the controversial pyramid building in Tirana.', 0, 60, 1),
    ('Tirana Art Gallery', 'Explore contemporary and traditional Albanian art.', 2, 90, 1),
    ('Lake Park', 'Enjoy a relaxing stroll or picnic in this urban park.', 0, 120, 1),
    ('Tirana Zoo', 'Visit the zoo to see various animal species.', 1, 60, 1),
    ('Tanners'' Bridge (Ura e Tabakeve)', 'Historical bridge offering scenic views over the Lana River.', 0, 45, 1),
    ('Pyramid of Tirana Night View', 'Experience the pyramid illuminated at night for a different perspective.', 0, 30, 1),
    ('Bazaar of Tirana', 'Discover local goods, souvenirs, and vibrant market life.', 0, 90, 1),
    ('House of Leaves Museum', 'Learn about the history of the Sigurimi, Albania''s secret police.', 4, 60, 1),
    ('Peace Bell', 'See the massive bell symbolizing peace in the city.', 0, 15, 1),
    ('Presidential Palace', 'Admire the architecture of the official residence of the President of Albania.', 0, 30, 1),
    ('Berat Castle', 'Explore the ancient castle and enjoy panoramic views.', 0, 90, 2),
    ('Onufri Museum', 'Visit a museum showcasing religious art and icons.', 2, 60, 2),
    ('Mangalem Quarter', 'Explore the historical quarter with narrow streets and Ottoman architecture.', 0, 120, 2),
    ('Gorica Bridge', 'Walk across the bridge for scenic river views.', 0, 30, 2),
    ('Holy Trinity Church', 'Visit a well-preserved Orthodox church.', 0, 45, 2),
    ('Berat Ethnographic Museum', 'Explore exhibits on traditional Albanian life.', 3, 90, 2),
    ('Gorica Castle', 'Ancient castle ruins offering views of the city.', 0, 60, 2),
    ('Lead Mosque', 'Historical mosque with unique architectural features.', 0, 45, 2),
    ('Bachelors'' Mosque', 'Visit a small mosque with interesting architecture.', 0, 30, 2),
    ('Berat Wine Tasting', 'Experience local wines in a wine tasting tour.', 10, 90, 2),
    ('Butrint Ancient City', 'Explore the UNESCO-listed ancient ruins of Butrint.', 5, 180, 3),
    ('Lëkurësi Castle', 'Visit the castle for panoramic views of Sarandë and the sea.', 0, 60, 3),
    ('Ksamil Beaches', 'Relax on the beautiful beaches near Sarandë.', 0, 240, 4),
    ('Monastery of 40 Saints', 'Visit the historic monastery dedicated to the Forty Martyrs of Sebaste.', 0, 90, 3),
    ('Syri i Kalter (Blue Eye)', 'Explore the natural spring with crystal-clear blue water.', 0, 120, 3),
    ('Saranda Waterfront Promenade', 'Enjoy a leisurely stroll along the scenic waterfront.', 0, 90, 3),
    ('Lekuresi Hill', 'Hike up the hill for stunning views and a peaceful atmosphere.', 0, 90, 3),
    ('Agios Saranda Church', 'Visit a Greek Orthodox church with beautiful architecture.', 0, 30, 3),
    ('Sarandë Archaeological Museum', 'Explore the museum showcasing local history and artifacts.', 2, 60, 3),
    ('Nightlife in Sarandë', 'Experience the vibrant nightlife with bars and clubs.', 20, 180, 3),
    --Skips to Sarajevo 11
    ('Old Town Bascarsija', 'Explore the historic center with traditional shops and cafes.', 0, 120, 4),
    ('Sarajevo War Tunnel', 'Visit the tunnel used during the Siege of Sarajevo for supplies.', 5, 90, 4),
    ('Latin Bridge', 'See the site where Archduke Franz Ferdinand was assassinated.', 0, 30, 4),
    ('Sarajevo Cable Car', 'Take a ride for panoramic views from Trebević Mountain.', 8, 60, 4),
    ('Gazi Husrev-beg Mosque', 'Visit a historic mosque with stunning Ottoman architecture.', 0, 45, 4),
    ('Sarajevo City Hall', 'Explore the reconstructed building with a historical museum.', 3, 60, 4),
    ('Yellow Fortress', 'Enjoy scenic views of the city from this historic fortress.', 0, 60, 4),
    ('Sarajevo Olympic Bobsleigh and Luge Track', 'Explore the abandoned track from the 1984 Winter Olympics.', 0, 90, 4),
    ('Vrelo Bosne', 'Visit a natural spring park with beautiful walking trails.', 3, 120, 4),
    ('Sarajevo Brewery Tour', 'Take a tour of a local brewery and taste traditional Bosnian beer.', 10, 90, 4),
    --Skips to Sofia 21
    ('Alexander Nevsky Cathedral', 'Visit the iconic cathedral, a symbol of Sofia.', 0, 60, 5),
    ('Vitosha Mountain', 'Hike or ski in the stunning Vitosha Mountain near Sofia.', 0, 240, 5),
    ('National Palace of Culture', 'Explore the cultural hub with events and exhibitions.', 3, 120, 5),
    ('Sofia Central Market Hall', 'Experience the vibrant atmosphere of the local market.', 0, 90, 5),
    ('Ivan Vazov National Theater', 'Attend a performance at Bulgaria''s national theater.', 10, 120, 5),
    ('Sofia History Museum', 'Discover the history of Sofia through various exhibits.', 5, 90, 5),
    ('Banya Bashi Mosque', 'Visit the historical mosque dating back to the 16th century.', 0, 45, 5),
    ('Saint Sofia Church', 'Explore the ancient church from the 6th century.', 0, 30, 5),
    ('National Art Gallery', 'Admire Bulgarian art in the national gallery.', 4, 120, 5),
    ('Sofia Zoo', 'Enjoy a day exploring the zoo with various animal species.', 2, 180, 5),
    --Skips to Athens 41
    ('Acropolis', 'Explore the ancient citadel and Parthenon atop the hill.', 20, 120, 6),
    ('Parthenon Museum', 'Visit the museum showcasing artifacts from the Acropolis.', 10, 90, 6),
    ('Plaka District', 'Stroll through the historic neighborhood with shops and tavernas.', 0, 180, 6),
    ('Temple of Olympian Zeus', 'See the ruins of the ancient temple dedicated to Zeus.', 8, 60, 6),
    ('National Archaeological Museum', 'Explore Greece''s largest archaeological museum.', 12, 180, 6),
    ('Mount Lycabettus', 'Hike or take a funicular to the summit for panoramic views.', 0, 90, 6),
    ('Ancient Agora of Athens', 'Visit the historical site that served as a marketplace.', 8, 120, 6),
    ('Syntagma Square', 'Experience the heart of Athens with its historical significance.', 0, 60, 6),
    ('Benaki Museum', 'Explore art and artifacts spanning Greek history.', 8, 90, 6),
    ('Athens Street Food Tour', 'Taste traditional Greek cuisine on a guided food tour.', 25, 180, 6),
    ('Cape Sounion', 'Visit the Temple of Poseidon for sunset views over the Aegean Sea.', 15, 180, 6),
    ('Panathenaic Stadium', 'Explore the historic stadium that hosted the first modern Olympics.', 5, 60, 6),
    ('Byzantine and Christian Museum', 'Discover Byzantine and Christian artifacts and art.', 8, 90, 6),
    ('Hellenic Motor Museum', 'Explore a collection of vintage and modern cars.', 10, 120, 6),
    ('Gazi Technopolis', 'Experience cultural events and exhibitions in a former gasworks complex.', 0, 120, 6),
    ('Athens War Museum', 'Learn about Greece''s military history through exhibits.', 6, 90, 6),
    ('Filopappou Hill', 'Hike to enjoy panoramic views of Athens and the Acropolis.', 0, 90, 6);


