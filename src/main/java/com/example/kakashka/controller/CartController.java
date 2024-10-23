package com.example.kakashka.controller;

import com.example.kakashka.model.User;
import com.example.kakashka.model.CartItem;
import com.example.kakashka.service.CartService;
import com.example.kakashka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService; // Добавляем зависимость UserService

    @GetMapping
    public String viewCart(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        // Получаем ID текущего пользователя
        Long userId = getUserId(userDetails);
        List<CartItem> cartItems = cartService.getAllCartItemsForUser(userId);
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@AuthenticationPrincipal UserDetails userDetails,
                            @RequestParam String productName,
                            @RequestParam int quantity,
                            @RequestParam double price) {
        Long userId = getUserId(userDetails);

        // Получаем пользователя из UserService
        User user = userService.findByUsername(userDetails.getUsername());

        CartItem cartItem = new CartItem();
        cartItem.setProductName(productName);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(price);
        cartItem.setUser(user); // Устанавливаем пользователя в cartItem

        cartService.addCartItem(cartItem);
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam Long id) {
        cartService.removeCartItem(id);
        return "redirect:/cart";
    }

    // Вспомогательный метод для получения ID пользователя
    private Long getUserId(UserDetails userDetails) {
        return userService.findByUsername(userDetails.getUsername()).getId();
    }
}
