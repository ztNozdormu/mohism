package cn.mohist.mohism.business.pay.api;

import java.util.Map;

/**
 * @author: dingzhiwei
 * @date: 17/9/8
 * @description:
 */
public interface IPayChannelService {

    Map selectPayChannel(String jsonParam);

}
