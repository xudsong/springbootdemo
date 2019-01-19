package com.example.springbootdemo.swaggerDoc.service.impl;

import com.example.springbootdemo.swaggerDoc.dto.Request;
import com.example.springbootdemo.swaggerDoc.dto.Response;
import com.example.springbootdemo.swaggerDoc.dto.Table;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigInteger;
import java.util.List;

@Service
public class DocCreateService {

    @Value("${doc.path}")
    private String path;

    /**
     * word整体样式
     */
    private static CTStyles wordStyles = null;

    /**
     * Word整体样式
     */
    static {
        XWPFDocument template;
        try {
            // 读取模板文档
            template = new XWPFDocument(new FileInputStream("D:/mainTitle.docx"));
            // 获得模板文档的整体样式
            wordStyles = template.getStyle();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlException e) {
            e.printStackTrace();
        }
    }

    public void creatDoc(List<Table> list) throws Exception{
        XWPFDocument document = new XWPFDocument();
        File file = new File(path);
        FileOutputStream out = new FileOutputStream(file);

        // 获取新建文档对象的样式
        XWPFStyles newStyles = document.createStyles();
        // 关键行// 修改设置文档样式为静态块中读取到的样式
        newStyles.setStyles(wordStyles);


        /**
         * 标题
         */
        createParagraph(document,ParagraphAlignment.CENTER,"1",20,"000000","API文档");

        list.remove(0);
        for(Table table : list) {

            createParagraph(document,ParagraphAlignment.LEFT,"2",16,"696969",table.getTitle());

            createParagraph(document,ParagraphAlignment.LEFT,"3",14,"696969",table.getTag()+"("+ table.getDescription()+")");

            //创建表格
            XWPFTable infoTable = createTable(document);
            //去表格边框
            //infoTable.getCTTbl().getTblPr().unsetTblBorders();
            //表格表头
            createTableRowOne(infoTable,"请求方式","请求URL","返回值类型");
            //表格body
            createTableRowTwo(infoTable,table.getRequestType(),table.getUrl(),table.getResponseForm());

            //添加标题
            createParagraph(document,ParagraphAlignment.LEFT,"3",12,"000000","请求参数");
            //创建请求参数表格
            XWPFTable infoTable1 = createTable(document);
            //表格表头
            createTableRowOne(infoTable1,"参数名","数据类型","参数类型","是否必填","备注");
            for(Request request:table.getRequestList()){
                String require = "N";
                if(request.getRequire()==true){
                    require = "Y";
                }
                createTableRowTwo(infoTable1,request.getName(),request.getType(),request.getParamType(),require,request.getRemark());
            }

            //添加标题
            createParagraph(document,ParagraphAlignment.LEFT,"3",12,"000000","响应参数");
            //创建相应参数表格
            XWPFTable infoTable2 = createTable(document);
            //表格表头
            createTableRowOne(infoTable2,"返回参数","参数名","备注");
            //表格body
            for(Response response:table.getResponseList()){
                createTableRowTwo(infoTable2,response.getDescription(),response.getName(),response.getRemark());
            }
            //添加标题
            createParagraph(document,ParagraphAlignment.LEFT,"3",12,"000000","示例");
            //创建相应参数表格
            XWPFTable infoTable3 = createTable(document);
            createTableRowOne(infoTable3,"请求参数",table.getRequestParam());
            createTableRowTwo(infoTable3,"返回值",table.getResponseParam());

            //换行
            nextLine(document);

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
     * @param style 大纲级别
     * @param fontSize 字体大小
     * @param color 字体颜色
     * @param title 标题
     * @return
     */
    private XWPFParagraph createParagraph(XWPFDocument document,ParagraphAlignment lineType,String style,int fontSize,String color, String title){
        //添加标题
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(lineType);
        titleParagraph.setStyle(style);
        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setText(title);
//        titleParagraphRun.setColor(color);
        titleParagraphRun.setFontSize(fontSize);
//        //设置段落背景颜色
//        CTShd cTShd = titleParagraphRun.getCTR().addNewRPr().addNewShd();
//        cTShd.setVal(STShd.CLEAR);
//        cTShd.setFill("97FFFF");
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
