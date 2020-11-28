# 1. 概念

**概念：** mysql是一个关系型数据库管理系统，由瑞典mysql-ab公司开发，目前属于oracle旗下产品，在web应用方面是最好的RDBMS应用软件之一。
- 关系型数据库：关系型数据库最典型的数据结构是表，由二维表及其之间的联系所组成的一个数据结构，一个关系型数据库由一个或多个表格组成，增加了速度并提高了灵活性。
    - 易于维护：都是使用表结构，格式一致。
    - 使用方便：SQL语言通用，可用于复杂查询，即在一个表以及多个表之间非常复杂的查询。
    - 读写性能比较差，尤其是海量数据的高效率读写。
    - 固定的表结构，灵活度稍欠。
    - 高并发读写需求，传统关系型数据库来说，硬盘I/O是一个很大的瓶颈。
- 非关系型数据库：非关系型数据库严格上不是一种数据库，应该是一种数据结构化存储方法的集合，可以是文档或者键值对等。
    - 格式灵活：存储数据的格式可以是key，value形式、文档形式、图片形式等等，使用灵活，应用场景广泛，而关系型数据库则只支持基础类型。
    - 速度快：nosql可以使用硬盘或者随机存储器作为载体，而关系型数据库只能使用硬盘。
    - 成本低：nosql数据库部署简单，基本都是开源软件。
    - 不提供sql支持，学习和使用成本较高。
    - 无事务处理。
    - 数据结构相对复杂，复杂查询方面稍欠。

## 1.1 优势特点

**概念：**
- mysql软件采用了双授权政策，它分为社区版和商业版，体积小、速度快、成本低。
- mysql是免费开源的，可以自定义mysql系统。
- mysql支持大型的数据库，是一个支持5000万条记录的数据仓库，32位系统表文件最大可支持4GB，64位系统支持最大的表文件为8TB。
- mysql使用标准的SQL数据语言形式。
- mysql可以用于多个系统上，并且支持多种语言，比如C、C++、Python、Java、Perl、PHP、Eiffel、Ruby和Tcl等。

## 1.2 RDBMS术语

**概念：** RDBMS，Relational Database Management System，关系数据库管理系统：
- 数据库（database）：数据库是一些关联表的集合，关系型数据库的数据都是存放在表中的。
- 数据表（table）：表是数据的矩阵，在一个数据库中的表看起来像一个简单的电子表格。
- 列（column）：列包含了相同类型的数据，如姓名列，年龄列，性别列等。
- 行（row）：行，也叫元组或记录，是一组相关的数据，如一条用户信息，一条文章数据等。
- 冗余：存储两倍数据，冗余可以使系统速度更快。
- 主键（primary key）：主键是唯一的，一个数据表中只能包含一个主键，一般用于查询数据。
- 外键（foreign key）：一个表的外键用于关联另一个表的主键。
- 复合键：复合键，也叫组合键，将多个列作为一个索引键，一般用于复合索引。
- 索引（index）：使用索引可快速访问数据库表中的特定信息，索引是对数据库表中一列或多列的值进行排序的一种结构，类似于书籍的目录。

## 1.3 存储引擎

**概念：** mysql存储引擎在不同的版本下，使用的也不同：
- `MyISAM` 是mysql5.0之前的默认数据库引擎，最为常用，拥有较高的插入，查询速度，但不支持事务。
- `InnoDB` 是mysql5.0之后的优选数据库引擎，是mysql5.5之后的默认数据库引擎，是事务型数据库的首选引擎，支持ACID事务，支持行级锁定。

## 1.4 SQL语言
       
**概念：** SQL，Structured Query Language，结构化查询语言，是在关系型数据库上执行数据操作，数据检索以及数据维护的标准语言，目前数据库厂商实现的都是SQL92标准，但是不是说所有的数据库的SQL都一样，就比如少数民族也得遵循中国的高考标准，但是加分。

# 2. 卸载

> 安装mysql之前，要保证当前系统环境没有安装过mysql或者已完全卸载干净之前的mysql。

**流程：**
1. 控制面板 - 程序和功能 - 右键卸载mysql所有相关程序。
2. 删除 `Program Files`，`Program Files（x86）` 和 `Program Data` 目录中所有与mysql相关的文件夹。
3. `win + r` 运行 `regedit` 命令打开注册表：
    - 删 `HKEY_LOCAL_MACHINE\SYSTEM\ControlSetXXX\Services\Eventlog\Application` 中所有mysql相关文件夹。
    - 删 `HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\Eventlog\Application` 中所有mysql相关文件夹。
4. 重启电脑，卸载完成。

# 3. 安装

**流程：** 
1. 双击进入安装界面，接受协议，点击 `Next`，进入 `Choosing a Setup Type` 界面。
2. 勾选 `Server only`，点击 `Next`，进入 `Installation` 界面。
    - 如果选择 `Full`，表示安装全部，包括数据库和 `workbench` 客户端等。
3. 点击 `Execute` 执行安装，等待进度条结束，点击 `Next`，进入 `Product Configuration` 界面。
4. 点击 `Next`，进入 `Group Replication` 界面。
5. 点击 `Next`，进入 `Type and Networking` 界面。
    - 确认端口号为3306。
6. 点击 `Next`，进入 `Accounts and Roles` 界面。
7. 填写两遍登录密码，建议使用 `root`，点击 `Next`，进入 `Windows Service` 界面。
    - 如果需要额外指定用户，在下方进行添加。
8. 确认服务名为 `MySQL57`，点击 `Next`，进入 `Plugins and Extensions` 界面。
9. 点击 `Next`，进入 `Apply Configuration` 界面。
10. 点击 `Execute`，开始安装，等待进度条结束，点击 `Finish`，回到 `Product Configuration` 界面。
11. 点击 `Next`，进入 `Installation Complete` 界面。
12. 点击 `Finsh`，完成安装。
13. 右键计算机 - 属性 - 高级系统设置 - 环境变量 - 配置mysql的环境变量：
    - 新建MYSQL_HOME: `C:\Program Files\MySQL\MySQL Server 5.7`
    - 修改path：`%MYSQL_HOME%\bin`
14. 启动cmd，键入 `mysqladmin --version` 命令查看mysql版本。
15. 自启动管理：右键计算机 - 管理 - 服务 - 找到mysql57服务 - 右键更改为手动。
 
> 如果安装时提示系统缺少NetFramework4.0，可安装对应插件：z-res/.NetFramework4.5.exe

> 如果安装提示2502和2503错误，找到C:\Windows\Temp文件，右键属性- 安全 - 添加权限，添加个everyone权限（完全控制），就可以安装了。

# 4. CMD操作

**概念：** 除了在计算机服务中启动mysql服务外，还可以在CMD命令行中来操作：
- 启动：`net start mysql57`，忽略大小写。
- 停止：`net stop mysql57`，忽略大小写。
- 卸载：`sc delete mysql57`，忽略大小写。
- 登录：`mysql [-hIP地址] -u帐号 -p`：
    -`-h` : 该命令用于指定客户端所要登录的mysql主机名，默认127.0.0.1。
    -`-u` : 所要登录的帐号。
    -`-p` : 登录密码，如果为空，可以忽略此选项，不为空不建议在当前行填写，以保持隐私。
- 登出：`exit` 或 `quit` 可以退出登录。
- 创建数据库：`create database dbjoe character set utf8mb4`：
    - `character set utf8mb4` 可以省略，省略后数据库编码会和连接编码保持一致，默认 `utf-8`。
- 查看数据库：`show databases`
- 删除数据库：`drop database dbjoe`
    - `information_schema`，`sys`，`mysql` 和 `perfomance_schema` 是不能删除的。
- 使用数据库：`use dbjoe`
    - 也可以在登录数据库时使用 `-D` 指定使用哪个数据库：`mysql -Ddbjoe -uroot -p`
- 查看元数据：和表中的记录无关的数据都可以称之为元数据，如查询，修改或删除语句所影响的记录数，数据库信息，数据表的信息，mysql的当前状态，版本号等。
    - `select version()`：查看数据库版本信息。
    - `select database()`：查看当前数据库名，或者返回空。
    - `select user()`：查看用户名。
    - `show status`：展示当前数据库状态。
    - `show variables`：展示当前数据库的一些配置变量信息。
    - `show tables`：查看数据表，无法看到临时表。

> mysql语句末尾尽量以分号 `;` 作为语句的结束。

# 5. 可视化工具

**概念：** mysql的可视化工具比较主流的有Navicat，workbench，SqlYog等，这里使用IDEA自带的可视化工具。

**流程：**
1. 点击IDEA右上角的 `Database` 选项卡。
2. 点击 `+` - `Data Source` - `MySQL`。
3. 填写Name，这个是数据库的连接名。
4. 填写Comment，这是连接的注释，可选。
5. 填写Host，数据库所在服务器的IP地址。
6. 填写Port，数据库端口号。
7. 填写User，数据库登录账号。
8. 填写Password，数据库登录密码。
9. 填写Database，填写数据库名，可选。
10. 填写URL，连接串，格式固定：`jdbc:mysql://localhost:3306`
    - 如果使用高版本驱动，需要手动添加时区 `?serverTimezone=UTC`
11. 点击 `Driver:MySQL` - `Go to Driver`：
12. 点击 `+` - `Custom Jars` - 找到本地驱动 - 点OK完成。
    - 低版本驱动：`mysql-connector-java-5.1.38.jar`
    - 高版本驱动：`mysql-connector-java-8.0.15.jar`
13. 点击 `Test Connection` 进行测试。

> IDEA中添加mysql的方言：File - Settings - Languages & Frameworks - SQL Dialects，将Global SQL Dialect 和 Project SQL Dialect 都选择为 MySQL。