package com.viol3t.springboot.service.impl;

import com.viol3t.springboot.mapper.HeroMapper;
import com.viol3t.springboot.pojo.Hero;
import com.viol3t.springboot.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    HeroMapper heroMapper;
    @Override
    public int add(Hero hero) {
        return heroMapper.add(hero);
    }

    @Override
    public void delete(int id) {
        heroMapper.delete(id);
    }

    @Override
    public int update(Hero hero) {
        return heroMapper.update(hero);
    }

    @Override
    public Hero get(int id) {
        return heroMapper.get(id);
    }

    @Override
    public List<Hero> list() {
        return heroMapper.list();
    }
}
