/**   
 *
 */
package com.nokia.itms.approbe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author haihuab
 * @date 2020年5月14日 下午5:04:35
 */
@Component
@ConfigurationProperties(prefix = "approbe")
@PropertySource(value = { "" })
public class ApProbeConfig {

}
