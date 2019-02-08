package cn.mohist.mohism.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"cn.mohist.mohism.generator.*"})
public class MohismGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MohismGeneratorApplication.class, args);
	}
}
