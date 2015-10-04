/**
 * 
 */
package com.vernal.is.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
/*
import com.vernal.is.dao.UserDAO;
import com.vernal.is.dao.impl.UserDAOImpl;*/
import com.vernal.is.model.Student;
import com.vernal.is.model.EngagementQuestion;
import com.vernal.is.model.Evaluations;
import com.vernal.is.model.Repository;
import com.vernal.is.translator.DashBoardTranslator;

/**
 * @author ramarla
 * 
 */
@Component

public class DashBoardService extends BaseService{
	
	
	@Resource
	DashBoardTranslator dashBoardTranslator;

	public List<Repository> getRepositoryDetail() {
		List<Repository> repositories = dashBoardTranslator
				.createRepositoryList();
		return repositories;

	}


	public EngagementQuestion getEngagementQuestion() throws IOException {
		File file = new File("engagement-question.json");
		InputStream inputStream = null;
		EngagementQuestion engagementQuestion = null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream = this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/engagement-question.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("engagement-question.json");
			} catch (FileNotFoundException exception) {
				// LOGGER.error("Error getting getApiConfig:",
				// exception.getMessage());
				throw exception;
			}
		}
		engagementQuestion = gson.fromJson(
				commonUtil.getStringFromInputStream(inputStream),
				EngagementQuestion.class);
		return engagementQuestion;
	}
	
	public Evaluations getEvaluations() throws IOException{
		File file = new File("dashboard-evaluation.json");
		InputStream inputStream = null;
		Evaluations evaluations =null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream =  this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/dashboard-evaluation.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("dashboard-evaluation.json");
			} catch (FileNotFoundException exception) {
				throw exception;
			}
		}
		evaluations = gson.fromJson(commonUtil.getStringFromInputStream(inputStream), Evaluations.class);
		return evaluations;
	}
	
	public Student getStudentsList() throws IOException {
		File file = new File("students-list.json");
		InputStream inputStream = null;
		Student dashBoard =null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream =  this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/students-list.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("students-list.json");
			} catch (FileNotFoundException exception) {
				throw exception;
			}
		}
		dashBoard = gson.fromJson(commonUtil.getStringFromInputStream(inputStream), Student.class);
		System.out.println("stu list-=------" + gson.toJson(dashBoard));
		//UserDAOImpl userDAO = new UserDAOImpl();
	//	System.out.println("userDAO.getUserInfo()"+gson.toJson(userDAO.getUserInfo()));
		return dashBoard;
	}
	
	public Student getActivity() throws IOException{
		File file = new File("dashboard-activity.json");
		InputStream inputStream = null;
		Student dashBoard =null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream =  this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/dashboard-activity.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("dashboard-activity.json");
			} catch (FileNotFoundException exception) {
				throw exception;
			}
		}
		dashBoard = gson.fromJson(commonUtil.getStringFromInputStream(inputStream), Student.class);
		System.out.println("acti list-=------" + gson.toJson(dashBoard));
		return dashBoard;
	}
}
