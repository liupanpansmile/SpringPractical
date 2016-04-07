# SpringPractical
读Spring  实战这本的测试代码

1.Chapter2
	（1）ClassPathXmlApplicationContext 创建容器时，配置文件中的所有的bean都已被创建
	（2）factory-method 允许指定静态方法，替代构造方法创建实例
	（3）内部bean使用
		<contructor-arg>
			<bean class ="xxx"></bean>
		</contructor-arg>
	(4)使用命名空间p装配属性
   （5）集合注入list set map props
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

   	(6)装配null值
   	<property name="nonNullProperty"><null/></property>
   	(7)Spring Expression Language(SpEL)

2.Chapter3  

(1)autowire
	1)byName:通过属性名称与bean id名称相同，自动装入

		 <bean id="instrument" class="com.finleyamber.spring.di.autowire.Piano"/>
    	<!--byName 自动装配-->
    	<bean id="instrumentalist" class="com.finleyamber.spring.di.autowire.Instrumentalist" p:song="Rose" autowire="byName"/>
    2）byType:通过属性的类型去查找上下文中与其类型相同的bean。但是会缺点，当上下文中存在多个类型相同的bean时，pring会报异常。
    3）constructor:构造函数自动注入，和ByType有一样的局限性
    4）autodetect:最佳自动装配，最先尝试使用constructor自动装配，如果没有发现，再使用byType 装配

(2)基于注解的自动装入@Autowire ，使用byType注入，当有多个类型相同的bean时，会产生bean创建失败
	(1)Qualifier : 限定器，只注入制定名称的bean
（3）Inject
	pox中添加
 		<dependency>
            <groupId>javax.inject</groupId>
            <artifactId>javax.inject</artifactId>
            <version>1</version>
        </dependency>

    给属性动态赋值，并使用SpEL
      @Value("#{properties.knifename}")

（4）自动检测标注Bean
	<context:component-scan base-package=""/> 会扫描制定的包及其所有子包，并查找出能够自动注册的SpringBean
		它具有<context:annotation-config/>(识别注解，指定bean装配)
	@Conponent: 通用的构造注解，表示为Spring组件
	@Controller：表示为Spring MVC Controller
	@Repository: 定义为数据仓库
	@Service:定义为服务
（5）@Configuration ：使用@Configuration 注解的Java类，相当于在XML中配置bean。方法名即为bean id

学习计划：
（1）了解注解的原理，自定义注解