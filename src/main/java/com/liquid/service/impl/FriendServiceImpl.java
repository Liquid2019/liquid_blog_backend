package com.liquid.service.impl;


import com.liquid.domain.Friend;
import com.liquid.mapper.FriendMapper;
import com.liquid.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("friendService")
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<Friend> findAllFriend() {
        return friendMapper.findAllFriend();
    }

    @Override
    public void insertFriend(Friend friend) {
        friendMapper.insertFriend(friend);
    }

    @Override
    public void deleteFriend(Integer id) {
        friendMapper.deleteFriend(id);
    }
}
