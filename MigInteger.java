package shuju;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

import org.junit.Test;

//百亿计算器
public class MigInteger {
	@Test
	/**
	 * 构造器就是和类名相同但无返回类型的方法。用于当前或某一对象的实例化， 并将当前或某一对象返回。要得到一个类的实例时，往往是要运行其构造函数的。
	 * 你的类就是定义了对象属于狗类还是猪类还是人类，当你想要一个对象的时候，你去人类的构造器里面填一些参数，
	 * 比如性别、长相、三围、年龄，人类根据这些给你生成一个特定的对象，所谓人类的实体 构造器的特点: 1.方法名和类名相等
	 * 2.没有返回值，并且不能用void（如果用void来声明其返回值类型， 那么java会把这个构造器当做方法来处理——那它不再是构造器）    
	 * 3.构造器中的参数列表中的参数可有可无 其主要功能是用来在创建对象时初始化对象， 即为对象成员变量赋初始值
	 * 高内聚，是指让一个类或者一个方法让他专注去做一件事情。低耦合：这个又要求对象，
	 * 类之间减少耦合性，更通俗的说比如你一个类的方法引用了很多的别的类，而你是直接new出来的， 这样就会出现，你修改某个类之后，这个方法就会出现异常错误
	 * StringBuilder是线程不安全的，而StringBuffer是线程安全的
	 * 数组没有length()方法，有length的属性。String有length()方法。JavaScript中，
	 * 获得字符串的长度是通过length属性得到的，这一点容易和Java混淆。 这说明 javac 编译可以对
	 * 字符串常量直接相加的表达式进行优化，不必要等到运行期去进行加法运算处理，而是在编 译时去掉其中的加号，直接将其编译成一个这些常量相连的结果。 final
	 * 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。 数组脚本越界/类转换异常/空指针异常 throws 捕获并向外抛出异常 throw
	 * 抛出异常 try catch 是内部捕获异常并做自定义处理 finally 是无论是否有异常都会被处理的语句，除非在 finally
	 * 前存在被执行的静态内部类不能访问外部类的成员。abstract method 必须以分号结尾，且不带花括号 局部变量前不能放置任何访问修饰符
	 * (private，public，和 protected)。final 可 以用来修饰局部变量.abstract 的 methods 不能以 private
	 * 修饰。 abstract 的 methods 就是让子类 implement(实现)具体细节的，怎么可以用 private 把 abstract
	 * 1、什么是流？ 具有流动的介质。 2、从流向来分类 1）输入流：把数据读入来程序中来； 2）输出流：把程序中的数据写到磁盘上； 3、从类别来分：
	 * 1）字符流：只能针对文本操作； Reader：字符输入流 FileReader Writer：字符输出流 FileWriter
	 * 2）字节流：万能流，可以操作所有的类别文件； InputStream：字节输入流 FileInputStream OutputStream： 字节输出流
	 * FileOutputStream 抽象类和普通类的主要有三点区别：
	 * 1）抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），缺省情况下默认为public。
	 * 2）抽象类不能用来创建对象；
	 * 3）如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。如果子类没有实现父类的抽象方法，则必须将子类也定义为为abstract类。
	 * 三.抽象类和接口的区别 抽象类可以提供成员方法的实现细节，而接口中只能存在public abstract 方法；
	 * 2）抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是public static final类型的；
	 * 3）接口中不能含有静态代码块以及静态方法，而抽象类可以有静态代码块和静态方法； 4）一个类只能继承一个抽象类，而一个类却可以实现多个接口。
	 * 抽象类是对一种事物的抽象，即对类抽象，而接口是对行为的抽象。 如何在Java中实现线程？
	 * 直接调用Runnable接口来重写run()方法实现线程，你可以继承java.lang.Thread 类
	 * 知道Java不支持类的多重继承，但允许你调用多个接口。所以如果你要继承其他类，当然是调用Runnable接口好了 Thread thread=new
	 * ThreadDemo(); 第一种 表明: run()和其他方法的调用没任何不同,main方法按顺序执行了它,并打印出最后一句 thread.run();
	 * 第二种 表明: start()方法重新创建了一个线程,在main方法执行结束后,由于start()方法创建的线程没有运行结束,
	 * 因此主线程未能退出,直到线程thread也执行完毕.这里要注意,默认创建的线程是用户线程(非守护线程) thread.start();
	 * 当你调用run()方法的时候，只会是在原来的线程中调用，没有新的线程启动，start()方法才会启动新线程
	 * 栈是一块和线程紧密相关的内存区域。每个线程都有自己的栈内存，用于存储本地变量，方法参数和栈调用，一个线程中存储的变量对其它线程是不可见的。
	 * 而堆是所有线程共享的一片公用内存区域。对象都在堆里创建，为了提升效率线程会从堆中弄一个缓存到自己的栈 值传递与引用传递的区别
	 * （1）基本数据类型传值，对形参的修改不会影响实参； （2）引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象；
	 * （3）String, Integer, Double等immutable的类型特殊处理，可以理解为传值，最后的操作不会修改实参对象。 选择排序
	 * 在未排序序列中找到最小元素，存放到排序序列的起始位置 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。 以此类推，直到所有元素均排序完毕。
	 * 插入排序 从第一个元素开始，该元素可以认为已经被排序 取出下一个元素，在已经排序的元素序列中从后向前扫描
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置 将新元素插入到该位置中
	 * 数据库事务transanction正确执行的四个基本要素。ACID,原子性(Atomicity)、一致性(Correspondence)、隔离性(Isolation)、持久性(Durability)
	 * 原子性:整个事务中的所有操作，要么全部完成，要么全部不完成
	 * 一致性:在事务开始之前和事务结束以后，数据库的完整性约束没有被破坏
	 * 隔离性:隔离状态执行事务，使它们好像是系统在给定时间内执行的唯一操作
	 * 持久性:在事务完成以后，该事务所对数据库所作的更改便持久的保存在数据库之中，并不会被回滚
	 * 从数据库层面增强性能：优化SQL语句，合理使用字段索引
	 * 编程手段防止SQL注入：使用JDBC PreparedStatement按位插入或查询
	 * 提升数据库服务器硬件配置，或者搭建数据库集群。建立索引。
	 * 对现有数据进行重新整理、加密、备份，可以通过统一的数据查询语言（比如SQL）进行快速检索、修改、删除等操作的文件系统。
	 * 通过结合数据挖掘等技术能够为数据使用者提供宏观和微观上的决策依据。
	 * B/S（Browser/Server）结构即浏览器和服务器结构，种网络结构模式，数据保留在服务器 WEB浏览器是客户端最主要的应用软件，不需要下载客户端。
	 * 只要提供了持久化类与表的映射关系，ORM框架在运行时就能参照映射文件的信息，把对象持久化到数据库中。当前ORM框架主要有五种：
	 * Hibernate(Nhibernate)，iBATIS，mybatis，EclipseLink，JFinal。
	 * 三层架构(3-tier architecture) 通常意义上的三层架构就是将整个业务应用划分为：
	 * 界面层（User Interface layer）、业务逻辑层（Business Logic Layer）、数据访问层
	 */
	public void test() throws Exception {
		InputStream h = new FileInputStream("c");
		OutputStream os = new FileOutputStream("d:/copy.png");
		byte[] buf = new byte[1024 * 8];
		int len = -1;
		while ((len = h.read(buf)) != -1) {
			os.write(buf, 0, len);
		}

		// Math.pow(x,n)方法,表示x的n次幂
		double x = Math.pow(2, 64);
		// 就是新建一个BigInteger值为(long) x的对象。
		BigInteger xBigInteger = BigInteger.valueOf((long) x);
		double y = Math.pow(2, 64);
		System.out.println("y = " + y);
		BigInteger yBigInteger = BigInteger.valueOf((long) y);
		System.out.println("x*y = " + multiply(xBigInteger, yBigInteger));
		System.out.println("x+y = " + add(xBigInteger, yBigInteger));
		System.out.println("x-y = " + subtract(xBigInteger, yBigInteger));
		System.out.println("x/y = " + divide(xBigInteger, yBigInteger));
	}

	/*
	 * 加法：x+y
	 */
	public BigInteger add(BigInteger x, BigInteger y) {
		return x.add(y);
	}

	/*
	 * 减法： x-y
	 */
	public BigInteger subtract(BigInteger x, BigInteger y) {
		return x.subtract(y);
	}

	/*
	 * 乘法： x*y
	 */
	public BigInteger multiply(BigInteger x, BigInteger y) {
		return x.multiply(y);
	}

	/*
	 * 除法：x/y
	 */
	public BigInteger divide(BigInteger x, BigInteger y) {
		return x.divide(y);
	}
}
