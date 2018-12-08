package com.eddyfajar.billyon.controller;

/*
 * Developed by I Gede Eddy Pastika Putra on 12/8/18 5:12 PM
 * Last modified 12/8/18 5:12 PM
 * PC ig.eddy.p.putra
 * Comment:
 * Copyright (c) 2018. All rights reserved
 */

import com.eddyfajar.billyon.constant.BillyonConstant;
import com.eddyfajar.billyon.generator.ValueGenerator;
import com.eddyfajar.billyon.model.CartProduct;
import com.eddyfajar.billyon.model.ResponseModel;
import com.eddyfajar.billyon.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart_product")
public class CartProductController extends ResponseModelController<CartProduct> {

    @Autowired
    CartProductRepository cartProductRepository;

    @PostMapping("/add")
    public ResponseModel<CartProduct> addCartProduct(@Valid @RequestBody CartProduct request){

        CartProduct cp = new CartProduct();
        ValueGenerator generator = new ValueGenerator();
        request.setId(generator.GenerateId());

        cp = cartProductRepository.save(request);

        setResponse(cp, BillyonConstant.ADD_CART_PRODUCT_ERROR_TRUE, BillyonConstant.ADD_CART_PRODUCT_ERROR_FALSE, false, null);

        return result;
    }


}
