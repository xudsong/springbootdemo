package com.example.springbootdemo;

import com.alibaba.fastjson.TypeReference;
import com.example.springbootdemo.util.CommonUtils;
import com.example.springbootdemo.util.MD5Util;
import com.example.springbootdemo.util.UicodeBackslashU;
import com.xiaoleilu.hutool.json.JSON;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.util.IdcardUtil;
import lombok.AllArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.nio.cs.ext.EUC_CN;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootdemoApplication.class)
public class MainTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test(){
        String mobile = "13632762050";
        String privateKey = "wXyQtcMJIO0Rrs0DRFgnLovVGOGimbJj";

        String timestamp = getSecondTimestampTwo(new Date())+"";
        String code = "345678";
        String signature = "code="+code+"&sjhm="+mobile+"&timestamp="+timestamp+privateKey;
        String str = MD5Util.getMD5(signature,false,32);
        String url = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/SendMessage";
        MultiValueMap<String,Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("code",code);
        postParameters.add("sjhm",mobile);
        postParameters.add("timestamp",timestamp);
        postParameters.add("signature",str);
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded");
        org.springframework.http.HttpEntity<MultiValueMap<String,Object>> r = new org.springframework.http.HttpEntity<>(postParameters);
        String data = restTemplate.postForObject(url,r,String.class);
        System.out.println(data);

    }

    public static void main(String[] args)throws Exception{
        //String idCard = "362321199011015934";
        //String mobile = "13632947598";
        //String mobile = "13632762050";

        //身份证验证
//        System.out.println(CommonUtils.idEncrypt(idCard));
//        System.out.println(CommonUtils.mobileEncrypt(mobile));
//        System.out.println(IdcardUtil.isValidCard(idCard));

//        String privateKey = "wXyQtcMJIO0Rrs0DRFgnLovVGOGimbJj";
//
//        String timestamp = getSecondTimestampTwo(new Date())+"";
//        //String code = "345678";
//        String unionid = "ok6fzvj6B8suz3YGe-8jtZgAAmdw";
//        String signature = "timestamp="+timestamp+"&unionid="+unionid+privateKey;//"code="+code+"&sjhm="+mobile+"&timestamp="+timestamp+privateKey;
//        String str = MD5Util.getMD5(signature,false,32);
//        String url = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/getUserInfoByUnionid";//"http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/SendMessage";
//        Map<String,String> map = new HashMap<>(8);
//        //map.put("code",code);
//        //map.put("sjhm",mobile);
//        map.put("timestamp",timestamp);
//        map.put("unionid",unionid);
//        map.put("signature",str);

        //String idCard = "362321199011015934";
        //String mobile = "13632947598";
        String mobile = "13728811363";
        //String appliName = "张三";
        //Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        String accidentDate = sdf.format(date);
        String accidentNo = "1234567890";
        String driverName1 = "张三";
        String mobile1 = "13728811363";
        String driverName2 = "李四";
        String mobile2 = "18328002268";


        //身份证验证
//        System.out.println(CommonUtils.idEncrypt(idCard));
//        System.out.println(CommonUtils.mobileEncrypt(mobile));
//        System.out.println(IdcardUtil.isValidCard(idCard));

        String privateKey = "wXyQtcMJIO0Rrs0DRFgnLovVGOGimbJj";

        String timestamp = getSecondTimestampTwo(new Date())+"";

        String list="[{\"caseNo\":\"440106591000000021\",\"id\":\"8\"}]";
        //String code = "345678";
        //String signature = "code="+code+"&sjhm="+mobile+"&timestamp="+timestamp+privateKey;
        //String signature = "accidentDate="+accidentDate+"&accidentNo="+accidentNo+"&appliName="+appliName+"&sjhm="+mobile+"&timestamp="+timestamp+privateKey;
        //String signature = "sjhm="+mobile+"&timestamp="+timestamp+privateKey;
        String signature = "accidentNo="+accidentNo+"&driverName1="+driverName1+"&driverName2="+driverName2+"&mobile1="+mobile1+"&mobile2="+mobile2+"&sjhm="+mobile+"&timestamp="+timestamp+privateKey;
        //String signature = "list="+list+"&timestamp="+timestamp+privateKey;
        String str = MD5Util.getMD5(signature,false,32);
        String url = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/SendMessage6";
       // String url = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/SetCaseFile";
        Map<String,Object> map = new HashMap<>(8);
        // map.put("code",code);
//        map.put("accidentDate",String.valueOf(accidentDate));
        map.put("accidentNo",accidentNo);
//        map.put("appliName",appliName);


       map.put("mobile2",mobile2);

        map.put("mobile1",mobile1);

        map.put("driverName1",driverName1);

        map.put("driverName2",driverName2);

        map.put("sjhm",mobile);
        //map.put("list",list);
        map.put("timestamp",timestamp);
        map.put("signature",str);

        Map<String,String> map1 = (Map)map;

        String result = send(url,map1,"UTF-8");
        System.out.println(result);


    }

    /**
    获取精确到秒的时间戳
    @param date
    @return
     */
    public static int getSecondTimestampTwo(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }

    /**
     * 模拟请求
     *
     * @param url        资源地址
     * @param map    参数列表
     * @param encoding    编码
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String send(String url, Map<String,String> map,String encoding) throws ParseException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        String body = "";
        try {
            //创建httpclient对象
            //client = HttpClients.createDefault();
            //创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            //装填参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            //设置参数到请求对象中
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
            //设置header信息
            //指定报文头【Content-type】、【User-Agent】
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpPost);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, encoding);
            }
            EntityUtils.consume(entity);
            //释放链接
            response.close();
            body = UicodeBackslashU.unicodeToCn(body);
            JSONObject jsonObject = new JSONObject(body);
            String result = jsonObject.get("status").toString();

            //return body;
        }catch (Exception e){

        }finally {
            client.close();
        }
        return body;
    }


}
