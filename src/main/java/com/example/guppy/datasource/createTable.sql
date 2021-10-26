CREATE TABLE guppy (
    id INT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(100),
    image VARCHAR(100),
    price FLOAT,
    sale FLOAT,
    status BOOLEAN,
    PRIMARY Key (id)
);
CREATE TABLE images (
    id INT UNSIGNED AUTO_INCREMENT,
    url VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE videos (
    id INT UNSIGNED AUTO_INCREMENT,
    url VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE guppy_more_detail (
    id_guppy INT UNSIGNED NOT NULL,
    quantity INT DEFAULT(0),
    _describe TEXT,
    fOREIGN KEY (id_guppy) REFERENCES guppy(id)
);
CREATE TABLE guppy_detail (
    id_guppy INT UNSIGNED NOT NULL,
    id_image INT UNSIGNED NOT NULL,
    id_video INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_guppy) REFERENCES guppy(id),
    FOREIGN KEY (id_image) REFERENCES images(id),
    FOREIGN KEY (id_video) REFERENCES videos(id)
);