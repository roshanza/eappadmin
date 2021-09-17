package au.com.metlife.reference.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;


public class AnswerDTO implements Serializable{	
	

	private Long id;
	private String text;
	private List<QuestionDTO> childQuestions;
	
	@ApiModelProperty( readOnly = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<QuestionDTO> getChildQuestions() {
		return childQuestions;
	}
	public void setChildQuestions(List<QuestionDTO> childQuestions) {
		this.childQuestions = childQuestions;
	}	
	
	
}
