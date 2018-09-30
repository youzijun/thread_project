

### IO 与 NIO

1. **传统socket**  
   io模型是阻塞的，每个线程服务每个连接，当连接建立以后，
   线程就一直等待数据的传输。
   
   **阻塞点**：  
   1. ServerSocket.accect()(等待建立连接)
   2. Socket.read() 等待传输数据
          
          
2. **NIO非阻塞模型**  
   有selector通道选择器和channel缓冲区
   一个线程可以服务多个连接，由一个总的selector去处理  
   每一次事件有连接事件、读取数据事件等，  
   都有selector去调度处理。
   
* **轮询监听selector**
   
   
   

