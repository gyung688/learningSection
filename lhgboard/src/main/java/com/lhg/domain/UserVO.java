package com.lhg.domain;

import org.apache.ibatis.type.Alias;

@Alias("userVO")
public class UserVO {

	private String kUserKey			="";	//k_user pk
	private String kUserId			="";	//아이디
	private String kUserPw			="";	//비밀번호
	private String kUserName		="";	//이름
	private String kUserMail		="";	//메일
	private String kUserPost		="";	//우편번호
	private String kUserAddr		="";	//주소
	private String kUserAddrDetail	="";	//상세주소
	
	
	public String getkUserPost() {
		return kUserPost;
	}
	public void setkUserPost(String kUserPost) {
		this.kUserPost = kUserPost;
	}
	public String getkUserAddrDetail() {
		return kUserAddrDetail;
	}
	public void setkUserAddrDetail(String kUserAddrDetail) {
		this.kUserAddrDetail = kUserAddrDetail;
	}
	public String getkUserKey() {
		return kUserKey;
	}
	public void setkUserKey(String kUserKey) {
		this.kUserKey = kUserKey;
	}
	public String getkUserId() {
		return kUserId;
	}
	public void setkUserId(String kUserId) {
		this.kUserId = kUserId;
	}
	public String getkUserPw() {
		return kUserPw;
	}
	public void setkUserPw(String kUserPw) {
		this.kUserPw = kUserPw;
	}
	public String getkUserName() {
		return kUserName;
	}
	public void setkUserName(String kUserName) {
		this.kUserName = kUserName;
	}
	public String getkUserMail() {
		return kUserMail;
	}
	public void setkUserMail(String kUserMail) {
		this.kUserMail = kUserMail;
	}
	public String getkUserAddr() {
		return kUserAddr;
	}
	public void setkUserAddr(String kUserAddr) {
		this.kUserAddr = kUserAddr;
	}
	
	
}
