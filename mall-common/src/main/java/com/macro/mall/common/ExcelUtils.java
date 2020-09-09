package com.macro.mall.common;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类说明:
 *
 * @author zengpeng
 */
public class ExcelUtils {

    public static void main(String[] args) {
        List<ExcelDomain> domains = new ArrayList<>();

        String prefix="扫村";
        String action="查询";
        String shujuyuan="住户列表信息";
        String properties="搜索人手机号，村庄ID，住户集合，联系人姓名，联系人电话，地址";
        String log = "请求路径，请求响应信息，请求耗时";

        Scanner scanner = new Scanner(System.in);

        String flag="exit1";
        while (true){
            action=scanner.nextLine();
            shujuyuan=scanner.nextLine();
            properties=scanner.nextLine();
            flag=scanner.next();
            if(flag.equals("exit")){
                break;
            }
            //1
            domains.add(ExcelDomain.builder()
                    .col0(prefix)
                    .col1("发送者：网格系统\n" +
                            "接收者：网格路由系统")
                    .col2(action + shujuyuan)
                    .col3("网格系统触发")
                    .col4(action + shujuyuan)
                    .col5("网格系统请求网格路由系统" + action + shujuyuan)
                    .col6("X")
                    .col7(shujuyuan)
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
                    .col5("网格系统获取网格路由系统响应信息")
                    .col6("E")
                    .col7(shujuyuan)
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
                    .col5("网格系统请求持久层存储请求信息")
                    .col6("W")
                    .col7(shujuyuan)
                    .col8(log+"，"+properties)
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
                    .col5("网格系统获取持久层响应信息")
                    .col6("E")
                    .col7(shujuyuan)
                    .col8(log+ "," +properties)
                    .col9("新增")
                    .col10("1")
                    .build());

            //5
            domains.add(ExcelDomain.builder()
                    .col0("")
                    .col1("发送者：网格系统\n" +
                            "接收者：网格路由系统")
                    .col2("请求华为全景系统"+action+shujuyuan)
                    .col3("网格路由系统触发")
                    .col4(action + shujuyuan)
                    .col5("网格路由系统请求持久层获取"+action+shujuyuan+"请求路径")
                    .col6("R")
                    .col7(shujuyuan)
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
                    .col5("持久层返回请求路径给网格路由系统")
                    .col6("E")
                    .col7(shujuyuan)
                    .col8(log + properties)
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
                    .col5("网格路由系统请求华为全景系统"+action+shujuyuan)
                    .col6("X")
                    .col7(shujuyuan)
                    .col8(log+properties)
                    .col9("新增")
                    .col10("1")
                    .build());

            //8
            domains.add(ExcelDomain.builder()
                    .col0("")
                    .col1("")
                    .col2("")
                    .col3("")
                    .col4("")
                    .col5("网格路由系统获取响应信息")
                    .col6("E")
                    .col7(shujuyuan)
                    .col8(log +","+ properties)
                    .col9("新增")
                    .col10("1")
                    .build());

            //9
            domains.add(ExcelDomain.builder()
                    .col0("")
                    .col1("")
                    .col2("")
                    .col3("")
                    .col4("")
                    .col5("网格路由系统请求持久层添加华为请求日志信息")
                    .col6("W")
                    .col7(shujuyuan)
                    .col8(log+","+properties)
                    .col9("新增")
                    .col10("1")
                    .build());

            //10
            domains.add(ExcelDomain.builder()
                    .col0("")
                    .col1("")
                    .col2("")
                    .col3("")
                    .col4("")
                    .col5("网格路由系统获取持久层返回信息")
                    .col6("E")
                    .col7(shujuyuan)
                    .col8(log+","+properties)
                    .col9("新增")
                    .col10("1")
                    .build());

        }


        try {
            ExcelUtil.writeExcel(new File("C:\\Users\\曾鹏\\Desktop\\cosmic_floor.xlsx"),domains);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
