package com.lhg.domain;

public class PagingVO {

	private int nowPage;	//현재페이지
	private int startPage;		//시작페이지
	private int endPage;		//끝페이지
	private int total;			//게시글개수
	private int cntPerPage;	//페이지당글개수
	private int lastPage;		//마지막페이지
	private int start;			//쿼리에쓸start
	private int end;			//end	
	private int cntPage = 5;	//
	
	public PagingVO(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calLastPage(getTotal(), getCntPerPage());
		calStartEndPage(getNowPage(), cntPage);
		calStartEnd(getNowPage(), getCntPerPage());
	}

	//제일 마지막 페이지 계산
	public void calLastPage(int toatl, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
	}
	
	// 시작, 끝 페이지 계산
	public void calStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if(getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if(getStartPage() < 1) {
			setStartPage(1);
		}
	}
	
	// DB쿼리에서 사용할 start, end 값 계산
	public void calStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage);
	}
	
	
	
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCntPage() {
		return cntPage;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	
	
}
