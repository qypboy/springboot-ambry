CREATE DATABASE IF NOT EXISTS door_window_cabinet_mall DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE door_window_cabinet_mall;

CREATE TABLE IF NOT EXISTS sys_region (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  code VARCHAR(32) NOT NULL UNIQUE,
  parent_code VARCHAR(32) NOT NULL,
  name VARCHAR(128) NOT NULL,
  level VARCHAR(32) NOT NULL,
  full_name VARCHAR(512) NOT NULL,
  path VARCHAR(512) NOT NULL,
  sort INT NOT NULL DEFAULT 0,
  enabled TINYINT NOT NULL DEFAULT 1,
  source VARCHAR(64),
  version VARCHAR(32),
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  INDEX idx_region_parent(parent_code),
  INDEX idx_region_level(level)
) COMMENT='中国区域数据，支持省市区镇村';

CREATE TABLE IF NOT EXISTS sys_dict_type (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  dict_code VARCHAR(64) NOT NULL UNIQUE,
  dict_name_i18n_key VARCHAR(128) NOT NULL,
  status TINYINT NOT NULL DEFAULT 1,
  remark VARCHAR(255),
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0
) COMMENT='字典类型';

CREATE TABLE IF NOT EXISTS sys_dict_item (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  dict_code VARCHAR(64) NOT NULL,
  item_value VARCHAR(64) NOT NULL,
  item_label_i18n_key VARCHAR(128) NOT NULL,
  sort INT NOT NULL DEFAULT 0,
  status TINYINT NOT NULL DEFAULT 1,
  remark VARCHAR(255),
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  UNIQUE KEY uk_dict_item(dict_code, item_value)
) COMMENT='字典项';

CREATE TABLE IF NOT EXISTS sys_role (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  role_code VARCHAR(64) NOT NULL UNIQUE,
  role_name_i18n_key VARCHAR(128) NOT NULL,
  sort INT NOT NULL DEFAULT 0,
  enabled TINYINT NOT NULL DEFAULT 1,
  remark VARCHAR(255),
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0
) COMMENT='系统角色';

CREATE TABLE IF NOT EXISTS sys_user (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(64) NOT NULL UNIQUE,
  password VARCHAR(128) NOT NULL,
  phone VARCHAR(32),
  address VARCHAR(255),
  enabled TINYINT NOT NULL DEFAULT 1,
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0
) COMMENT='系统用户';

CREATE TABLE IF NOT EXISTS sys_menu (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  menu_code VARCHAR(64) NOT NULL UNIQUE,
  menu_name_i18n_key VARCHAR(128) NOT NULL,
  parent_code VARCHAR(64) NOT NULL DEFAULT 'ROOT',
  permission_code VARCHAR(128),
  route_path VARCHAR(255),
  component_path VARCHAR(255),
  icon VARCHAR(64),
  menu_type VARCHAR(32) NOT NULL DEFAULT 'MENU',
  sort INT NOT NULL DEFAULT 0,
  enabled TINYINT NOT NULL DEFAULT 1,
  remark VARCHAR(255),
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  INDEX idx_menu_parent(parent_code),
  INDEX idx_menu_permission(permission_code)
) COMMENT='系统菜单与权限点';

CREATE TABLE IF NOT EXISTS sys_user_role (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  role_code VARCHAR(64) NOT NULL,
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  UNIQUE KEY uk_user_role(user_id, role_code),
  INDEX idx_user_role_code(role_code)
) COMMENT='用户角色关系';

CREATE TABLE IF NOT EXISTS sys_role_menu (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  role_code VARCHAR(64) NOT NULL,
  menu_code VARCHAR(64) NOT NULL,
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  UNIQUE KEY uk_role_menu(role_code, menu_code),
  INDEX idx_role_menu_code(menu_code)
) COMMENT='角色菜单关系';

CREATE TABLE IF NOT EXISTS base_i18n (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  i18n_key VARCHAR(128) NOT NULL,
  locale VARCHAR(16) NOT NULL,
  i18n_value VARCHAR(255) NOT NULL,
  remark VARCHAR(255),
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  UNIQUE KEY uk_i18n_key_locale(i18n_key, locale)
) COMMENT='国际化文本表';

CREATE TABLE IF NOT EXISTS goods (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  category_code VARCHAR(64) NOT NULL,
  material_code VARCHAR(64),
  price DECIMAL(12,2) NOT NULL DEFAULT 0,
  stock INT NOT NULL DEFAULT 0,
  description TEXT,
  image_url VARCHAR(512),
  enabled TINYINT NOT NULL DEFAULT 1,
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  INDEX idx_goods_category(category_code)
) COMMENT='商品';

CREATE TABLE IF NOT EXISTS mall_order (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  order_no VARCHAR(64) NOT NULL UNIQUE,
  user_id BIGINT NOT NULL,
  total_amount DECIMAL(12,2) NOT NULL,
  status VARCHAR(32) NOT NULL,
  receiver_name VARCHAR(64) NOT NULL,
  receiver_phone VARCHAR(32) NOT NULL,
  receiver_region_code VARCHAR(32),
  receiver_region_name VARCHAR(512),
  receiver_address VARCHAR(255) NOT NULL,
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  INDEX idx_order_user(user_id),
  INDEX idx_order_status(status)
) COMMENT='订单';

CREATE TABLE IF NOT EXISTS mall_order_item (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  order_id BIGINT NOT NULL,
  goods_id BIGINT NOT NULL,
  goods_name VARCHAR(128) NOT NULL,
  price DECIMAL(12,2) NOT NULL,
  quantity INT NOT NULL,
  custom_options_json TEXT,
  create_by VARCHAR(64),
  create_by_no VARCHAR(64),
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_by VARCHAR(64),
  update_by_no VARCHAR(64),
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted INT NOT NULL DEFAULT 0,
  INDEX idx_order_item_order(order_id)
) COMMENT='订单明细快照';
