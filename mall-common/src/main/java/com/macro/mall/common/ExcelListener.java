package com.macro.mall.common;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:
 *
 * @author zengpeng
 */
public class ExcelListener<T extends BaseRowModel> extends AnalysisEventListener<T> {
    private final List<T> data = new ArrayList<>();
    @Override
    public void invoke(T obj, AnalysisContext context) {
        //数据存储
        data.add(obj);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<T> getData() {
        return data;
    }
}
