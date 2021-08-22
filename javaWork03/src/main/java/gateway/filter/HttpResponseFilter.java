/**
 * @(#)HttpResponseFilter.java, 8月 22, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author yangmingyu
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}