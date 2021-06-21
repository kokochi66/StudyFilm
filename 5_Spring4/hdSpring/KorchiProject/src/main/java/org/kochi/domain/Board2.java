package org.kochi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(appliesTo = "board")
public class Board2 implements Serializable {
	private static final long serialVersionUID = 7211418002481684234L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="board_no")
	private Integer boardNo;
	
	@Column(name="title")
	private String title;
	
	@Override
	public String toString() {
		return "Board2 [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + "]";
	}

	@Column(name="content")
	private String content;
	
	@Column(name="writer")
	private String writer;
	
	public Integer getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Column(name="reg_date")
	private Date regDate;
}
