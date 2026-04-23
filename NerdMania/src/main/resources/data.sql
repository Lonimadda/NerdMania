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
INSERT INTO nerdmania."prodotto"
(
    nome,
    prezzo,
    peso,
    descrizione,
    categoria_id,
    immagine_url,
    altezza,
    spessore,
    lunghezza,
    fragile
)
VALUES
-- Console
('PlayStation 5', 599.99, 4.5, 'Console Sony next-gen', 1, 'https://ricondizionati.mediaworld.it/dw/image/v2/BJRJ_PRD/on/demandware.static/-/Sites-mw-refurbished-catalog-master/default/dw7525b7ce/images/hi-res/401535.jpg?sw=1000&sh=1000', 39.0, 10.4, 26.0, true),
('Xbox Series X', 549.99, 4.4, 'Console Microsoft next-gen', 1, 'https://cms-assets.xboxservices.com/assets/f0/8d/f08dfa50-f2ef-4873-bc8f-bcb6c34e48c0.png?n=642227_Hero-Gallery-0_C2_857x676.png', 30.1, 15.1, 15.1, true),
('Nintendo Switch OLED', 349.99, 0.9, 'Console ibrida Nintendo', 1, 'https://www.hidrobrico.it/10241-home_default/nintendo-switch-oled-178-cm-7-64-gb-wi-fi-bianco-10007454-console.jpg', 10.2, 1.4, 24.2, true),
('PlayStation 4 Slim', 299.99, 2.8, 'Console Sony precedente generazione', 1, 'https://clickstorei.com/20400-large_default/sony-playstation-4-slim-console-ps4-500gb-dualshock-come-nuova.jpg', 26.5, 3.9, 28.8, true),

-- Action Figures
('Funko Pop Darth Vader', 19.99, 0.3, 'Action figure da collezione', 2, 'https://m.media-amazon.com/images/I/61s6vlqz-LL._AC_UF1000,1000_QL80_.jpg', 16.0, 9.5, 11.5, true),
('Funko Pop Iron Man', 21.99, 0.3, 'Action figure Marvel', 2, 'https://fantasiastore.it/37567-large_default/funko-pop-games-626-iron-man-avengers.jpg', 16.0, 9.5, 11.5, true),
('Statua Goku Super Saiyan', 89.99, 1.2, 'Statua da collezione Dragon Ball', 2, 'https://www.kaioland.com/wp-content/uploads/2023/09/WechatIMG567__45152-jpg.webp', 28.0, 14.0, 18.0, true),
('Funko Pop Eleven', 18.99, 0.3, 'Action figure Stranger Things', 2, 'https://m.media-amazon.com/images/I/81Xrw7HMKvL.jpg', 16.0, 9.5, 11.5, true),

-- Accessori PC
('Mouse Logitech G502', 49.99, 0.2, 'Mouse gaming RGB', 3, 'https://data.clickforshop.it/imgprodotto/logitech-910-005471-g502-hero-mouse-gaming-16000-dpi-colore-nero_350093_zoom.jpg', 4.0, 7.5, 13.2, true),
('Mouse Razer Basilisk', 59.99, 0.25, 'Mouse gaming ergonomico', 3, 'https://assets2.razerzone.com/images/pnx.assets/a757557a2f7ed514f8963043399f18eb/razer-basilisk-v3-35k-448x700.webp', 4.3, 7.5, 13.0, true),
('Webcam Logitech C920', 79.99, 0.4, 'Webcam Full HD', 3, 'https://m.media-amazon.com/images/I/61ECZFu1fRL.jpg', 4.3, 7.1, 9.4, true),
('Tappetino XXL RGB', 29.99, 0.6, 'Mousepad esteso RGB', 3, 'https://m.media-amazon.com/images/I/61Eu-q3pFCL._AC_UF1000,1000_QL80_.jpg', 0.4, 30.0, 80.0, false),

-- Tastiere
('Tastiera Meccanica Razer', 129.99, 1.1, 'Tastiera gaming RGB', 4, 'https://m.media-amazon.com/images/I/61t82j0TmXL._AC_UF1000,1000_QL80_.jpg', 4.0, 14.0, 44.0, true),
('Tastiera Logitech G815', 159.99, 1.2, 'Tastiera low profile', 4, 'https://m.media-amazon.com/images/I/61V+UuxZloL._AC_UF1000,1000_QL80_.jpg', 2.2, 15.0, 47.0, true),
('Tastiera Corsair K70', 139.99, 1.3, 'Tastiera meccanica premium', 4, 'https://assets.corsair.com/image/upload/c_pad,q_85,h_1100,w_1100,f_auto/products/Gaming-Keyboards/base-k70-core-tkl-wireless-config/gallery/CH-914901E-NA/K70_CORE_TKL_WIRELESS_01.webp', 4.0, 16.5, 44.0, true),
('Tastiera Redragon Kumara', 49.99, 0.9, 'Tastiera meccanica entry level', 4, 'https://m.media-amazon.com/images/I/71lQnVCMmXL.jpg', 3.8, 13.5, 36.0, true),

-- Cuffie Gaming
('Cuffie HyperX Cloud II', 89.99, 0.35, 'Cuffie gaming professionali', 5, 'https://m.media-amazon.com/images/I/71ltsViEA8L._AC_UF1000,1000_QL80_.jpg', 18.0, 9.5, 20.0, true),
('Cuffie Logitech G Pro X', 119.99, 0.4, 'Cuffie competitive', 5, 'https://m.media-amazon.com/images/I/61lHMzMOazL.jpg', 19.0, 9.5, 20.0, true),
('Cuffie Razer Kraken', 79.99, 0.38, 'Cuffie gaming RGB', 5, 'https://assets.mmsrg.com/isr/166325/c1/-/ASSET_MP_144425437?x=536&y=402&format=jpg&quality=80&sp=yes&strip=yes&trim&ex=536&ey=402&align=center&resizesource&unsharp=1.5x1+0.7+0.02&cox=0&coy=0&cdx=536&cdy=402', 20.0, 10.0, 19.0, true),
('Cuffie SteelSeries Arctis 7', 149.99, 0.42, 'Cuffie wireless', 5, 'https://m.media-amazon.com/images/I/71W0f+JzO2L._AC_UF1000,1000_QL80_.jpg', 19.5, 9.8, 20.5, true),

-- Retro Gaming
('Game Boy Color', 129.99, 0.25, 'Console portatile anni 90', 6, 'https://m.media-amazon.com/images/I/71YDNC98aaL._AC_UF894,1000_QL80_.jpg', 13.3, 2.7, 7.8, true),
('SEGA Mega Drive Mini', 89.99, 0.5, 'Console retro SEGA', 6, 'https://m.media-amazon.com/images/I/71jz2UF7LsS.jpg', 3.9, 11.6, 15.4, true),
('NES Classic Mini', 99.99, 0.45, 'Console retro Nintendo', 6, 'https://m.media-amazon.com/images/I/71GIan4mDmL.jpg', 4.0, 13.0, 14.0, true),
('Atari Flashback 9', 79.99, 0.55, 'Console retro Atari', 6, 'https://m.media-amazon.com/images/I/71AJpM2yYsL.jpg', 5.0, 14.0, 18.0, true),

-- Gadget Film & Serie
('Bacchetta Harry Potter', 39.99, 0.2, 'Replica ufficiale', 7, 'https://m.media-amazon.com/images/I/31MNT3D8XVL._AC_UF1000,1000_QL80_.jpg', 2.0, 2.0, 35.0, true),
('Scudo Captain America', 129.99, 2.5, 'Replica Marvel', 7, 'https://m.media-amazon.com/images/I/71ucm3s2iwL.jpg', 8.0, 45.0, 45.0, true),
('Casco Mandalorian', 149.99, 3.0, 'Replica Star Wars', 7, 'https://cdn.1001hobbies.it/2474887-large_default/hasbro-hasf0493-casco-elettronico-star-wars-the-mandalorian-black-seri.jpg', 28.0, 25.0, 30.0, true),
('Tazza Breaking Bad', 14.99, 0.4, 'Tazza ufficiale', 7, 'https://img.oggettifantastici.com/2024/12/x_lgs-6832615000.jpg', 9.5, 8.0, 12.0, true),

-- Controller
('DualSense PS5', 69.99, 0.28, 'Controller ufficiale PS5', 8, 'https://m.media-amazon.com/images/I/61tpbGZhxBL.jpg', 6.6, 10.6, 16.0, true),
('Xbox Wireless Controller', 59.99, 0.32, 'Controller Xbox', 8, 'https://m.media-amazon.com/images/I/613KEfta+5L._AC_UF350,350_QL80_.jpg', 7.0, 11.0, 15.5, true);-- ============================
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
INSERT INTO nerdmania."spedizione" (fragile, altezza, spessore, lunghezza, peso, ordine_id)
VALUES
    (false, 40, 20, 60, 5,  1),
    (true, 15, 10, 20, 0.5, 2),
    (false, 12, 8, 25, 1.2,  3),
    (true, 45, 25, 70, 6,  4),
    (false, 20, 15, 30, 1.5,  5),
    (false, 25, 20, 40, 2.0, 6),
    (true, 18, 12, 22, 0.8,  7),
    (false, 30, 18, 35, 1.1,  8);


