package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.repositories.MyDataMongoRepository;
import java.util.List;

@Controller
public class HeloController {
        
    @Autowired
    MyDataMongoRepository repository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) 
    {
        mav.setViewName("index");
        mav.addObject("title","Find Page");
        mav.addObject("msg","MyDataMongo의 예제입니다.");
        Iterable<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }
        
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly=false)
    public ModelAndView from(
                    @RequestParam("area") String area,
                    @RequestParam("name") String name,
                    @RequestParam("address") String address,
                    @RequestParam("tel") String tel,
                    ModelAndView mov) 
    {
        MyDataMongo mydata = new MyDataMongo(area,name,address,tel);
        repository.save(mydata);
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert(ModelAndView mav) 
    {
        mav.setViewName("insert");
        return mav;
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView add(
		            @RequestParam("area") String area,
		            @RequestParam("name") String name,
		            @RequestParam("address") String address,
		            @RequestParam("tel") String tel,
		            ModelAndView mav) 
    {
	   
    	 MyDataMongo mydata = new MyDataMongo(area,name,address,tel);
         repository.save(mydata);
         return new ModelAndView("redirect:/");
	    
    }
    
    @RequestMapping(value = "/eidt/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView mav) 
    {
        mav.setViewName("eidt");
        mav.addObject("title","eidt Page");
        mav.addObject("msg","MyData의 예제입니다.");
        List<MyDataMongo> list = repository.findAll();
        mav.addObject("list", list);
        return mav;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView mav) 
    {
        mav.setViewName("update");
        mav.addObject("title","update Page");
        mav.addObject("msg","MyData의 예제입니다.");
        List<MyDataMongo> getlist = repository.findAll();
        mav.addObject("datalist", getlist);
        return mav;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(
	            @RequestParam("area") String area,
	            @RequestParam("name") String name,
	            @RequestParam("address") String address,
	            @RequestParam("tel") String tel,
	            ModelAndView mav) 
    {
 	   
   	 	MyDataMongo mydata = new MyDataMongo(area,name,address,tel);
        repository.save(mydata);
        return new ModelAndView("redirect:/edit{id}");
	    
   }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(ModelAndView mav) 
    {
        mav.setViewName("delete");
        mav.addObject("title","delete Page");
        mav.addObject("msg","MyData의 예제입니다.");
        List<MyDataMongo> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView remove(
	            @RequestParam("area") String area,
	            @RequestParam("name") String name,
	            @RequestParam("address") String address,
	            @RequestParam("tel") String tel,
	            ModelAndView mav) 
    {
 	   
   	 	repository.deleteAll();
        return new ModelAndView("redirect:/");
	    
   }
}
