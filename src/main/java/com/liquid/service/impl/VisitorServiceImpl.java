package com.liquid.service.impl;

import com.liquid.domain.Visitor;
import com.liquid.mapper.VisitorMapper;
import com.liquid.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorMapper visitorMapper;

    @Override
    public void deleteAllVisitor() {
        visitorMapper.deleteAllVisitor();
    }
    @Override
    public List<Visitor> findAllVisitor() {
        return visitorMapper.findAllVisitor();
    }

    @Override
    public void createVisitor(Visitor visitor) {
        visitorMapper.createVisitor(visitor);
    }
}
