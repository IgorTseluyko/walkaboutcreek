CREATE TABLE hotel.public.user (
  id                   BIGSERIAL PRIMARY KEY,
  email                CHARACTER VARYING(254) NOT NULL,
  password             CHARACTER VARYING(254) NOT NULL,
  last_login           TIMESTAMP WITHOUT TIME ZONE,
  last_password_change TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT user_email_key UNIQUE (email)
);