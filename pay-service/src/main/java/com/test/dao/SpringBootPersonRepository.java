package com.test.dao;

import com.test.entity.SpringBootPerson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaofengfu on 2017/6/9.
 */
public interface SpringBootPersonRepository extends JpaRepository<SpringBootPerson,Integer> {

}
