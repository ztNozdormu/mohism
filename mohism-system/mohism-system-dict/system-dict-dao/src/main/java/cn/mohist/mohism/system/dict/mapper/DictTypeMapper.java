package cn.mohist.mohism.system.dict.mapper;

import cn.mohist.mohism.system.dict.dto.DictTypeInfo;
import cn.mohist.mohism.system.dict.model.DictType;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-24
 */
public interface DictTypeMapper extends BaseMapper<DictType> {

    /**
     * 获取字典类型列表
     *
     * @author fengshuonan
     * @Date 2018/7/25 上午11:24
     */
    List<DictTypeInfo> getDictTypeList(Page page, DictTypeInfo dictTypeInfo);

}
