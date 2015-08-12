CREATE TABLE hotel.public.hotel (
  room_id    BIGINT PRIMARY KEY,
  hotel_id   BIGINT NOT NULL,
  client_id  BIGINT NOT NULL,
  start_date TIMESTAMP WITHOUT TIME ZONE,
  end_date   TIMESTAMP WITHOUT TIME ZONE,
  room_price BIGINT NOT NULL,
  CONSTRAINT files_const_key FOREIGN KEY (client_id)
  REFERENCES hotel.public.client (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);