package com.wyt.survayPark.domain;

import java.sql.Timestamp;
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
@Table(name="survey")
public class Survey implements java.io.Serializable{


	private static final long serialVersionUID = 1L;
	private String id;
	private String title = "未命名";
	private String preText = "上一步";
	private String nextText = "下一步";
	private String exitText = "退出";
	private String doneText = "完成";
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	private Set<Page> pages = new HashSet<Page>();
	
	public Survey(){}

	private User user ;
	
	public Survey(String id, String title, String preText, String nextText,
			String exitText, String doneText, Timestamp createTime,
			Set<Page> pages, User user) {
		super();
		this.id = id;
		this.title = title;
		this.preText = preText;
		this.nextText = nextText;
		this.exitText = exitText;
		this.doneText = doneText;
		this.createTime = createTime;
		this.pages = pages;
		this.user = user;
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

	@Column(name="preText",length=225)
	public String getPreText() {
		return preText;
	}

	public void setPreText(String preText) {
		this.preText = preText;
	}

	@Column(name="nextText",length=225)
	public String getNextText() {
		return nextText;
	}

	public void setNextText(String nextText) {
		this.nextText = nextText;
	}

	@Column(name="exitText",length=225)
	public String getExitText() {
		return exitText;
	}

	public void setExitText(String exitText) {
		this.exitText = exitText;
	}

	@Column(name="doneText",length=225)
	public String getDoneText() {
		return doneText;
	}

	public void setDoneText(String doneText) {
		this.doneText = doneText;
	}

	@Column(name="createTime",updatable=false)
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@OneToMany(mappedBy="survey")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
