package com.lhg.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lhg.domain.BoardVO;
import com.lhg.persistence.BoardDAO;
import com.lhg.util.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
					
	//게시글 등록, 수정
	@Override
	public void insertBoard(BoardVO boardVO, MultipartHttpServletRequest mRequest) throws Exception {
		boardDAO.insertUpdatetBoard(boardVO); 
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(boardVO, mRequest);
		int size = list.size();
		for(int i = 0; i < size; i++) { 
			boardDAO.insertBoardFile(list.get(i));
		}
	}
	
	//게시글 리스트
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		return boardDAO.selectBoardList(boardVO);
	}

	//게시글 수
	@Override
	public int selectBoardListCnt(BoardVO boardVO) throws Exception {
		return boardDAO.selectBoardListCnt(boardVO);
	}
	
	//게시글 상세
	@Override
	public BoardVO selectBoardInfo(BoardVO boardVO) throws Exception {
		return boardDAO.selectBoardInfo(boardVO);
	}

	//게시글 수정
	@Override
	public void updateBoard(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mRequest) throws Exception{
		boardDAO.insertUpdatetBoard(boardVO);
		
		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardVO, files, fileNames, mRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i = 0; i<size; i++){
			tempMap = list.get(i);
			if(tempMap.get("is_new").equals("Y")){
				boardDAO.insertBoardFile(tempMap);
			}else{
				boardDAO.updateBoardFile(tempMap);
			}
		}
	}
	
	//게시글 삭제
	@Override
	public void deleteBoard(int eBoardKey) throws Exception {
		boardDAO.deleteBoardFile(eBoardKey);
		boardDAO.deleteBoard(eBoardKey);
	}

	//파일 조회
	@Override
	public List<Map<String, Object>> selectBoardFile(int eBoardKey) throws Exception {
		return boardDAO.selectBoardFile(eBoardKey);
	}

	//파일 다운
	@Override
	public Map<String, Object> selectBoardFileDown(Map<String, Object> map) throws Exception {
		return boardDAO.selectBoardFileDown(map);
	}


}
