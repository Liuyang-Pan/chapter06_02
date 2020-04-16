package com.chapter06_02.test;

import com.chapter06_02.domain.User;
import com.chapter06_02.domain.Users;
import com.chapter06_02.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.testFindAllUser();
//        testClass.test();
//        testClass.testUpdate();
//        testClass.testRegister();
//        testClass.testLogin();
    }

    public void testFindAllUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        List<User> list = userService.findAllUser();
        for (User user : list) {
            System.err.println(user);
        }
    }

    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        Scanner scanner = new Scanner(System.in);
        System.err.println("***********************欢迎查询************************：");
        System.err.println("请输入列名：");
        String field = scanner.next();
        System.err.println("请输入值：");
        String value = scanner.next();
        //List<Users> users = userService.listUsersByCondition(field, value);
        List<Users> users = userService.findListUsersByCondition(field, value);
        for (Users user : users) {
            System.err.println(user);
        }
    }

    public void testLogin() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        Scanner scanner = new Scanner(System.in);
        System.err.println("***********************欢迎登录************************：");
        System.err.println("请输入用户名：");
        String name = scanner.next();
        System.err.println("请输入密码：");
        String password = scanner.next();
        if (userService.doLogin(name, password)) {
            System.err.println("用户登录成功！");
        } else {
            System.err.println("用户登录失败！");
        }
    }

    public void testRegister() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        System.out.println("***********************欢迎注册************************");
        Scanner inputScanner = new Scanner(System.in);
        System.err.println("请输入用户名：");
        String name = inputScanner.next();
        System.err.println("请输入密码：");
        String onePassword = inputScanner.next();
        System.err.println("请确认密码：");
        String twoPassword = inputScanner.next();
        if (userService.doRegister(name, onePassword, twoPassword)) {
            System.out.println("注册成功！");
        } else {
            System.out.println("注册失败！");
        }
    }

    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        Scanner scanner = new Scanner(System.in);
        System.err.println("***********************修改用户信息************************");
        System.err.println("请输入列名：");
        String field = scanner.next();
        System.err.println("请输入值：");
        String value = scanner.next();
        System.err.println("请输入要修改的用户名：");
        String loginId = scanner.next();
        System.err.println("请输入密码：");
        String loginPwd = scanner.next();
        if (userService.doUpdate(field, value, loginId, loginPwd)) {
            System.err.println("用户信息修改成功！");
        } else {
            System.err.println("用户信息修改失败！");
        }
    }
}
