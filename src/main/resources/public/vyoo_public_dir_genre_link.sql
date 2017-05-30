CREATE TABLE public.dir_genre_link
(
    dir_genre_pk integer DEFAULT nextval('dir_genre_link_dir_genre_pk_seq'::regclass) PRIMARY KEY NOT NULL,
    dir_fk integer,
    genre_fk integer,
    CONSTRAINT dir_genre_link_director_director_pk_fk FOREIGN KEY (dir_fk) REFERENCES director (director_pk),
    CONSTRAINT dir_genre_link_genre_genre_pk_fk FOREIGN KEY (genre_fk) REFERENCES genre (genre_pk)
);
CREATE UNIQUE INDEX dir_genre_link_dir_genre_pk_uindex ON public.dir_genre_link (dir_genre_pk);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (1, 1, 1);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (2, 1, 4);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (3, 1, 8);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (4, 1, 7);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (5, 2, 8);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (6, 2, 1);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (7, 2, 2);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (8, 3, 1);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (9, 3, 5);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (10, 3, 8);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (11, 4, 1);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (12, 4, 9);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (13, 4, 10);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (14, 5, 2);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (15, 5, 7);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (16, 6, 7);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (17, 7, 1);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (18, 7, 2);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (19, 7, 3);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (20, 8, 1);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (21, 8, 5);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (22, 9, 2);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (23, 9, 9);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (24, 10, 1);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (25, 10, 3);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (26, 10, 4);
INSERT INTO public.dir_genre_link (dir_genre_pk, dir_fk, genre_fk) VALUES (27, 10, 6);