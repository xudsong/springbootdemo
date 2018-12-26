package com.example.springbootdemo.util;

import java.lang.reflect.Field;

public class ObjectFiledCheckUtil {

    /**
     * 检查必填参数
     * @param object
     * @param mustParam
     * @return
     */
    public static String checkMustParam(Object object,String... mustParam){
        StringBuffer strBuf = new StringBuffer();
        if(null == object){
            return "传参对象为空";
        }
        if(null == mustParam || 0 == mustParam.length){
            return null;
        }
        for (String param: mustParam){
            try {
                //查找父类
                Field field = null;
                Class tempClass = object.getClass();
                while (null == field && null != tempClass){
                    try {
                        field = tempClass.getDeclaredField(param);
                    }catch (Exception e){
                        tempClass = tempClass.getSuperclass();
                    }
                }

                if(null == field){
                    strBuf.append(param);
                    strBuf.append("字段不存在");
                }else {
                    field.setAccessible(true); // 参数为true，禁止访问控制检查
                    if (null == field.get(object)){
                        strBuf.append(param);
                        strBuf.append("不能为空");
                    }
                }
            }catch (Exception e){
                strBuf.append(param);
                strBuf.append("字段不存在");
            }
        }
        return strBuf.toString();
    }

    /**
     * 将obj2中的值只填充obj1中为值空的属性（obj1于obj2具有共同的属性）
     * @param obj1
     * @param obj2
     * @return
     */
    public static String fillNullParam(Object obj1 , Object obj2){
        StringBuffer strBuf = new StringBuffer();
        if(null == obj1 && null == obj2){
            return "传入对象为空";
        }
        Field fields[] = obj2.getClass().getDeclaredFields();
        for (Field field : fields){
            try {
                String fieldValue = field.getName();
                Field obj1Field = obj1.getClass().getDeclaredField(fieldValue);
                if (null == obj1Field){
                    strBuf.append(obj1Field);
                    strBuf.append("字段不存在");
                    continue;
                }
                field.setAccessible(true);
                obj1Field.setAccessible(true);
                if (null == obj1Field.get(obj1)){
                    obj1Field.set(obj1,field.get(obj2));
                }
            }catch (Exception e){
                strBuf.append(field);
                strBuf.append("有异常");
            }
        }
        return strBuf.toString();
    }

}
