package com.imeic.test;

import com.imeic.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        while (true) {
            UserTest userTest = new UserTest();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请选择要执行的服务：1、查询，2、添加，3、更新，4、删除");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    userTest.findId();
                    continue;
                case 2:
                    userTest.findAdd();
                    continue;
                case 3:
                    userTest.findUp();
                    continue;
                case 4:
                    userTest.findDel();
                    continue;
            }
        }
    }

    public void findId() {
        //创建输入语句
        Scanner scanner = new Scanner(System.in);
        //读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis数据库，创建sqlsessionfactory类的实例
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession类实例
        SqlSession session = sqlMapper.openSession();
        System.out.println("请输入要查询的Id：");
        int id = (int) scanner.nextInt();
        //传入参数查询
        User userid = session.selectOne("findById", id);
        //输出查询到的内容
        System.out.println(userid.toString());
        //关闭流
        session.close();
    }


    public void findAdd() {
        int num = 0;
        //创建输入语句
        Scanner scanner = new Scanner(System.in);
        //读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis数据库，创建sqlsessionfactory类的实例
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession类实例
        SqlSession session = sqlMapper.openSession();
        System.out.println("请输入要增加内容的Name：");
        String name = scanner.next();
        System.out.println("请输入要增加内容的Age：");
        int age = scanner.nextInt();
        System.out.println("请输入要增加内容的Position：");
        String position = scanner.next();
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setPosition(position);
        num = session.insert("findByAdd", user);
        session.commit();
        if (num == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        //关闭流
        session.close();
    }

    public void findUp() {
        int num = 0;
        //创建输入语句
        Scanner scanner = new Scanner(System.in);
        //读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis数据库，创建sqlsessionfactory类的实例
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession类实例
        SqlSession session = sqlMapper.openSession();
        System.out.println("请输入要更新的Id：");
        int id = (int) scanner.nextInt();
        System.out.println("请输入要更新内容的Name：");
        String name = scanner.next();
        System.out.println("请输入要更新内容的Age：");
        int age = scanner.nextInt();
        System.out.println("请输入要更新内容的Position：");
        String position = scanner.next();
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setPosition(position);
        num = session.update("findByUp", user);
        session.commit();
        if (num == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        //关闭流
        session.close();
    }


    public void findDel() {
        int num = 0;
        //创建输入语句
        Scanner scanner = new Scanner(System.in);
        //读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis数据库，创建sqlsessionfactory类的实例
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession类实例
        SqlSession session = sqlMapper.openSession();
        System.out.println("请输入要删除的Id：");
        int id = (int) scanner.nextInt();
        num = session.delete("findByDel", id);
        session.commit();
        if (num == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        //关闭流
        session.close();
    }

}
