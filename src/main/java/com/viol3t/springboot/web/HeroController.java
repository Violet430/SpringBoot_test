package com.viol3t.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.viol3t.springboot.pojo.Hero;
import com.viol3t.springboot.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HeroController {
    @Autowired
    HeroService heroService;


    /**
     * restful 部分
     */
    @GetMapping("/heroes")
    public PageInfo<Hero> list(@RequestParam(value = "start",defaultValue = "1") int start,
                               @RequestParam(value = "size",defaultValue = "5") int size)throws Exception{
        PageHelper.startPage(start,size,"id desc");
        List<Hero> hs = heroService.list();
        System.out.println(hs.size());
        PageInfo<Hero> page = new PageInfo<>(hs,5);
        return page;
    }
    @GetMapping("/heroes/{id}")
    public Hero get(@PathVariable("id") Integer id)throws Exception{
        System.out.println(id);
        Hero hero = heroService.get(id);
        System.out.println(hero);
        return hero;
    }
    @PostMapping("/heroes")
    public String add(@RequestBody Hero hero)throws Exception{
        heroService.add(hero);
        return "success";
    }
    @DeleteMapping("/heroes/{id}")
    public String delete(Hero hero)throws Exception{
        heroService.delete(hero.getId());
        return "success";
    }
    @PutMapping("/heroes/{id}")
    public String update(@RequestBody Hero h)throws Exception{
        System.out.println(h.getName());
        heroService.update(h);
        return "success";
    }
    /**
     * 页面跳转部分
     */
    @RequestMapping(value = "/listHero",method = RequestMethod.GET)
    public ModelAndView listHero(){
        ModelAndView mv = new ModelAndView("listHero");
        return mv;
    }
    @RequestMapping(value = "/editHero",method = RequestMethod.GET)
    public ModelAndView editHero(){
        ModelAndView mv = new ModelAndView("editHero");
        return mv;
    }

}
