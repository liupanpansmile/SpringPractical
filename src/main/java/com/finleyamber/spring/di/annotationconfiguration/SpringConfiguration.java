package com.finleyamber.spring.di.annotationconfiguration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lpp on 2016/4/7.
 */

/*告知Spring，该类将包含一个或多个Spring Bean的注入，这样可以替代xml中配置  */
@Configuration
public class SpringConfiguration {

    /*创建id为pinao的bean，方法名即为Bean id*/
    @Bean
    public Instrument piano(){
        return new Piano() ;
    }

    @Bean
    public Instrumentalist  instrumentalist(){
        return new Instrumentalist() ;
    }
}
