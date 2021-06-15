package com.example.bdkj_website.modol;

/**
 * Copyright (C)  Chengdu BangDao 2019-
 * FileName : StandardData.java
 * History : 
 * 版本号		作者			创建或修改日期		public方法列表
 * 1.0		liuyuhang	2019-11-11		[setSuccess,setWarning,setError,setException]
 */

import java.util.TreeMap;

/**
 * @desc 返回值的标准类;
 * @desc 被config.StandardResponseBodyAdvice.java调用
 * @desc 不符合本标准类的内容,会被StandardResponseBodyAdvice拦截
 * @author liuyuhang3385
 */
public class StandardData<K, V> {

	/**
	 * 设置返回值的状态
	 */
	private String status = "success";

	/**
	 * 设置返回的消息内容
	 */
	private String message = "defaultMessage";

	/**
	 * 设置返回的错误内容
	 */
	private Exception e = null;

	/**
	 * 设置返回的数据
	 */
	private TreeMap<K, V> Data = new TreeMap<K, V>();

	/**
	 * 设置数据
	 * 
	 * @param k,key
	 * @param v,value
	 * @return data本身
	 */
	public TreeMap<K, V> put(K k, V v) {
		this.Data.put(k, v);
		return Data;
	}

	/**
	 * 根据key删除数据
	 * 
	 * @param k,key
	 * @return data本身
	 */
	public TreeMap<K, V> remove(K k) {
		this.Data.remove(k);
		return Data;
	}

	/**
	 * 删除当前data内的全部数据
	 * 
	 * @return
	 */
	public String cleanAll() {
		this.Data.clear();
		return "success";
	}

	/**
	 * 根据key查询数据
	 * 
	 * @param k,key
	 * @return data的value本身
	 */
	public V get(K k) {
		return this.Data.get(k);
	}

	/**
	 * 设置成功状态
	 * 
	 * @param message 成功的提示内容字符串
	 * @return 字符串提示成功
	 */
	public String setSuccess(String message) {
		status = "success";
		if (null != message) {
			this.message = message;
			return "set status success and set message : " + message;
		} else {
			this.message = "defaultSuccessMessage";
			return "set status success and set message default or extends";
		}
	}

	/**
	 * 设置警告状态
	 * 
	 * @param message 警告的提示内容字符串
	 * @return 字符串提示成功
	 */
	public String setWarning(String message) {
		status = "warning";
		if (null != message) {
			this.message = message;
			return "set status warning and set message : " + message;
		} else {
			this.message = "defaultWarningMessage";
			return "set status warning and set message default or extends";
		}
	}

	/**
	 * 设置错误状态
	 * 
	 * @param message 错误的提示内容字符串
	 * @return 字符串提示成功
	 */
	public String setError(String message) {
		status = "error";
		if (null != message) {
			this.message = message;
			return "set status error and set message : " + message;
		} else {
			this.message = "defaultErrorMessage";
			return "set status error and set message default or extends";
		}
	}

	/**
	 * 设置异常状态
	 * 
	 * @param message 异常的提示内容字符串
	 * @return 字符串提示成功
	 */
	public String setException(String message, Exception e) {
		status = "exception";
		System.out.println("StandardData throw exception , message is :" + message);
		if (null != message) {
			this.message = message;
			this.e = e;
			return "set status error and set message : " + message;
		} else {
			this.message = "defaultExceptionMessage";
			this.e = e;
			return "set status error and set message default or extends";
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

	public TreeMap<K, V> getData() {
		return Data;
	}

	public void setData(TreeMap<K, V> data) {
		Data = data;
	}

	@Override
	public String toString() {
		return "StandardData [status=" + status + ", message=" + message + ", e=" + e + ", Data=" + Data + "]";
	}

}
