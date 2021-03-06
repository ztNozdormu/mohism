package cn.mohist.mohism.business.pay.service.impl;

import cn.mohist.mohism.business.pay.api.IPayChannelService;
import cn.mohist.mohism.business.pay.model.PayChannel;
import cn.mohist.mohism.business.pay.service.BaseService;
import cn.mohist.mohism.pay.domain.BaseParam;
import cn.mohist.mohism.pay.enumm.RetEnum;
import cn.mohist.mohism.pay.util.JsonUtil;
import cn.mohist.mohism.pay.util.MyLog;
import cn.mohist.mohism.pay.util.ObjectValidUtil;
import cn.mohist.mohism.pay.util.RpcUtil;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.Map;

/**
 * @author: dingzhiwei
 * @date: 17/9/8
 * @description:
 */
@Service(version = "1.0.0")
public class PayChannelServiceImpl extends BaseService implements IPayChannelService {

    private static final MyLog _log = MyLog.getLog(PayChannelServiceImpl.class);

    @Override
    public Map selectPayChannel(String jsonParam) {
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("查询支付渠道信息失败, {}. jsonParam={}", RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        String mchId = baseParam.isNullValue("mchId") ? null : bizParamMap.get("mchId").toString();
        String channelId = baseParam.isNullValue("channelId") ? null : bizParamMap.get("channelId").toString();
        if (ObjectValidUtil.isInvalid(mchId, channelId)) {
            _log.warn("查询支付渠道信息失败, {}. jsonParam={}", RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        PayChannel payChannel = super.baseSelectPayChannel(mchId, channelId);
        if(payChannel == null) return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_DATA_NOT_EXISTS);
        String jsonResult = JsonUtil.object2Json(payChannel);
        return RpcUtil.createBizResult(baseParam, jsonResult);
    }
}
