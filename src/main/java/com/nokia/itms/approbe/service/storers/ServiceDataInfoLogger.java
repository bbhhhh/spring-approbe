/**   
 *
 */
package com.nokia.itms.approbe.service.storers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年5月15日 上午10:51:30
 */
public class ServiceDataInfoLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceDataInfoLogger.class);

    public static void log(String data) {
        LOGGER.info(data);
    }
}
