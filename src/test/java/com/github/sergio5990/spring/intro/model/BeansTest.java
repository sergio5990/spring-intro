package com.github.sergio5990.spring.intro.model;

import com.github.sergio5990.spring.intro.Runner;
import com.github.sergio5990.spring.intro.annotation.AnnotationInject;
import com.github.sergio5990.spring.intro.annotation.AnnotationName;
import com.github.sergio5990.spring.intro.annotation.AnnotationSetterInject;
import com.github.sergio5990.spring.intro.annotation.ConstructorInject;
import com.github.sergio5990.spring.intro.beans.UserRepository;
import com.github.sergio5990.spring.intro.beans.UserService;
import com.github.sergio5990.spring.intro.beans.impl.UserRepositoryImpl;
import com.github.sergio5990.spring.intro.beans.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BeansTest {

    @Test
    void annotationTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserRepositoryImpl.class);
        context.register(UserServiceImpl.class);
        context.refresh();

        UserRepository repoBean = context.getBean(UserRepository.class);
        BeanDefinition repoBeanDefinition = context.getBeanDefinition("userRepositoryImpl");
        assertNotNull(repoBean);
        assertNotNull(repoBeanDefinition);
        System.out.println(repoBean.toString());
        System.out.println(repoBeanDefinition);
    }

    @Test
    void annotationTestScan(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.spring.intro.beans");
        context.refresh();

        UserRepository repoBean = context.getBean(UserRepository.class);
        BeanDefinition repoBeanDefinition = context.getBeanDefinition("userRepositoryImpl");
        assertNotNull(repoBean);
        assertNotNull(repoBeanDefinition);
        System.out.println(repoBean.toString());
        System.out.println(repoBeanDefinition);
    }

    @Configuration
    static class BeanConfig {

        @Bean
        public UserService userService(UserRepository userRepository){
            return new UserServiceImpl(userRepository);
        }

        @Bean
        public UserRepository userRepository(){
            return new UserRepositoryImpl();
        }

    }

    @Test
    void javaConfigTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.refresh();

        UserRepository repoBean = context.getBean(UserRepository.class);
        BeanDefinition repoBeanDefinition = context.getBeanDefinition("userRepository");
        assertNotNull(repoBean);
        assertNotNull(repoBeanDefinition);
        System.out.println(repoBean.toString());
        System.out.println(repoBeanDefinition);
    }

    @Test
    void xmlTest(){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("beans.xml");
        context.refresh();

        UserRepository repoBean = context.getBean(UserRepository.class);
        BeanDefinition repoBeanDefinition = context.getBeanDefinition("repositoryXml");
        assertNotNull(repoBean);
        assertNotNull(repoBeanDefinition);
        System.out.println(repoBean.toString());
        System.out.println(repoBeanDefinition);
    }

    @Test
    void getBeanByNameOrTypeTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.refresh();

        UserRepository repoBean = context.getBean(UserRepository.class);
        BeanDefinition repoBeanDefinition = context.getBeanDefinition("userRepository");

        assertNotNull(repoBean);
        assertNotNull(repoBeanDefinition);
        System.out.println(repoBean.toString());
        System.out.println(repoBeanDefinition);
    }

    @Test
    void getBeanAnnotationTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.register(AnnotationInject.class);
        context.refresh();

        AnnotationInject bean = context.getBean(AnnotationInject.class);

        assertNotNull(bean);
        assertNotNull(bean.getUserRepository());
    }

    @Test
    void getBeanAnnotationSetterTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.register(AnnotationSetterInject.class);
        context.refresh();

        AnnotationSetterInject bean = context.getBean(AnnotationSetterInject.class);

        assertNotNull(bean);
        assertNotNull(bean.getUserRepository());
    }

    @Test
    void getBeanConstructorTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.register(ConstructorInject.class);
        context.refresh();

        ConstructorInject bean = context.getBean(ConstructorInject.class);

        assertNotNull(bean);
        assertNotNull(bean.getUserRepository());
    }

    @Configuration
    static class BeanTwiceConfig {

        @Bean
        public UserService userService(UserRepository userRepository){
            return new UserServiceImpl(userRepository);
        }

        @Bean
//        @Primary
//        @Qualifier("userRepository")
        public UserRepository userRepository(){
            return new UserRepositoryImpl();
        }

        @Bean
        public UserRepository userRepository2(){
            return new UserRepositoryImpl();
        }

    }

    @Test
    void selectBeanTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanTwiceConfig.class);
        context.register(AnnotationName.class);
        context.refresh();

        AnnotationName bean = context.getBean(AnnotationName.class);

        assertNotNull(bean);
    }

    @Test
    void runnerTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Runner.class);
        context.refresh();
    }


}
