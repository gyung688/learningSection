package com.lhg.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lhg.domain.BoardVO;
import com.lhg.domain.PagingVO;
import com.lhg.domain.UserVO;
import com.lhg.service.BoardService;

/**
 * @author lhg
 * @since 2021.07.28
 *
 */
@Controller
@RequestMapping("lhg/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService boardService;

	/**
	 * Comment : 게시글 목록 페이지
	 * @param boardVO
	 * @param request
	 * @param redirect
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board_lf", method = {RequestMethod.POST, RequestMethod.GET})
	public String boardLf(BoardVO boardVO
			,	HttpServletRequest request	
			, 	ModelMap model) throws Exception{
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("user");
		model.addAttribute("userVO",userVO);

		int totCnt = boardService.selectBoardListCnt(boardVO);
		int nowPage = boardVO.getNowPage();
		int cntPerPage = boardVO.getCntPerPage();
		
		PagingVO paging = new PagingVO(totCnt, nowPage, cntPerPage);
		boardVO.setStart(paging.getStart());
		boardVO.setCntPerPage(paging.getCntPerPage());

		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		
		model.addAttribute("paging", paging);
		model.addAttribute("boardList", boardList);
		
		return "lhg/board/board_lf";
	}
	
	//게시글 작성 페이지
	@RequestMapping(value = "/board_if", method = {RequestMethod.POST, RequestMethod.GET})
	public String boardIf(BoardVO boardVO
			,	HttpServletRequest request
			, 	ModelMap model) throws Exception{
		
		return "lhg/board/board_if";
	}
	
	//게시글 작성
	@RequestMapping(value = "/board_i", method = RequestMethod.GET)
	public String boardI(BoardVO boardVO
			,	MultipartHttpServletRequest mRequest) throws Exception{
		
		boardService.insertBoard(boardVO, mRequest);
		
		return "redirect:/lhg/board/board_lf";
	}
	
	//게시글 상세 페이지
	@RequestMapping(value="/board_vf", method = RequestMethod.GET)
	public String boardVf(BoardVO boardVO
			,	HttpServletRequest request
			, 	ModelMap model) throws Exception{
		
		BoardVO boardInfo = boardService.selectBoardInfo(boardVO);
		model.addAttribute("boardInfo", boardInfo);
		
		int key = Integer.parseInt(boardVO.geteBoardKey());
		List<Map<String, Object>> fileList = boardService.selectBoardFile(key);
		model.addAttribute("file", fileList);
		
		return "lhg/board/board_vf";
	}
	
	//게시글 수정 페이지
	@RequestMapping(value="/board_uf", method = RequestMethod.GET)
	public String boardUf(BoardVO boardVO
			,	HttpServletRequest request
			, 	ModelMap model) throws Exception{
		
		BoardVO boardInfo = boardService.selectBoardInfo(boardVO);
		model.addAttribute("boardInfo", boardInfo);
		
		int key = Integer.parseInt(boardVO.geteBoardKey());
		List<Map<String, Object>> fileList = boardService.selectBoardFile(key);
		model.addAttribute("file", fileList);
		
		return "lhg/board/board_uf";
	}
	
	//게시글 수정
	@RequestMapping(value="/board_u", method = RequestMethod.POST)
	public String boardU(BoardVO boardVO
			,	@RequestParam(value="fileNoDel[]", required=false) String[] files
			,	@RequestParam(value="fileNameDel[]", required=false) String[] fileNames
			,	MultipartHttpServletRequest mRequest) throws Exception{
		
		boardService.updateBoard(boardVO, files, fileNames, mRequest);
		
		return "redirect:/lhg/board/board_lf";
	}
	
	//게시글 삭제
	@RequestMapping(value="/board_d", method = RequestMethod.GET)
	public String boardD(int eBoardKey) throws Exception{
		
		boardService.deleteBoard(eBoardKey);
		
		return "redirect:/lhg/board/board_lf";
	}
	
	//파일 다운
	@RequestMapping(value="/fileDown")
	public void fileDown(@RequestParam Map<String, Object> map
			,	HttpServletResponse response) throws Exception{
		
		Map<String, Object> resultMap = boardService.selectBoardFileDown(map);
		String storedFileName = (String) resultMap.get("stored_file_name");
		String originalFileName = (String) resultMap.get("org_file_name");
		
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\board\\file\\"+storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	@RequestMapping(value="/excelDown", method = RequestMethod.POST)
	public String excelDown(Model model, BoardVO boardVO) throws Exception{
        List<BoardVO> list = boardService.excelBoardList(boardVO);
        
        SXSSFWorkbook workbook = boardService.excelFileDownloadProcess(list);
        
        model.addAttribute("locale", Locale.KOREA);
        model.addAttribute("workbook", workbook);
        model.addAttribute("workbookName", "게시판표");
        
        return "excelDownloadView";
	}


}
