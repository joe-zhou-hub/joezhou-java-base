# 在索引列上使用NOT会导致索引失效。

# 低效
EXPLAIN
SELECT *
FROM EMP
WHERE EMPNO IS NOT NULL;

# 高效
EXPLAIN
SELECT *
FROM EMP
WHERE EMPNO = 7369;

# 避免触发隐式转换，如果字段是字符类型，就不要用数组类型的值
# 且如果恰好是索引列，索引会失效。CREATE INDEX I_ENAME ON EMP(ENAME);
CREATE INDEX I_ENAME ON EMP (ENAME);

# 低效
EXPLAIN
SELECT *
FROM EMP
WHERE ENAME = 7369;

# 高效
EXPLAIN
SELECT *
FROM EMP
WHERE ENAME = 'SMITH';

# 把大筛选量的WHERE往后排，因为数据库采用自后而前的顺序解析WHERE条件
# 根据这个原理，那些可以过滤掉最大数量记录的WHERE条件尽量写在所有WHERE条件的末尾。

# 低效
SELECT *
FROM EMP
WHERE SAL > 500
  AND ENAME IN ('SMITH', 'WORD');

# 高效
SELECT *
FROM EMP
WHERE ENAME IN ('SMITH', 'WORD')
  AND SAL > 500;

# 全查中避免使用 `*`，mysql在解析的过程中，会将 `*` 依次转换成所有的列名
# 这个工作是通过查询数据字典完成的, 这意味着将耗费更多的时间，虽然这个时间几乎可以忽略
# 但是 `*` 的代码可读性仍然很差。

# 低效
SELECT *
FROM EMP;

# 高效
SELECT EMPNO,
       ENAME,
       JOB,
       MGR,
       HIREDATE,
       SAL,
       COMM,
       DEPTNO
FROM EMP;

# 删表记录时，用 `TRUNCATE` 替代 `DELETE`，当删除表中的记录时
# 在通常情况下，回滚段(rollback segments) 用来存放可以被恢复的信息
# 如果你没有COMMIT事务，数据库会将数据恢复到删除之前的状态
# 准确地说是恢复到执行删除命令之前的状态，而当运用 `TRUNCATE` 时
# 回滚段不再存放任何可被恢复的信息，当命令运行后，数据不能被恢复
# 因此很少的资源被调用，执行时间也会很短。

# 低效
DELETE
FROM EMP;

# 高效
TRUNCATE TABLE EMP;

# 多使用表的别名，当在SQL语句中连接多个表时，请使用表的别名并把别名前缀于每个字段上
# 这样一来，就可以减少解析的时间并减少那些由列名歧义引起的语法错误。

# 低效
SELECT *
FROM EMP
         JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO;

# 高效
SELECT E.ENAME, D.DEPTNO
FROM EMP E
         JOIN DEPT D ON E.DEPTNO = D.DEPTNO;

# 用 `NOT EXISTS` 替代 `NOT IN`，在许多基于基础表的查询中
# 为了满足一个条件，往往需要对另一个表进行联接，在这种情况下
# 使用 `EXISTS` 或 `NOT EXISTS` 通常将提高查询的效率。在写成外连子查询中
# `NOT IN` 子句将执行一个内部的排序和合并，无论在哪种情况下，`NOT IN` 都是最低效的
# 因为它对子查询中的表执行了一个全表遍历。

# 低效
SELECT *
FROM DEPT
WHERE DEPTNO NOT IN (SELECT DEPTNO FROM EMP);

# 高效
SELECT *
FROM DEPT
WHERE NOT EXISTS(SELECT 1 FROM EMP WHERE DEPT.DEPTNO = EMP.DEPTNO);

# 用 `EXISTS` 替换 `DISTINCT`，当提交一个包含一对多表信息的查询时
# 避免在SELECT子句中使用 `DISTINCT`，一般可以考虑用 `EXIST` 替换
# 因为RDBMS核心模块将在子查询的条件一旦满足后，立刻返回结果。

# 低效
SELECT DISTINCT(D.DEPTNO)
FROM DEPT D
         JOIN EMP E ON D.DEPTNO = E.DEPTNO;

# 高效
SELECT DEPTNO
FROM DEPT D
WHERE EXISTS(
              SELECT 1 FROM EMP E WHERE D.DEPTNO = E.DEPTNO
          );

# 避免在索引列上进行计算，避免在索引列上使用计算，会导致索引失效。

# 低效
EXPLAIN
SELECT *
FROM EMP
WHERE EMPNO * 12 > 25000;

# 高效
EXPLAIN
SELECT *
FROM EMP
WHERE EMPNO > 25000 / 12;

# 多使用 `>=` 替代 `>`，两者的区别在于，`>3` 首先定位到 `ID=3` 的记录并且向后扫描到第一个ID大于3的记录
# 而 `>=3` 将直接跳到第一个DEPT等于3的记录。

# 低效
SELECT *
FROM EMP
WHERE DEPTNO > 2;

# 高效
SELECT *
FROM EMP
WHERE DEPTNO >= 3;

# 用UNION替换OR (适用于索引列)，通常情况下
# 用UNION替换WHERE子句中的OR将会起到较好的效果
# 对索引列使用OR将造成全表扫描。
# 注意，以上规则只针对多个索引列有效，如果字段没有被索引
# 查询效率可能会因为你没有选择OR而降低。
# 假设在下面的例子中，EMPNO和ENAME上都建有索引

CREATE INDEX I_ENAME ON EMP (ENAME);

# 低效
EXPLAIN
SELECT *
FROM EMP
WHERE EMPNO = 7933
   OR ENAME = 'SMITH';

# 高效
EXPLAIN
SELECT *
FROM EMP
WHERE EMPNO = 7933
UNION
SELECT *
FROM EMP
WHERE ENAME = 'SMITH';

# 避免在索引列上使用 `IS NULL` 和 `IS NOT NULL`

# 低效
EXPLAIN
SELECT *
FROM EMP
WHERE EMPNO IS NOT NULL;

# 高效
EXPLAIN
SELECT *
FROM EMP
WHERE EMPNO >= 0;

# 优化 `GROUP BY`，通过将不需要的记录在 `GROUP BY` 之前过滤掉，可以提高 `GROUP BY` 语句的效率。

# 低效
SELECT JOB, AVG(SAL)
FROM EMP
GROUP BY JOB
HAVING JOB = 'PRESIDENT'
    OR 'JOB' = 'MANAGER';

# 高效
SELECT JOB, AVG(SAL)
FROM EMP
WHERE JOB = 'PRESIDENT'
   OR JOB = 'MANAGER'
GROUP BY JOB;