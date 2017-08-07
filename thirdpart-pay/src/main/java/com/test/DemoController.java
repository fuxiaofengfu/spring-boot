package com.test;

import com.test.serivce.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiaofengfu on 2017/6/6.
 *
 * swagger
 */
@Controller
public class DemoController {

    @Autowired
    Configration configration;
    @Autowired
    PersonService personService;

    @RequestMapping(value="/")
    public String demo(Model modelAndView){

        modelAndView.addAttribute("mytest","我的hello");
        return "index.html";
    }

    @RequestMapping(value="/demo")
    public void demo1(HttpServletResponse response){
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getOutputStream().print(new String("何鲁---丽,hello world".getBytes(),"ISO-8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
