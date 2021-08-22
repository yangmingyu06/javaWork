/**
 * @(#)MyHttpClient.java, 8月 15, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package client;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author yangmingyu
 */
public class MyHttpClient {

    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    public HttpResponse getRequest(HttpGet httpGet) {
        try {
            return httpclient.execute(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse postRequest(HttpPost httpPost) {
        try {
            return httpclient.execute(httpPost);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}