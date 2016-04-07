# SpringPractical
读Spring  实战这本的测试代码

1.知识点总结
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