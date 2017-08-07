package com.test.serivce;

import com.test.dao.SpringBootPersonRepository;
import com.test.entity.SpringBootPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiaofengfu on 2017/6/9.
 */
@Service
public class PersonService {

    @Autowired
    private SpringBootPersonRepository personRepository;
    @Autowired
    IdCardService idCardService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(transactionManager="transactionManager",propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public SpringBootPerson save() throws Exception {
        SpringBootPerson springBootPerson = new SpringBootPerson();
        springBootPerson.setGender("男");
        springBootPerson.setName("学海无涯");
        springBootPerson.setTransPropagation("Propagation.REQUIRED");
        springBootPerson = personRepository.saveAndFlush(springBootPerson);
        System.out.println("*******当前保存但未提交事务的personId="+springBootPerson.getId());
        try {
            idCardService.save(springBootPerson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //test propagation NOT_SUPPORTED SUPPORTS
        //idCardService.findPerson();
        //throw new Exception("****外层事务异常>>>>>>>>>>>>>>>>");
        return springBootPerson;
    }

    @Transactional(value="jdbcTransactionManager",propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void saveJdbc() throws Exception {
        String sql = "INSERT INTO `spring_boot_person` (`gender`, `name`, `trans_propagation`)" +
                     "VALUES ('男', '学海无涯', 'jdbc_trans')";
        jdbcTemplate.execute(sql);
        try {
            idCardService.jdbcSave();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //throw new Exception("****外层事务异常>>>>>>>>>>>>>>>>");
    }

}
