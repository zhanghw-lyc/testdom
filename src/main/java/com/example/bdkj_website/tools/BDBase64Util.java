package com.example.bdkj_website.tools;

import com.example.bdkj_website.config.BASE64DecodedMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BDBase64Util {
    /**
     * base64 格式转化为 MultipartFile
     * @param base64 字符串
     * （base64格式: "data:image/png;base64," + "图片的base64字符串"）
     * @return
     */
    public static MultipartFile base64ToMultipart(String base64){
        try {
            String[] baseStr = base64.split(",");
            BASE64Decoder decoder = new BASE64Decoder();

            byte[] b = new byte[0];
            b = decoder.decodeBuffer(baseStr[1]);

            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            return new BASE64DecodedMultipartFile(b,baseStr[0]);
        }catch (Exception e){
            return null;
        }
    }

    /**
     *  将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @param imgFile 图片路径
     * @return
     */
    public static String ImageToBase64ByLocal(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    /**
     * base64 转换为 输入流
     * @param base64
     * @return
     */
    public static InputStream base64ToInput(String base64){
        try {
            byte[] bytes = new BASE64Decoder().decodeBuffer(base64);
            for(int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            return new ByteArrayInputStream(bytes);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}