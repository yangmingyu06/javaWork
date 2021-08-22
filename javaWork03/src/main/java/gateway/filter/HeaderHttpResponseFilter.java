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
        response.headers().set("ran", "00");
    }

}