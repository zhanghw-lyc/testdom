package com.example.bdkj_website.tools;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Liuyuhang 13501043063
 *
 */
public class ImgTools {

	public static void main(String[] args) {
		String input = "D:\\software\\workspace_zhw\\BDActive\\file\\activity\\origin\\0fc42e0a-e337-4d78-9f7c-0820c14be62a.jpg";
		String output = "D:\\software\\workspace_zhw\\BDActive\\file\\0fc42e0a-e337-4d78-9f7c-0820c14be62a.jpg";
		ThumbnailsCompressPic(input, output, 100, (float) 0.5);
	}

	/**
	 * 根据size缩放图片的工具
	 * @author Liuyuhang 13501043063
	 * @param inputFile:输入文件路径
	 * @param outputFile:输出文件路径
	 * @param size:要缩放的大的边的size
	 * @param quality:图片质量
	 * @return
	 */
	public static boolean ThumbnailsCompressPic(String inputFile, String outputFile, int size, float quality) {
		try {
			//创建inputfile
			File input = new File(inputFile);
			//读取inpuptFile作为原始对象
			Thumbnails.Builder<File> fileBuilder = Thumbnails.of(input).scale(1.0).outputQuality(1.0);
			BufferedImage src = fileBuilder.asBufferedImage();//读取图片对象
			if (src.getHeight(null) > size || src.getWidth(null) > size) {//判断图片是否大于预期要缩放的图片
				//缩小
				Thumbnails.Builder<File> builder = Thumbnails.of(input);//将inputFile转化为图像对象
				builder.size(50, 500); //取最大的尺寸变成size，然后等比缩放
				builder.outputQuality(quality).toFile(outputFile);//输出图片
			} else {
				//放大
				Thumbnails.of(input).scale(1.0).outputQuality(quality).toFile(outputFile);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 图片大小规定：
	 * mini图：500
	 * 缩略图：200
	 *
	 *
	 */
	/**
	 * 根据size缩放图片的工具
	 * @author Liuyuhang 13501043063
	 * @param inputFile:输入文件路径
	 * @param outputFile:输出文件路径
	 * @param quality:图片质量
	 * @return
	 */
	public static void ThumbnailsCompressPicAbbre(String inputFile, String outputFile, float quality) {
		try {
			//创建inputfile
			File input = new File(inputFile);
			//读取inpuptFile作为原始对象
			Thumbnails.Builder<File> fileBuilder = Thumbnails.of(input).scale(1.0).outputQuality(1.0);
			BufferedImage src = fileBuilder.asBufferedImage();//读取图片对象
			int height = src.getHeight();
			int width = src.getWidth();
			int size = 0;
			//如果宽大于高
			if (width>=height){
				size = 86;
			}else{
				size = 115;
			}
			System.out.println(src.getHeight());
			System.out.println(src.getWidth());
			//缩小
			Thumbnails.Builder<File> builder = Thumbnails.of(input);//将inputFile转化为图像对象
			builder.size(size, size); //取最大的尺寸变成size，然后等比缩放
			builder.outputQuality(quality).toFile(outputFile);//输出图片
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
