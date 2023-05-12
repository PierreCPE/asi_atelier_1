package com.sp.controller;

import com.sp.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardCrt {
    @Autowired
    CardService cService;

}