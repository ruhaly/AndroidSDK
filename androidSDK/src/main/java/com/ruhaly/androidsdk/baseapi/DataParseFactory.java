/**
 * 文件名：DataParseFactory.java
 * 版本信息�??
 * 日期�??2013-4-2
 */

package com.ruhaly.androidsdk.baseapi;

/**
 * 项目名称：framework 类名称：DataParseFactory 类描述： 创建人：吴安�?? 创建时间�??2013-4-2 下午7:29:29
 * 修改人：吴安�?? 修改时间�??2013-4-2 下午7:29:29 修改备注�??
 */
public class DataParseFactory {
    public static <T> IDataParse<T> newDataParse(String str) {
        return new JSONParse<T>();
    }
}
