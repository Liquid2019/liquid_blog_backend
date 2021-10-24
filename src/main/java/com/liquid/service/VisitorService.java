package com.liquid.service;

import com.liquid.domain.Visitor;

import java.util.List;


public interface VisitorService {
    public List<Visitor> findAllVisitor();
    public void createVisitor(Visitor visitor);
    public void deleteAllVisitor();
}
