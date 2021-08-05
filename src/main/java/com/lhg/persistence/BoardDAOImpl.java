package com.lhg.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lhg.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.lhg.mappers.boardMapper";
	
	//게시글 등록, 수정
	@Override
	public void insertUpdatetBoard(BoardVO boardVO) throws Exception {
		sql.insert(namespace + ".insertUpdatetBoard", boardVO);
	}
	
	//게시글 리스트
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		return sql.selectList(namespace + ".selectBoardList", boardVO);
	}
	
	//게시글 수
	@Override
	public int selectBoardListCnt(BoardVO boardVO) throws Exception {
		return sql.selectOne(namespace + ".selectBoardListCnt", boardVO);
	}
	
	//게시글 상세
	@Override
	public BoardVO selectBoardInfo(BoardVO boardVO) throws Exception {
		return sql.selectOne(namespace + ".selectBoardInfo", boardVO);
	}
	
	//게시글 삭제
	@Override
	public void deleteBoard(int eBoardKey) throws Exception {
		sql.delete(namespace + ".deleteBoard", eBoardKey);
	}
	
	//파일 업로드
	@Override
	public void insertBoardFile(Map<String, Object> map) throws Exception{
		sql.insert(namespace + ".insertBoardFile", map);
	}

	//파일 조회
	@Override
	public List<Map<String, Object>> selectBoardFile(int eBoardKey) throws Exception {
		return sql.selectList(namespace + ".selectBoardFile", eBoardKey);
	}

	//파일 다운
	@Override
	public Map<String, Object> selectBoardFileDown(Map<String, Object> map) throws Exception {
		return sql.selectOne(namespace + ".selectBoardFileDown", map);
	}

	//파일 수정
	@Override
	public void updateBoardFile(Map<String, Object> map) throws Exception {
		sql.update(namespace + ".updateBoardFile", map);
	}

	@Override
	public void deleteBoardFile(int eBoardKey) throws Exception {
		sql.update(namespace + ".deleteBoardFile", eBoardKey);
		
	}

	//엑셀 출력 게시글 리스트
	@Override
	public List<BoardVO> excelBoardList(BoardVO boardVO) throws Exception {
		return sql.selectList(namespace + ".excelBoardList", boardVO);
	}


}
