package com.example.kakashka.service;

import com.example.kakashka.model.CartItem;
import com.example.kakashka.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<CartItem> getAllCartItemsForUser(Long userId) {
        return cartRepository.findByUserId(userId); // Возвращает все элементы корзины для указанного пользователя
    }

    public void addCartItem(CartItem cartItem) {
        cartRepository.save(cartItem); // Сохранение элемента корзины
    }

    public void removeCartItem(Long id) {
        cartRepository.deleteById(id); // Удаление элемента корзины
    }
}
