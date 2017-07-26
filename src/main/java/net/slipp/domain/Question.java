package net.slipp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private Long id;
	
	private String writer;
	
	private String title;
	
	private String contents;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	public Question() {
		
	}

	public Question(String writer, String title, String contents) {
		this.datetime=new Date();
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
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

	@Override
	public String toString() {
		return "Question [id=" + id + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", datetime=" + datetime + "]";
	}


		
	
	
}
