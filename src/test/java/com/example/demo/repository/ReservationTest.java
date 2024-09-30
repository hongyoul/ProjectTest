package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;

@SpringBootTest
public class ReservationTest {

	
	@Autowired
	ReservationRepository repository;
	
	LocalDate localDate1 = LocalDate.of(2024,9,5);
	LocalDate localDate2 = LocalDate.of(2024,9,10);
	
	
	@Test
	public void 리파지토리객체를_가져왔는지_확인() {
		System.out.println("repository = " + repository);
	}
	
	@Test
	public void 데이터일관등록() {
		List<Reservation> list = new ArrayList<>();
		
		
		Reservation yeyag1 = Reservation
							.builder()
							.guestName("둘리")
							.guestPhone("010-1111-2222")
							.checkInDate(localDate1)
							.roomNo(201)
							.build();
		
		Reservation yeyag2 = Reservation
							.builder()
							.guestName("또치")
							.guestPhone("010-3333-4444")
							.checkInDate(localDate1)
							.roomNo(202)
							.build();

		Reservation yeyag3 = Reservation
							.builder()
							.guestName("도우너")
							.checkInDate(localDate2)
							.roomNo(201)
							.build();
		
		
		list.add(yeyag1);
		list.add(yeyag2);
		list.add(yeyag3);
	
		
		repository.saveAll(list);
	}
	
}
