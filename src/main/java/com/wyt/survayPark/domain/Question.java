package com.wyt.survayPark.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="question")
public class Question {
	
	private String id;
	// 题型0-8
	private int questionType;
	// 标题
	private String title;
	// 选项
	private String options;
	// 其他项
	private boolean other;

	// 其他项样式:0-无 1-文本框 2-下拉列表
	private int otherStyle;
	// 其他项下拉选项
	private String otherSelectOptions;

	// 矩阵式行标题集
	private String matrixRowTitles;
	// 矩阵式列标题集
	private String matrixColTitles;
	// 矩阵是下拉选项集
	private String matrixSelectOptions;
	
	//建立从Question到Page之间多对一关联关系
	private Page page ;
	
	public Question(){}

	public Question(String id, int questionType, String title, String options,
			boolean other, int otherStyle, String otherSelectOptions,
			String matrixRowTitles, String matrixColTitles,
			String matrixSelectOptions, Page page) {
		super();
		this.id = id;
		this.questionType = questionType;
		this.title = title;
		this.options = options;
		this.other = other;
		this.otherStyle = otherStyle;
		this.otherSelectOptions = otherSelectOptions;
		this.matrixRowTitles = matrixRowTitles;
		this.matrixColTitles = matrixColTitles;
		this.matrixSelectOptions = matrixSelectOptions;
		this.page = page;
	}

	@Id
	@Column(name="id",nullable=false,length=36)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="questionType",length=1)
	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	@Column(name="title",length=225)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="options",length=225)
	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@Column(name="other")
	@org.hibernate.annotations.Type(type="yes_no")
	public boolean isOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	@Column(name="otherStyle")
	public int getOtherStyle() {
		return otherStyle;
	}

	public void setOtherStyle(int otherStyle) {
		this.otherStyle = otherStyle;
	}

	@Column(name="otherSelectOptions")
	public String getOtherSelectOptions() {
		return otherSelectOptions;
	}

	public void setOtherSelectOptions(String otherSelectOptions) {
		this.otherSelectOptions = otherSelectOptions;
	}

	@Column(name="matrixRowTitles",length=225)
	public String getMatrixRowTitles() {
		return matrixRowTitles;
	}

	public void setMatrixRowTitles(String matrixRowTitles) {
		this.matrixRowTitles = matrixRowTitles;
	}

	@Column(name="matrixColTitles",length=225)
	public String getMatrixColTitles() {
		return matrixColTitles;
	}

	public void setMatrixColTitles(String matrixColTitles) {
		this.matrixColTitles = matrixColTitles;
	}

	@Column(name="matrixSelectOptions",length=225)
	public String getMatrixSelectOptions() {
		return matrixSelectOptions;
	}

	public void setMatrixSelectOptions(String matrixSelectOptions) {
		this.matrixSelectOptions = matrixSelectOptions;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="surveyId")
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	

}
