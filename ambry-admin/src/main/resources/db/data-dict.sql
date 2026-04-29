USE door_window_cabinet_mall;

INSERT INTO sys_dict_type(dict_code, dict_name_i18n_key, status, remark) VALUES
('goods_type', 'dict.type.goods_type', 1, '门窗橱柜玻璃配件'),
('material_type', 'dict.type.material_type', 1, '材质维护'),
('glass_type', 'dict.type.glass_type', 1, '玻璃配置'),
('order_status', 'dict.type.order_status', 1, '订单流转状态')
ON DUPLICATE KEY UPDATE dict_name_i18n_key = VALUES(dict_name_i18n_key);

INSERT INTO sys_dict_item(dict_code, item_value, item_label_i18n_key, sort, status, remark) VALUES
('goods_type', 'WINDOW', 'dict.item.goods_type.WINDOW', 1, 1, NULL),
('goods_type', 'CABINET', 'dict.item.goods_type.CABINET', 2, 1, NULL),
('goods_type', 'GLASS', 'dict.item.goods_type.GLASS', 3, 1, NULL),
('goods_type', 'ACCESSORY', 'dict.item.goods_type.ACCESSORY', 4, 1, NULL),
('material_type', 'BROKEN_BRIDGE_ALUMINUM', 'dict.item.material_type.BROKEN_BRIDGE_ALUMINUM', 1, 1, NULL),
('material_type', 'SOLID_WOOD', 'dict.item.material_type.SOLID_WOOD', 2, 1, NULL),
('glass_type', 'DOUBLE_TEMPERED', 'dict.item.glass_type.DOUBLE_TEMPERED', 1, 1, NULL),
('order_status', 'WAIT_CONFIRM', 'dict.item.order_status.WAIT_CONFIRM', 1, 1, NULL),
('order_status', 'WAIT_PAY', 'dict.item.order_status.WAIT_PAY', 2, 1, NULL),
('order_status', 'PRODUCING', 'dict.item.order_status.PRODUCING', 3, 1, NULL),
('order_status', 'COMPLETED', 'dict.item.order_status.COMPLETED', 4, 1, NULL)
ON DUPLICATE KEY UPDATE item_label_i18n_key = VALUES(item_label_i18n_key), sort = VALUES(sort), status = VALUES(status);

INSERT INTO sys_role(role_code, role_name_i18n_key, sort, enabled, remark) VALUES
('SUPER_ADMIN', 'role.SUPER_ADMIN', 1, 1, '系统管理员'),
('SALES', 'role.SALES', 2, 1, '销售人员'),
('MEMBER', 'role.MEMBER', 3, 1, '商城会员')
ON DUPLICATE KEY UPDATE role_name_i18n_key = VALUES(role_name_i18n_key), sort = VALUES(sort), enabled = VALUES(enabled);

INSERT INTO sys_user(username, password, phone, address, enabled) VALUES
('admin', 'admin123', NULL, NULL, 1),
('sales', 'sales123', NULL, NULL, 1),
('member', 'member123', NULL, NULL, 1)
ON DUPLICATE KEY UPDATE enabled = VALUES(enabled);

INSERT INTO sys_menu(menu_code, menu_name_i18n_key, parent_code, permission_code, route_path, component_path, menu_type, sort, enabled, remark) VALUES
('SYS_MGMT', 'menu.SYS_MGMT', 'ROOT', NULL, '/system', 'layout/system', 'CATALOG', 1, 1, '系统管理'),
('SYS_DICT', 'menu.SYS_DICT', 'SYS_MGMT', 'system:dict:write', '/system/dict', 'system/dict/index', 'MENU', 10, 1, '字典管理'),
('GOODS_MGMT', 'menu.GOODS_MGMT', 'ROOT', NULL, '/goods', 'layout/goods', 'CATALOG', 2, 1, '商品管理'),
('GOODS_SAVE', 'menu.GOODS_SAVE', 'GOODS_MGMT', 'goods:save', '/goods/save', 'goods/save/index', 'MENU', 10, 1, '商品保存')
ON DUPLICATE KEY UPDATE menu_name_i18n_key = VALUES(menu_name_i18n_key), permission_code = VALUES(permission_code), enabled = VALUES(enabled);

INSERT INTO sys_user_role(user_id, role_code)
SELECT u.id, 'SUPER_ADMIN' FROM sys_user u WHERE u.username = 'admin'
ON DUPLICATE KEY UPDATE role_code = VALUES(role_code);
INSERT INTO sys_user_role(user_id, role_code)
SELECT u.id, 'SALES' FROM sys_user u WHERE u.username = 'sales'
ON DUPLICATE KEY UPDATE role_code = VALUES(role_code);
INSERT INTO sys_user_role(user_id, role_code)
SELECT u.id, 'MEMBER' FROM sys_user u WHERE u.username = 'member'
ON DUPLICATE KEY UPDATE role_code = VALUES(role_code);

INSERT INTO sys_role_menu(role_code, menu_code) VALUES
('SUPER_ADMIN', 'SYS_DICT'),
('SUPER_ADMIN', 'GOODS_SAVE'),
('SALES', 'GOODS_SAVE')
ON DUPLICATE KEY UPDATE menu_code = VALUES(menu_code);

INSERT INTO base_i18n(i18n_key, locale, i18n_value, remark) VALUES
('dict.type.goods_type', 'zh_CN', '商品类型', '字典类型'),
('dict.type.goods_type', 'en', 'Goods Type', 'dictionary type'),
('dict.type.material_type', 'zh_CN', '材质类型', '字典类型'),
('dict.type.material_type', 'en', 'Material Type', 'dictionary type'),
('dict.type.glass_type', 'zh_CN', '玻璃类型', '字典类型'),
('dict.type.glass_type', 'en', 'Glass Type', 'dictionary type'),
('dict.type.order_status', 'zh_CN', '订单状态', '字典类型'),
('dict.type.order_status', 'en', 'Order Status', 'dictionary type'),
('dict.item.goods_type.WINDOW', 'zh_CN', '门窗', '字典项'),
('dict.item.goods_type.WINDOW', 'en', 'Window', 'dictionary item'),
('dict.item.goods_type.CABINET', 'zh_CN', '橱柜', '字典项'),
('dict.item.goods_type.CABINET', 'en', 'Cabinet', 'dictionary item'),
('dict.item.goods_type.GLASS', 'zh_CN', '玻璃', '字典项'),
('dict.item.goods_type.GLASS', 'en', 'Glass', 'dictionary item'),
('dict.item.goods_type.ACCESSORY', 'zh_CN', '配件', '字典项'),
('dict.item.goods_type.ACCESSORY', 'en', 'Accessory', 'dictionary item'),
('role.SUPER_ADMIN', 'zh_CN', '超级管理员', '角色名称'),
('role.SUPER_ADMIN', 'en', 'Super Admin', 'role name'),
('role.SALES', 'zh_CN', '销售', '角色名称'),
('role.SALES', 'en', 'Sales', 'role name'),
('role.MEMBER', 'zh_CN', '会员', '角色名称'),
('role.MEMBER', 'en', 'Member', 'role name'),
('menu.SYS_MGMT', 'zh_CN', '系统管理', '菜单名称'),
('menu.SYS_MGMT', 'en', 'System', 'menu name'),
('menu.SYS_DICT', 'zh_CN', '字典管理', '菜单名称'),
('menu.SYS_DICT', 'en', 'Dictionary', 'menu name'),
('menu.GOODS_MGMT', 'zh_CN', '商品管理', '菜单名称'),
('menu.GOODS_MGMT', 'en', 'Goods', 'menu name'),
('menu.GOODS_SAVE', 'zh_CN', '新增商品', '菜单名称'),
('menu.GOODS_SAVE', 'en', 'Create Goods', 'menu name')
ON DUPLICATE KEY UPDATE i18n_value = VALUES(i18n_value);
