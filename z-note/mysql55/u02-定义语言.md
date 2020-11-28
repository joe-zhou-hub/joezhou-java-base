# 1. 数据定义语言

**概念：** 数据定义语言（DDL）负责操作数据库的元信息，如表，用户，列，索引等，例如CREATE、DROP、ALTER等语句都属于DDL的范围之内。

# 2. 用户操作

**概念：**
- 创建用户：`GRANT 权限列表 ON 数据库名.* TO '账号'@'IP' IDENTIFIED BY '密码'`
    - 用户和权限之间是多对多关系。
    - 本机IP建议使用localhost替代127.0.0.1。
    - 权限列表：SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, ALL等。
    - 创建用户后需要使用命令 `FLUSH PRIVILEGES` 来刷新权限操作。
- 查询用户：`SELECT USER, HOST FROM MYSQL.USER`  
- 修改密码（CMD）：`MYSQLADMIN -u账号 -p旧密码 PASSWORD 新密码`
- 删除用户：`DROP USER 账号`

**源码：** ddl/用户操作.sql

# 3. 数据表操作

**概念：** mysql的表是所有账号通用的，且没有表空间的概念。
- 格式：`CREATE TABLE 表名 (列名 类型 修饰, ...) 引擎 字符集`
    - `UNSIGNED`：表示该列无符号，默认有符号。
    - `NOT NULL`：表示该列不能插入空数据，列最好不为null。
    - `AUTO_INCREMENT`：表示该列自增，支持 `AUTO_INCREMENT = 10` 的写法。
    - `COMMENT`：可以指定该列的注释内容。
    - `DEFAULT`：可以指定该列的默认值，列尽量给默认值。
    - `PRIMARY KEY ()`：可以指定本张表的主键列。
- 查看建表语句：`SHOW CREATE TABLE 表名`
- 查看表结构：`DESC 表名` 或 `SHOW COLUMNS FROM 表名`
- 查看表索引：`SHOW INDEX FROM 表名`
- 查看表性能：`SHOW TABLE STATUS LIKE '%表名%'`
- 重命名表：`RENAME TABLE 旧表名 TO 新表名`
- 删除表：`DROP TABLE 表名`
- 如果存在则删除表：`DROP TABLE IF EXISTS 表名`
- 清空表：`TRUNCATE TABLE 表名`
- 增加一列：`ALTER TABLE 表名 ADD 列名 类型`
- 修改一列的数据类型：`ALTER TABLE 表名 MODIFY 列名 新类型`
- 删除一列：`ALTER TABLE 表名 DROP COLUMN 列名`
- 快速复制表数据：`CREATE TABLE 新表名 (SELECT * FROM 旧表名)`

> 临时表：如果在造表语句中的 `TABLE` 前添加 `TEMPORARY` 修饰，则表示创建了一张临时表，临时表用于保存临时数据，支持正常的CRUD，仅在当前连接可见，当关闭连接时，mysql会自动删除表并释放所有空间，当然你也可以自己手动销毁它。

**源码：** ddl/数据表操作.sql

## 3.1 数据类型
       
**概念：** mysql中定义数据字段的类型对数据库的优化是非常重要的：
- 数值类型：数值型有符号概念，以 `TINYINT` 为例，有符号范围-128~127，无符号范围0~255。
   - `TINYINT`：极小整数型，1byte 
   - `SMALLINT`：小整数型，2byte
   - `MEDIUMINT`：正常整数型，3byte
   - `INT`：整数型，4byte，同义词 `INTEGER`
   - `BIGINT`：大整数型，8byte
   - `FLOAT`：单精度浮点型，4byte
   - `DOUBLE`：双精度浮点型，8byte
   - `DECIMAL(n, m)`：高精度浮点型，同义词 `DEC`，n表示整数位数，m表示小数位数。
- 日期类型：
   - `DATE`：年月日，3byte，范围1000-01-01~9999-12-31
   - `TIME`：时分秒，3byte，范围-838:59:59~838:59:59
   - `DATETIME`：年月日时分秒，8byte，范围1000-01-01 00:00:00~9999-12-31 23:59:59
   - `TIMESTAMP`：时间戳，8byte，范围1970-01-01 00:00:00~2037-01-01 00:00:00
   - `YEAR`：年份，1字节，有效范围1901~2155
- 字符类型：
   - `CHAR`：定长字符串类型，范围0~255
   - `VARCHAR`：可变长字符串类型，范围0~65535
   - `TINYTEXT`：极小长文本类型，范围0~255
   - `TEXT`：长文本类型，范围0~65535
   - `MEDIUMTEXT`：中等长文本类型，范围0~16777215
   - `LONGTEXT`：极大长文本类型，范围0~4294967295
   - `TINYBLOB`：极小二进制长文本类型
   - `BLOB`：二进制长文本类型
   - `MEDIUMBLOB`：中等二进制长文本类型
   - `LONGBLOB`：极大二进制长文本类型

> 字段类型能用TINYINT就不用INT，能用INT就不用CHAR，能用CHAR就不用VARCHAR，能用VARCHAR(20)就不用VARCHAR(255)。

## 3.2 命名规范

**概念：** 研发中经常发生因为数据库表的设计不良而影响开发进度的问题，其中包括命名格式不规范，命名方案不统一、可读性不高等等，所以在一开始就设计良好的SQL代码和命名，是很有必要的。
- 数据库名，表名，字段名可以由字母，数字，下划线组成。
- 数据库名，表名，字段名建议使用下划线格式。
- 表名，字段名使用反引号包裹，可以避免碰撞关键字。
- 表名，字段名建议全小写，禁止使用复数形式单词。
- 字段名中尽量不要出现表名前缀，禁止使用缩写。
- 表名，字段名必须填写规范优雅的注释。

## 3.3 三范式

**概念：** 数据库设计三范式（3NF）是帮助我们设计更好的数据库表的规范，不一定非要严格执行这个标准，但它对你设计数据库来说，无疑是一个很好的建议和帮助。
- 第一范式（1NF）：表中的每一列都保持了原子性，不能再拆分，则满足1NF。
    - 如：用户表｛姓名，性别，电话｝，其中｛电话｝可以再拆成｛家庭电话，公司电话｝，所以不满足INF。
- 第二范式（2NF）：满足1NF基础上，表有主键，且每一列都与主键相关，则满足2NF。
    - 如：订单表｛订单编号（PK），商品编号，下单日期｝，其中｛商品编号｝和｛订单编号｝无关，所以不满足2NF，应该删除，再使用中间表。
- 第三范式（3NF）：满足2NF基础上，每一列都与主键直接相关，而不是间接相关，则满足3NF。
    - 如：订单表｛订单编号（PK），买家编号，买家姓名｝，其中所有字段都和订单相关，满足2NF，但实际上是｛买家姓名｝和｛买家编号｝直接相关，｛买家编号｝和｛订单编号｝直接相关，导致｛买家姓名｝和｛订单编号｝不是直接相关，而是间接相关，所以不满足3NF，应该将｛买家姓名｝移动到买家表中，而不应该出现在订单表中。

# 4. 约束

**概念：** 约束就是对表中列添加的一些强制校验和规则，以保证数据的正确性和完整性。
- 非空约束 `NOT NULL`：该列非空，即不能插入空值：
    - 造表时：`字段 类型 NOT NULL`。
    - 造表后：`ALTER TABLE 表名 MODIFY 字段 类型 NOT NULL`
- 唯一约束 `UNIQUE`：该列唯一，即不能插入重复数据：
    - 造表时：`字段 类型 UNIQUE` 或末尾添加 `,UNIQUE (字段)`
    - 造表后：`ALTER TABLE 表名 ADD [CONSTRAINT 约束名] UNIQUE (字段)`，约束名默认字段名。
- 主键约束 `PRIMARY KEY`：该列唯一且非空，一张表只能有一个主键约束列：
    - 造表时：`字段 类型 PRIMARY KEY` 或末尾添加 `,PRIMARY KEY (字段)`
    - 造表后：`ALTER TABLE 表名 ADD [CONSTRAINT 约束名] PRIMARY KEY (字段)`，约束名默认 `PRIMARY`。
- 外键约束 `FOREIGN KEY`：主表的某个字段去连接从表的主键或唯一约束字段，二者必须同类型，同长度，但可以不同名：
    - 造表时：末尾添加 `,FOREIGN KEY (外键字段) REFERENCES 从表(从表主键)`
    - 造表后：`ALTER TABLE 表名 ADD [CONSTRAINT 约束名] FOREIGN KEY (字段) REFERENCES 从表(主键)`，约束名随机。
- 查询表的约束：`SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE TABLE_NAME = 表名`
- 删除表的约束：
    - 删除主键约束：`ALTER TABLE 表名 DROP PRIMARY KEY`
    - 删除唯一约束：`ALTER TABLE 表名 DROP KEY/INDEX 约束名`
    - 删除外键约束：`ALTER TABLE 表名 DROP FOREIGN KEY 约束名`
- 添加约束前，尽量保持表中无数据或者无错误数据。

**源码：** ddl/约束.sql

# 5. 索引

**概念：** 索引用来提高DQL的效率，mysql使用自平衡B-tree结构来提高查询数据的效率。
- 一般都只在经常作为查询条件的字段上建立索引，因为添加索引提高了DQL效率的同时，降低了DML语句的效率：
    - 索引需要创建一张对应的索引结构表，耗时很长且需要物理空间来存储，也需要定期维护，每当有记录在表中增减或索引列被修改时，索引本身也会被修改，这意味着每条记录的DML操作将为此多付出4、5次的磁盘I/O。
- 创建普通索引：
    - `ALTER TABLE 表名 ADD INDEX 索引名 (字段)`
    - `CREATE INDEX 索引名 ON 表名 (字段)`，索引名必须指定。
- 创建唯一索引：
    - `ALTER TABLE 表名 ADD UNIQUE (字段)`，索引名默认字段名。
    - `CREATE UNIQUE INDEX 索引名 ON 表名 (字段)`，索引名必须指定。
- 创建主键索引：不支持 `CREATE ON` 语法。
    - `ALTER TABLE 表名 ADD PRIMARY KEY (字段)`，约束名默认 `PRIMARY`。
- 查看索引：`SHOW INDEX FROM 表名`
- 删除索引：
    - `ALTER TABLE 表名 DROP INDEX 索引名`
    - `DROP INDEX 索引名 ON 表名`
- 索引重构：`REPAIR TABLE 表名 QUICK`
    - 定期重构索引是很有必要的。
- 联合索引：比如给A,B和C字段添加一个联合索引，那么单独查询A,B或C的时候，也会走索引，但需要注意不要中间断档。
- 索引和约束：
    - 区别：索引用来提高DQL，约束用来保证数据正确性和完整性。
    - 关联：主键列，唯一约束列和外键列都会自动添加索引，删除约束时索引也会自动删除。

**源码：** ddl/索引.sql

# 6. 视图

**概念：** 视图就是一条查询sql语句的结果集，不占空间，且除了本身外不包含任何数据。
- 创建视图：不建议使用 `*` 作为结果集的查询字段：
    - `CREATE VIEW 视图名 AS (结果集)`：创建视图。
    - `CREATE OR REPLACE VIEW 视图名 AS (结果集)`：创建或修改视图。
- 删除视图：`DROP VIEW 视图名`

**源码：** ddl/视图.sql

