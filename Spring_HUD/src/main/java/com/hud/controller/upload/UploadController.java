package com.hud.controller.upload;

import java.io.File;
import java.util.UUID;
 
import javax.annotation.Resource;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class UploadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    //이 클래스의 로그를 출력하기 위한 코드, 로그저장소에서 getLogger 메소드를 사용해서 호출
    // xml에 설정된 리소스를 참조
    // bean의 id가 uploadPath인 태그를 참조
    
    @Resource(name = "uploadPath") //servlet-conetext에 저장한 빈인 uploadPath를 호출한다.
    String uploadPath; //@Resource에서 받은 리소스 값인 uploadPath가 들어오게 된다.
    
    // menu 페이지에서 이 메소드를 거치고, 맵핑할때 "/upload/uploadForm"페이지로 포워딩 된다.
    // method방식을 정하지 않으면 get방식이다. (즉 get방식일때는 이 메소드를 거친다. post방식일때는 아님)
    @RequestMapping(value = "/upload/uploadForm", method = RequestMethod.GET)
    public void uploadForm() {
        //         upload / uploadForm.jsp 로 포워딩    
    }
    //그냥 화면을 바꿀때는 get 방식을 사용하고 파일을 업로드 할때는 POST방식을 사용한다.
    
    
    //업로드 버튼 => 임시 디렉토리에 업로드
    // => 파일정보가 file에 저장
    // => 지정된 디렉토리에 저장 =>
    
    // 파일을 업로드(내용을 채울때는) 할때는 POST방식을 사용하므로 이 메소드를 거친다.
    // 메소드 이름을 다르게 할 수도 있지만 method 방식을 POST와 GET방식으로 각각 지정해서 할 수도 있다.
    @RequestMapping(value = "/upload/uploadForm", method = RequestMethod.POST)
        public ModelAndView uploadForm (MultipartFile file, ModelAndView mav) throws Exception {
        
        logger.info("파일이름 : " + file.getOriginalFilename());
        String savedName = file.getOriginalFilename();
        logger.info("파일크기:" +file.getSize());
        logger.info("컨텐츠 타입:" +file.getContentType()); //파일이름과 크기와 파일의 종류를 로그로 출력함
        
        
        
        savedName = uploadFile(savedName, file.getBytes());
        //파일을 올리고 파일의 바이트를 올리고, 저장된 파일이름 가져와서 결과페이로 보낼예정
        
        mav.setViewName("upload/uploadResult");
        mav.addObject("savedName", savedName);
        return mav; //uploadResult.jsp로 포워딩
    }
    
    //파일 이름이 중복되지 않도록 처리
        private String uploadFile(String originalName, byte[] fileData) throws Exception{
            // uuid 생성 (Universal Unique IDentifier, 범용 고유 식별자)
            // uuid를 만드는 이유는 파일을 2개 올리게 되면 이름이 중복되는데 그러다 1개가 삭제 될 수 있기 때문에
            // uuid라는 고유한 식별자를 주어서 (랜덤으로 코드를 만들어냄) 이름이 중복되지 않게 해서 삭제되지 않게끔 하려는 것이다.
            // uuid를 생성해서 그것을 파일의 이름 앞에다 붙여서 중복을 방지한다.
            
            UUID uid = UUID.randomUUID();
            String savedName = uid.toString() + "_" +originalName;
            File targer = new File(uploadPath, savedName); //파일을 실제로 저장함
            // 임시 디렉토리에 저장된 업로드된 파일을
            // 지정된 디렉토리로 복사
            // FileCopyUtils.copy (바이트배열, 파일객체)
            FileCopyUtils.copy(fileData, targer); //파일을 복사
            return savedName; //복사한 파일이름을 되돌려 준다.
        }
}

