USE door_window_cabinet_mall;

INSERT INTO sys_region(code, parent_code, name, level, full_name, path, sort, enabled, source, version) VALUES
('440000', '0', '广东省', 'PROVINCE', '广东省', '440000', 1, 1, 'seed', '2026'),
('440100', '440000', '广州市', 'CITY', '广东省广州市', '440000/440100', 1, 1, 'seed', '2026'),
('440106', '440100', '天河区', 'DISTRICT', '广东省广州市天河区', '440000/440100/440106', 1, 1, 'seed', '2026'),
('440106001', '440106', '石牌街道', 'TOWN', '广东省广州市天河区石牌街道', '440000/440100/440106/440106001', 1, 1, 'seed', '2026'),
('440106001001', '440106001', '石牌村', 'VILLAGE', '广东省广州市天河区石牌街道石牌村', '440000/440100/440106/440106001/440106001001', 1, 1, 'seed', '2026')
ON DUPLICATE KEY UPDATE name = VALUES(name), full_name = VALUES(full_name), path = VALUES(path), version = VALUES(version);
