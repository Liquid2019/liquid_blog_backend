package com.liquid.service;

import com.liquid.domain.Friend;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public interface FriendService {
    List<Friend> findAllFriend();
    void insertFriend(Friend friend);
    void deleteFriend(Integer id);
}
