**概念：** `IdFactory` 是一个工具类，主要负责ID的生成，mysql主键自增，可以忽略这个类，该类主要为oracle数据库服务，因为ORACLE无法主键自增，需要依靠存在的序列来生成数字ID，或者生成不重复的32位随机字符串作为字符串ID。

**源码：**
```java
/**
 * @author JoeZhou
 */
public class IdFactory {
    private static Jdbc jdbc = JdbcFactory.getJdbc();

    public static int getIdFromSeq(String seqName) {
        String sql = "SELECT " + seqName + ".NEXTVAL AS ID FROM DUAL";
        Map<String, Object> map = jdbc.retrieveOne(sql);
        String id = null;
        if (!map.isEmpty()) id = map.get("ID").toString();
        return id == null ? null : Integer.parseInt(id);
    }

    public static String getIdFromUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
```