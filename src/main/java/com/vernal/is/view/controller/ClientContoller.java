/**
 * 
 */
package com.vernal.is.view.controller;
import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vernal.is.model.Client;
import com.vernal.is.service.ClientService;

/**
 * @author periyvi
 *
 */


@Controller
@RequestMapping("/client")
public class ClientContoller extends BaseController{

	@Resource
	ClientService clientService; 
	
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> getClientLists() throws Exception{
		Client clientList = clientService.getClientList();
		return new ResponseEntity<Client>(clientList,HttpStatus.OK);
	 }
	
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/getClientProfile")
	public ResponseEntity<?> getClientDetails() throws Exception{
		Client clientList = clientService.getClientList();
		return new ResponseEntity<Client>(clientList,HttpStatus.OK);
	 }
	
	
}
