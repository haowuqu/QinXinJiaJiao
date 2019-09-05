package com.example.lanhong.qingxinjiajiao;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GetTeaDetail {
    //获取头像
    public Bitmap getYan(String url) throws Exception {
        Bitmap bitmap;
        try {
            //建立网络连接
            URL imageURl=new URL(url);
            URLConnection con=imageURl.openConnection();
            con.connect();
            InputStream in=con.getInputStream();
            bitmap=BitmapFactory.decodeStream(in);
        }finally{
        }
        return bitmap;
    }
    //登入的方法
    public String result = ""; // 用来取得返回的String
    public boolean getDetail(String name, String connectUrl) {
        boolean isLoginSucceed = false;
        HttpClient httpClient = new DefaultHttpClient();
        // 发送post请求
        HttpPost httpRequest = new HttpPost(connectUrl);
        // Post运作传送变数必须用NameValuePair[]阵列储存
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name", name));
        try {
            // 发出HTTP请求
            httpRequest.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
            // 取得HTTP response
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
            System.out.println(result+"111111111111");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 判断返回的数据是否为php中成功登入是输出的
        if (!result.equals("")) {
            isLoginSucceed = true;
        }
        return isLoginSucceed;
    }

}



