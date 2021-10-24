package com.liquid.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Visitor {
    private Integer id;
    private String host;
    private String agent;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", agent='" + agent + '\'' +
                ", time=" + time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
