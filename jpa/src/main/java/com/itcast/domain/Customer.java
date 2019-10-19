package com.itcast.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 客户的实体类
 * 1.实体类和表的映射关系
 * @Table：实体类和表的映射关系
 * name:
 */
@Entity//声明实体类
@Table(name = "cst_customer")//建立实体类和表的映射关系
public class Customer implements Serializable {
    /**
     * @Id：声明主键的配置@GeneratedValue:配置主键的生成策略
     * strategy
     * @GenerationType.IDENTITY:自增:mysql
     * *底层数据库必须支持自动增长（对id自增）
     * @GenerationType.SEQUENCE:序列 oracle
     * @GenerationType.TABLE 通过一张表进行主键生成策略
     * @GenerationType.AUTO程序帮助选择生成策略，上边三种。先序列，如果数据库不支持，选table
     */
    @Id//声明当前私有属性为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cust_id") //指定和表中cust_id字段的映射关系
    private Long custId;
    @Column(name="cust_name")
    private String custName;
    @Column(name="cust_source")
    private String custSource;
    @Column(name="cust_industry")
    private String custInstry;
    @Column(name="cust_level")
    private String custLevel;
    @Column(name="cust_address")
    private String custAddress;
    @Column(name="cust_phone")
    private String custPhone;

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custInstry='" + custInstry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustInstry() {
        return custInstry;
    }

    public void setCustInstry(String custInstry) {
        this.custInstry = custInstry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
}
