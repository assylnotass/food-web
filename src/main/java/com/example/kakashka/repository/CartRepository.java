package com.example.kakashka.repository;

import com.example.kakashka.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId); // Метод для поиска элементов корзины по пользователю
}
