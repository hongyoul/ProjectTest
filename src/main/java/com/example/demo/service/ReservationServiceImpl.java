package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationRepository repository;

	@Override
	public List<ReservationDTO> getList() {
		
		List<Reservation> result = repository.findAll();
		
		List<ReservationDTO> list = new ArrayList<>();
		
		list = result.stream()
				  .map(entity -> entityToDto(entity))
				  .collect(Collectors.toList());
			
			return list;
	
	}

	@Override
	public int register(ReservationDTO dto) {
			
		Reservation entity = dtoToEntity(dto);
				
			// 엔티티를 테이블에 저장
			repository.save(entity);
				
			// 저장 후 게시물의 번호를 반환
			int newNo = entity.getNo();
				
			 System.out.println(entity);
				
			return newNo;
	}

	@Override
	public ReservationDTO read(int no) {
		// 게시물 번호로 글 조회
				Optional<Reservation> optional = repository.findById(no);
				
				// 값이 있는지 확인
				if (optional.isPresent()) {
					Reservation reservation = optional.get();
					ReservationDTO dto = entityToDto(reservation);
					return dto;
				}
				
				return null;
	}
	

}
