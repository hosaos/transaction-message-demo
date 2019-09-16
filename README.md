操作步骤

1、修改application-dev.yml中数据库连接为你本地连接地址

2、执行table.sql中sql语句

3、修改TransactionProducer及Consumer中nameServer地址

4、启动MainApplication

5、用户1给用户2转账操作，访问http://localhost:8080/test/mqTest
    每次转账100元

    用户1初始金额100
    用户2初始金额0
    
    第一次转账用户1金额足够，操作成功，发送prepare消息并commit，消息被成功投递，consumer消费到
    第一次转账用户2金额不够，操作失败，发送prepare消息并rollback，消息被丢弃