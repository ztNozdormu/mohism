package cn.mohist.mohism;

import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.jms.Destination;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableJms
@MapperScan(basePackages = "cn.mohist.mohism.system.log.server.mapper")
public class SystemLogApplication {
	
//	@Bean
//	public Queue queue() {
//		return new ActiveMQQueue("spring-queue");
//	}
	
	@Bean
	public Destination topicDestination() {
		return new ActiveMQTopic("itemAddTopic");
	}

	public static void main(String[] args) {
		SpringApplication.run(SystemLogApplication.class, args);
	}

}
