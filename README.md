# mySeckill
## IDEA+maven+SSM 秒杀业务练习

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
### 二、spring+mybatis 整合
   1. jdbc.properties 配置
        * jdbc.driver
        * jdbc.url
        * jdbc.username
        * jdbc.password
   2. mybatis-config.xml配置
        * useGeneratedKeys          许 JDBC 支持自动生成主键
        * useColumnLabel            使用列标签代替列名
        * mapUnderscoreToCamelCase  开启自动驼峰命名规则（camel case）映射
   3. spring-dao.xml 配置
        + 1.数据库属性文件位置
            - property-placeholder
        + 2.数据库连接池配置 c3p0
            - 基本信息配置
                - driverClass
                - jdbcUrl
                - user
                - password
            - c3p0 私有配置
                - maxPoolSize
                - minPoolSize
                - autoCommitOnClose     关闭 断开连接自动提交
                - checkoutTimeout       获取连接超时时间
                - acquireRetryAttempts 当前连接失败 重试次数
        + 3.0 配置 sqlSessionFactory
            - dataSource            注入数据源
            - configLocation        mybatis 配置
            - typeAliasesPackage    扫描entity 包,多个用‘;’ 隔开
            - mapperLocations       扫描sql配置文件:mapper需要的xml文件
        + ４:配置扫描Dao接口包,动态实现DAO接口,注入到spring容器
            - sqlSessionFactoryBeanName 注入SqlSessionFactory
            - basePackage               给出需要扫描的Dao接口