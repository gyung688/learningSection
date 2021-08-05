package com.lhg.domain;

public class DefaultVO {

	private int nowPage = 1;
	
	private int cntPerPage = 5;
	
	private int start;
	
	private String searchWord = "";
	
	private String searchType = "";    
		

//  /** 검색KeywordFrom */
//  private String searchKeywordFrom = "";    
//
//	/** 검색KeywordTo */
//  private String searchKeywordTo = "";
//  
//  /** 검색 시작날짜 (7일전,한달전,세달전, ···) */
//  private String searchStartDate = "";	

	
	
	public int getNowPage() {
		return nowPage;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	

	
	
	
	
//	/** 검색조건 */
//    private String searchCondition = "";
//    
//    /** 검색Keyword */
//    private String searchKeyword = "";
//    
//    /** 검색사용여부 */
//    private String searchUseYn = "";
//    
//    /** 현재페이지 */
//    private int pageIndex = 1;
//    
//    /** 페이지갯수 */
//    private int pageUnit = 15;
//    
//    /** 페이지사이즈 */
//    private int pageSize = 10;
//
//    /** firstIndex */
//    private int firstIndex = 0;
//
//    /** lastIndex */
//    private int lastIndex = 1;
//
//    /** recordCountPerPage */
//    private int recordCountPerPage = 10;
// 
//    /** 검색KeywordFrom */
//    private String searchKeywordFrom = "";    
//
//	/** 검색KeywordTo */
//    private String searchKeywordTo = "";
//    
//    /** 검색 시작날짜 (7일전,한달전,세달전, ···) */
//    private String searchStartDate = "";
//    
//    /** 스태프키 */
//    private String kStaffKey = "0";
}
