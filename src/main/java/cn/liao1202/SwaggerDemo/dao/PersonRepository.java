package cn.liao1202.SwaggerDemo.dao;

import cn.liao1202.SwaggerDemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,Integer> {
}
