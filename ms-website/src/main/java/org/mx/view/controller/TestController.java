package org.mx.view.controller;

import org.mx.view.common.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController
{
	
	@Autowired
	private UserViewService userViewService;
	
    @RequestMapping("totest")
    public String toTest()
    {
		try {
			String	str = userViewService.getTest();
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "test";
    }
}
