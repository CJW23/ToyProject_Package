package com.cjw.entity.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Entity의 name은 entity이름을 설정 -> jpql을 사용할 때는 user2로 사용

@Entity(name = "user2")
@Table(name = "user3")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
