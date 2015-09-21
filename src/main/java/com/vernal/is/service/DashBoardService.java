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

import com.vernal.is.model.DashBoard;
import com.vernal.is.model.EngagementQuestion;
import com.vernal.is.model.Evaluations;
import com.vernal.is.model.Question;
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

	public Question getQuestion() throws IOException {
		File file = new File("dynamic-fields.json");
		InputStream inputStream = null;
		Question question = null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream = this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/dynamic-fields.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("dynamic-fields.json");
			} catch (FileNotFoundException exception) {
				// LOGGER.error("Error getting getApiConfig:",
				// exception.getMessage());
				throw exception;
			}
		}
		question = gson.fromJson(
				commonUtil.getStringFromInputStream(inputStream),
				Question.class);
		return question;
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

	public DashBoard getInboxDetail() throws IOException {
		File file = new File("dashboard-inbox.json");
		InputStream inputStream = null;
		DashBoard dashBoard =null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream =  this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/dashboard-inbox.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("dashboard-inbox.json");
			} catch (FileNotFoundException exception) {
				throw exception;
			}
		}
		dashBoard = gson.fromJson(commonUtil.getStringFromInputStream(inputStream), DashBoard.class);
		return dashBoard;
	}
	
	public DashBoard getActivity() throws IOException{
		File file = new File("dashboard-activity.json");
		InputStream inputStream = null;
		DashBoard dashBoard =null;
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
		dashBoard = gson.fromJson(commonUtil.getStringFromInputStream(inputStream), DashBoard.class);
		System.out.println("acti list-=------" + gson.toJson(dashBoard));
		return dashBoard;
	}
}
