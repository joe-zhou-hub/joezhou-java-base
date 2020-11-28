# 1. MySQL

**概念：** 除了常规连接方式，还可以使用下面的连接方式。

```java
String driver="org.gjt.mm.mysql.Driver";     
String url="jdbc:mysql://localhost/库名?user=用户名&password=密码&useUnicode=true&characterEncoding=utf-8";
Class.forName(driver).newInstance();
Connection conn=DriverManager.getConnection(url);
```

# 2. Oracle

```java
Class.forName("oracle.jdbc.driver.OracleDriver");
String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCLJOE";
String user = "scott",password = "tiger";
Connection conn = DriverManager.getConnection(url, user,password);
```

# 3. SQL_Server

```java
String driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
String url="jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=库名";
String user="用户名";
String password="密码";
Class.forName(driver).newInstance();
Connection conn=DriverManager.getConnection(url,user,password);
```

# 4. DB2

```java
String driver = "com.ibm.db2.jdbc.app.DB2Driver"
String url="jdbc:db2://localhost:5000/库名";
String user="用户名";
String password="密码";
Class.forName(driver).newInstance();
Connection conn=DriverManager.getConnection(url,user,password);
```

# 5. Sybase

```java
String driver="com.sybase.jdbc.SybDriver";
String url="jdbc:sybase:Tds:localhost:5007/库名";
Properties sysProps=System.getProperties();
SysProps.put("user","用户名");
SysProps.put("password","密码");
Class.forName(driver).newInstance(); 
Connection conn=DriverManager.getConnection(url, SysProps);
```

# 6. PostgreSQL

```java
String driver="org.postgresql.Driver";     
String url="jdbc:postgresql://localhost/库名";
String user="用户名";
String password="密码";
Class.forName(driverStr ).newInstance();
Connection conn=DriverManager.getConnection(url,user,password);
```

# 7. Informix数据库

```java
String driver="com.informix.jdbc.IfxDriver";    
Stringurl="jdbc:informix-sqli://123.45.67.89:1533/库名:INFORMIXSERVER=myserver;user = 用户名;password = 密码";
Class.forName(driver).newInstance();
Connection conn=DriverManager.getConnection(url);
```