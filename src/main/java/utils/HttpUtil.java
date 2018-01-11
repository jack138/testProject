package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class HttpUtil {

    
public static String httpPostWithJSON(String url) throws Exception {
     
    HttpPost httpPost = new HttpPost(url);
    CloseableHttpClient client = HttpClients.createDefault();
    String respContent = null;
         
 //     json方式
    JSONObject jsonParam = new JSONObject();
    jsonParam.put("userid", "123456");
    jsonParam.put("doctorname", "梅笙");
    jsonParam.put("evalname", "荆无命");
    jsonParam.put("evalidcard", "210112197908211761");
    jsonParam.put("height", "175");
    jsonParam.put("weight", "72");
    jsonParam.put("channelno", "2101010");
    jsonParam.put("requestno", "lb020");
    jsonParam.put("sex", "male");
    jsonParam.put("age", 18);
    jsonParam.put("physicallevel", "st_light");
    
    
    StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题    
    entity.setContentEncoding("UTF-8");    
    entity.setContentType("application/json");    
    httpPost.setEntity(entity);
    System.out.println();
    

//  表单方式
//  List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>(); 
//  pairList.add(new BasicNameValuePair("name", "admin"));
//  pairList.add(new BasicNameValuePair("pass", "123456"));
//  httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));   
        
    HttpResponse resp = client.execute(httpPost);
    if(resp.getStatusLine().getStatusCode() == 200) {
        HttpEntity he = resp.getEntity();
        respContent = EntityUtils.toString(he,"UTF-8");
    }
    return respContent;
    }

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8080/hms-web/evaluate/sendRequest.action";
        HttpUtil.httpPostWithJSON(url);
    }
}
