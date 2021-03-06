package com.foxinmy.weixin4j.mp.test.msg;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.foxinmy.weixin4j.exception.WeixinException;

/**
 * 接受一般消息格式测试
 * 
 * @author jy.hu
 * @date 2014年3月24日
 * @since JDK 1.7
 */
public class InMsgTest extends MessagePush {

	private StringBuilder xmlSb = new StringBuilder();

	/***************** common message *********************/

	@Test
	public void text() throws WeixinException, IOException {
		xmlSb.delete(0, xmlSb.length());
		xmlSb.append("<xml>");
		xmlSb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
		xmlSb.append("<FromUserName><![CDATA[fromUser]]></FromUserName>");
		xmlSb.append("<CreateTime>1348831860</CreateTime>");
		xmlSb.append("<MsgType><![CDATA[text]]></MsgType>");
		xmlSb.append("<Content><![CDATA[this is a test]]></Content>");
		xmlSb.append("<MsgId>1234567890123456</MsgId>");
		xmlSb.append("</xml>");
		String response = push(xmlSb.toString());
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	@Test
	public void image() throws WeixinException, IOException {
		xmlSb.delete(0, xmlSb.length());
		xmlSb.append("<xml>");
		xmlSb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
		xmlSb.append("<FromUserName><![CDATA[FromUser]]></FromUserName>");
		xmlSb.append("<CreateTime>123456789</CreateTime>");
		xmlSb.append("<MsgType><![CDATA[image]]></MsgType>");
		xmlSb.append("<PicUrl><![CDATA[this is a url]]></PicUrl>");
		xmlSb.append("<MediaId><![CDATA[media_id]]></MediaId>");
		xmlSb.append("<MsgId>1234567890123456</MsgId>");
		xmlSb.append("</xml>");
		String response = push(xmlSb.toString());
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	@Test
	public void voice() throws WeixinException, IOException {
		xmlSb.delete(0, xmlSb.length());
		xmlSb.append("<xml>");
		xmlSb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
		xmlSb.append("<FromUserName><![CDATA[FromUser]]></FromUserName>");
		xmlSb.append("<CreateTime>123456789</CreateTime>");
		xmlSb.append("<MsgType><![CDATA[voice]]></MsgType>");
		xmlSb.append("<MediaId><![CDATA[media_id]]></MediaId>");
		xmlSb.append("<Format><![CDATA[Format]]></Format>");
		xmlSb.append("<MsgId>1234567890123456</MsgId>");
		xmlSb.append("</xml>");
		String response = push(xmlSb.toString());
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	@Test
	public void re_voice() throws WeixinException, IOException {
		xmlSb.delete(0, xmlSb.length());
		xmlSb.append("<xml>");
		xmlSb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
		xmlSb.append("<FromUserName><![CDATA[FromUser]]></FromUserName>");
		xmlSb.append("<CreateTime>123456789</CreateTime>");
		xmlSb.append("<MsgType><![CDATA[voice]]></MsgType>");
		xmlSb.append("<MediaId><![CDATA[media_id]]></MediaId>");
		xmlSb.append("<Format><![CDATA[Format]]></Format>");
		xmlSb.append("<Recognition><![CDATA[腾讯微信团队]]></Recognition>");
		xmlSb.append("<MsgId>1234567890123456</MsgId>");
		xmlSb.append("</xml>");
		String response = push(xmlSb.toString());
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	@Test
	public void video() throws WeixinException, IOException {
		xmlSb.delete(0, xmlSb.length());
		xmlSb.append("<xml>");
		xmlSb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
		xmlSb.append("<FromUserName><![CDATA[FromUser]]></FromUserName>");
		xmlSb.append("<CreateTime>123456789</CreateTime>");
		xmlSb.append("<MsgType><![CDATA[video]]></MsgType>");
		xmlSb.append("<MediaId><![CDATA[media_id]]></MediaId>");
		xmlSb.append("<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>");
		xmlSb.append("<MsgId>1234567890123456</MsgId>");
		xmlSb.append("</xml>");
		String response = push(xmlSb.toString());
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	@Test
	public void location() throws WeixinException, IOException {
		xmlSb.delete(0, xmlSb.length());
		xmlSb.append("<xml>");
		xmlSb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
		xmlSb.append("<FromUserName><![CDATA[FromUser]]></FromUserName>");
		xmlSb.append("<CreateTime>123456789</CreateTime>");
		xmlSb.append("<MsgType><![CDATA[location]]></MsgType>");
		xmlSb.append("<Location_X>23.134521</Location_X>");
		xmlSb.append("<Location_Y>113.358803</Location_Y>");
		xmlSb.append("<Scale>20</Scale>");
		xmlSb.append("<Label><![CDATA[位置信息]]></Label>");
		xmlSb.append("<MsgId>1234567890123456</MsgId>");
		xmlSb.append("</xml>");
		String response = push(xmlSb.toString());
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	@Test
	public void link() throws WeixinException, IOException {
		xmlSb.delete(0, xmlSb.length());
		xmlSb.append("<xml>");
		xmlSb.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
		xmlSb.append("<FromUserName><![CDATA[FromUser]]></FromUserName>");
		xmlSb.append("<CreateTime>123456789</CreateTime>");
		xmlSb.append("<MsgType><![CDATA[link]]></MsgType>");
		xmlSb.append("<Title><![CDATA[公众平台官网链接]]></Title>");
		xmlSb.append("<Description><![CDATA[公众平台官网链接]]></Description>");
		xmlSb.append("<Url><![CDATA[url]]></Url>");
		xmlSb.append("<MsgId>1234567890123456</MsgId>");
		xmlSb.append("</xml>");
		String response = push(xmlSb.toString());
		Assert.assertNotNull(response);
		System.out.println(response);
	}
}
