/**
 * Copyright 2018-2020 stylefeng & fengshuonan (sn93@qq.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.mohist.mohism.system.dict.service;

import cn.mohist.mohism.system.dict.dto.DictTypeInfo;
import cn.mohist.mohism.system.dict.model.DictType;

import java.util.List;

/**
 * 字典类型远程调用接口
 *
 * @author fengshuonan
 * @date 2018-07-27-上午10:12
 */
public interface DictTypeService {

//    /**
//     * 获取字典类型列表
//     *
//     * @param dictTypeInfo 查询条件封装
//     * @author fengshuonan
//     * @Date 2018/7/25 下午12:36
//     */
//    List<DictTypeInfo> getDictTypeList(DictTypeInfo dictTypeInfo,Integer pageNo,
//                                       Integer pageSize);
//
//    /**
//     * 添加字典类型
//     *
//     * @author fengshuonan
//     * @Date 2018/7/25 下午1:43
//     */
//    void addDictType(DictType dictType);
//
//    /**
//     * 修改字典类型
//     *
//     * @author fengshuonan
//     * @Date 2018/7/25 下午2:28
//     */
    void updateDictType(DictType dictType);
//
//    /**
//     * 删除字典类型
//     *
//     * @author fengshuonan
//     * @Date 2018/7/25 下午2:43
//     */
//    void deleteDictType(Long dictTypeId);
//
//    /**
//     * 修改字典状态
//     *
//     * @author fengshuonan
//     * @Date 2018/7/25 下午2:43
//     */
//    void updateDictTypeStatus(Long dictTypeId,Integer status);

}
