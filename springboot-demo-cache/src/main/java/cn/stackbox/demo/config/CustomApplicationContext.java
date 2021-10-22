package cn.stackbox.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description 自定义application context，获取java bean
 */
@Component
public class CustomApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CustomApplicationContext.applicationContext = applicationContext;
    }

    /**
     * 通过bean的名字获取javabean
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    /**
     * 通过class获取Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }
}