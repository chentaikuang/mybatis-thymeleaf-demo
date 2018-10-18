package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/test")
public class HtmlController {

    /**
     * http://localhost:8888/test/htmlImg
     * @param map
     * @return
     */
    @RequestMapping("/htmlImg")
    public String htmlImg(HashMap<String, Object> map) {
        String str = "<p><br/></p><p><img src=\"http://img01.sys.iflashbuy.com:8282/group2/M00/00/60/wKgFZFrz3SeAXtrkAAAtOnXUqbE499.jpg\" alt=\"图片\"/><img src=\"http://img01.sys.iflashbuy.com:8282/group2/M00/07/7D/wKgF-lrz3TGAJF0JAAfT1R93j9g679.jpg\" alt=\"图片\"/><img src=\"http://img01.sys.iflashbuy.com:8282/group2/M00/00/60/wKgFZFrz3TSAANcGAAhdEvHo5tc457.jpg\" alt=\"图片\"/><img src=\"http://img01.sys.iflashbuy.com:8282/group2/M00/07/7D/wKgF-lrz3TiAXYdzAAlVC8srH-4057.jpg\" alt=\"图片\"/><img src=\"http://img01.sys.iflashbuy.com:8282/group2/M00/00/60/wKgFZFrz3TyAbaBoAAn9LyPeGU4365.jpg\" alt=\"图片\"/></p><p><br/></p><p><br/></p>";
        map.put("hello", "这里是HTML页面,使用thymeleaf");
        map.put("desc", str);
        return "/index";
    }

    /**
     * http://localhost:8888/test/html
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/html")
    public String html(Model model) throws Exception {
        String str = "<p>我是小臣，这是demo</p><br />";
        model.addAttribute("desc", str);
        model.addAttribute("hello", "h5");
        return "/index";
    }
}