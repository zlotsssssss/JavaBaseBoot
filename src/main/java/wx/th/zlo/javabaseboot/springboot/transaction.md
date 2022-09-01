事务特性：1.原子性 2.一致性 3.隔离性 4.持久性

事务管理器，PlatformTransactionManager接口，提供很多实现类

![img.png](img.png)

事务传播行为（propagation）：两人之间的事务传播，a事务方法调用b事务方法，

![img_1.png](img_1.png)

事务隔离性（ioslation）：多事务操作之间不会产生影响，
三个读问题：脏读、不可重复读，幻读
脏读：一个未提交的事务读取了另一个未提交事务的数据