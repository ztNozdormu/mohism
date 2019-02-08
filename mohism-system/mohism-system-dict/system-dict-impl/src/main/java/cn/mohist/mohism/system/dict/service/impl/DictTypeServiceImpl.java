package cn.mohist.mohism.system.dict.service.impl;

//import cn.hutool.core.bean.BeanUtil;
//import cn.hutool.core.bean.copier.CopyOptions;
//import cn.mohist.mohism.common.gm.enums.StatusEnum;
//import cn.mohist.mohism.common.gm.exception.RequestEmptyException;
//import cn.mohist.mohism.common.gm.exception.ServiceException;
//import cn.mohist.mohism.core.page.PageFactory;
//import cn.mohist.mohism.core.util.ToolUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.mohist.mohism.common.gm.enums.StatusEnum;
import cn.mohist.mohism.common.gm.exception.RequestEmptyException;
import cn.mohist.mohism.common.gm.exception.ServiceException;
import cn.mohist.mohism.core.page.PageFactory;
import cn.mohist.mohism.core.util.ToolUtil;
import cn.mohist.mohism.system.dict.dto.DictTypeInfo;
import cn.mohist.mohism.system.dict.enums.DictTypeEnum;
import cn.mohist.mohism.system.dict.mapper.DictTypeMapper;
import cn.mohist.mohism.system.dict.model.DictType;
import cn.mohist.mohism.system.dict.service.DictTypeService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static cn.mohist.mohism.system.dict.exception.DictExceptionEnum.*;
import java.util.List;


/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-24
 */
@Component
@Service(version = "1.0.0",interfaceName="cn.mohist.mohism.system.dict.service.DictTypeService")
@Transactional(rollbackFor = Exception.class)
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    /**
     * 获取字典类型列表
     *
     * @param page         分页参数
     * @param dictTypeInfo 查询条件封装
     * @author fengshuonan
     * @Date 2018/7/25 下午12:36
     */
    public List<DictTypeInfo> getDictTypeList(Page page, DictTypeInfo dictTypeInfo) {
        if (page == null) {
            page = PageFactory.defaultPage();
        }
        if (dictTypeInfo == null) {
            dictTypeInfo = new DictTypeInfo();
        }
        return this.baseMapper.getDictTypeList(page, dictTypeInfo);
    }

    public List<DictTypeInfo> getDictTypeList(DictTypeInfo dictTypeInfo,Integer pageNo,
                                       Integer pageSize){

        if (dictTypeInfo == null) {
            dictTypeInfo = new DictTypeInfo();
        }
        return this.baseMapper.getDictTypeList(new Page(pageNo, pageSize), dictTypeInfo);
    }

    /**
     * 添加字典类型
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午1:43
     */
    public void addDictType(DictType dictType) {
        if (ToolUtil.isOneEmpty(dictType, dictType.getDictTypeCode(), dictType.getDictTypeName())) {
            throw new RequestEmptyException();
        }

        //判断有没有相同编码的字典
        Wrapper<DictType> wrapper = new EntityWrapper<DictType>()
                .eq("DICT_TYPE_CODE", dictType.getDictTypeCode());
        int dictTypes = this.selectCount(wrapper);
        if (dictTypes > 0) {
            throw new ServiceException(REPEAT_DICT_TYPE);
        }

        dictType.setStatus(StatusEnum.ENABLE.getCode());
        dictType.setDictTypeClass(DictTypeEnum.BUSINESS.getCode());

        this.insert(dictType);
    }

    /**
     * 修改字典类型
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午2:28
     */
    public void updateDictType(DictType dictType) {
        if (ToolUtil.isOneEmpty(dictType, dictType.getDictTypeCode(), dictType.getDictTypeName())) {
            throw new RequestEmptyException();
        }

        DictType oldDictType = this.selectById(dictType.getDictTypeId());
        if (oldDictType == null) {
//            throw new ServiceException(NOT_EXISTED);
        }

        //查询有没有编码重复的字典
        Wrapper<DictType> wrapper = new EntityWrapper<DictType>()
                .eq("DICT_TYPE_CODE", dictType.getDictTypeCode())
                .and()
                .ne("DICT_TYPE_ID", oldDictType.getDictTypeId());
        int dictTypes = this.selectCount(wrapper);
        if (dictTypes > 0) {
            throw new ServiceException(REPEAT_DICT_TYPE);
        }

        BeanUtil.copyProperties(dictType, oldDictType, CopyOptions.create().setIgnoreNullValue(true));
        this.updateById(oldDictType);
    }

    /**
     * 删除字典类型
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午2:43
     */
    public void deleteDictType(Long dictTypeId) {
        if (ToolUtil.isEmpty(dictTypeId)) {
            throw new RequestEmptyException();
        }

        //判断字典是否存在
        DictType dictType = this.selectById(dictTypeId);
        if (dictType == null) {
            throw new ServiceException(NOT_EXISTED);
        }

        this.deleteById(dictTypeId);
    }

    /**
     * 修改字典状态
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午2:43
     */
    public void updateDictTypeStatus(Long dictTypeId, Integer status) {
        if (ToolUtil.isOneEmpty(dictTypeId, status)) {
            throw new RequestEmptyException();
        }

        //判断字典是否存在
        DictType dictType = this.selectById(dictTypeId);
        if (dictType == null) {
            throw new ServiceException(NOT_EXISTED);
        }

        //判断状态是否正确
        StatusEnum statusEnum = StatusEnum.toEnum(status);
        if (statusEnum == null) {
            throw new ServiceException(WRONG_STATUS);
        }

        dictType.setStatus(status);

        this.updateById(dictType);
    }
}
