USE door_window_cabinet_mall;

INSERT INTO sys_dict_type(dict_code, dict_name, status, remark) VALUES
('goods_type', '商品类型', 1, '门窗橱柜玻璃配件'),
('material_type', '材质类型', 1, '材质维护'),
('glass_type', '玻璃类型', 1, '玻璃配置'),
('order_status', '订单状态', 1, '订单流转状态')
ON DUPLICATE KEY UPDATE dict_name = VALUES(dict_name);

INSERT INTO sys_dict_item(dict_code, item_value, item_label, sort, status, remark) VALUES
('goods_type', 'WINDOW', '门窗', 1, 1, NULL),
('goods_type', 'CABINET', '橱柜', 2, 1, NULL),
('goods_type', 'GLASS', '玻璃', 3, 1, NULL),
('goods_type', 'ACCESSORY', '配件', 4, 1, NULL),
('material_type', 'BROKEN_BRIDGE_ALUMINUM', '断桥铝', 1, 1, NULL),
('material_type', 'SOLID_WOOD', '实木', 2, 1, NULL),
('glass_type', 'DOUBLE_TEMPERED', '双层钢化玻璃', 1, 1, NULL),
('order_status', 'WAIT_CONFIRM', '待确认', 1, 1, NULL),
('order_status', 'WAIT_PAY', '待付款', 2, 1, NULL),
('order_status', 'PRODUCING', '生产中', 3, 1, NULL),
('order_status', 'COMPLETED', '已完成', 4, 1, NULL)
ON DUPLICATE KEY UPDATE item_label = VALUES(item_label), sort = VALUES(sort), status = VALUES(status);
