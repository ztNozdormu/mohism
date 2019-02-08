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

import cn.mohist.mohism.system.dict.dto.DictInfo;
import cn.mohist.mohism.system.dict.model.Dict;

import cn.mohist.mohism.system.dict.dto.TreeDictInfo;

import java.util.List;

/**
 * 字典远程调用接口
 */
public interface DictService {

    /**
     * 新增字典
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午3:17
     */
    void addDict(Dict dict);

    /**
     * 修改字典
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午3:35
     */
    void updateDict(Dict dict);

    /**
     * 删除字典
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午4:53
     */
    void deleteDict(Long dictId);

    /**
     * 更新字典状态
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午4:53
     */
    void updateDictStatus(Long dictId,Integer status);

    /**
     * 获取字典列表
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午5:18
     */
    List<DictInfo> getDictList(DictInfo dictInfo, Integer pageNo,
                               Integer pageSize);
    /**
     * 获取树形字典列表
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午5:53
     */
    List<TreeDictInfo> getTreeDictList(String dictTypeCode);

}
