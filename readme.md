# Spring 经典应用场景
## Spring 事件监听器
+ AsyncEvent  
#### 测试异步事件
浏览器直接访问`127.0.0.1:8888/createBill?code=001`   
####  Spring异步事件的应用范围
1:发送短信
2:推送邮件
3:微信模版消息
4:执行异步任务
#### 优势
1: 实现核心业务和子业务的解耦
2: 监听器基于spring bean实现，与其他spring 组件完美融合  
3: 支持自定义异步线程池  
4: 避免手动创建异步线程和过度使用消息队列

#### 一个完整的事件监听过程包含四个对象
1:发送事件的主体
2:事件的类型定义
3:事件发布器
4:事件监听器

#### 测试全局锁SprLock
测试 `127.0.0.1:8888/createBill4Safe?code=001`  
浏览器开启两个窗口直接访问 但是需要开启浏览控制台 具体详见‘浏览器域名并发限制’

## 浏览器域名并发限制
#### 现象一
> 浏览器打开两个窗口，访问同一个请求，会产生同步现象， 只有当第一个窗口的请求成功返回后，第二个窗口的请求才开始发送，  
> 但是如果第二个窗口打开控制台的在调用的话，后台会同时收到两次请求，没有等待现象  
> 但是如果用postman同时调两次该请求的话，后台会同时收到两次请求，没有等待现象  
> 但是如果用一个chrome窗口和一个360浏览器窗口，同时调用该请求的话，也没有等待现象  
> 但是如果用同一个ip 绑定两个域名，然后用两个域名访问该接口，也没有等待现象  

#### 解惑
这种现象是是浏览器的一个主动优化策略，同样的请求没道理并发2次，所以改成了排队

#### 浏览器域名并发限制常见解决方案
前端优化最常见的方法就包括文件合并，图片合并成位图，以及资源分布在多个域名下，多域名能规避最大并发问题，浏览器是每个域名有并发限制  

