/**
 * 
 */
package com.vernal.is.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vernal.is.model.DashBoard;
import com.vernal.is.model.EngagementQuestion;
import com.vernal.is.model.Evaluations;
import com.vernal.is.model.Question;
import com.vernal.is.model.Repository;
import com.vernal.is.service.DashBoardService;

/**
 * @author bashelu
 * 
 */
@Controller
@RequestMapping("/dashboard")
public class DashBoardController extends BaseController {

	@Resource
	DashBoardService dashBoardService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dashBoardHome() {

		return new ResponseEntity<>("welcome", HttpStatus.OK);
	}

	@RequestMapping(value = "/repository", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getRepositoryDetail() throws Exception {
		List<Repository> repositories = dashBoardService.getRepositoryDetail();
		return new ResponseEntity<List<Repository>>(repositories, HttpStatus.OK);
	}

	@RequestMapping(value = "/dynamicFields", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDynamicFields() throws Exception {
		Question question = dashBoardService.getQuestion();
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}

	@RequestMapping(value = "/engagementQuestion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getengagementQuestion() throws Exception {
		EngagementQuestion engagementQuestion = dashBoardService.getEngagementQuestion();
		return new ResponseEntity<EngagementQuestion>(engagementQuestion,HttpStatus.OK);
	}

	 @RequestMapping(value = "/evaluation", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> getEvaluation() throws Exception{
		 Evaluations  evaluations = dashBoardService.getEvaluations();
		 return new ResponseEntity<Evaluations>(evaluations,HttpStatus.OK);
	 }

	 @RequestMapping(value = "/inbox", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> getInboxDetail() throws Exception{
		 DashBoard dashBoard = dashBoardService.getInboxDetail();
		 return new ResponseEntity<DashBoard>(dashBoard,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/activity", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> getActivity() throws Exception{
		 DashBoard dashBoard = dashBoardService.getActivity();
		 return new ResponseEntity<DashBoard>(dashBoard,HttpStatus.OK);
	 }
}
