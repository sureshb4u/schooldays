package com.vernal.is.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Leave")
public class LeaveManagementController {
	
	/*@RequestMapping(value = "/todaysList", method = RequestMethod.GET)
	@ResponseBody
	public LeaveManagementList getUsers() throws Exception {
		System.out.println("Get Users>>>>>>>>>>");
		LeaveManagementList leaveManagementList = new LeaveManagementList();
		leaveManagementList.setLeaveManagementList(leave.getLeaveManagementList());
		return leaveManagementList;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object getUsers1() throws Exception {
		System.out.println("Get Users>>>>>>>>>>");
		return "WELCOME";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object saveUsers(@ModelAttribute("userForm") UserDTO user,
            Map<String, Object> model) throws Exception {
		System.out.println("saveUsers>>>>>>>>>>");
		return "success";
	}
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addBills(@RequestBody UserDTO userDTO) throws Exception {
		ResponseBean responseBean = new ResponseBean();
	//	responseBean = leave.insertUser(userDTO);
		return responseBean;
	}


	@RequestMapping(value = "updateUser", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseBean updateBills(@RequestBody UserDTO userDTO) throws Exception {
		ResponseBean responseBean = new ResponseBean();
	//	responseBean = leave.updateUser(userDTO);
		return responseBean;
	}

	@RequestMapping(value = "deleteBill/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseBean deleteBill(@PathVariable int userId) throws Exception {
		ResponseBean responseBean = new ResponseBean();
	//	responseBean = leave.deleteUser(userId);
		return responseBean;
	}*/
}
