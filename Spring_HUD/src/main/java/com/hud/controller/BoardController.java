package com.hud.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hud.model.BoardVo;
import com.hud.model.Criteria;
import com.hud.model.MemberVo;
import com.hud.model.PageVo;
import com.hud.model.ReplyVo;
import com.hud.service.BoardService;
import com.hud.service.ReplyService;
import com.hud.utils.UploadFileUtils;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService bservice;
	@Autowired
	private ReplyService RepService;
	
	private static final Logger Logger=	LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	//게시글 목록 리스트
	/*
	 * @RequestMapping(value="list",method=RequestMethod.GET) public void
	 * listGet(Model model) throws Exception{ //select 전체 목록을 Model객체에 저장후 list.jsp에
	 * 실어 보낸다 model.addAttribute("list",bservice.listAll());
	 * 
	 * }
	 */
	//게시글 목록 리스트(페이징된거)
	@RequestMapping(value="list",method=RequestMethod.GET)
	public void listGet(Criteria cri,Model model) throws Exception{
		int total=bservice.boardCount(cri);
		
		PageVo pv=new PageVo(cri,total); 
		
		Logger.info(""+cri.getKeyword());
		Logger.info(""+pv.getStartPage());
		Logger.info(""+total);
		//select 전체 목록을 Model객체에 저장후 list.jsp에 실어 보낸다
	model.addAttribute("list",bservice.boardListPaging(cri));
	Logger.info(""+bservice.boardListPaging(cri));
	model.addAttribute("page",pv);	
	System.out.println("목록"+cri);
	
	
	
	}	
	//
	//글쓰기를 위한 controller
	@RequestMapping(value="/register", method =RequestMethod.GET)
	public String registGet() throws Exception{
		Logger.info("regist get..");
		return"board/write";
	}
	
	@RequestMapping(value="/register", method =RequestMethod.POST)
	public String registPost(BoardVo board,MultipartFile file) throws Exception{
		Logger.info("regist post.."+board);
		
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			 String aa=File.separator + "imgUpload" + ymdPath + File.separator + fileName;
				
				board.setImg(aa.substring(ymdPath.length()).replace(File.separatorChar, '/'));
				
				String bb=File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName;
				
				board.setThumbImg(bb.substring(ymdPath.length()).replace(File.separatorChar, '/'));
		
		} else {
			 fileName = null;
			}
			
			
		
		
		bservice.boardWrite(board);
		
		System.out.println(board);
		return"redirect:list";
	}
	@RequestMapping(value="detail", method =RequestMethod.GET)
	public void detailGET(@RequestParam("no") int no,Model model) throws Exception{
		Logger.info("detail get.."+no);
		model.addAttribute("detail",bservice.boardDetail(no));
		bservice.updateViewCnt(no);
		
		
		/*
		 * List<ReplyVo>repList=RepService.readReply(no); 
		 * model.addAttribute("repList",
		 * repList);
		 */
		
	}
	@RequestMapping(value="modify", method =RequestMethod.GET)
	public void modifyGET(@RequestParam int no,Model model) throws Exception{
		Logger.info("modify get..");
		model.addAttribute("modify",bservice.boardDetail(no));	
		
	}
	@RequestMapping(value="modify", method =RequestMethod.POST)
	public String modifyPOST(BoardVo board) throws Exception{
		
		Logger.info("modify get..");
		bservice.boardModify(board); //dao에서 수정역할을 불러옴
		return"redirect:detail?no="+board.getNo();
		
	}
	@RequestMapping(value="delete", method =RequestMethod.GET)
	public String deleteGET(BoardVo board) throws Exception{
		
		Logger.info("delete get..");
		bservice.boardDel(board); //dao에서 수정역할을 불러옴
		return"redirect:list";
		
	} 
	// 상품 소감(댓글) 목록
	@ResponseBody
	@RequestMapping(value = "/detail/readReply", method = RequestMethod.GET)
	public List<ReplyVo> getReplyList(@RequestParam("n") int no) throws Exception {
	 
	   
	 List<ReplyVo>repList=RepService.readReply(no); 
	 
	 return repList;
	} 
	
	// 댓글 작성
	@ResponseBody
	@RequestMapping(value = "/detail/replyWrite", method = RequestMethod.POST)
	public void replyWrite(ReplyVo vo, HttpSession session) throws Exception {
	
		 MemberVo member = (MemberVo)session.getAttribute("member");
		 vo.setWriter(member.getId());
		 
	
	 
	 RepService.writeReply(vo);
System.out.println(vo+"오는지ㅋㅋ");
	 
	
	}
	
	// 댓글 수정 POST
	@ResponseBody
	@RequestMapping(value = "/detail/modifyReply", method = RequestMethod.POST)
	public int replyUpdate(ReplyVo vo,  HttpSession session) throws Exception {
	 
	 
	 RepService.replyUpdate(vo);
	 
	 int result=1;
	 return result;
	}

	// 댓글 삭제 POST
	@ResponseBody
	@RequestMapping(value = "/detail/deleteReply", method = RequestMethod.POST)
	public int replyDelete(ReplyVo vo, HttpSession session) throws Exception {
	 
	 
	 RepService.replyDelete(vo);
	 
	 
	
	 int result=1;
	 return result;
	}
	
	

}
