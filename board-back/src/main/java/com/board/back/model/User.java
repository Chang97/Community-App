package com.board.back.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseTime {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 db에 넘버링 전략을 따라감
	private int id;
	
	@Column(nullable = false, length=30, unique = true)
	private String username; //아이디
	
	@Column(nullable = false, length=300)
	private String password; //해쉬로 암호화 하기 떄문에 넉넉하게 작성
	
	@Column(nullable = false, length=50)
	private String email;
	
	//@ColumnDefault("'user'")
	// DB는 RoleType이 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; //enum 사용하는게 좋음.//admin, user
	
	@Column(name = "created_time")
	private Date createdTime;
	
	@Column(name = "updated_time")
	private Date updatedTime;
	
	@ColumnDefault("'N'")
	@Column(name = "del_yn", length = 1)
	private String delYn;
}
