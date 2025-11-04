-- ---------- ROLE MASTER DATA ----------
INSERT INTO roles (id, name)
VALUES (1, 'ROLE_ADMIN')
ON DUPLICATE KEY UPDATE name = name;

INSERT INTO roles (id, name)
VALUES (2, 'ROLE_USER')
ON DUPLICATE KEY UPDATE name = name;


-- ---------- USERS ----------
-- username: admin / password: admin (plain text for demo)
INSERT INTO users (id, username, password, full_name)
VALUES (1, 'admin', 'admin', 'Administrator')
ON DUPLICATE KEY UPDATE username = username;


-- ---------- SENSORS ----------
INSERT INTO sensors (id, name, type, location, last_value)
VALUES 
  (1, 'Traffic Sensor A', 'traffic', 'Sector 1', 12.5),
  (2, 'Air Quality Sensor B', 'air-quality', 'Industrial Area', 62.0),
  (3, 'Water Flow Sensor C', 'water', 'River Side', 21.9)
ON DUPLICATE KEY UPDATE name = VALUES(name);


-- ---------- INCIDENTS ----------
INSERT INTO incidents (id, title, description, status, created_at, location)
VALUES 
  (1, 'Road Accident', 'Minor collision near Sector 5', 'NEW', NOW(), 'Sector 5'),
  (2, 'Air Quality Alert', 'PM2.5 exceeded safe limit', 'NEW', NOW(), 'Industrial Area')
ON DUPLICATE KEY UPDATE title = VALUES(title);
