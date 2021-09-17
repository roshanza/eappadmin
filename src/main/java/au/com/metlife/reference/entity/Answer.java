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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
@Entity
@Table(name = "answer" , schema = "EAPPOCC")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	private String text;	
	
	@OneToMany(mappedBy = "childQuestion") 
	

	private List<Question> childQuestions;
	
	
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	@JsonIgnore
	
	private Question question;



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public List<Question> getChildQuestions() {
		return childQuestions;
	}



	public void setChildQuestions(List<Question> childQuestions) {
		this.childQuestions = childQuestions;
	}



	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}



	
	

	
	
	
}
