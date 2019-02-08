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
package cn.mohist.mohism.core.page;

import cn.mohist.mohism.common.gm.page.PageQuery;
import cn.mohist.mohism.common.gm.util.ValidateUtil;
import cn.mohist.mohism.core.context.RequestDataHolder;
import cn.mohist.mohism.core.reqres.request.RequestData;
import cn.mohist.mohism.core.util.HttpContext;
import cn.mohist.mohism.core.util.ToolUtil;
import com.baomidou.mybatisplus.plugins.Page;

import javax.servlet.http.HttpServletRequest;


/**
 * 默认分页参数构建
 *
 * @author fengshuonan
 * @date 2017年11月15日13:52:16
 */
public class PageFactory {

    /**
     * 排序，升序还是降序
     */
    private static final String ASC = "asc";

    /**
     * 每页大小的param名称
     */
    private static final String PAGE_SIZE_PARAM_NAME = "pageSize";

    /**
     * 第几页的param名称
     */
    private static final String PAGE_NO_PARAM_NAME = "pageNo";

    /**
     * 升序还是降序的param名称
     */
    private static final String SORT_PARAM_NAME = "sort";

    /**
     * 根据那个字段排序的param名称
     */
    private static final String ORDER_BY_PARAM_NAME = "orderBy";

    /**
     * 默认规则的分页
     *
     * @author fengshuonan
     * @Date 2018/7/23 下午4:11
     */
    public static <T> Page<T> defaultPage() {

        int pageSize = 20;
        int pageNo = 1;

        HttpServletRequest request = HttpContext.getRequest();

        if (request == null) {
            return new Page<>(pageNo, pageSize);
        } else {
            //每页条数
            String pageSizeString = getFieldValue(request, PAGE_SIZE_PARAM_NAME);
            if (ValidateUtil.isNotEmpty(pageSizeString)) {
                pageSize = Integer.valueOf(pageSizeString);
            }

            //第几页
            String pageNoString = getFieldValue(request, PAGE_NO_PARAM_NAME);
            if (ValidateUtil.isNotEmpty(pageNoString)) {
                pageNo = Integer.valueOf(pageNoString);
            }

            //获取排序字段和排序类型(asc/desc)
            String sort = getFieldValue(request, SORT_PARAM_NAME);
            String orderByField = getFieldValue(request, ORDER_BY_PARAM_NAME);

            if (ToolUtil.isEmpty(sort)) {
                Page<T> page = new Page<>(pageNo, pageSize);
                page.setOpenSort(false);
                return page;
            } else {
                Page<T> page = new Page<>(pageNo, pageSize, orderByField);
                if (ASC.equalsIgnoreCase(sort)) {
                    page.setAsc(true);
                } else {
                    page.setAsc(false);
                }
                return page;
            }
        }

    }

    /**
     * 自定义参数的分页
     *
     * @author fengshuonan
     * @Date 2018/7/23 下午4:11
     */
    public static <T> Page<T> createPage(PageQuery pageQuery) {

        int pageSize = 20;
        int pageNo = 1;

        if (pageQuery != null && ValidateUtil.isNotEmpty(pageQuery.getPageSize())) {
            pageSize = pageQuery.getPageSize();
        }

        if (pageQuery != null && ValidateUtil.isNotEmpty(pageQuery.getPageNo())) {
            pageNo = pageQuery.getPageNo();
        }

        if (pageQuery == null) {
            Page<T> page = new Page<>(pageNo, pageSize);
            page.setOpenSort(false);
            return page;
        } else {
            if (ToolUtil.isEmpty(pageQuery.getSort())) {
                Page<T> page = new Page<>(pageNo, pageSize);
                page.setOpenSort(false);
                return page;
            } else {
                Page<T> page = new Page<>(pageNo, pageSize, pageQuery.getOrderByField());
                if (ASC.equalsIgnoreCase(pageQuery.getSort())) {
                    page.setAsc(true);
                } else {
                    page.setAsc(false);
                }
                return page;
            }
        }
    }

    /**
     * 获取参数值，通过param或从requestBody中取
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午1:12
     */
    private static String getFieldValue(HttpServletRequest request, String fieldName) {
        String parameter = request.getParameter(fieldName);
        if (parameter == null) {
            RequestData requestData = RequestDataHolder.get();
            if (requestData == null) {
                return null;
            } else {
                Object fieldValue = requestData.get(fieldName);
                if (fieldValue == null) {
                    return null;
                } else {
                    return fieldValue.toString();
                }
            }
        } else {
            return null;
        }
    }
}
