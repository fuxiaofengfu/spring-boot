package com.test.serivce;

import com.test.dao.SpringBootIdCardRepository;
import com.test.dao.SpringBootPersonRepository;
import com.test.entity.SpringBootIdCard;
import com.test.entity.SpringBootPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by xiaofengfu on 2017/7/7.
 */
@Service
public class IdCardService {

    @Autowired
    SpringBootIdCardRepository idCardRepository;
    @Autowired
    private SpringBootPersonRepository personRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(value="transactionManager",propagation = Propagation.NEVER,rollbackFor = Exception.class)
    public SpringBootIdCard save(SpringBootPerson person) throws Exception {
        SpringBootIdCard springBootIdCard = new SpringBootIdCard();
        springBootIdCard.setCardNo(UUID.randomUUID().toString());
        springBootIdCard.setExpire(new Date());
        springBootIdCard.setPersonId(person.getId());
        springBootIdCard.setTransPropagation("Propagation.REQUIRES_NEW");
        springBootIdCard = idCardRepository.saveAndFlush(springBootIdCard);
        System.out.println("*******当前保存但未提交事务的springBootIdCardId="+springBootIdCard.getId());
        throw new Exception("****内层事务异常>>>>>>>>>>>>>>>>");
       // return springBootIdCard;
    }

    @Transactional(value="jdbcTransactionManager",propagation = Propagation.MANDATORY,rollbackFor = Exception.class)
    public void jdbcSave() throws Exception {
        String sql = "INSERT INTO `spring_boot_idcard` (`card_no`, `expire`, `person_id`, `trans_propagation`)" +
                     "values ('edf9d39d3ace', '2017-07-11 00:52:49', 75, 'jdbc_nested')";
        jdbcTemplate.execute(sql);
        //throw new Exception("****内层事务异常>>>>>>>>>>>>>>>>");
    }

    @Transactional(transactionManager="jdbcTransactionManager",propagation = Propagation.NOT_SUPPORTED,rollbackFor=Exception.class)
    public void findPerson(){
        List<SpringBootPerson> all = personRepository.findAll();
        if(null != all && !all.isEmpty()){
            System.out.println(all.size());
            Iterator<SpringBootPerson> iterator = all.iterator();
            while (iterator.hasNext()){
                System.out.println("****SpringBootPerson.id="+iterator.next().getId());
            }
        }
    }
}
