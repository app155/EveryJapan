package com.example.Globalin.dto;

import com.example.Globalin.model.UserProfile;
import com.example.Globalin.model.Post;
import com.example.Globalin.model.HotPost;
import com.example.Globalin.model.Board;

import java.util.List;

public class MainPageDTO {
    private UserProfile userProfile;
    private List<Post> humanitiesPosts;
    private List<Post> freePosts;
    private List<HotPost> hotPosts;
    private List<Board> bestBoards;

    // Getters and Setters
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<Post> getHumanitiesPosts() {
        return humanitiesPosts;
    }

    public void setHumanitiesPosts(List<Post> humanitiesPosts) {
        this.humanitiesPosts = humanitiesPosts;
    }

    public List<Post> getFreePosts() {
        return freePosts;
    }

    public void setFreePosts(List<Post> freePosts) {
        this.freePosts = freePosts;
    }

    public List<HotPost> getHotPosts() {
        return hotPosts;
    }

    public void setHotPosts(List<HotPost> hotPosts) {
        this.hotPosts = hotPosts;
    }

    public List<Board> getBestBoards() {
        return bestBoards;
    }

    public void setBestBoards(List<Board> bestBoards) {
        this.bestBoards = bestBoards;
    }
}
