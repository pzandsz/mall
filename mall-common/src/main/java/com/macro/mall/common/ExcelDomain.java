package com.macro.mall.common;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

/**
 * 类说明:
 *
 * @author zengpeng
 */
@Data
@Builder
public class ExcelDomain extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String col0;

    @ExcelProperty(index = 1)
    private String col1;

    @ExcelProperty(index = 2)
    private String col2;

    @ExcelProperty(index = 3)
    private String col3;

    @ExcelProperty(index = 4)
    private String col4;

    @ExcelProperty(index = 5)
    private String col5;

    @ExcelProperty(index = 6)
    private String col6;

    @ExcelProperty(index = 7)
    private String col7;

    @ExcelProperty(index = 8)
    private String col8;

    @ExcelProperty(index = 9)
    private String col9;

    @ExcelProperty(index = 10)
    private String col10;
}
