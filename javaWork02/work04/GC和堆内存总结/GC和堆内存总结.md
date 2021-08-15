# GC和堆内存总结

## 各种GC算法原理
1. 当选用**串行GC**算法时，选项为-XX:+UseSerialGC，年轻代的GC收集器是**defNew**，老年代使用的垃圾回收器是**tenured**,


2. 当选用**并行GC算法**时，选项为-XX:+UseParallelGC，年轻代的GC收集器是**PSYoungGen**,老年代使用的垃圾回收器是**ParOldGen**


3. 当选用**CMS算法**时,选项为-XX:+UseConcMarkSweepGC，年轻代的GC收集器是**ParNew**，老年代使用的垃圾回收器是**CMS**，我们在日志中分别看到了  CMS Initial Mark（初始标记）--> CMS-concurrent-mark（并发标记）--> CMS-concurrent-preclean（并发预处理）--> CMS-concurrent-abortable-preclean （并发可中止的预清理阶段）--> CMS Final Remark（最终标记）--> CMS-concurrent-sweep（并发清理）--> CMS-concurrent-reset（并发重置）几个阶段


4. 当选用**G1算法**时，选项为-XX:+UseG1GC，内存堆被分为小块的region，不再有固定的年轻代和老年代，垃圾回收的过程中对应了**G1 Evacuation Pause**（年轻代模式转移暂停）,然后是**并发标记阶段**（Concurrent Marking）,该阶段分别对应着 initial-mark（初始标记）--> concurrent-root-region-scan（root区扫描）--> concurrent-mark(并发标记) --> remark（再次标记）--> cleanup(stw的清理) --> concurrent-cleanup(并发的清理) ,最后是stw混**合模式**的回收（mixed），这个过程回收所有年轻代和部分老年代，但这个过程不一定启动，和标记过程中会穿插多次的Young模式的转移暂停




## 造成GC频繁的原因
主要有两个原因及解决方案：
1. 高分配速率  
造成该问题的主要原因是因为对象分配速度过快，解决该问题的主要方法就是增加Eden区的大小，近而减少minor gc的次数

2. 过早提升  
 造成该问题的主要原因是年轻代对象晋升速率过快，解决该问题的主要方法就是增加年轻代的大小或者减少在业务中使用的内存数量


 
