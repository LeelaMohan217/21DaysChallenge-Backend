package com.leelamohan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long task_id;
	@Column(nullable = false)
	private String task_name;
	@Column(nullable = false)
	private String task_description;
	@Column(nullable = false)
	private Long user_id;
	@Column(nullable = false)
	private int completedDays = 0;
}
