package au.com.metlife.reference.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//@JsonInclude(value=Include.NON_NULL, content=Include.NON_NULL)
/**
 * @author rzameer
 *
 */
@Entity
@Table(name = "question" , schema = "EAPPOCC")
public class Question {
	
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String type;
	private String text;
	private String hintText;
	private String answerURI;
	private String additionalQuestionURI;
	private String additionalQuestionDescription;
 
	
	 
	 @OneToMany(mappedBy = "question") 
	

	private List<Answer> possibleAnswers;
	 
	 
	 @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
		@JoinColumn(name = "answer_id", referencedColumnName = "id")
		@JsonIgnore
	
		private Answer childQuestion;


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


	public List<Answer> getPossibleAnswers() {
		return possibleAnswers;
	}


	public void setPossibleAnswers(List<Answer> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}


	public Answer getChildQuestion() {
		return childQuestion;
	}


	public void setChildQuestion(Answer childQuestion) {
		this.childQuestion = childQuestion;
	}


	


 
	

}
