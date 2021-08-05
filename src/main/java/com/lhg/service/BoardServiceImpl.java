package com.lhg.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
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

	//엑셀 리스트
	@Override
	public List<BoardVO> excelBoardList(BoardVO boardVO) throws Exception {
		return boardDAO.excelBoardList(boardVO);
	}

	//리스트를 엑셀 워크북 객체로 생성
	public SXSSFWorkbook makeSimpleExcelWorkbook(List<BoardVO> list) {
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		
		//시트생성
		SXSSFSheet sheet = workbook.createSheet("게시판표");
		
		//시트 열 너비 설정
		sheet.setColumnWidth(0, 1500);
		sheet.setColumnWidth(0, 3000);
		sheet.setColumnWidth(0, 3000);
		sheet.setColumnWidth(0, 1500);
		
		//헤더 행 생
		Row headerRow = sheet.createRow(0);
		//해당 행의 첫번째 열 셀 생성
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("번호");
		//해당 행의 두번째 열 셀 생성
		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("제목");
		//해당 행의 세번째 열 셀 생성
		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("내용");
		//해당 행의 네번째 열 셀 생성
		headerCell = headerRow.createCell(3);
		headerCell.setCellValue("작성자");
		//해당 행의 다섯번째 열 셀 생성
		headerCell = headerRow.createCell(4);
		headerCell.setCellValue("작성일자");
		
		//표 내용 행 및 셀 생성
		Row bodyRow = null;
		Cell bodyCell = null;
		for(int i = 0; i < list.size(); i++) {
			BoardVO boardVO = list.get(i);
			
			//행 생성
			bodyRow = sheet.createRow(i+1);
			//데이터 번호 표시
			bodyCell = bodyRow.createCell(0);
			bodyCell.setCellValue(i + 1);
			//데이터 제목 표시
			bodyCell = bodyRow.createCell(1);
			bodyCell.setCellValue(boardVO.geteBoardTitle());
			//데이터 내용 표시
			bodyCell = bodyRow.createCell(2);
			bodyCell.setCellValue(boardVO.geteBoardContent());
			//데이터 작성자 표시
			bodyCell = bodyRow.createCell(3);
			bodyCell.setCellValue(boardVO.getkUserName());
			//데이터 작성일자 표시
			bodyCell = bodyRow.createCell(4);
			bodyCell.setCellValue(boardVO.geteBoardDate());
		}
		return workbook;
	}

	//생성한 엑셀 워크북을 컨트롤러에서 받게해줄 메소드
	public SXSSFWorkbook excelFileDownloadProcess(List<BoardVO> list) {
		return this.makeSimpleExcelWorkbook(list);
	}
}
