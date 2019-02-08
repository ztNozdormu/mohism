package cn.mohist.mohism.system.dict.mapper;

import cn.mohist.mohism.system.dict.dto.DictInfo;
import cn.mohist.mohism.system.dict.model.Dict;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 *  基于mp
 * 基础字典 Mapper 接口
 * </p>
 */
public interface DictMapper extends BaseMapper<Dict> {

    /**
     * 获取字典列表
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午5:21
     */
    List<DictInfo> getDictList(Page page, DictInfo dictInfo);

}
