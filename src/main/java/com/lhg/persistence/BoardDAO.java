package com.lhg.persistence;

import java.util.List;
import java.util.Map;

import com.lhg.domain.BoardVO;

public interface BoardDAO {

	//게시글 등록, 수정
	public void insertUpdatetBoard(BoardVO boardVO) throws Exception;
	
	//게시글 리스트
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;

	//게시글 수
	public int selectBoardListCnt(BoardVO boardVO) throws Exception;
	
	//게시글 상세
	public BoardVO selectBoardInfo(BoardVO boardVO) throws Exception;
	
	//게시글 삭제
	public void deleteBoard(int eBoardKey) throws Exception;
	
	//파일 등록
	public void insertBoardFile(Map<String, Object> map) throws Exception;
	
	//파일 조회
	public List<Map<String,Object>> selectBoardFile(int eBoardKey) throws Exception;
	
	//파일 다운
	public Map<String, Object> selectBoardFileDown(Map<String, Object> map) throws Exception;
	
	//파일 수정
	public void updateBoardFile(Map<String, Object> map) throws Exception;
	
	//삭제된 게시글 파일 수정
	public void deleteBoardFile(int eBoardKey) throws Exception;
	
	//엑셀 출력 게시글 리스트
	public List<BoardVO> excelBoardList(BoardVO boardVO) throws Exception;
}
