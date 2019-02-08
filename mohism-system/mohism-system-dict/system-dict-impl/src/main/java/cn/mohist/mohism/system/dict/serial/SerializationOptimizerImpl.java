package cn.mohist.mohism.system.dict.serial;

import cn.mohist.mohism.system.dict.model.Dict;
import cn.mohist.mohism.system.dict.model.DictType;
import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.alibaba.fastjson.JSONObject;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {

    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        
        //这里可以把所有需要进行序列化的类进行添加
        classes.add(JSONObject.class);
        // 字典业务类
        classes.add(Dict.class);
        classes.add(DictType.class);
        return classes;
    }
}
