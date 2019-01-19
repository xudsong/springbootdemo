package com.example.springbootdemo.swaggerDoc.controller;

import com.example.springbootdemo.swaggerDoc.dto.Table;
import com.example.springbootdemo.swaggerDoc.service.TableService;
import com.example.springbootdemo.swaggerDoc.service.impl.DocCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {
    @Autowired
    private TableService tableService;

    @Autowired
    private DocCreateService docCreateService;

    @RequestMapping("/getWord")
    public String getJson(Model model){
        try {
            List<Table> list = tableService.tableList();
            //model.addAttribute("table",list);
            docCreateService.creatDoc(list);
            return "word";
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
