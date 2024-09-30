package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService service; 
	
	// 목록화면을 반환하는 메소드
	@GetMapping("/list")
	// 전달받은 페이지번호가 없으면 첫번째 페이지 반환
		
	public void list(Model model) {

			// 서비스를 통해 게시물 목록을 가져와서 화면에 전달
			List<ReservationDTO> list = service.getList();

			// 모델 객체에 데이터 담기
			model.addAttribute("list", list);
			
			 System.out.println("전체 예약 수: " + list.size());
		}

		// 등록화면 반환하는 메소드
		@GetMapping("/register")
		public void register() {

		}
		
		@PostMapping("/register")
		public String registerPost(ReservationDTO dto, RedirectAttributes redirectAttributes) {

			// 화면에서 전달한 폼데이터를 받아서 데이터베이스에 저장
			// 그리고 새로운 게시물 번호를 반환받음
			int no = service.register(dto);

			System.out.println("no:" + no);

			redirectAttributes.addFlashAttribute("no", no);

			
			return "redirect:/reservation/list"; 
		}

		// 상세화면을 반환하는 메소드
		@GetMapping("/read")
		public void read(@RequestParam(name = "no") int no, Model model) {

			// 게시물 번호를 파라미터로 전달받아 게시물 조회
			ReservationDTO dto = service.read(no);

			// 조회한 데이터를 화면에 전달
			model.addAttribute("dto", dto);

			
			
		}
}
