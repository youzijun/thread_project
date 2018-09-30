
### 说明：

##### 生产者-消费者模型

    生产者、消费者都使用同一BlockingQueue<Data>队列，
    Data为自定义消息类型
    生产者通过blockingQueue.offer()向队列添加消息数据
    消费者通过blockingQueue.take()取出数据进行消费