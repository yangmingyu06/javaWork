/**
 * @(#)HeaderHttpResponseFilter.java, 8月 22, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author yangmingyu
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {

    @Override
    public void filter(FullHttpResponse response) {
        byte[] array = response.content().array();
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append((char) b);
        }
        if (sb.toString().contains("ran")) {
            response.headers().set("ran", "00");
        }
    }

}