-- ============================
-- UTENTI
-- ============================
INSERT INTO nerdmania."user" (id, username, nome, cognome, email, password, carta_fedelta)
VALUES
    (1, 'lollo', 'Lorenzo', 'Lombardi', 'lorenzolomb20@gmail.com', 'password123', true),
    (2, 'marioR', 'Mario', 'Rossi', 'mario@example.com', 'pass456', false),
    (3, 'giuliaN', 'Giulia', 'Neri', 'giulia@example.com', 'giulia789', true),
    (4, 'fedeG', 'Federico', 'Gallo', 'fede@example.com', 'fede321', false),
    (5, 'annaB', 'Anna', 'Bianchi', 'anna@example.com', 'anna654', true);

-- ============================
-- CATALOGO
-- ============================
INSERT INTO nerdmania."catalogo" (id, nome)
VALUES
    (1, 'Elettronica'),
    (2, 'Gadget Nerd'),
    (3, 'Accessori Gaming');

-- ============================
-- CATEGORIE
-- ============================
INSERT INTO nerdmania."categoria" (id, nome, catalogo_id)
VALUES
    (1, 'Console', 1),
    (2, 'Action Figures', 2),
    (3, 'Accessori PC', 1),
    (4, 'Tastiere', 3),
    (5, 'Cuffie Gaming', 3),
    (6, 'Retro Gaming', 1);

-- ============================
-- PRODOTTI
-- ============================
INSERT INTO nerdmania."prodotto" (id, nome, prezzo, peso, descrizione, categoria_id)
VALUES
    (1, 'PlayStation 5', 599.99, 4.5, 'Console Sony next‑gen', 1),
    (2, 'Funko Pop Darth Vader', 19.99, 0.3, 'Action figure da collezione', 2),
    (3, 'Mouse Logitech G502', 49.99, 0.2, 'Mouse gaming RGB', 3),
    (4, 'Xbox Series X', 549.99, 4.4, 'Console Microsoft next‑gen', 1),
    (5, 'Nintendo Switch OLED', 349.99, 0.9, 'Console ibrida Nintendo', 1),
    (6, 'Funko Pop Iron Man', 21.99, 0.3, 'Action figure Marvel', 2),
    (7, 'Tastiera Meccanica Razer', 129.99, 1.1, 'Tastiera gaming RGB', 4),
    (8, 'Cuffie HyperX Cloud II', 89.99, 0.35, 'Cuffie gaming professionali', 5),
    (9, 'Game Boy Color', 129.99, 0.25, 'Console portatile anni 90', 6),
    (10, 'SEGA Mega Drive Mini', 89.99, 0.5, 'Console retro SEGA', 6);

-- ============================
-- MAGAZZINI
-- ============================
INSERT INTO nerdmania."magazzino" (id, nome, indirizzo, codice, quantita)
VALUES
    (1, 'Magazzino Nord', 'Via Milano 10', 'MN001', 300),
    (2, 'Magazzino Sud', 'Via Napoli 22', 'MS002', 150),
    (3, 'Magazzino Centro', 'Via Roma 88', 'MC003', 500);

-- ============================
-- MAGAZZINO - PRODOTTO
-- ============================
INSERT INTO nerdmania."magazzino_prodotto" (magazzino_id, prodotto_id)
VALUES
    (1, 1), (1, 3), (1, 7), (1, 8),
    (2, 2), (2, 3), (2, 5), (2, 6),
    (3, 4), (3, 9), (3, 10), (3, 1);

-- ============================
-- ORDINI
-- ============================
INSERT INTO nerdmania."ordine" (id, costo_totale, indirizzo_spedizione, user_id)
VALUES
    (1, 649.98, 'Via Roma 55, Napoli', 1),
    (2, 19.99, 'Via Firenze 12, Milano', 2),
    (3, 129.99, 'Via Torino 33, Torino', 3),
    (4, 679.98, 'Via Bari 77, Bari', 4);

-- ============================
-- ORDINE - PRODOTTO
-- ============================
INSERT INTO nerdmania."ordine_prodotto" (ordine_id, prodotto_id)
VALUES
    (1, 1), (1, 3),
    (2, 2),
    (3, 7),
    (4, 1), (4, 8);

-- ============================
-- SPEDIZIONI
-- ============================
INSERT INTO nerdmania."spedizione" (id, fragile, altezza, spessore, lunghezza, peso, estero, ordine_id)
VALUES
    (1, false, 40, 20, 60, 5, false, 1),
    (2, true, 15, 10, 20, 0.5, true, 2),
    (3, false, 12, 8, 25, 1.2, false, 3),
    (4, true, 45, 25, 70, 6, false, 4);

-- ============================
-- CARRELLI
-- ============================
INSERT INTO nerdmania."carrello" (id, prezzo_totale, quantita, peso, user_id, ordine_id)
VALUES
    (1, 649.98, 2, 4.7, 1, 1),
    (2, 19.99, 1, 0.3, 2, 2),
    (3, 129.99, 1, 1.1, 3, 3),
    (4, 679.98, 2, 4.9, 4, 4);