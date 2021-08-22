/**
 * @(#)RandomHttpEndpointRouter.java, 8月 22, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package gateway.router;

import java.util.List;
import java.util.Random;

/**
 * @author yangmingyu
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {


    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        int range = random.nextInt() % 100;
        String url = urls.get(0);
        for (int i = 0; i < urls.size(); i++) {
            if (range < 20 && urls.get(i).contains("8801")) {
                url = urls.get(i);
                break;
            }
            if (range >= 20 && urls.get(i).contains("8802")) {
                url = urls.get(i);
                break;
            }
        }
        return url;
    }
}