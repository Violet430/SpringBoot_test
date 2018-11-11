package com.viol3t.springboot.service;

import com.viol3t.springboot.pojo.Hero;

import java.util.List;

public interface HeroService {
    public int add(Hero hero);
    public void delete(int id);
    public int update(Hero hero);
    public Hero get(int id);
    public List<Hero> list();
}
