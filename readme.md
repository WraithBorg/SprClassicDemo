# Spring 经典应用场景
## Spring事件机制-观察者模式
+ AsyncEvent  
#### 观察者模式一般包括以下对象
+ Subject 抽象的被观察对象
+ ConcreteSubject 具体的被观察对象
+ Observer 抽象的观察者
+ ConcreteObserver 具体的观察者

#### Spring-观察者模式应用
> Spring通过ApplicationEvent和ApplicationListener接口来处理时间,  
    如果某个Bean实现了ApplicationListener接口并被部署到容器中，  
    那么每次对象的ApplicationEvent发布到容器中，都会通知该Bean，

#### 测试异步事件
浏览器直接访问`127.0.0.1:8888/createBill?code=001`   
####  Spring异步事件的应用范围
1:发送短信
2:推送邮件
3:微信模版消息
4:执行异步任务
#### 优势
1: 实现核心业务和子业务的解耦，改善代码流程
2: 监听器基于spring bean实现，与其他spring 组件能够完美结合  
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

### Spring监听器高级用法
#### 1:添加监听器触发条件，和规定监听范围 ，测试地址
`http://127.0.0.1:8888/testComplexEvent?age=1`  
`http://127.0.0.1:8888/testComplexEvent?age=19`  
#### 2：自定义Spring线程池
参照代码*com.spr.event.SprAsyncConfig*  
访问`http://127.0.0.1:8888/testComplexEvent?age=19`   
日志打印 2020-09-27 14:20:07.464  INFO 16120 --- [-async-thread-1] com.spr.event.OrderBillEventListener :略....   
表示线程池配置成功  

#### EventListener注解参数解析
+ value
+ classes
+ condition
其中value作用和classes一样  

代码位置：*com.spr.event.OrderBillEventListener.testComplexEvent*  
`@EventListener(value = {SprComplexEvent4CreateBill.class, SprComplexEvent4UpdateBill.class}, condition = "#event.sprUser.age > 18")`   
这段注解表示，该方法监听SprComplexEvent4CreateBill和SprComplexEvent4UpdateBill两种事件，而且只有当sprUser对象的age属性大于18的时候，才会出发监听器  

## 浏览器对于同域名下的并发限制
#### 现象一
> 浏览器打开两个窗口，访问同一个请求，会产生同步现象， 只有当第一个窗口的请求成功返回后，第二个窗口的请求才开始发送，  
> 但是如果第二个窗口打开浏览器控制台，两个窗口继续同时访问同一个请求，后台会同时收到两次请求，没有等待现象  
> 但是如果用postman同时调两次该请求的话，后台会同时收到两次请求，没有等待现象  
> 但是如果用一个chrome窗口和一个360浏览器窗口，同时调用该请求的话，也没有等待现象  
> 但是如果用同一个ip 绑定两个域名，然后用两个域名访问该接口，也没有等待现象  

#### 解惑
这种现象是是浏览器的一个主动优化策略，同样的请求没道理并发2次，所以改成了排队

#### 浏览器域名并发限制常见解决方案
前端优化最常见的方法就包括文件合并，图片合并成位图，以及资源分布在多个域名下，多域名能规避最大并发问题，浏览器是每个域名有并发限制  

