package com.vernal.is.view.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vernal.is.service.CommonServices;

@Controller
@RequestMapping(value="/common")
public class CommonController extends BaseController {
	
	@Resource
	CommonServices commonServices; 
	
	@RequestMapping(value="/{emailId}/email-verification",method = RequestMethod.POST)
	public ResponseEntity<?> emailVerification(@PathVariable(value="emailId")String emailId, HttpSession session){
		System.out.println("emailId>>>>>>"+emailId);
		String s= null;
		try {
			if(emailId != null && !emailId.isEmpty())
				s = commonServices.verifyEmail(emailId, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}

}
