package com.example.bdkj_website.exception;

/**
 * <p>Title: BDException</p>
 * <p>Description: 异常类封装</p>
 * <p>Company: 邦道科技有限公司</p>
 *
 * @author zhanghw
 * @date 2020/4/6 5:36 PM
 */
public class BDException extends RuntimeException {
    private String tip;

    public BDException(String msg) {
        super(msg);
    }

    public BDException(String msg, String tip) {
        super(msg);
        this.tip = tip;
    }

    public String getTip(){
        return this.tip;
    }
}
