package com.firebird.breaduniv.bread.breadMypage.controller;

import com.firebird.breaduniv.bread.breadCourseRegistration.controller.BreadCourseRegistrationController;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadCourseRegistrationDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadEnrollmentDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadFileDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import com.firebird.breaduniv.bread.breadMypage.model.service.BreadMypageService;
import lombok.Setter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

@Controller
public class BreadMypageController {

    private final BreadMypageService breadMypageService;

    @Autowired
    public BreadMypageController(BreadMypageService breadMypageService) {
        this.breadMypageService = breadMypageService;
    }

    /***
     * 마이페이지
     * @param model 데이터
     * @return
     */
    @GetMapping("/breadEdit")
    public String breadEdit(Model model) {
        // 임시로 사용자 아이디를 고정해서 테스트
        int userCode = 3;
        // service -> dao -> DB 후에 역순으로 다시 값을 들고 돌아온다.
        BreadUserDTO breadUserDTO = breadMypageService.selectBreadUserInfo(userCode);
        System.out.println("breadUserDTO ============> " + breadUserDTO);
        model.addAttribute("breadUser", breadUserDTO);
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadEdit";
    }

    @PostMapping("/breadEditFileUpdate")
    @ResponseBody
    public String breadEditFileUpdate(Model model, @RequestParam("file") MultipartFile file
            , @ModelAttribute BreadFileDTO breadFileDTO, @RequestParam String preFileName
    ) {
        // 사용자가 변경하려는 파일을 전달 받음
        System.out.println("file =====> " + file);
        System.out.println("preFileName = " + preFileName);

        // 여기서 부터는 파일을 업로드 할 경로 지정에 대한 설정을 진행
        String root = "/Users/theakim/Desktop/dev/04_Project/bread";
        String filePath = root + "/breadImages";
        // 여기까지

        // 여기서부터는 위에 선언한 경로를 자바 File 클래스를 이용하여 정보를 객체로 생성
        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());
        // 여기까지

        // 여기서는 생성한 파일 객체를 이용해서 실제 물리적인 공간(디스크공간)에 폴더가 있는지 여부를 exists()메소드를 이용해서 존재여부를 true/false로 반환받는다.
        // 있으면 true 없으면 false 근대 없으면 새롭게 만들어야 하니까는 !(논리부정)을 통해서 없으면 새롭게 만들어주는 코드를 작성
        if(!dir.exists()){
            dir.mkdirs();
        }
        // 여기까지

        String originFileName = file.getOriginalFilename();   // 파일이 가지고 있는 원본 파일명을 넘겨준다.
        String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 확장자 찾기
        // 파일명이 중복되지 않게 랜덤한 숫자로 '-' 뺴고 변경
        String savedName = UUID.randomUUID().toString().replace("-","") + ext;

        System.out.println("savedName = " + savedName);
        System.out.println("originFileName = " + originFileName);
        System.out.println("ext = " + ext);

        // 위에서 처리한 내용을 데이터베이스에 값을 변경하기위해서 전달해줘야하는 값을 처리하는 로직
        breadFileDTO.setProfileOriginFileName(originFileName);  // 원본파일명
        breadFileDTO.setProfileUploadFileName(savedName);       // 변경된 파일명
        breadFileDTO.setUserCode(3);                            // 사용자 아이디가 있어야 특정 사용자의 정보를 업데이트를 할 수 있으니 필요

        // 등록이 성공을하면 이전 파일을 물리공간에서 삭제처리하기 위해서 파일명을 조회하기 위한 메소드
        String prevFileName = breadMypageService.getOriginFileNameByUserCode(3);
        System.out.println("prevFileName = " + prevFileName);

        try {
            // transferTo() 메소드를 이용해서 해당 경로에 업로드할 파일을 업로드한다.
            file.transferTo(new File(filePath + "/" + savedName)); // transferTo()를 통해서 파일을 업로드한다.
        } catch (IOException e) {
            e.printStackTrace(); // 오류나면 빨간색으로 오류표시
        }

        // user(3)에 해당하는 파일이 다른 파일로 업데이트 됐을 시에 기존의 파일은 삭제
        System.out.println("breadFileDTO = " + breadFileDTO);

        // 파일 등록이 완료되었으니 파일의 정보를 가지고서 데이터베이스의 컬럼 값들을 업데이트 진행하는 소스
        int result = breadMypageService.breadEditFileUpdate(breadFileDTO);

        // 업데이트 성공 값에 따라서 성공과 실패를 진행한다.
        if(result > 0) {
            // success
            File deleteFile = new File(filePath + "/" + prevFileName);
            boolean isDeleted = deleteFile.delete();
            System.out.println("이전 파일 삭제 여부 : " + isDeleted);
            return "success";  // 현재는 비동기처리를 해놓고 있어서 이동할 페이지는 필요하지 않고 결과값에 대한 값만 필요해서 특정 문자열값을 리턴
                               // 비동기 처리를 했을 때는 메소드위에 @ResponseBody를 꼭 붙여준다. 해당 어노테이션을 붙여주지 않으면 viewResolve 객체가 페이지를 forward방식으로 페이지를 이동시킨다.
        } else {
            // fail
//            model.addAttribute("errorMessage", "사용자 정보 수정 실패!");
//            model.addAttribute("textColor", "#456E2A");
            return "failed";
        }
    }

    @GetMapping("/breadEditUpdate")
    public String breadEditUpdate(Model model) {
        int userCode = 3;
        BreadUserDTO breadUserDTO = breadMypageService.selectBreadUserInfo(userCode);
        model.addAttribute("breadUser", breadUserDTO);
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadEditUpdate";
    }

    @PostMapping("/breadEditUpdate")
    public String breadEditUpdate(Model model, @ModelAttribute BreadUserDTO breadUser, @RequestParam String firstAddress, @RequestParam String secondAddress) {
        System.out.println("firstAddress = " + firstAddress);
        System.out.println("secondAddress = " + secondAddress);

        String sumAddress = firstAddress + "$" + secondAddress;
        System.out.println("sumAddress = " + sumAddress);

        breadUser.setUserAddress(sumAddress);
        System.out.println("breadUser = " + breadUser);

        int userCode = 3;
        // service로 처리를 진행
        // insert, update, delete를 실행했을 경우의 리턴값은? 성공한 행의 갯수를 반환한다. int
        // 결과가 성공했으면 sendRedirect를 이용하고 실패하면 forward 방식으로 에러페이지로 에러 정보를 전달해서 출력한다.
        int result = breadMypageService.updateBread(breadUser);

        if(result > 0) {
            // success
            return "redirect:/breadEdit";
        } else {
            // fail
            model.addAttribute("errorMessage", "사용자 정보 수정 실패!");
            model.addAttribute("textColor", "#456E2A");
            return "/breadEdit";
        }
    }

    @RequestMapping("/breadEnrollment")
    public String breadEnrollment(Model model) {
        int courseCode = 1;
        BreadEnrollmentDTO breadEnrollmentDTO = breadMypageService.selectBreadCourseInfo(courseCode);
        model.addAttribute("breadEnrollment", breadEnrollmentDTO);
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadEnrollment";
    }

    @RequestMapping("/breadTimeTable")
    public String breadTimeTable(Model model) {
        int courseRegistrationCode = 1;
        BreadCourseRegistrationDTO breadCourseRegistrationDTO = breadMypageService.selectBreadCourseRegistrationInfo(courseRegistrationCode);
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadTimeTable";
    }
}
