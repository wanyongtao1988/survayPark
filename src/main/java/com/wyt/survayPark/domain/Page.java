package com.wyt.survayPark.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="page")
public class Page implements java.io.Serializable {

	private String id;
	private String title;
	private String description;
	
	//调查
	private Survey survey ;
	//问题集合
	private Set<Question> questions = new HashSet<Question>();
	
	public Page(){}

	public Page(String id, String title, String description, Survey survey,
			Set<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.survey = survey;
		this.questions = questions;
	}

	@Id
	@Column(name="id",nullable=false,length=36)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="title",length=225)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="description",length=225)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="surveyId")
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@OneToMany(mappedBy="page")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
	

}
