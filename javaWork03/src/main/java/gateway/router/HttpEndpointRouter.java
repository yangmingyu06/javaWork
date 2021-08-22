/**
 * @(#)HttpEndpointRouter.java, 8月 22, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package gateway.router;

import java.util.List;

/**
 * @author yangmingyu
 */
public interface HttpEndpointRouter {

    String route(List<String> endpoints);

}