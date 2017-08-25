Author: 杜金源 YOHO!有货
 
###参考文章：
<http://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/CapacityScheduler.html>
Hadoop Yarn 权威指南
 
###一：目前的CDH集群里配置调度方案是：
org.apache.hadoop.yarn.server.resourcemanager.scheduler.capacity.CapacityScheduler

  计算能力调度器（Capacity Scheduler）的实现算法，计算能力调度器是由Yahoo贡献的，主要是解决HADOOP-3421中提出的，在调度器上完成HOD（Hadoop On Demand）功能，克服已有HOD的性能低效的缺点。
  关于另外一种调度策略Fair Scheduler和Capacity Scheduler之间的区别，可以看这篇文章：<http://www.jianshu.com/p/fa16d7d843af> 

###二：计算能力调度器介绍
  以队列为单位划分资源，每个队列可设定一定比例的资源最低保证和使用上限，同时，每个用户也可设定一定的资源使用上限以防止资源滥用。而当一个队列的资源有剩余时，可暂时将剩余资源共享给其他队列。总之，Capacity Scheduler主要有以下几个特点：
  Capacity Scheduler支持以下特性：
(1) 计算能力保证。支持多个队列，某个作业可被提交到某一个队列中。每个队列会配置一定比例的计算资源，且所有提交到队列中的作业共享该队列中的资源。
(2) 灵活性。空闲资源会被分配给那些未达到资源使用上限的队列，当某个未达到资源的队列需要资源时，一旦出现空闲资源资源，便会分配给他们。
(3) 支持优先级。队列支持作业优先级调度（默认是FIFO）
(4) 多重租赁。综合考虑多种约束防止单个作业、用户或者队列独占队列或者集群中的资源。
(5) 基于资源的调度。 支持资源密集型作业，允许作业使用的资源量高于默认值，进而可容纳不同资源需求的作业。不过，当前仅支持内存资源的调度。
关于capacity的值的设定，官网上的解释是：
Queue capacity in percentage (%) as a float (e.g. 12.5). The sum of capacities for all queues, at each level, must be equal to 100. Applications in the queue may consume more resources than the queue’s capacity if there are free resources, providing elasticity.
也就是在每一个层级的队列的总和都要是100.