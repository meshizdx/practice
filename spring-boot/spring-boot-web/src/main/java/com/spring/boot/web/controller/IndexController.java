package com.spring.boot.web.controller;

import com.spring.boot.web.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BF100177 on 2017/5/26.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        Person single = new Person("张三","男","25");
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("李四","男","28");
        Person p2 = new Person("王五","男","25");
        Person p3 = new Person("赵六","男","29");
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";

    }

}
