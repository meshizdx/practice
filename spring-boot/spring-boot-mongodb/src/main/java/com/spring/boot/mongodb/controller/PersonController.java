package com.spring.boot.mongodb.controller;

import com.spring.boot.mongodb.dao.PersonRepository;
import com.spring.boot.mongodb.entity.Location;
import com.spring.boot.mongodb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by BF100177 on 2017/5/31.
 */
@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/add")
    public Person add(){
        Person person = new Person("ylf",25);
        Collection<Location> locations = new LinkedHashSet<Location>();
        Location l1 = new Location("郑州","2015");
        Location l2 = new Location("郑州","2016");
        Location l3 = new Location("上海","2016");
        Location l4 = new Location("上海","2017");
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        locations.add(l4);
        person.setLocations(locations);
        return personRepository.save(person);
    }

    @RequestMapping("/findByName")
    public Person findByName(@RequestParam("name") String name){
        return personRepository.findByName(name);
    }

    @RequestMapping("/queryFindByName")
    public List<Person> findByName(Integer age){
        return personRepository.whithQueryFindByAge(age);
    }


}
