package com.merveadler.controller;

import com.merveadler.dto.request.CreateFollowDto;
import com.merveadler.repository.entity.Follow;
import com.merveadler.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.merveadler.constant.ApiUrls.*;

@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Follow>> findAll(){
        return ResponseEntity.ok(followService.findAll());
    }

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createFollow(@RequestBody CreateFollowDto dto){
        return ResponseEntity.ok(followService.createFollow(dto));
    }
}
