package com.liquid.mapper;

import com.liquid.domain.Visitor;

import java.util.List;

public interface VisitorMapper {
    public List<Visitor> findAllVisitor();
    public void createVisitor(Visitor visitor);
    public void deleteAllVisitor();
}
