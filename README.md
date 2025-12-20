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
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example
│   │   │       ├── config          # 配置类
│   │   │       ├── controller      # 控制器
│   │   │       ├── service         # 服务层接口
│   │   │       ├── service.impl    # 服务层实现
│   │   │       ├── mapper          # 数据访问层
│   │   │       ├── entity          # 实体类
│   │   │       ├── dto             # 数据传输对象
│   │   │       ├── common          # 公共类
│   │   │       └── utils           # 工具类
│   │   └── resources
│   │       ├── mapper              # MyBatis映射文件
│   │       ├── db                  # 数据库脚本
│   │       └── application.yml     # 配置文件
└── pom.xml                         # Maven配置文件
```

## 数据库设计

系统包含以下核心数据表：
1. 商品表（product）
2. 用户表（user）
3. 订单表（order）
4. 订单项表（order_item）

## 快速开始

1. 确保已安装JDK 17、MySQL 8、Redis
2. 执行`src/main/resources/db/schema.sql`创建数据库和表
3. 修改`application.yml`中的数据库和Redis连接配置
4. 使用Maven构建项目：`mvn clean install`
5. 运行项目：`mvn spring-boot:run`
6. 访问API文档：http://localhost:8080/doc.html

## API文档

项目集成Knife4j，提供在线API文档和测试功能。
访问地址：http://localhost:8080/doc.html
默认账号：admin
默认密码：admin123