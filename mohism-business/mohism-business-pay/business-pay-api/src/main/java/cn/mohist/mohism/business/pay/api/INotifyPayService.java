package cn.mohist.mohism.business.pay.api;

import java.util.Map;

/**
 * @author: dingzhiwei
 * @date: 17/9/10
 * @description:
 */
public interface INotifyPayService {

    Map doAliPayNotify(String jsonParam);

    Map doWxPayNotify(String jsonParam);

    Map sendBizPayNotify(String jsonParam);
}
