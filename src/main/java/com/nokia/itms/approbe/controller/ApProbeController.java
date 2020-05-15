/**   
 *
 */
package com.nokia.itms.approbe.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.itms.approbe.service.storers.ServiceDataInfoLogger;
import com.nokia.itms.approbe.service.storers.StaInfoLogger;
import com.nokia.itms.approbe.service.storers.UplinkStatusLogger;
import com.nokia.itms.approbe.service.storers.WifiStatusLogger;
import com.nokia.itms.approbe.service.storers.WlanNeighborLogger;
import com.nokia.itms.util.JsonUtils;

/**
 * @author haihuab
 * @date 2020年5月14日 下午3:52:47
 */
@RestController
@RequestMapping(path = "rest/softprobe/periodic-message")
public class ApProbeController {
    public static final String RESP_SUCCESS = "{\"respCode\":0}";

    @PostMapping(path = "uplinkStatus", consumes = "application/json", produces = "application/json")
    public String uplinkStatus(@RequestBody Map<String, Object> data) {
        UplinkStatusLogger.log(JsonUtils.objectToJson(data));
        return RESP_SUCCESS;
    }

    @PostMapping(path = "staInfo", consumes = "application/json", produces = "application/json")
    public String staInfo(@RequestBody Map<String, Object> data) {
        StaInfoLogger.log(JsonUtils.objectToJson(data));
        return RESP_SUCCESS;
    }

    @PostMapping(path = "WiFiStatus", consumes = "application/json", produces = "application/json")
    public String WiFiStatus(@RequestBody Map<String, Object> data) {
        WifiStatusLogger.log(JsonUtils.objectToJson(data));
        return RESP_SUCCESS;
    }

    @PostMapping(path = "wlanNeighbor", consumes = "application/json", produces = "application/json")
    public String wlanNeighbor(@RequestBody Map<String, Object> data) {
        WlanNeighborLogger.log(JsonUtils.objectToJson(data));
        return RESP_SUCCESS;
    }

    @PostMapping(path = "serviceDataInfo", consumes = "application/json", produces = "application/json")
    public String serviceDataInfo(@RequestBody Map<String, Object> data) {
        ServiceDataInfoLogger.log(JsonUtils.objectToJson(data));
        return RESP_SUCCESS;
    }

}
