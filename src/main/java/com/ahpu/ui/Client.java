package com.ahpu.ui;

import com.ahpu.dao.IAccountDao;
import com.ahpu.service.IAccountService;
import com.ahpu.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 获取spring的ioc核心容器，并根据id获取对象
*/
public class Client {
    public static void main(String[] args){
        /**
         * ApplicationContext的三个常用实现类：
         *      ClassPathXmlApplicationContext:它可有加载类路径下的配置文件，要求配置文件必须在类路径下
         *      FileSystemXmlApplicationContext:它可以加载磁盘任意路径下的配置问价（必须有访问权限）
         *      AnnotationConfigApplicationContext:它是用于读取注解创建容器的
         *
         * 核心容器的两个接口引发出的问题：
         * ApplicationContext:
         *          它是构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件就马上创建配置文件中的对象
         * BeanFactory:
         *          它在构建核心容器时，创建对象采取的策略是延迟加载的方式。也就是说根据id获取对象，什么时候才真正的获取对象
         */

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();

        IAccountService as2 = (IAccountService) ac.getBean("accountService2");
        as2.saveAccount();

        IAccountService as3 = (IAccountService) ac.getBean("accountService3");
        as3.saveAccount();
        //手动关闭容器
        //((ClassPathXmlApplicationContext) ac).close();
//        System.out.println(as == as1);   //true  单例
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(as);
//        System.out.println(adao);
    }
}
