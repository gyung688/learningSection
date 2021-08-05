package com.lhg.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lhg.domain.BoardVO;

public interface BoardService {

	//게시글 등록
	public void insertBoard(BoardVO boardVO, MultipartHttpServletRequest mRequest) throws Exception;
	
	//게시글 리스트
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;
	
	//게시글 수
	public int selectBoardListCnt(BoardVO boardVO) throws Exception;
	
	//게시글 상세
	public BoardVO selectBoardInfo(BoardVO boardVO) throws Exception;
	
	//게시글 수정
	public void updateBoard(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mRequest) throws Exception;
	
	//게시글 삭제 
	public void deleteBoard(int eBoardKey) throws Exception;

	//파일 조회
	public List<Map<String, Object>> selectBoardFile(int eBoardKey) throws Exception;
	
	//파일다운
	public Map<String, Object> selectBoardFileDown(Map<String, Object> map) throws Exception;

	
}
