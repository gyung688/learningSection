package com.lhg.domain;


public class BoardVO extends DefaultVO{

	private String eBoardKey 		= "";	//e_board pk
	private String eBoardNo 		= "";	//게시판 번호
	private String eBoardTitle 		= "";	//게시판  제목
	private String eBoardContent	= "";	//게시판  내용
	private String eBoardDate 		= "";	//게시판  작성일
	private String eBoardUdate 		= "";	//게시판  수정일
	private String kUserKey 		= "";	//게시판  작성자 key
	private String kUserName		= "";	//게시판  작성자 이름
	
	
	public String getkUserName() {
		return kUserName;
	}
	public void setkUserName(String kUserName) {
		this.kUserName = kUserName;
	}
	public String getkUserKey() {
		return kUserKey;
	}
	public void setkUserKey(String kUserKey) {
		this.kUserKey = kUserKey;
	}
	public String geteBoardKey() {
		return eBoardKey;
	}
	public void seteBoardKey(String eBoardKey) {
		this.eBoardKey = eBoardKey;
	}
	public String geteBoardNo() {
		return eBoardNo;
	}
	public void seteBoardNo(String eBoardNo) {
		this.eBoardNo = eBoardNo;
	}
	public String geteBoardTitle() {
		return eBoardTitle;
	}
	public void seteBoardTitle(String eBoardTitle) {
		this.eBoardTitle = eBoardTitle;
	}
	public String geteBoardContent() {
		return eBoardContent;
	}
	public void seteBoardContent(String eBoardContent) {
		this.eBoardContent = eBoardContent;
	}
	public String geteBoardDate() {
		return eBoardDate;
	}
	public void seteBoardDate(String eBoardDate) {
		this.eBoardDate = eBoardDate;
	}
	public String geteBoardUdate() {
		return eBoardUdate;
	}
	public void seteBoardUdate(String eBoardUdate) {
		this.eBoardUdate = eBoardUdate;
	}
	
	
	
}
