package net.slipp.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Question {

	@Id
	@GeneratedValue
	@JsonProperty
	private Long id;

	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_question_writer"))
	@JsonProperty
	private User writer;
	
	@JsonProperty
	private String title;
		
	@Lob
	@JsonProperty
	private String contents;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	@JsonProperty
	private Integer countOfAnswer =0;
	
	@OneToMany(mappedBy="question")
	@OrderBy("id DESC")
	private List<Answer> answers;
	
	public Question() {

	}

	public Question(User writer, String title, String contents) {
		this.datetime = new Date();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void update(String title2, String contents2) {
		this.title=title2;
		this.contents=contents2;
	}

	public boolean isSameWriter(User sessionedUser) {
		return this.writer.equals(sessionedUser);
	}

	
	
	public Integer getCountOfAnswer() {
		return countOfAnswer;
	}

	public void setCountOfAnswer(Integer countOfAnswer) {
		this.countOfAnswer = countOfAnswer;
	}

	public void addAnswer() {
		this.countOfAnswer +=1;	
	}
	
	public void deleteAnswer(){
		this.countOfAnswer  -=1;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", datetime=" + datetime + ", countOfAnswer=" + countOfAnswer + ", answers=" + answers + "]";
	}

	
	
}
