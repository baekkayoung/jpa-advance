package com.sparta.jpaadvance.Food;

import com.sparta.jpaadvance.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    // Food가 외래키 주인이지만 실제 외래키는 User가 가지고 있음
    @OneToMany
    @JoinColumn(name = "food_id") // users 테이블에 food_id 컬럼 존재
    private List<User> userList = new ArrayList<>();
}