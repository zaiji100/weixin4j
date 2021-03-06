package com.foxinmy.weixin4j.response;

import java.io.Serializable;

import com.foxinmy.weixin4j.type.EncryptType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微信的被动消息
 * 
 * @className HttpWeixinMessage
 * @author jy
 * @date 2015年3月29日
 * @since JDK 1.7
 * @see
 */
@XStreamAlias("xml")
public class HttpWeixinMessage implements Serializable {
	private static final long serialVersionUID = -9157395300510879866L;

	// 以下字段是加密方式为「安全模式」时的参数
	/**
	 * 公众号的唯一ID
	 */
	@XStreamAlias("ToUserName")
	private String toUserName;
	/**
	 * 加密后的内容
	 */
	@XStreamAlias("Encrypt")
	private String encryptContent;
	/**
	 * 加密类型
	 * 
	 * @see com.foxinmy.weixin4j.type.EncryptType
	 */
	private EncryptType encryptType;

	// 以下字段每次被动消息时都会带上
	/**
	 * 随机字符串
	 */
	private String echoStr;
	/**
	 * 时间戳
	 */
	private String timeStamp;
	/**
	 * 随机数
	 */
	private String nonce;
	/**
	 * 参数签名
	 */
	private String signature;
	/**
	 * 设置的token
	 */
	private String token;
	/**
	 * xml消息明文主体
	 */
	private String originalContent;
	/**
	 * 请求的方式
	 */
	private String method;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getEncryptContent() {
		return encryptContent;
	}

	public void setEncryptContent(String encryptContent) {
		this.encryptContent = encryptContent;
	}

	public EncryptType getEncryptType() {
		return encryptType;
	}

	public void setEncryptType(EncryptType encryptType) {
		this.encryptType = encryptType;
	}

	public String getEchoStr() {
		return echoStr;
	}

	public void setEchoStr(String echoStr) {
		this.echoStr = echoStr;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOriginalContent() {
		return originalContent;
	}

	public void setOriginalContent(String originalContent) {
		this.originalContent = originalContent;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "HttpWeixinMessage [toUserName=" + toUserName
				+ ", encryptContent=" + encryptContent + ", encryptType="
				+ encryptType + ", echoStr=" + echoStr + ", timeStamp="
				+ timeStamp + ", nonce=" + nonce + ", signature=" + signature
				+ ", token=" + token + ", originalContent=" + originalContent
				+ ", method=" + method + "]";
	}
}
