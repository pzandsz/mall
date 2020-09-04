package com.macro.mall.excel;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:
 *
 * @author zengpeng
 */
public class WanggeExcelTest {


    @Test
    public void create() throws FileNotFoundException {

        List<ExcelDomain> domains = new ArrayList<>();

        String prefix="扫街";
        String action="查询";

        String shujuyuan="走访记录商户详情列表";

        String properties="扫街活动ID，扫街活动名称，商户ID，商户名称，联系人名称，联系人电话";
        //1
        domains.add(ExcelDomain.builder()
                .col0(prefix)
                .col1("发送者：用户\n" +
                        "接收者：前端系统")
                .col2(action + shujuyuan)
                .col3("用户点击"+action)
                .col4(action + shujuyuan)
                .col5(action + shujuyuan)
                .col6("E")
                .col7(prefix + shujuyuan)
                .col8(properties)
                .col9("新增")
                .col10("1")
                .build());
        //2
        domains.add(ExcelDomain.builder()
                .col0("")
                .col1("")
                .col2("")
                .col3("")
                .col4("")
                .col5(action + "信息输出到服务端")
                .col6("X")
                .col7(prefix+shujuyuan)
                .col8(properties)
                .col9("新增")
                .col10("1")
                .build());

        //3
        domains.add(ExcelDomain.builder()
                .col0("")
                .col1("")
                .col2("")
                .col3("")
                .col4("")
                .col5("服务端返回结果给前端系统")
                .col6("E")
                .col7(prefix+shujuyuan)
                .col8(properties)
                .col9("新增")
                .col10("1")
                .build());

        //4
        domains.add(ExcelDomain.builder()
                .col0("")
                .col1("")
                .col2("")
                .col3("")
                .col4("")
                .col5("前端返回"+action+"结果给用户")
                .col6("X")
                .col7(prefix+shujuyuan)
                .col8(properties)
                .col9("新增")
                .col10("1")
                .build());

        //5
        domains.add(ExcelDomain.builder()
                .col0("")
                .col1("发送者：前端系统\n" +
                        "接收者：服务端网格系统")
                .col2(action+shujuyuan)
                .col3("输入触发")
                .col4(action + shujuyuan)
                .col5("服务端网格系统获取前端请求数据")
                .col6("E")
                .col7(prefix+shujuyuan)
                .col8(properties)
                .col9("新增")
                .col10("1")
                .build());

        //6
        domains.add(ExcelDomain.builder()
                .col0("")
                .col1("")
                .col2("")
                .col3("")
                .col4("")
                .col5("服务端查询持久层"+shujuyuan)
                .col6("R")
                .col7(prefix+shujuyuan)
                .col8(properties)
                .col9("新增")
                .col10("1")
                .build());
        //7
        domains.add(ExcelDomain.builder()
                .col0("")
                .col1("")
                .col2("")
                .col3("")
                .col4("")
                .col5("持久层返回"+shujuyuan+"给服务端网格系统")
                .col6("E")
                .col7(prefix+shujuyuan)
                .col8(properties)
                .col9("新增")
                .col10("1")
                .build());

        domains.add(ExcelDomain.builder()
                .col0("")
                .col1("")
                .col2("")
                .col3("")
                .col4("")
                .col5("服务端网格系统返回"+shujuyuan+"给前端系统")
                .col6("X")
                .col7(prefix+shujuyuan)
                .col8(properties)
                .col9("新增")
                .col10("1")
                .build());



        ExcelUtil.writeExcel(new File("C:\\Users\\曾鹏\\Desktop\\cosmic_floor.xlsx"),domains);
    }
}
