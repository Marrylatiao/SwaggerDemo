package cn.liao1202.SwaggerDemo.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "balance")
    private Double balance;
}
