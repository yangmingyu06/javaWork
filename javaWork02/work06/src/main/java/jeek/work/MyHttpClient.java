/**
 * @(#)MyHttpClient.java, 8月 15, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jeek.work;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author yangmingyu
 */
public class MyHttpClient {

    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    private static String REQUEST_URL = "http://localhost:8801";

    public static void main(String[] args) {
        HttpClient httpClient = new DefaultHttpClient();
        System.out.println(getRequest(new HttpGet(REQUEST_URL)));
        HttpPost postReq = new HttpPost(REQUEST_URL);
        postReq.setEntity(new StringEntity("hello", "utf-8"));
        postRequest(postReq);
    }

    private static String getRequest(HttpGet httpGet) {
        try {
            return EntityUtils.toString(httpclient.execute(httpGet).getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String postRequest(HttpPost httpPost) {
        try {
            return EntityUtils.toString(httpclient.execute(httpPost).getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}