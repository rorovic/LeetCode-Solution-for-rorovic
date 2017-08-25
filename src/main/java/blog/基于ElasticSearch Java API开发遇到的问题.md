因为任务安排，开发的重心，从Spark Streaming转移到了，基于ElasticSearch的开发。这次遇到的问题，是基于ElasticSearch的Java API开发时，遇到的。报错现象如下：  

`TransportSerializationException[Failed to deserialize response of type [org.elasticsearch.action.search.SearchResponse]]; nested: ExceptionInInitializerError; nested: IllegalArgumentException[An SPI class of type org.apache.lucene.codecs.PostingsFormat with name 'Lucene50' does not exist.  You need to add the corresponding JAR file supporting this SPI to your classpath.  The current classpath supports the following names: [completion]];`  

程序在本地IDEA运行一切正常，但是打成jar包后，运行到接受ES返回来的Search response的时候，报错了。无法反序列化。但往后看，实际上和Java的SPI机制有关，程序没有找到正确的Lucene50的位置。要解决这个问题，首先需要了解以下概念。  

Java spi机制：
     “当服务的提供者，提供了服务接口的一种实现之后，在jar包的META-INF/services/目录里同时创建一个以服务接口命名的文件。该文件里就是实现该服务接口的具体实现类。而当外部程序装配这个模块的时候，就能通过该jar包META-INF/services/里的配置文件找到具体的实现类名，并装载实例化，完成模块的注入。 基于这样一个约定就能很好的找到服务接口的实现类，而不需要再代码里制定。  
     jdk提供服务实现查找的一个工具类：java.util.ServiceLoader” 《【java规范】Java spi机制浅谈》  

观察：  
 程序运行会用到以下两个codecs文件。并通过这些codecs文件，找到lib里类的路径。但是程序只会读到第一个META-INF/services/*下得三个文件。没有读到后面lucene-core-5.5.0.jar里的文件。
 查看第二个services的文件 org.apache.lucene.codecs.PostingsFormat中的内容是：
  org.apache.lucene.codecs.lucene50.Lucene50PostingsFormat
 所以根据报错，推测错误里报的就是没有读取到第二个红框里的文件的路径。  
 
 ![image](https://github.com/rorovic/LeetCode-Solution-for-rorovic/master/blob/blog-001.png)

解决方法：  
     如果你使用的是IDEA，那么请手动在工程的src目录下创建目录META-INF/services/ 并手动将上面两个红框里的内容做合并，这样所有路径都包含了，缺一不可。  


