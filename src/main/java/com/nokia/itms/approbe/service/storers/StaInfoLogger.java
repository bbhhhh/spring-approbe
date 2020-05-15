/**   
 *
 */
package com.nokia.itms.approbe.service.storers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年5月15日 上午10:52:05
 */
public class StaInfoLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(StaInfoLogger.class);

    public static void log(String data) {
        LOGGER.info(data);
    }
}
