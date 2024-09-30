package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_reservation") 
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    int no;

	    @Column(length = 20, nullable = false)
	    String guestName; 

	    @Column(length = 20 )
	    String guestPhone; 

	    @Column(nullable = false)
	    int roomNo; 
	    
		@DateTimeFormat(pattern = "yyyy-mm-dd")
		@Column(nullable = false)
		LocalDate checkInDate;

}
