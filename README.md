# SpringPractical
读《Spring  In Action》这本书的测试代码

## Chapter2
* ClassPathXmlApplicationContext 创建容器时，配置文件中的所有的bean都已被创建
* factory-method 允许指定静态方法，替代构造方法创建实例
* 内部bean使用
		<contructor-arg>
			<bean class ="xxx"></bean>
		</contructor-arg>
* 使用命名空间p装配属性
* 集合注入list set map props
   		<bean>
   			<property nane="instruments">
   				<list>
   					<ref bean="guitar" />
   					<ref bean="pinao" />
   				</list>
   			</property>
   		</bean>

   		<bean>
   			<property nane="instruments">
   				<set>
   					<ref bean="guitar" />
   					<ref bean="pinao" />
   				</set>
   			</property>
   		</bean>
   		list set 用来装配类型java.util.Collection的任意实现或数组的属性，只是list允许重复，而set不允许重复


   		装配map
		<bean>
   			<property nane="instruments">
   				<map>
   					<entry key="GUITAR" value-ref="guitar"/>
   					<entry key="PINAO" value-ref="pinao"/>
   				</map>
   			</property>
   		</bean>

   		props与map类似，但是props的key-value都是String类型
		<bean>
   			<property nane="instruments">
   				<props>
   					<prop key="GUITAR">guitar</prop>
   					<prop key="PINAO">pinao</prop>
   				</props>
   			</property>
   		</bean>

* 装配null值
	<property name="nonNullProperty"><null/></property>
* Spring Expression Language(SpEL)

## Chapter3  

* autowire
    ** byName:通过属性名称与bean id名称相同，自动装入

		 <bean id="instrument" class="com.finleyamber.spring.di.autowire.Piano"/>
    	<!--byName 自动装配-->
    	<bean id="instrumentalist" class="com.finleyamber.spring.di.autowire.Instrumentalist" p:song="Rose" autowire="byName"/>
    ** byType:通过属性的类型去查找上下文中与其类型相同的bean。但是会缺点，当上下文中存在多个类型相同的bean时，pring会报异常。
    ** constructor:构造函数自动注入，和ByType有一样的局限性
    ** autodetect:最佳自动装配，最先尝试使用constructor自动装配，如果没有发现，再使用byType 装配

* 基于注解的自动装入@Autowire ，使用byType注入，当有多个类型相同的bean时，会产生bean创建失败
	(1)Qualifier : 限定器，只注入制定名称的bean
* Inject
	pom中添加
 		<dependency>
	            <groupId>javax.inject</groupId>
	            <artifactId>javax.inject</artifactId>
	            <version>1</version>
        	</dependency>

      给属性动态赋值，并使用SpEL
       @Value("#{properties.knifename}")

* 自动检测标注Bean
	<context:component-scan base-package=""/> 会扫描制定的包及其所有子包，并查找出能够自动注册的SpringBean
		它具有<context:annotation-config/>(识别注解，指定bean装配)
	@Conponent: 通用的构造注解，表示为Spring组件
	@Controller：表示为Spring MVC Controller
	@Repository: 定义为数据仓库
	@Service:定义为服务
* @Configuration ：使用@Configuration 注解的Java类，相当于在XML中配置bean。方法名即为bean id
======================================================================================================
## Chapter4 aop

* 相关概念
    ** 通知：定义切面是什么，在什么时候用
        前置通知（Before）:在犯法方法执行前被调用
        后置通知：After->无论返回是否成功，都会执行； After-Returning：返回成功才会执行
        异常通知（After-Throwing):异常抛出才会执行
        环绕通知（Around）:在方法执行前以及执行后都会被调用
    ** 切点： 表示被切入的地方，如方法，属性，构造函数等。
    ** 连接点：在执行过程中能够插入切面的一个点。
          如一个接口A，有个方法a，如果有多个类实现A，A1 A2 A3.如果切点为a，那么连接点为A1.a A2.a  A3.a
    ** 织入：将切面应用到目标对象创建新的代理对象的过程，切面在指定的连接点被织入到目标对象中。

* 通知 切点xml 配置

	<aop:config>
	        <aop:aspect ref="audience">
	            <aop:pointcut id="perform" expression="execution(* com.finleyamber.spring.aop.simple.Performer.perform(..))"></aop:pointcut>
	
	            <!--前置通知-->
	            <aop:before method="takeSeats" pointcut-ref="perform"/>
	            <aop:before method="turnOffCellphones" pointcut-ref="perform"/>
	
	            <!--后置通知-->
	            <aop:after-returning method="applaud" pointcut-ref="perform"/>
	
	            <!--异常通知-->
	            <aop:after-throwing method="demandRefund" pointcut-ref="perform"/>
	
	            <!--环绕通知-->
	            <aop:around method="watchPerformance" pointcut-ref="perform"/>
	        </aop:aspect>
	
	</aop:config>
	
	<aop:config>
	        <aop:aspect ref="magician">
	            <aop:pointcut id="thinking" expression="execution(* com.finleyamber.spring.aop.simple.Thinker.thinkOfSomething(String)) and args(thoughts)"/>
	            <aop:before method="interceptThoughts" pointcut-ref="thinking" arg-names="thoughts"/>
	        </aop:aspect>
	</aop:config>
* 注解切面
  在applicationContext.xml 添加
    <!--@Aspect注解所标注的bean转变为代理通知-->
    <aop:aspectj-autoproxy/>


  @Aspect
public class Audience {
    @Pointcut("execution(* com.finleyamber.spring.aop.annotation.Performer.perform(..))")
    public void performance(){
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("The audience is taking seats");
    }
    @Before("performance()")
    public void turnOffCellphones(){
        System.out.println("The audience is turning off cellphone");
    }

    @AfterReturning("performance()")
    public void applaud(){
        System.out.println("The audience is applauding");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("The audicece demand for refund");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            long start = System.currentTimeMillis() ;
            joinPoint.proceed() ;
            long end = System.currentTimeMillis() ;
            System.out.println("Performance Cost :" +(end-start) + " mills");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}


学习计划：
（1）了解注解的原理，自定义注解
