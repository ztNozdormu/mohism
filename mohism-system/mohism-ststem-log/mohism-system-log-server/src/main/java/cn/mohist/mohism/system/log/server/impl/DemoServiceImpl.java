package cn.mohist.mohism.system.log.server.impl;

import cn.mohist.mohism.system.log.service.DemoService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",interfaceName="cn.mohist.mohism.system.log.service.DemoService")
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
