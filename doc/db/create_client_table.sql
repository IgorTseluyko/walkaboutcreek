CREATE TABLE hotel.public.client (
  id                BIGINT PRIMARY KEY,
  name              CHARACTER VARYING(254) NOT NULL,
  phone             CHARACTER VARYING(254) NOT NULL,
  visits_count      BIGINT,
  date_of_last_visit TIMESTAMP WITHOUT TIME ZONE,
  money_spent       BIGINT,
  transport_type    CHARACTER VARYING(254),
  description       CHARACTER VARYING(5000),
  CONSTRAINT client_phone_key UNIQUE (phone),
  CONSTRAINT client_const_key FOREIGN KEY (id)
  REFERENCES hotel.public.user (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);