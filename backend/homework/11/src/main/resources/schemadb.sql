
--shift_types:
---id : uuid
---uq_name : text
---description : text
---active : boolean
---created_at : utc time (DEFAULT now())
---updated_at : utc time (DEFAULT now())
---time_zone : character varying(32)
---tenant_id : uuid


--shifts:
---id : uuid
---shift_type_id : uuid
---name : varying(128)
---date_start : date
---date_end : date
---time_start : time(6) without time zone
---time_end : time(6) without time zone
---created_at : utc time (DEFAULT now())
---updated_at : utc time (DEFAULT now())
---time_zone : character varying(32)
---tenant_id : uuid


--users:
---id : uuid
---username : varying(32)
---loggedin : smallInt (DEFAULT 0)
---time_zone : character varying(32)
---tenant_id : uuid


--shift_user:
---id : uuid
---shift_id : uuid
---user_id : uuid
---tenant_id : uuid


-- Execution Statements:


CREATE TABLE tenants (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

INSERT INTO tenants (id, name, created_by, updated_by)
VALUES
('550e8400-e29b-41d4-a716-446655440000', 'Tenant A', 'Admin', 'Admin'),
('550e8400-e29b-41d4-a716-446655440001', 'Tenant B', 'Admin', 'Admin'),
('550e8400-e29b-41d4-a716-446655440002', 'Tenant C', 'Admin', 'Admin');



CREATE TABLE shift_types (
    id UUID PRIMARY KEY,
    uq_name TEXT,
    description TEXT,
    active BOOLEAN,
    time_zone VARCHAR(32),
    tenant_id UUID,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id)
);

INSERT INTO shift_types (id, uq_name, description, active, time_zone, tenant_id, created_by, updated_by)
VALUES
('550e8400-e29b-41d4-a716-446655440006', 'Morning', 'Morning Shift Type', true, 'UTC', '550e8400-e29b-41d4-a716-446655440000', 'Admin', 'Admin'),
('550e8400-e29b-41d4-a716-446655440007', 'Afternoon', 'Afternoon Shift Type', true, 'UTC', '550e8400-e29b-41d4-a716-446655440000', 'Admin', 'Admin'),
('550e8400-e29b-41d4-a716-446655440008', 'Evening', 'Evening Shift Type', true, 'UTC', '550e8400-e29b-41d4-a716-446655440000', 'Admin', 'Admin');

INSERT INTO shift_types (id, uq_name, description, active, time_zone, tenant_id, created_by, updated_by)
VALUES ('550e8400-e29b-41d4-a716-446655440002', 'Afternoon', 'Afternoon Shift Type', true, 'UTC', '550e8400-e29b-41d4-a716-446655440000', 'Admin', 'Admin');


CREATE TABLE shifts (
    id UUID PRIMARY KEY,
    shift_type_id UUID,
    name VARCHAR(128),
    start_date DATE,
    end_date DATE,
    start_time TIME WITHOUT TIME ZONE,
    end_time TIME WITHOUT TIME ZONE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_shift_type FOREIGN KEY (shift_type_id) REFERENCES shift_types(id)
);

INSERT INTO shifts (id, shift_type_id, name, start_date, end_date, start_time, end_time, created_by, updated_by)
VALUES
('550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440002', 'Morning Shift', '2024-02-04', '2024-02-04', '08:00:00', '12:00:00', 'Admin', 'Admin'),
('550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440002', 'Afternoon Shift', '2024-02-04', '2024-02-04', '12:00:00', '16:00:00', 'Admin', 'Admin'),
('550e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440002', 'Evening Shift', '2024-02-04', '2024-02-04', '16:00:00', '20:00:00', 'Admin', 'Admin');


CREATE TABLE users (
    id UUID PRIMARY KEY,
    user_name VARCHAR(32),
    logged_in SMALLINT DEFAULT 0,
    time_zone VARCHAR(32),
    tenant_id UUID,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id)
);

INSERT INTO users (id, user_name, logged_in, time_zone, tenant_id, created_by, updated_by)
VALUES
('550e8400-e29b-41d4-a716-446655440009', 'JohnDoe', 0, 'UTC', '550e8400-e29b-41d4-a716-446655440000', 'Admin', 'Admin'),
('550e8400-e29b-41d4-a716-446655440010', 'JaneDoe', 0, 'UTC', '550e8400-e29b-41d4-a716-446655440000', 'Admin', 'Admin'),
('550e8400-e29b-41d4-a716-446655440011', 'AliceSmith', 0, 'UTC', '550e8400-e29b-41d4-a716-446655440001', 'Admin', 'Admin');


CREATE TABLE shift_users (
    id UUID PRIMARY KEY,
    shift_id UUID,
    user_id UUID,
    tenant_id UUID,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_shift FOREIGN KEY (shift_id) REFERENCES shifts(id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id)
);

INSERT INTO shift_users (id, shift_id, user_id, tenant_id, created_by, updated_by)
VALUES
('550e8400-e29b-41d4-a716-446655440012', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440009', '550e8400-e29b-41d4-a716-446655440000', 'Admin', 'Admin');
