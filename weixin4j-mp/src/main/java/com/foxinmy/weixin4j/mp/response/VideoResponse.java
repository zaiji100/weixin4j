package com.foxinmy.weixin4j.mp.response;

import com.foxinmy.weixin4j.mp.msg.model.Video;
import com.foxinmy.weixin4j.mp.type.ResponseType;
import com.foxinmy.weixin4j.msg.BaseMessage;
import com.foxinmy.weixin4j.xml.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 回复视频消息
 * 
 * @className VideoResponse
 * @author jy.hu
 * @date 2014年4月6日
 * @since JDK 1.7
 * @see <a
 *      href="http://mp.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E8%A2%AB%E5%8A%A8%E5%93%8D%E5%BA%94%E6%B6%88%E6%81%AF#.E5.9B.9E.E5.A4.8D.E8.A7.86.E9.A2.91.E6.B6.88.E6.81.AF">回复视频消息</a>
 * @see com.foxinmy.weixin4j.mp.msg.model.Video
 * @see com.foxinmy.weixin4j.mp.response.BaseResponse
 * @see com.foxinmy.weixin4j.mp.response.BaseResponse#toXml()
 */
public class VideoResponse extends BaseResponse {

	private static final long serialVersionUID = -1013075358679078381L;

	public VideoResponse(BaseMessage inMessage) {
		super(ResponseType.video, inMessage);
		super.getMsgType().setMessageClass(VideoResponse.class);
	}

	@XStreamAlias("Video")
	private Video video;

	public void pushVideo(String mediaId) {
		this.video = new Video(mediaId);
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toXml() {
		XStream xstream = getXStream();
		xstream.aliasField("MediaId", Video.class, "mediaId");
		xstream.aliasField("Title", Video.class, "title");
		xstream.aliasField("Description", Video.class, "desc");
		xstream.omitField(Video.class, "thumbMediaId");
		return xstream.toXML(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[VideoResponse ,toUserName=").append(super.getToUserName());
		sb.append(" ,fromUserName=").append(super.getFromUserName());
		sb.append(" ,msgType=").append(super.getMsgType().name());
		sb.append(" ,video=").append(video.toString());
		sb.append(" ,createTime=").append(super.getCreateTime()).append("]");
		return sb.toString();
	}
}