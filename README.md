# mySeckill
##IDEA+maven+SSM 秒杀业务练习

### 一、 pom文件编写
   1. 日志依赖 
       * slf4j-api
       * logback-core
       * logback-classic
   2. 数据库 
      * mysql-connector-java 
      * c3p0
      * druid
   3. DAO MyBatis依赖
      * mybatis 
      * mybatis-spring MyBatis自身实现的spring整合依赖
   4. servlet web相关依赖
      * standard
      * jstl
      * jackson-databind
      * javax.servlet-api
   5. spring 依赖
      + spring核心依赖
        - spring-core
        - spring-beans
        - spring-context
      + spring dao层依赖
        - spring-jdbc
        - spring-tx
      + spring web相关依赖
        - spring-web
        - spring-webmvc
      + spring test相关依赖
        - spring-test
   6. redis客户端：Jedis
       * jedis
   7. protostuff序列化依赖
        * protostuff-core
        * protostuff-runtime
   8. commons-collections
        * commons-collections 集合工具
      