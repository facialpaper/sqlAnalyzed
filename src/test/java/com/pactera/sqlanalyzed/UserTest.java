package com.pactera.sqlanalyzed;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pactera.sqlanalyzed.entity.User;
import com.pactera.sqlanalyzed.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class  UserTest {
   
	@Autowired
    private UserService userService;
	
	@Test
	 public void test1() {

	        User user = userService.getUserByUserId("6B5C3292D6E708BDE0531CFF000A2718");

	        //System.out.println(user.getName());
	        assertEquals("董*安",user.getName());
	    }
}
