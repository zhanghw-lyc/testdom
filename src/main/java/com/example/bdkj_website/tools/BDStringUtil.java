package com.example.bdkj_website.tools;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Title: BDStringUtil</p>
 * <p>Description: 字符串工具类 </p>
 * <p>Company: 成都邦道科技有限公司</p>
 *
 * @author zhanghw
 * @date 2020/3/26 4:17 PM
 */
public class BDStringUtil implements Serializable {

    /***/
    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_CHART = "UTF-8";

    /**
     * 将时间字符串转化为Long型数字
     *
     * @param time HH:mm
     * @return
     */
    public static Long timeStrToLong(String time) {
        String str = time.replaceAll(":", "");
        return toLong(str);
    }

    /**
     * 过滤空NULL
     *
     * @param o
     * @return
     */
    public static String filterNull(Object o) {
        return o != null && !"null".equals(o.toString()) ? o.toString().trim() : "";
    }

    /**
     * 是否为空
     *
     * @param o
     * @return
     */
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if ("".equals(filterNull(o.toString()))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否不为空
     *
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        if (o == null) {
            return false;
        }
        if ("".equals(filterNull(o.toString()))) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 是否可转化为数字
     *
     * @param o
     * @return
     */
    public static boolean isNumber(Object o) {
        try {
            new BigDecimal(o.toString());
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 是否可转化为Long型数字
     *
     * @param o
     * @return
     */
    public static boolean isLong(Object o) {
        try {
            new Long(o.toString());
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 转化为Long型数字, 不可转化时返回0
     *
     * @param o
     * @return
     */
    public static Long toLong(Object o) {
        if (isLong(o)) {
            return new Long(o.toString());
        } else {
            return 0L;
        }
    }

    /**
     * 转化为int型数字, 不可转化时返回0
     *
     * @param o
     * @return
     */
    public static int toInt(Object o) {
        if (isNumber(o)) {
            return new Integer(o.toString());
        } else {
            return 0;
        }
    }

    public static Integer toInteger(Object o) {
        if (isNumber(o)) {
            return new Integer(o.toString());
        } else {
            return null;
        }
    }

    /**
     * 替换字符串,支持字符串为空的情形
     *
     * @param strData
     * @param regex
     * @param replacement
     * @return
     */
    public static String replace(String strData, String regex, String replacement) {
        return strData == null ? "" : strData.replaceAll(regex, replacement);
    }

    /**
     * 字符串转为HTML显示字符
     *
     * @param strData
     * @return
     */
    public static String string2HTML(String strData) {
        if (strData == null || "".equals(strData)) {
            return "";
        }
        strData = replace(strData, "&", "&amp;");
        strData = replace(strData, "<", "&lt;");
        strData = replace(strData, ">", "&gt;");
        strData = replace(strData, "\"", "&quot;");
        return strData;
    }

    /**
     * 从指定位置截取指定长度的字符串
     *
     * @param
     * @return
     */
    public static String getMiddleString(String input, int index, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length() - index + 1) ? input.length() - index + 1 : count;
        return input.substring(index - 1, index + count - 1);
    }

    /**
     * 将"/"替换成"\"
     *
     * @param strDir
     * @return
     */
    public static String changeDirection(String strDir) {
        String s = "/";
        String a = "\\";
        if (strDir != null && !" ".equals(strDir)) {
            if (strDir.contains(s)) {
                strDir = strDir.replace(s, a);
            }
        }
        return strDir;
    }

    /**
     * 去除字符串中 头和尾的空格，中间的空格保留
     *
     * @return String
     * @throws
     * @Title: trim
     * @Description:
     */
    public static String trim(String s) {
        int i = s.length();// 字符串最后一个字符的位置
        int j = 0;// 字符串第一个字符
        int k = 0;// 中间变量
        char[] arrayOfChar = s.toCharArray();// 将字符串转换成字符数组
        while ((j < i) && (arrayOfChar[(k + j)] <= ' '))
            ++j;// 确定字符串前面的空格数
        while ((j < i) && (arrayOfChar[(k + i - 1)] <= ' '))
            --i;// 确定字符串后面的空格数
        return (((j > 0) || (i < s.length())) ? s.substring(j, i) : s);// 返回去除空格后的字符串
    }

    /**
     * 得到大括号中的内容
     *
     * @param str
     * @return
     */
    public static String getBrackets(String str) {
        int a = str.indexOf("{");
        int c = str.indexOf("}");
        if (a >= 0 && c >= 0 & c > a) {
            return (str.substring(a + 1, c));
        } else {
            return str;
        }
    }

    /**
     * 去掉字符串中、前、后的空格
     *
     * @param
     * @throws IOException
     */
    public static String extractBlank(String name) {
        if (name != null && !"".equals(name)) {
            return name.replaceAll(" +", "");
        } else {
            return name;
        }
    }

    /**
     * 将null换成""
     *
     * @param str
     * @return
     */
    public static String convertStr(String str) {
        return str != null && !"null".equals(str) ? str.trim() : "";
    }

    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }

    /**
     * TODO URL转换为参数字符串
     * 如 "index.jsp?id=123&code=tom"，解析为id=123&code=tom
     *
     * @param url
     * @return
     * @author MrXiao
     * @date 2017年4月27日 上午11:24:23
     */
    public static String truncateUrlPage(String url) {
        if (url == null) {
            return null;
        }
        url = url.trim().toLowerCase();

        if (url.contains("?")) {
            String[] arrSplit = url.split("[?]");
            if (arrSplit.length > 1) {
                if (arrSplit[1] != null) {
                    return arrSplit[1];
                }
            }
        }
        return url;
    }

    /**
     * TODO URL参数转换为Map
     * id=123&code=tom转换为Map
     *
     * @param urlParamStr
     * @return
     * @author MrXiao
     * @date 2017年4月27日 上午11:28:10
     */
    public static Map<String, String> urlParam(String urlParamStr) {
        Map<String, String> map = new HashMap<String, String>();
        String strUrlParam = truncateUrlPage(urlParamStr);
        if (strUrlParam == null) {
            return map;
        }
        // 每个键值为一组
        String[] arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = strSplit.split("[=]");

            // 解析出键值
            if (arrSplitEqual.length > 1) {
                if (arrSplitEqual[1] != null && arrSplitEqual[1].contains("%")) {
                    // 正确解析
                    try {
                        map.put(arrSplitEqual[0], URLDecoder.decode(arrSplitEqual[1], "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    // 正确解析
                    map.put(arrSplitEqual[0], trim(arrSplitEqual[1]));
                }
            } else {
                if (arrSplitEqual[0] != "") {
                    // 只有参数没有值，不加入
                    map.put(arrSplitEqual[0], "");
                }
            }
        }
        return map;
    }


    /**
     * @see #join(Object[] array, String sep, String prefix)
     */
    public static String join(Object[] array, String sep) {
        return join(array, sep, null);
    }

    /**
     * @see #join(Object[] array, String sep, String prefix)
     */
    public static String join(Collection<?> list, String sep) {
        return join(list, sep, null);
    }

    /**
     * @see #join(Object[] array, String sep, String prefix)
     */
    public static String join(Collection<?> list, String sep, String prefix) {
        Object[] array = list == null ? null : list.toArray();
        return join(array, sep, prefix);
    }

    /**
     * 以指定的分隔符来进行字符串元素连接
     * <p>
     * 例如有字符串数组array和连接符为逗号(,)
     * <code>
     * String[] array = new String[] { "hello", "world", "qiniu", "cloud","storage" };
     * </code>
     * 那么得到的结果是:
     * <code>
     * hello,world,qiniu,cloud,storage
     * </code>
     * </p>
     *
     * @param array  需要连接的对象数组
     * @param sep    元素连接之间的分隔符
     * @param prefix 前缀字符串
     * @return 连接好的新字符串
     */
    public static String join(Object[] array, String sep, String prefix) {
        if (array == null) {
            return "";
        }

        int arraySize = array.length;

        if (arraySize == 0) {
            return "";
        }

        if (sep == null) {
            sep = "";
        }

        if (prefix == null) {
            prefix = "";
        }

        StringBuilder buf = new StringBuilder(prefix);
        for (int i = 0; i < arraySize; i++) {
            if (i > 0) {
                buf.append(sep);
            }
            buf.append(array[i] == null ? "" : array[i]);
        }
        return buf.toString();
    }

    /**
     * 以json元素的方式连接字符串中元素
     * <p>
     * 例如有字符串数组array
     * <code>
     * String[] array = new String[] { "hello", "world", "qiniu", "cloud","storage" };
     * </code>
     * 那么得到的结果是:
     * <code>
     * "hello","world","qiniu","cloud","storage"
     * </code>
     * </p>
     *
     * @param array 需要连接的字符串数组
     * @return 以json元素方式连接好的新字符串
     */
    public static String jsonJoin(String[] array) {
        int arraySize = array.length;
        int bufSize = arraySize * (array[0].length() + 3);
        StringBuilder buf = new StringBuilder(bufSize);
        for (int i = 0; i < arraySize; i++) {
            if (i > 0) {
                buf.append(',');
            }

            buf.append('"');
            buf.append(array[i]);
            buf.append('"');
        }
        return buf.toString();
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || "".equals(s);
    }

    public static boolean inStringArray(String s, String[] array) {
        for (String x : array) {
            if (x.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] utf8Bytes(String data) {
        try {
            return data.getBytes(DEFAULT_CHART);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String utf8String(byte[] data) {
        try {
            return new String(data, DEFAULT_CHART);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isBlank(String value) {
        int strLen;
        if (value == null || (strLen = value.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(value.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlankLoop(String... values) {
        int strLen;
        if (values == null || (strLen = values.length) == 0) {
            return true;
        }
        for (String value : values) {
            if (value == null || (strLen = value.length()) == 0) {
                continue;
            }
            for (int i = 0; i < strLen; i++) {
                if ((Character.isWhitespace(value.charAt(i)) == false)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    public static boolean isNotBlankLoop(String... values) {
        return !isBlankLoop(values);
    }

    /**
     * 检查指定的字符串列表是否不为空。
     */
    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !isEmpty(value);
            }
        }
        return result;
    }

    /**
     * 首字母大写
     *
     * @param str
     * @return
     */
    public static String getFirstUpper(String str) {
        String newStr = "";
        if (str.length() > 0) {
            newStr = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
        }
        return newStr;
    }

    /**
     * 将驼峰命名的字符串转成符合数据库字段的字符串
     *
     * @param str
     * @return java.lang.String
     */
    public static String getColunm(String str) {
        if (isEmpty(str)) {
            return str;
        }

        char[] chars = str.toCharArray();
        //
        for (char c : chars) {
            if (c > 65 && c < 90) {
                String[] strArry = str.split(String.valueOf(c));
                str = strArry[0] + "_" + String.valueOf(c) + getColunm(strArry[1]);
            }
        }
        return str.toUpperCase();
    }

    /**
     * 将null转换为空字符串
     * @param str
     * @return
     */
    public static String getStrValue(String str){
        if (isBlank(str)){
            return "";
        }
        return str;
    }

    public static String getStringWrapper(String str, String frontStr, String backStr) {

        if (backStr != null) {
            str += backStr;
        }
        if (frontStr != null) {
            str = frontStr + str;
        }
        return str;
    }

    /**
    * @Description: 将有域名的http转化为https
    * @Param: [url]
    * @return: java.lang.String
    * @Author: zhanghw
    * @Date: 2020/7/22
    */
    public static String httpsUrl(String url){
        if (url.contains("www")){
            url = url.replace("http","https");
        }
        return url;
    }

    /**
     * 会计电算化包装请求头，方便读取图片
     * @param requestURL
     * @param requestURI
     * @param accountSetId
     * @param staticPcPort
     * @return
     */
    public static String packageRequestHeadForAccount(String requestURL, String requestURI, Integer accountSetId, String staticPcPort) {
        if (requestURL.contains("www")){
            String url = BDStringUtil.httpsUrl(requestURL.toString());//获得客户端发送请求的完整url
            String ip = url.substring(0, url.lastIndexOf(":"));
            String requestHead = new StringBuilder().append(ip).append(":").append(staticPcPort).append("/account/").append(accountSetId).append("/").toString();
            return requestHead;
        }else {
            String requestHead = requestURL.substring(0, requestURL.indexOf(requestURI)) + "/account/" + accountSetId + "/";
            return requestHead;
        }
    }

    /**
     * 删除所有的HTML标签
     *
     * @param source 需要进行除HTML的文本
     * @return
     */
    public static String deleteAllHTMLTag(String source) {
        if(source == null) {
            return "";
        }
        String s = source;
        /** 删除普通标签  */
        s = s.replaceAll("<(S*?)[^>]*>.*?|<.*? />", "");
        /** 删除转义字符 */
        s = s.replaceAll("&.{2,6}?;", "");
        /** 删除src属性内容*/
        s = s.replaceAll("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)","");
        return s;
    }

    public static String getSubStr(String source,Integer length){
        if (isBlank(source)){
            return "";
        }
        String substring = source;
        if (source.length() >= length){
            substring = source.substring(0, length);
        }
        return substring;
    }

    public static String getSrcHtmlTag(String source){
        Pattern p = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)");
        Matcher m = p.matcher(source);
        String rawData = "";
        if(m.find()){
            rawData = m.group(1);
            System.out.println(rawData);  // 组提取字符串 0x993902CE
        }
        return rawData;
    }

    /**
     * 富文本图片限制宽度
     * @param s
     * @return
     */
    public static String addWithToHtmlTag(String s){
        if(s == null) {
            return "";
        }
        String replace = s.replace("<img", "<img style=\"width: 100%; height: 100%;\"");
        //替换table表格的宽和高
        String replace1 = replace.replace("<table", "<table style=\"height: 100%; border-collapse: collapse; width:100%; margin-left: auto; margin-right: auto;\"");

        return replace1;
    }

    /*public static void main(String[] args) {
        File file = new File("D:\\aaa.txt");
        BufferedReader reader = null;
        List<String> list = Lists.newArrayList();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                list.add(tempStr);
            }
            reader.close();
            List<String> collect = list.stream().distinct().collect(Collectors.toList());
            collect.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }*/

    public static void main(String[] args) {
        /*String subStr = getSubStr("12345678901234", 15);
        System.out.println(subStr);*/
        String s = "<img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAfQAAAEaCAYAAADnmKV4AAAgAElEQVR4Aey9d3Rc13n1rfV9ETFz63QAbCAaG0CCvZPqktV7L1a1JLfYsYrjOFYvLsmbnthJ3iR24m7LkiJKFCkWsYi9ir33ClYQHdzv2s+5Z+bOYFBZJeOPs+5ggCl3ZjC/s/RUo55+kJDTAfo4aWCSNlVTHMHMsCxZEcs1sceWgTZ2mXUAAAoaSURBVImZxsRIy3lsGnBD3lcwn2hXvZTyaaehy2W3jSfdJga1Ig4E6Dkc5pjmVpasYz4gsPRSq+Cy3cBxs4TDehYHzRyOWgUcVbPYz6axl07AC/TTaklU+cVGB5PVOkbdCsatMo5KWeyaSeykE9gxkwL0UbWIp6sdXKy2cdptYNKsYVgu4TCXdVLuTtqd8+gEOv/v6IGzvh5xZM2pow/n1NP15yYepc5rff8+pwt4z5/LvwNDAd2Buij1qUoXoJfqGJYbGJZqGFbq+MboGP/qV/8F/uT3//xfI8A90b5wZ8RoLO7nfPnbsqdCt0P9ODbB7rs7GZ3eCCKeiAM7k+nQtdAr4lC9wA9EsNmOIINjzqnEhegc9vaLYHO2jljLRWXGjqhzllzpdBpKENFrPaPM80ufvMhqvMIqo5FbS0cwbWQz6jUeyPsB7qqpb8LoBPKCuhMt88CXaA+k4L31tfV9/wg168J9F6Y2+1UrIYi6DPCHCVUrnN0m2MjYT8Wxlosgo1YWPUpJOPYSyexK2YgSeylEk4ksZckzDXQY9hLTINGM18loJ/ncgJ1jm7J/Ll/Dp3ZhHkmM06zmga7V3W/yfV1hT4F+qzhzOx9gX1cPcBooFOpM/ja/zDjf+3O1esxPA/Q6Q53Xq/itF3HoF7CYaOIUUMp9EOTK1S5pjaJsZXCk3IOz1oVHDeKOKjmsFejSs9ir5zBjpWSrNluQv134sBQQJcHhXYVjxtFPKZKrxXEM+KxaWDHSOMxFyvRv71UwHGrgaNmFbuVAvbKBexzXj1rY980sZc2sGcYYvOsga5P70jboWXj0Mri0Mx6Tt7zg386Bsf3jiwNdZ40stEpfab1b46bga5gPgt0Qr2AUaGIYbEoDzWjchmjUg3P1h/hn/y9X8H/+R+/f2cQ3RVg7vcIwUXxBkB0f2/edzSEveeiP/Om+94HhXnXN31/3vtOjXvZA48o9XvC/f8DQakD2bQ/OIwAAAAASUVORK5CYII=\" alt=\"\" /></span></p>\n" +
                "<p class=\"p1\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939;\"><span class=\"s1\" style=\"font-kerning: none;\">各省、自治区、直辖市公安厅、局，新疆生产建设兵团公安局：</span></p>\n" +
                "<p class=\"p2\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939; min-height: 21px;\">&nbsp;</p>\n" +
                "<p class=\"p1\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939;\"><span class=\"s1\" style=\"font-kerning: none;\">根据《国务院对确需保留的行政审批项国设定行政许可的决定》（国务院令第412号）的规定，公布保留的涉及安全技术防范管理的行政许可项目有4项；即安全技术防范产品生产、销售的审批；邮政局（所）安全防范设施设计审核及工程验收；军工产品储存库风险等级认定和技术防范工程方案审核及工程验收；金融机构营业场所、金库安全防范设施设计方案审批及工程验收。</span></p>\n" +
                "<p class=\"p2\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939; min-height: 21px;\">&nbsp;</p>\n" +
                "<p class=\"p1\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939;\"><span class=\"s1\" style=\"font-kerning: none;\"><span class=\"Apple-converted-space\">&nbsp; &nbsp; </span>为进一步规范安全技术防范行业管理工作，确保上述保留行政许可项团的公开、公平、公正实施，现就有关问题通知如下：</span></p>\n" +
                "<p class=\"p2\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939; min-height: 21px;\">&nbsp;</p>\n" +
                "<p class=\"p1\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939;\"><span class=\"s1\" style=\"font-kerning: none;\"><span class=\"Apple-converted-space\">&nbsp; &nbsp; </span>一、对继续实施生产登记批准制度的5类产品（见附件1）；其生产审批环节仍按照《安全技术防范产品管理办法》的规定执行。2004年年审工作尚未开展的地方，可根据当地实际情况；从今年第四季度或明年第一季度起执行。销售审批环节在国务院公布保留许可项目之前已取消行政审批的；不再重新设定；尚未取消的；要尽快转变管理模式。</span></p>\n" +
                "<p class=\"p2\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939; min-height: 21px;\">&nbsp;</p>\n" +
                "<p class=\"p1\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939;\"><span class=\"s1\" style=\"font-kerning: none;\"><span class=\"Apple-converted-space\">&nbsp; &nbsp; </span>二、对列入第一批强制性认证产品目录的1类4种产品（见附件2）； 其管理制度严格按《认证认可条例》和《强制性产品认证管理规定》执行。从2003年5月1日起，列入强制性认证产品目录的产品须获得强制性产品认证证书；并加施强制性产品认证标志后，方可出厂销售、进口和在经营性活动中使用。</span></p>\n" +
                "<p class=\"p2\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939; min-height: 21px;\">&nbsp;</p>\n" +
                "<p class=\"p1\" style=\"margin: 0px; text-align: justify; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal; font-family: 'Source Han Sans CN'; color: #393939;\"><span class=\"s1\" style=\"font-kerning: none;\"><span class=\"Apple-converted-space\">&nbsp; &nbsp; </span>三、对列入第二批强制性认证产品目录的4类7种产品（见附件3），从今年8月1日起到2005年10月1日止；为生产登记制度向认证制度管理的过渡期。在进入过渡期后开始接受认证申请，在过渡期间生产登记批准书和认证证书同时有效。2005年10月1日以后；生产登记批准书作废；管理方式与第一批强制性认证产品的管理方式相同。对新申请从业的企业，应引导其直接申请认证，对生产登记批准证书或检测报告已到期或即将到期的；应督促其尽快向认证制度转变；以免增加企业负担。</span></p>";
    }


}


