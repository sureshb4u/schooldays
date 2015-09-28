/**
 * 
 */
package com.vernal.is.model;

import java.util.List;

/**
 * @author bashelu
 *
 */
public class Student {
	private List<Person> studentsList;
	private List<Inbox> inboxList;
	private List<Activity> activityList;
	/**
	 * @return the inboxList
	 */
	public List<Inbox> getInboxList() {
		return inboxList;
	}

	/**
	 * @param inboxList the inboxList to set
	 */
	public void setInboxList(List<Inbox> inboxList) {
		this.inboxList = inboxList;
	}

	/**
	 * @return the activityList
	 */
	public List<Activity> getActivityList() {
		return activityList;
	}

	/**
	 * @param activityList the activityList to set
	 */
	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	public List<Person> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<Person> studentsList) {
		this.studentsList = studentsList;
	}
	
}
