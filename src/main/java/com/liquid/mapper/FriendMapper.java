package com.liquid.mapper;

import com.liquid.domain.Friend;

import java.util.List;



public interface FriendMapper {
    public List<Friend> findAllFriend();
    public void insertFriend(Friend friend);
    public void deleteFriend(Integer id);
}
