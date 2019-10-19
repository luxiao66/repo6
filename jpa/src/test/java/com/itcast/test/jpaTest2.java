package com.itcast.test;

import com.itcast.domain.Customer;
import com.itcast.util.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaTest2 {
    @Test
    public void testSave(){
        //1.加载配置文件获得实体类管理器工厂对象
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过工厂对象获得实体管理器
        EntityManager em = factory.createEntityManager();
        //3.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //4.完成增删该操作,保存一个对象到数据库中
        Customer customer=new Customer();
        customer.setCustName("青城");
        customer.setCustInstry("环保");
        //5.保存
        em.persist(customer);
        //6.提交事务
        tx.commit();
        //7.关闭资源
        em.close();
        factory.close();
    }
    @Test
    public void testSave2(){
        //1.加载配置文件获得实体类管理器工厂对象
        EntityManager em = JpaUtils.getEntityManager();
        //3.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //4.完成增删该操作,保存一个对象到数据库中
        Customer customer=new Customer();
        customer.setCustName("青风");
        customer.setCustInstry("环保");
        //5.保存
        em.persist(customer);
        //6.提交事务
        tx.commit();
        //7.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
    }
    @Test
    public void testFind(){
        //1.根据jpaUtil获得实体实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //2.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       //3.执行增删改查操作;
        Customer customer = em.find(Customer.class, 3L);
        System.out.println(customer);

        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
}
    @Test
    public void testReference(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.getReference(Customer.class, 2L);
        System.out.println(customer);
        tx.commit();
        entityManager.close();
    }
    @Test
    public void testRemove(){
        //1.根据jpaUtil获得实体实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //2.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.执行增删改查操作;
        Customer customer = em.find(Customer.class, 1L);
        em.remove(customer);

        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
    }
    @Test
    public void testUpdate(){
        //1.根据jpaUtil获得实体实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //2.获取事务对象,开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.执行增删改查操作;
        Customer customer = em.find(Customer.class, 2L);
        customer.setCustInstry("教育");
em.merge(customer);
        //4.提交事务
        tx.commit();
        //5.关闭资源
        em.close();
//        factory.close();公共工厂不关闭
    }
}
