package au.com.metlife.reference.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;


public class QuestionDTO implements Serializable{	
  
	private Long id;	
	private String type;
	private String text;
	private String hintText;
	private String answerURI;
	private String additionalQuestionURI;
	private String additionalQuestionDescription;
	private List<AnswerDTO> possibleAnswers;
	
	@ApiModelProperty( readOnly = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHintText() {
		return hintText;
	}
	public void setHintText(String hintText) {
		this.hintText = hintText;
	}
	public String getAnswerURI() {
		return answerURI;
	}
	public void setAnswerURI(String answerURI) {
		this.answerURI = answerURI;
	}
	public String getAdditionalQuestionURI() {
		return additionalQuestionURI;
	}
	public void setAdditionalQuestionURI(String additionalQuestionURI) {
		this.additionalQuestionURI = additionalQuestionURI;
	}
	public String getAdditionalQuestionDescription() {
		return additionalQuestionDescription;
	}
	public void setAdditionalQuestionDescription(String additionalQuestionDescription) {
		this.additionalQuestionDescription = additionalQuestionDescription;
	}
	public List<AnswerDTO> getPossibleAnswers() {
		return possibleAnswers;
	}
	public void setPossibleAnswers(List<AnswerDTO> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}
	
	
	

}
