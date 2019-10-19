package com.itcast.test;

import com.itcast.domain.Customer;
import com.itcast.util.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class Jpql {
    @Test
    public void testFindAll(){
        //1.根据jpaUtil获得实体实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //2.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.执行增删改查操作;
        String jpql="from Customer";
        Query query = em.createQuery(jpql);//创建query对象query对象才是执行jpql的对象
        //发送查询并封装结果集
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }
        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
    }
    @Test
    public void testOrder(){
        //1.根据jpaUtil获得实体实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //2.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.执行增删改查操作;
        String jpql="from Customer order by custId desc";
        Query query = em.createQuery(jpql);//创建query对象query对象才是执行jpql的对象
        //发送查询并封装结果集
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }
        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
    }
    @Test
    public void testCount(){
        //1.根据jpaUtil获得实体实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //2.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.执行增删改查操作;
        String jpql="select count(custId) from Customer";
        Query query = em.createQuery(jpql);//创建query对象query对象才是执行jpql的对象
        //发送查询并封装结果集
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);
        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
    }
    @Test
    public void testPage(){
        //1.根据jpaUtil获得实体实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //2.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.执行增删改查操作;
        String jpql="from Customer";
        Query query = em.createQuery(jpql);//创建query对象query对象才是执行jpql的对象
        //对参查询参数进行赋值
        //分页
        //起始索引
        query.setFirstResult(0);
        //每页查询条数
        query.setMaxResults(2);
        //发送查询并封装结果集
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }
        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
    }
    @Test
    public void testCondition(){
        //1.根据jpaUtil获得实体实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //2.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.执行增删改查操作;
        String jpql="from Customer where custName like ?";
        Query query = em.createQuery(jpql);//创建query对象query对象才是执行jpql的对象
        query.setParameter(1,"_城");
        //发送查询并封装结果集
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }
        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
    }
}
