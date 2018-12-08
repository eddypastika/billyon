package com.eddyfajar.billyon.controller;

/*
 * Developed by I Gede Eddy Pastika Putra on 12/8/18 4:32 PM
 * Last modified 12/8/18 4:32 PM
 * PC ig.eddy.p.putra
 * Comment:
 * Copyright (c) 2018. All rights reserved
 */

import com.eddyfajar.billyon.constant.BillyonConstant;
import com.eddyfajar.billyon.generator.ValueGenerator;
import com.eddyfajar.billyon.model.Cart;
import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController extends ResponseModelController<Cart> {

    @Autowired
    private CartRepository cartRepository;


    @PostMapping("/add")
    public ResponseModel<Cart> addCart(@Valid @RequestBody Cart cartRequest){
        Cart cart = new Cart();
        ValueGenerator generator = new ValueGenerator();
        cartRequest.setId(generator.GenerateId());

        cart = cartRepository.save(cartRequest);

        setResponse(cart, BillyonConstant.ADD_CART_ERROR_TRUE,BillyonConstant.ADD_CART_ERROR_FALSE, false,null);

        return result;
    }
}
