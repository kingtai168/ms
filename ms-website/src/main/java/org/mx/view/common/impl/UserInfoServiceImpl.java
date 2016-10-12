package org.mx.view.common.impl;

import org.mx.view.common.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserInfoServiceImpl implements UserViewService
{

//	@Autowired
//	private UserService userService;
	
	@Override
	public String getTest() throws Exception {
		// TODO Auto-generated method stub
//		return userService.getTest();
		return null;
	}

}
