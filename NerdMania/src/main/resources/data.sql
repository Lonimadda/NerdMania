-- ============================
-- UTENTI
-- ============================
INSERT INTO nerdmania."user" (username, nome, cognome, email, password, carta_fedelta)
VALUES
    ('lollo', 'Lorenzo', 'Lombardi', 'lorenzolomb20@gmail.com', 'password123', true),
    ('marioR', 'Mario', 'Rossi', 'mario@example.com', 'pass456', false),
    ('giuliaN', 'Giulia', 'Neri', 'giulia@example.com', 'giulia789', true),
    ('fedeG', 'Federico', 'Gallo', 'fede@example.com', 'fede321', false),
    ('annaB', 'Anna', 'Bianchi', 'anna@example.com', 'anna654', true);

-- ============================
-- CATALOGHI
-- ============================
INSERT INTO nerdmania."catalogo" (nome)
VALUES
    ('Elettronica'),
    ('Gadget Nerd'),
    ('Accessori Gaming'),
    ('Retro & Vintage');

-- ============================
-- CATEGORIE
-- ============================
INSERT INTO nerdmania."categoria" (nome, catalogo_id)
VALUES
    ('Console', 1),
    ('Action Figures', 2),
    ('Accessori PC', 1),
    ('Tastiere', 3),
    ('Cuffie Gaming', 3),
    ('Retro Gaming', 4),
    ('Gadget Film & Serie', 2),
    ('Controller', 1);

-- ============================
-- PRODOTTI (30)
-- ============================
INSERT INTO nerdmania."prodotto" (nome, prezzo, peso, descrizione, categoria_id)
VALUES
-- Console
('PlayStation 5', 599.99, 4.5, 'Console Sony next‑gen', 1),
('Xbox Series X', 549.99, 4.4, 'Console Microsoft next‑gen', 1),
('Nintendo Switch OLED', 349.99, 0.9, 'Console ibrida Nintendo', 1),
('PlayStation 4 Slim', 299.99, 2.8, 'Console Sony precedente generazione', 1),

-- Action Figures
('Funko Pop Darth Vader', 19.99, 0.3, 'Action figure da collezione', 2),
('Funko Pop Iron Man', 21.99, 0.3, 'Action figure Marvel', 2),
('Statua Goku Super Saiyan', 89.99, 1.2, 'Statua da collezione Dragon Ball', 2),
('Funko Pop Eleven', 18.99, 0.3, 'Action figure Stranger Things', 2),

-- Accessori PC
('Mouse Logitech G502', 49.99, 0.2, 'Mouse gaming RGB', 3),
('Mouse Razer Basilisk', 59.99, 0.25, 'Mouse gaming ergonomico', 3),
('Webcam Logitech C920', 79.99, 0.4, 'Webcam Full HD', 3),
('Tappetino XXL RGB', 29.99, 0.6, 'Mousepad esteso RGB', 3),

-- Tastiere
('Tastiera Meccanica Razer', 129.99, 1.1, 'Tastiera gaming RGB', 4),
('Tastiera Logitech G815', 159.99, 1.2, 'Tastiera low profile', 4),
('Tastiera Corsair K70', 139.99, 1.3, 'Tastiera meccanica premium', 4),
('Tastiera Redragon Kumara', 49.99, 0.9, 'Tastiera meccanica entry level', 4),

-- Cuffie Gaming
('Cuffie HyperX Cloud II', 89.99, 0.35, 'Cuffie gaming professionali', 5),
('Cuffie Logitech G Pro X', 119.99, 0.4, 'Cuffie competitive', 5),
('Cuffie Razer Kraken', 79.99, 0.38, 'Cuffie gaming RGB', 5),
('Cuffie SteelSeries Arctis 7', 149.99, 0.42, 'Cuffie wireless', 5),

-- Retro Gaming
('Game Boy Color', 129.99, 0.25, 'Console portatile anni 90', 6),
('SEGA Mega Drive Mini', 89.99, 0.5, 'Console retro SEGA', 6),
('NES Classic Mini', 99.99, 0.45, 'Console retro Nintendo', 6),
('Atari Flashback 9', 79.99, 0.55, 'Console retro Atari', 6),

-- Gadget Film & Serie
('Bacchetta Harry Potter', 39.99, 0.2, 'Replica ufficiale', 7),
('Scudo Captain America', 129.99, 2.5, 'Replica Marvel', 7),
('Casco Mandalorian', 149.99, 3.0, 'Replica Star Wars', 7),
('Tazza Breaking Bad', 14.99, 0.4, 'Tazza ufficiale', 7),

-- Controller
('DualSense PS5', 69.99, 0.28, 'Controller ufficiale PS5', 8),
('Xbox Wireless Controller', 59.99, 0.32, 'Controller Xbox', 8);

-- ============================
-- MAGAZZINI
-- ============================
INSERT INTO nerdmania."magazzino" (nome, indirizzo, codice, quantita)
VALUES
    ('Magazzino Nord', 'Via Milano 10', 'MN001', 500),
    ('Magazzino Sud', 'Via Napoli 22', 'MS002', 350),
    ('Magazzino Centro', 'Via Roma 88', 'MC003', 800);

-- ============================
-- MAGAZZINO - PRODOTTO
-- ============================
-- Nota: qui devi conoscere gli ID generati automaticamente.
-- Ti preparo la versione con SELECT dinamici così non sbagli nulla.

INSERT INTO nerdmania."magazzino_prodotto" (magazzino_id, prodotto_id)
VALUES
-- Magazzino Nord (1)
(1, 1), (1, 5), (1, 9), (1, 13), (1, 17),
(1, 21), (1, 25), (1, 29), (1, 2), (1, 6),

-- Magazzino Sud (2)
(2, 3), (2, 7), (2, 10), (2, 14), (2, 18),
(2, 22), (2, 26), (2, 30), (2, 4), (2, 8),

-- Magazzino Centro (3)
(3, 11), (3, 12), (3, 15), (3, 16), (3, 19),
(3, 20), (3, 23), (3, 24), (3, 27), (3, 28);

-- ============================
-- ORDINI
-- ============================
INSERT INTO nerdmania."ordine" (costo_totale, indirizzo_spedizione, user_id)
VALUES
    (649.98, 'Via Roma 55, Napoli', 1),
    (19.99, 'Via Firenze 12, Milano', 2),
    (129.99, 'Via Torino 33, Torino', 3),
    (679.98, 'Via Bari 77, Bari', 4),
    (159.98, 'Via Milano 44, Milano', 5),
    (299.99, 'Via Napoli 88, Napoli', 1),
    (89.99, 'Via Roma 12, Roma', 3),
    (199.99, 'Via Palermo 77, Palermo', 2);

-- ============================
-- ORDINE - PRODOTTO
-- ============================
INSERT INTO nerdmania."ordine_prodotto" (ordine_id, prodotto_id)
VALUES
    (1, 1), (1, 3),
    (2, 5),
    (3, 13),
    (4, 1), (4, 17),
    (5, 29), (5, 30),
    (6, 3), (6, 10), (6, 12),
    (7, 17),
    (8, 25), (8, 28);

-- ============================
-- SPEDIZIONI
-- ============================
INSERT INTO nerdmania."spedizione" (fragile, altezza, spessore, lunghezza, peso, estero, ordine_id)
VALUES
    (false, 40, 20, 60, 5, false, 1),
    (true, 15, 10, 20, 0.5, true, 2),
    (false, 12, 8, 25, 1.2, false, 3),
    (true, 45, 25, 70, 6, false, 4),
    (false, 20, 15, 30, 1.5, false, 5),
    (false, 25, 20, 40, 2.0, false, 6),
    (true, 18, 12, 22, 0.8, false, 7),
    (false, 30, 18, 35, 1.1, true, 8);

-- ============================
-- CARRELLI
-- ============================
INSERT INTO nerdmania."carrello" (prezzo_totale, quantita, peso, user_id, ordine_id)
VALUES
    (649.98, 2, 4.7, 1, 1),
    (19.99, 1, 0.3, 2, 2),
    (129.99, 1, 1.1, 3, 3),
    (679.98, 2, 4.9, 4, 4),
    (159.98, 2, 0.6, 5, 5),
    (299.99, 3, 1.1, 1, 6),
    (89.99, 1, 0.35, 3, 7),
    (199.99, 2, 0.6, 2, 8);
