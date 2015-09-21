package com.vernal.is.model;

import java.util.List;

public class Questions {

	private String qno;
	private String question;
	private String type;
	private boolean optionValue;
	private List<Options> typeList;
	private boolean multipleChoiceValue;
	private boolean isFreeText;
	/**
	 * @return the qno
	 */
	public String getQno() {
		return qno;
	}
	/**
	 * @param qno the qno to set
	 */
	public void setQno(String qno) {
		this.qno = qno;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the typeList
	 */
	public List<Options> getTypeList() {
		return typeList;
	}
	/**
	 * @param typeList the typeList to set
	 */
	public void setTypeList(List<Options> typeList) {
		this.typeList = typeList;
	}
	/**
	 * @param optionValue the optionValue to set
	 */
	public void setOptionValue(boolean optionValue) {
		this.optionValue = optionValue;
	}
	/**
	 * @param multipleChoiceValue the multipleChoiceValue to set
	 */
	public void setMultipleChoiceValue(boolean multipleChoiceValue) {
		this.multipleChoiceValue = multipleChoiceValue;
	}
	/**
	 * @return the isOption
	 */
	public boolean isOptionValue() {
		return optionValue;
	}
	/**
	 * @param isOption the isOption to set
	 */
	public void setOption(boolean optionValue) {
		this.optionValue = optionValue;
	}
	/**
	 * @return the isMultipleChoice
	 */
	public boolean isMultipleChoiceValue() {
		return multipleChoiceValue;
	}
	/**
	 * @param isMultipleChoice the isMultipleChoice to set
	 */
	public void setMultipleChoice(boolean multipleChoiceValue) {
		this.multipleChoiceValue = multipleChoiceValue;
	}
	/**
	 * @return the isFreeText
	 */
	public boolean isFreeText() {
		return isFreeText;
	}
	/**
	 * @param isFreeText the isFreeText to set
	 */
	public void setFreeText(boolean isFreeText) {
		this.isFreeText = isFreeText;
	}
	
	
}
