package com.test.pro11.ex04;

public class ArticleDTO {
	private int articleNo;
	private String writer;
	private String title;
	private String content;
	
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ArticleDTO [articleNo=" + articleNo + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ "]";
	}
}