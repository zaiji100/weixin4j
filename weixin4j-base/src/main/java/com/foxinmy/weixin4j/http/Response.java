package com.foxinmy.weixin4j.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.foxinmy.weixin4j.xml.XmlStream;

public class Response {

	private String text;
	private int statusCode;
	private String statusText;
	private byte[] body;
	private InputStream stream;
	private boolean isJsonResult;
	private boolean isXmlResult;

	public Response() {
	}

	public Response(String text) {
		this.text = text;
	}

	public void setJsonResult(boolean isJsonResult) {
		this.isJsonResult = isJsonResult;
	}

	public void setXmlResult(boolean isXmlResult) {
		this.isXmlResult = isXmlResult;
	}

	public String getAsString() {
		return text;
	}

	public JsonResult getAsJsonResult() {
		return JSON.parseObject(text, JsonResult.class);
	}

	public JSONObject getAsJson() {
		return JSON.parseObject(text);
	}

	public <T> T getAsObject(TypeReference<T> typeReference) {
		if (isJsonResult) {
			return JSON.parseObject(text, typeReference);
		}
		if (isXmlResult) {
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>) typeReference.getType();
			return XmlStream.get(text, clazz);
		}
		return null;
	}

	public XmlResult getAsXmlResult() {
		return XmlStream.get(text, XmlResult.class);
	}

	/**
	 * <a href=
	 * "http://mp.weixin.qq.com/wiki/17/fa4e1434e57290788bde25603fa2fcbd.html"
	 * >全局返回码</a> {"errcode":45009,"errmsg":"api freq out of limit"}
	 * 
	 * @return
	 * @throws DocumentException
	 */
	public JsonResult getTextError(int code) {
		JsonResult result = new JsonResult();
		result.setCode(code);
		SAXReader reader = new SAXReader();
		Document doc = null;
		InputStream is = null;
		try {
			is = Response.class.getResourceAsStream("error.xml");
			doc = reader.read(is);
			Node node = doc.getRootElement().selectSingleNode(
					String.format("error/code[text()=%d]", code));
			if (node != null) {
				node = node.getParent();
				String desc = null;
				Node _node = node.selectSingleNode("desc");
				if (_node != null) {
					desc = _node.getStringValue();
				}
				String text = null;
				_node = node.selectSingleNode("text");
				if (_node != null) {
					text = _node.getStringValue();
				}
				if (StringUtils.isBlank(desc) && StringUtils.isNotBlank(text)) {
					desc = text;
				}
				if (StringUtils.isBlank(text) && StringUtils.isNotBlank(desc)) {
					text = desc;
				}
				result.setDesc(desc);
				result.setText(text);
			} else {
				result.setDesc("unknown error");
				result.setText("未知错误");
			}
		} catch (DocumentException e) {
			result.setDesc("unknown error");
			result.setText("未知错误");
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					;
				}
			}
		}
		return result;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public byte[] getBody() {
		return (byte[]) body.clone();
	}

	/**
	 * May expose internal representation by incorporating reference to mutable
	 * object
	 */
	public void setBody(byte[] body) {
		this.body = (byte[]) body.clone();
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Response [text=" + text + ", statusCode=" + statusCode
				+ ", statusText=" + statusText + ", stream=" + stream
				+ ", isJsonResult=" + isJsonResult + ", isXmlResult="
				+ isXmlResult + "]";
	}
}
