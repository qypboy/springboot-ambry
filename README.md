# 门窗橱柜定制商城系统

## 项目介绍

门窗橱柜定制商城系统是一个针对门窗、橱柜、配件、玻璃定制行业的数字化管理系统，集后台管理和用户下单于一体。系统解决了传统业务中人工记录订单、手动翻账算账、统计困难等痛点问题。

## 技术栈

- 后端框架: Spring Boot 3.1.5 (JDK 17)
- 数据库: MySQL 8
- ORM框架: MyBatis Plus 3.5.4.1
- 连接池: Druid 1.2.20
- 缓存: Redis
- API文档: Knife4j 4.3.0
- 工具类: Lombok, Fastjson2

## 功能模块

### 后台管理功能
1. 商品管理（门窗、橱柜、配件、玻璃等分类）
2. 订单管理
3. 用户管理
4. 数据统计与报表

### 用户端功能
1. 商品浏览与搜索
2. 购物车管理
3. 在线下单
4. 订单查询
5. 个人中心

## 系统架构

```
door-window-cabinet-mall
├── pom.xml                         # Maven父工程
├── ambry-common                    # 实体、请求、返回、枚举、工具类、统一返回、异常
├── ambry-config                    # 权限、Redis、MySQL、MyBatis、文件、跨域、Knife4j配置
├── ambry-integration               # 第三方系统对接、Feign Client、Feign拦截器
├── ambry-business                  # Controller、Manager、Service、Mapper、mapper.xml
└── ambry-admin                     # 启动模块、application.yml、数据库初始化脚本
```

当前后端仓库不包含前端代码，前端作为独立项目通过 REST API 访问后端。

### 模块说明

- `ambry-common`：统一存放实体、请求对象、返回对象、分页模型、用户上下文、枚举、常量、工具类、统一返回和业务异常，不使用 `dto`、`vo` 包名；表实体统一以 `Entity` 结尾。
- `ambry-config`：统一存放全局配置，包括 MyBatis Plus、Mapper 扫描、分页插件、BaseEntity 自动填充、跨域、文件上传、JWT、角色权限拦截器、Knife4j 和全局异常。
- `ambry-integration`：统一存放第三方系统对接能力，例如 Feign Client、Feign 请求拦截器、短信/支付/物流等外部接口。
- `ambry-business`：按 `controller -> manager -> service -> mapper` 分层。Controller 只调用 Manager，Service 基于 MyBatis Plus `IService/ServiceImpl`，Mapper XML 放在本模块 `src/main/resources/mapper/**`。
- `ambry-admin`：只负责启动和装配，包含 `AmbryAdminApplication`、`application.yml` 和 `db/schema.sql`、`db/data-dict.sql`、`db/data-region.sql`。

### 基础实体字段

所有表实体继承 `BaseEntity`，包含：

- `id`
- `deleted`
- `createBy`
- `createByNo`
- `createTime`
- `updateBy`
- `updateTime`

`ambry-config` 中的 MyBatis Plus 自动填充处理器会在新增和更新时写入这些审计字段。

## 数据库设计

系统包含以下核心数据表：
1. 中国区域表（sys_region），支持省、市、区县、镇街、村
2. 字典类型表（sys_dict_type）
3. 字典项表（sys_dict_item）
4. 商品表（goods）
5. 系统角色表（sys_role）
6. 系统用户表（sys_user）
7. 订单表（mall_order）
8. 订单项表（mall_order_item）

## 快速开始

1. 确保已安装JDK 17、MySQL 8、Redis
2. 依次执行`ambry-admin/src/main/resources/db/schema.sql`、`data-dict.sql`、`data-region.sql`创建表和初始化基础数据
3. 修改`ambry-admin/src/main/resources/application.yml`中的数据库和Redis连接配置
4. 使用Maven构建项目：`mvn clean install`
5. 运行项目：`mvn -pl ambry-admin spring-boot:run`
6. 访问API文档：http://localhost:8080/doc.html

## API文档

项目集成Knife4j，提供在线API文档和测试功能。
访问地址：http://localhost:8080/doc.html
默认账号：admin
默认密码：admin123