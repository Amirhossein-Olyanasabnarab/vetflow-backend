CREATE TABLE owners (
                        id UUID PRIMARY KEY,
                        first_name VARCHAR(100) NOT NULL,
                        last_name VARCHAR(100) NOT NULL,
                        phone_number VARCHAR(30) NOT NULL,
                        email VARCHAR(255),
                        address VARCHAR(500),
                        created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_owners_phone_number ON owners (phone_number);

CREATE TABLE pets (
                      id UUID PRIMARY KEY,
                      owner_id UUID NOT NULL,
                      name VARCHAR(100) NOT NULL,
                      species VARCHAR(100) NOT NULL,
                      breed VARCHAR(100),
                      gender VARCHAR(20) NOT NULL DEFAULT 'UNKNOWN',
                      birth_date DATE,
                      weight_kg NUMERIC(6, 2),
                      microchip_number VARCHAR(100),
                      medical_notes TEXT,
                      created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,

                      CONSTRAINT fk_pets_owner
                          FOREIGN KEY (owner_id)
                              REFERENCES owners (id)
                              ON DELETE RESTRICT,

                      CONSTRAINT chk_pets_gender
                          CHECK (gender IN ('MALE', 'FEMALE', 'UNKNOWN')),

                      CONSTRAINT chk_pets_weight_kg
                          CHECK (weight_kg IS NULL OR weight_kg > 0)
);

CREATE INDEX idx_pets_owner_id ON pets (owner_id);

CREATE UNIQUE INDEX uq_pets_microchip_number
    ON pets (microchip_number)
    WHERE microchip_number IS NOT NULL;