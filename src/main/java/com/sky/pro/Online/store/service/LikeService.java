package com.sky.pro.Online.store.service;

import com.sky.pro.Online.store.model.LikeModel;
import com.sky.pro.Online.store.model.NameCounter;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LikeService {

    private final LikeModel likeModel;

    public LikeService(LikeModel likeModel) {
        this.likeModel = likeModel;
    }

    public String addLikeGetText() {
        likeModel.addLike();
        int currentLikes = likeModel.getLikes();
        return "Вы лайкнули котика! Всего лайков от вас: " + currentLikes;
    }

    public String getCurrentLikesText() {
        int currentLikes = likeModel.getLikes();
        return "Текущий статус котика: У него " + currentLikes + " лайков от вас.";
    }

    public String delLikeGetText() {
        likeModel.delLike();
        int currentLikes = likeModel.getLikes();
        return "Вы забрали свой лайк! Текущий статус котика: У него " + currentLikes + " лайков от вас.";
    }

    public String resetLikeGetText() {
        likeModel.resetLike();
        int currentLikes = likeModel.getLikes();
        return "Вы забрали все свои лайки! Текущий статус котика: У него " + currentLikes + " лайков от вас.";
    }
}
