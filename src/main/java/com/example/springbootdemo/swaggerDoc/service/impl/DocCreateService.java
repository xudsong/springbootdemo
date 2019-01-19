package com.example.springbootdemo.swaggerDoc.service.impl;

import com.example.springbootdemo.swaggerDoc.dto.Request;
import com.example.springbootdemo.swaggerDoc.dto.Response;
import com.example.springbootdemo.swaggerDoc.dto.Table;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.List;

@Service
public class DocCreateService {

    @Value("${doc.path}")
    private String path;

    public void creatDoc(List<Table> list) throws Exception{
        XWPFDocument document = new XWPFDocument();
        File file = new File(path);
        FileOutputStream out = new FileOutputStream(file);

        /**
         * 标题
         */
        createParagraph(document,ParagraphAlignment.CENTER,20,"000000","API文档");

        list.remove(0);
        for(Table table : list) {

            createParagraph(document,ParagraphAlignment.LEFT,16,"696969",table.getTitle());

            createParagraph(document,ParagraphAlignment.LEFT,14,"696969",table.getTag()+"("+ table.getDescription()+")");

            //创建表格
            XWPFTable infoTable = createTable(document);
            //去表格边框
            //infoTable.getCTTbl().getTblPr().unsetTblBorders();

            //表格表头
            createTableRowOne(infoTable,"请求方法","请求URL");
            //表格body
            createTableRowTwo(infoTable,table.getRequestType(),table.getUrl());


            //添加标题
            createParagraph(document,ParagraphAlignment.LEFT,12,"000000","请求参数");
            //创建请求参数表格
            XWPFTable infoTable1 = createTable(document);
            //表格表头
            createTableRowOne(infoTable1,"参数名","数据类型","参数类型","是否必填","备注");
            for(Request request:table.getRequestList()){
                createTableRowTwo(infoTable1,request.getName(),request.getType(),request.getParamType(),request.getRemark());
            }

            //添加标题
            createParagraph(document,ParagraphAlignment.LEFT,12,"000000","响应参数");
            //创建相应参数表格
            XWPFTable infoTable2 = createTable(document);
            //表格表头
            createTableRowOne(infoTable2,"参数名","返回参数","备注");
            //表格body
            for(Response response:table.getResponseList()){
                createTableRowTwo(infoTable2,response.getName(),response.getDescription(),response.getRemark());
            }

        }

        document.write(out);
        out.close();
        System.out.println("create_table document written success.");

    }

    /**
     * 换行
     * @param document
     * @return
     */
    private XWPFDocument nextLine(XWPFDocument document){
        XWPFParagraph nextLine = document.createParagraph();
        XWPFRun nextLineRun = nextLine.createRun();
        nextLineRun.setText("\r");
        return document;
    }

    /**
     * 创建表格
     * @param document
     * @return
     */
    private XWPFTable createTable(XWPFDocument document){
        XWPFTable infoTable = document.createTable();
        //列宽自动分割
        CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();
        infoTableWidth.setType(STTblWidth.DXA);
        infoTableWidth.setW(BigInteger.valueOf(9072));
        return infoTable;
    }

    /**
     * 创建段落
     * @param document
     * @param lineType 样式：居中还是靠左
     * @param fontSize 字体大小
     * @param color 字体颜色
     * @param title 标题
     * @return
     */
    private XWPFParagraph createParagraph(XWPFDocument document,ParagraphAlignment lineType,int fontSize,String color, String title){
        //添加标题
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(lineType);
        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setText(title);
        titleParagraphRun.setColor(color);
        titleParagraphRun.setFontSize(fontSize);
        //设置段落背景颜色
        CTShd cTShd = titleParagraphRun.getCTR().addNewRPr().addNewShd();
        cTShd.setVal(STShd.CLEAR);
        cTShd.setFill("97FFFF");
        return titleParagraph;
    }

    /**
     * 创建表格表头
     * @param infoTable
     * @param param
     * @return
     */
    private XWPFTableRow createTableRowOne(XWPFTable infoTable,String... param){
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        int i= 0;
        for (String text : param) {
            if(i==0) {
                infoTableRowOne.getCell(0).setText(text);
                i++;
            }else {
                infoTableRowOne.addNewTableCell().setText(text);
            }
        }
        return infoTableRowOne;
    }

    /**
     * 创建表格表体
     * @param infoTable
     * @param param
     * @return
     */
    private XWPFTableRow createTableRowTwo(XWPFTable infoTable,String... param){
        XWPFTableRow infoTableRowTwo = infoTable.createRow();
        int i =0;
        for(String text:param){
            infoTableRowTwo.getCell(i).setText(text);
            i++;
        }
        return infoTableRowTwo;
    }

}
