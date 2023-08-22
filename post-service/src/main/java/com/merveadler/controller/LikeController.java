package com.merveadler.controller;

import com.merveadler.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.merveadler.constant.ApiUrls.*;

@RestController
@RequestMapping(LIKE)
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;


}
