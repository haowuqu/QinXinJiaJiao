package com.example.lanhong.qingxinjiajiao;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class Resrve_Teacher {
    public String result = ""; // 用来取得返回的String
    public boolean Reserve(String par_phone,String teach_phone,String teach_name,String subject ,String data,String connectUrl) {
        boolean isLoginSucceed = false;
        HttpClient httpClient = new DefaultHttpClient();
        // 发送post请求
        HttpPost httpRequest = new HttpPost(connectUrl);
        // Post运作传送变数必须用NameValuePair[]阵列储存
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("par_phone", par_phone));
        params.add(new BasicNameValuePair("teach_phone", teach_phone));
        params.add(new BasicNameValuePair("teach_name", teach_name));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("data", data));
        try {
            // 发出HTTP请求
            httpRequest.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
            // 取得HTTP response
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 判断返回的数据是否为php中成功登入是输出的
        if (result.equals("success")) {
            isLoginSucceed = true;
        }
        return isLoginSucceed;
    }

}


