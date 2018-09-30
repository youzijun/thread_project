

### zookeeper实现分布式锁

#### 原理：
    对每个商品id在zookeeper中创建一个临时node节点，
    每个商品id试图创建对应的node节点时，
    如果创建成功，就拥有了这把分布式锁，
    同样的商品id再次创建是就会抛出NodExistsException异常，
    然后再catch代码块中使用
        while(true){
            Thread.sleep(xxx);
            //创建node节点
            xxxxx
        }
    上面的轮询方式去不断创建node节点，
    直到该商品id释放该锁（删除此node节点）
    它才会创建成功，拥有锁。
    
    
    =============
    临时node节点其实是一个zookeeper中的目录
    形式：/Locks/msg_000022
    // 关键方法，创建包含自增长id名称的目录，这个方法支持了分布式锁的实现
    // 四个参数：
    // 1、目录名称
    // 2、目录文本信息
    // 3、文件夹权限，Ids.OPEN_ACL_UNSAFE表示所有权限
    // 4、目录类型，（CreateMode.EPHEMERAL_SEQUENTIAL表示会在目录名称后面加一个自增加数字）此处使用EPHEMERAL
    this.zookeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
    
    1. demo代码中因为使用了商品id作为分布式锁的序号，故选用EPHEMERAL
    （此种方式，目录名称传进来的不同，名称后面跟的序号是一样的）
    
    2. 其它场景可以使用EPHEMERAL_SEQUENTIAL模式
    （此种方式，目录名称传进来的是相同的，序号是自增的）
    目录结构：/yyyy/xxxx_000023
    每次线程获取分布式锁的时候都会生成/yyyy下面一个子目录（子节点）
    先获取/yyyy目录下的所有子节点，然后正序排序，每次子节点序号最小的获取锁
    所有较第一种中，此种方式每个子节点只需要监听自己的前一个子节点就可以（前一个序号是比自己小的）
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    