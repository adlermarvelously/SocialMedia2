package com.merveadler.service;

import com.merveadler.manager.IUserProfileManager;
import com.merveadler.repository.ILikeRepository;
import com.merveadler.repository.entity.Like;
import com.merveadler.utility.JwtTokenProvider;
import com.merveadler.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService extends ServiceManager<Like,String> {

    private final ILikeRepository likeRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final IUserProfileManager userProfileManager;

    public LikeService(ILikeRepository likeRepository, JwtTokenProvider jwtTokenProvider, IUserProfileManager userProfileManager) {
        super(likeRepository);
        this.likeRepository = likeRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userProfileManager = userProfileManager;
    }

    public Optional<Like> findByUserIdAndPostId(String userId, String postId){
        Optional<Like> like = likeRepository.findByUserIdAndPostId(userId, postId);
        return like;
    }

    public void deleteByUserIdAndPostId(String userId, String postId){
        likeRepository.deleteByUserIdAndPostId(userId, postId);
    }
}
