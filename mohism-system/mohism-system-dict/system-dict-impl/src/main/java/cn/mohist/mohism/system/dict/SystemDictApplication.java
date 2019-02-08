package cn.mohist.mohism.system.dict;

import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.jms.Destination;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableJms
@ComponentScan(value = {"cn.mohist.mohism.system.dict","cn.mohist.mohism.system.dict.service"})
@MapperScan(basePackages = "cn.mohist.mohism.system.dict.mapper")
public class SystemDictApplication {
	
//	@Bean
//	public Queue queue() {
//		return new ActiveMQQueue("spring-queue");
//	}
	
	@Bean
	public Destination topicDestination() {
		return new ActiveMQTopic("itemAddTopic");
	}

	public static void main(String[] args) {
		SpringApplication.run(SystemDictApplication.class, args);
	}

}
