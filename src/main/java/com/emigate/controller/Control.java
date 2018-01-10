package com.emigate.controller;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emigate.metier.EmailService;

@RestController

public class Control{
	private Logger logger = LoggerFactory.getLogger(Control.class);

  @Autowired
  EmailService eService;

 /* @RequestMapping(value="/sendmail", method = RequestMethod.POST)
	public String banana(HttpServletRequest request){
		


	 
	  try {

		 eService.sendMail(request.getParameter("a"),request.getParameter("sujet"),request.getParameter("message"));
		  }catch( Exception e ){
				// catch error
				logger.info("Error Sending Email: " + e.getMessage());
				  

			}
	
	  return "redirect:/publication";

	}*/
 
}


	
	