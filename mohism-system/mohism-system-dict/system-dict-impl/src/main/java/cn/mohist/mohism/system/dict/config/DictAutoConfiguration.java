package cn.mohist.mohism.system.dict.config;

import cn.mohist.mohism.system.dict.core.db.DictInitializer;
import cn.mohist.mohism.system.dict.core.db.DictTypeInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 字典的自动配置
 *
 * @author fengshuonan
 * @date 2018-07-24-下午5:12
 */
@Configuration
public class DictAutoConfiguration {

    /**
     * 数据库初始化
     */
    @Bean
    public DictInitializer dictInitializer() {
        return new DictInitializer();
    }

    @Bean
    public DictTypeInitializer dictTypeInitializer() {
        return new DictTypeInitializer();
    }

}
