package cn.mohist.mohism.business.pay;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
//@ComponentScan(basePackages={"cn.mohist.mohism.business.pay"})
@MapperScan(basePackages = "cn.mohist.mohism.business.pay.mapper")
public class BusinessPayServerAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(BusinessPayServerAppliaction.class, args);
    }
}
