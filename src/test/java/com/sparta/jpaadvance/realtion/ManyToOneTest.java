package com.sparta.jpaadvance.realtion;

import com.sparta.jpaadvance.Food.Food;
import com.sparta.jpaadvance.User.User;
import com.sparta.jpaadvance.repository.FoodRepository;
import com.sparta.jpaadvance.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class ManyToOneTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FoodRepository foodRepository;


    @Test
    @Rollback(value = false)
    @DisplayName("N대1 단방향 테스트")
    void test1() {
        User user = new User();
        user.setName("Robbie"); // 이름 설정

        Food food = new Food();
        food.setName("후라이드 치킨"); // 이름 설정
        food.setPrice(15000); // 가격 설정
        food.setUser(user); // 외래 키(연관 관계) 설정

        Food food2 = new Food();
        food2.setName("양념 치킨"); // 이름 설정
        food2.setPrice(20000); // 가격 설정
        food2.setUser(user); // 외래 키(연관 관계) 설정

        userRepository.save(user);
        foodRepository.save(food);
        foodRepository.save(food2);
    }


}