package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

public interface ReservationService {

	// 게시물 등록 메소드
	int register(ReservationDTO dto);
	
	// 게시물 목록 조회 메소드
	List<ReservationDTO> getList();
	
	// 게시물 상세조회 메소드
	ReservationDTO read(int no);
	
	// DTO를 엔티티로 변환라는 메소드
	default Reservation dtoToEntity(ReservationDTO dto) {
			
		Reservation entity = Reservation.builder()
								.no(dto.getNo())
								.guestName(dto.getGuestName())
								.guestPhone(dto.getGuestPhone())
								.roomNo(dto.getRoomNo())
								.checkInDate(dto.getCheckInDate())
								.build();
			
			return entity; 
		}
		
	// entity -> DTO 변환 메소드
	default ReservationDTO entityToDto(Reservation entity) {
			
		ReservationDTO dto = ReservationDTO.builder()
								.no(entity.getNo())
								.guestName(entity.getGuestName())
								.guestPhone(entity.getGuestPhone())
								.roomNo(entity.getRoomNo())
								.checkInDate(entity.getCheckInDate())
								.build();
								
			return dto;
			
		}	
	
}
