package com.viol3t.springboot.mapper;

import com.viol3t.springboot.pojo.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeroMapper {
    public int add(Hero hero);
    public void delete(int id);
    public Hero get(int id);
    public int update(Hero hero);
    public List<Hero> list();
}
