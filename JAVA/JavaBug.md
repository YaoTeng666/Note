# JAVA中问题汇总



## 1、java中对父类方法重写的条件

条件：

1. [子类](https://so.csdn.net/so/search?q=子类&spm=1001.2101.3001.7020)重写的方法的权限修饰符的权限范围应该大于等于父类的方法。（权限修饰符： public > [protected](https://so.csdn.net/so/search?q=protected&spm=1001.2101.3001.7020) > 默认不写的 > private）
2. 返回值类型 ：要求子类重写的方法的返回值类型应该小于等于父类。
3. 要求子类重写的父类的方法名要与父类被重写的方法名字完全一致(大小写严格要求).
4. 参数列表(参数的个数必须相同)、参数列表(参数的类型必须相同)、要求参数的个数类型顺序完全一致，负责会报编译错误。
5. 子类重写的父类的方法抛出异常的类型必须小于等于父类被重写的方法。

> 链接地址：https://blog.csdn.net/chen_kai_fa/article/details/122942209



## 2、java重载条件

参数类型、参数个数、参数顺序不同。跟返回类型无关。



## 3、Java中extends 与implements区别和联系

> 链接：https://www.cnblogs.com/yiqiejieyoukenengya/p/6118820.html