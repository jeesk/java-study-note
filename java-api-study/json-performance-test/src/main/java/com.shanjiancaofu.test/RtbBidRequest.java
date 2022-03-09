package com.shanjiancaofu.test;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * BidRequest对象是一次竞价请求的主体内容，包含了此次请求的设备信息、用户信息、位置信息、广告展示时机信息等，具体结构如下：
 */
public class RtbBidRequest {
	/*必填，标识一次请求的唯一ID*/
	private String id;
	/*必填，数组格式，一个完整的BidRequest必须包含至少一个Imp对象*/
	private List<Imp> imp;
	/*条件必填，当前竞价请求发自某个站点时，必须提供完整的Site对象*/
	private Site site;
	/*条件必填，当前竞价请求发自某个应用时，必须提供完整的App对象*/

	private App app;
	/*必填，发起当前竞价请求的设备信息，Device对象中包含了大量必填信息，需要注意*/
	private Device device;
	/*条件必填，当前竞价请求发自某个站点时，必须提供User对象；其他情况推荐填充User对象*/
	private User user;
	/*可选，描述当前竞价请求屏蔽的广告分类，具体分类方式参见附录IAB分类信息表*/
	private List<Integer> bcat;
	/*可选，描述当前竞价请求屏蔽的广告主域名*/
	private List<String> badv;
	/*条件必填，当前竞价请求发自搜索广告场景时，必须提供完整的query信息描述当前搜索的关键词*/
	private String query;
	/*必填，当前请求sdk信息  这个信息对于自建dsp 需要填写 */
	private SdkInfo sdkInfo;


	@lombok.Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Imp {
		/*必填，标识一个Imp对象的唯一ID*/
		private String id;
		private List<BidInfo> bidInfo;
		/*条件必填，当前广告展现机会是一个横幅广告位时，必须提供完整的Banner对象*/
		private Banner banner;
		/*条件必填，当前广告展现机会是一个视屏广告位时，必须提供完整的Video对象*/
		private Video video;
		/*条件必填，当前广告展现机会是一个原生广告位时，必须提供完整的Native对象*/
		@JSONField(name = "native")
		@JsonProperty(value = "native")
		@SerializedName("native")
		private Native aNative;
		/*SLOT_FIEXD	横幅固定广告位
		SLOT_STARTUP	应用开屏广告位
		SLOT_INTERSTITIAL	应用插屏广告位
		SLOT_VIDEO	视屏流广告位
		SLOT_NATIVE	原生广告位
		SLOT_FLOATING	横幅悬浮广告位*/
		/*必填，SlotType对象，描述当前广告位的类型信息*/
		private Integer slottype;
		/*当前Imp所对应的广告位ID*/
		/*必填，当前Imp所对应的广告位ID，DSP在使用该字段前，需要和流量供应方约定好slotid的字符串拼接格式*/
	/*一个完整的Imp对象必须拥有Banner、Video、Native三个对象中的一个，且最多只拥有一个。
	ssp将来自广告位ID(1001)的一个Imp通过Adx发送给Dsp，建议Ssp将slotid字段填充为${sspname}_1001。
	Dsp在做广告位定向之前需要和Ssp预先确认好有哪些广告位可能需要被定向。 否则由Ssp发送的slotid可能不能被Dsp识别。
	*/
		private String slotid;
	}

	/**
	 * 当前广告展现机会是一个原生广告位时，必须提供完整的Native对象
	 */
	@lombok.Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Native {
		/*必填，原生广告所需要的物料元素*/
		private List<Assets> assets;
	}

	@lombok.Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Site {
		/*必填，发起当前请求的站点唯一ID。一般站长在广告平台进行注册的时候，平台会为每个站点分配唯一的ID*/
		private String id;
		/*必填，当前站点的名称*/
		private String name;
		/*必填，当前站点的域名*/
		/*domain字段涉及到Cloud-DSP的域名定向相关业务*/
		private String domain;
		/*推荐，当前站点的分类信息，参见附录IAB分类信息表，通过数组形式表述多种类型*/
		private List<Integer> cat;
		/*可选，当前站点的质量信息，缺省状态会将当前站点的质量属性设置为系统默认值*/
		private String quality;
		/*必填，当前页面的URL*/
		private String page;
		/*推荐，当前页面的分类信息，参见附录IAB分类信息表，通过数组形式表述多种类型*/
		private List<Integer> pagecat;
		/*可选，当前页面的质量信息，缺省状态会将当前页面的质量属性设置为系统默认值*/
		private String pagequality;
		/*可选，当前页面的类型信息，包括：资讯页、论坛页等，缺省状态为系统默认类型*/
		private String pagetype;
		/*必填，当前页面的referrer url*/
		private String ref;
		/*推荐，当前页面的关键词信息，通过逗号分隔表述多个关键词信息*/
		private String keywords;
	}


	/**
	 * App对象描述了发起当前竞价请求的应用信息。
	 * domain字段涉及到Cloud-DSP的域名定向相关业务
	 */
	@lombok.Data
	@AllArgsConstructor
	@Builder
	@NoArgsConstructor
	public static class App {
		/*必填，发起当前请求的应用唯一ID。一般开发者在广告平台进行注册的时候，平台会为每个应用分配唯一的ID*/
		private String id;
		/*必填，当前应用的名称*/
		private String name;
		/*推荐，当前应用的域名*/
		private String domain;
		/*推荐，当前应用的分类信息，参见附录IAB分类信息表，通过数组形式表述多种类型*/
		private List<Integer> cat;
		/*可选，当前应用的质量信息，缺省状态会将当前应用的质量属性设置为系统默认值*/
		private String quality;
		private List<Integer> pagecat;

		/*可选，当前应用页的质量信息，缺省状态会将当前应用页的质量属性设置为系统默认值*/
		private List<String> pagequality;
		/*必填，当前应用的版本信息*/
		private String ver;
		/*必填，当前应用的包名*/
		private String bundle;
		/*推荐，当前应用是否是付费应用，缺省状态标识当前应用是免费应用*/
		private Boolean paid;
		/*推荐，当前页面的关键词信息，通过逗号分隔表述多个关键词信息*/
		private String keywords;
		/*推荐，当前应用在应用商店的页面URL*/
		private String storeurl;
	}

	@lombok.Data
	@AllArgsConstructor
	@Builder
	@NoArgsConstructor
	public static class Device {
		/*推荐，“Do Not Track”标记*/
		private Boolean dnt;
		/*条件必填，对于从网页中发起的竞价请求，必须提供完整的ua信息；描述发起当前竞价请求的浏览器User Agent*/
		private java.lang.String ua;
		/*必填，当前设备的IP信息*/
		private java.lang.String ip;
		/*推荐，当前设备的IPv6信息可以获取的时候，推荐同时填充ip和ipv6字段*/
		private java.lang.String ipv6;
		/*推荐，Geo对象，描述当前设备的定位信息*/
		private Geo geo;
		/*条件必填，设备号(IMEI)信息。当竞价请求发自Android设备时，会要求填充did、dpid、mac三类信息中至少一类*/
		private java.lang.String did;
		/*条件必填，设备号(IMEI)信息的sha1哈希值，在必须填充did的时候，可以通过填充didsha1代替*/
		private java.lang.String didsha1;

		/*条件必填，设备号(IMEI)信息的md5哈希值，在必须填充did的时候，可以通过填充didmd5代替*/
		private java.lang.String didmd5;

		/*条件必填，Android-id信息。当竞价请求发自Android设备时，会要求填充did、dpid、mac三类信息中至少一类*/
		private java.lang.String dpid;

		/*条件必填，Android-id的sha1哈希值，在必须填充dpid的时候，可以通过填充dpidsha1代替*/
		private java.lang.String dpidsha1;

		/*条件必填，Android-id的md5哈希值，在必须填充dpid的时候，可以通过填充dpidmd5代替*/
		private java.lang.String dpidmd5;

		/*标识符（ID）就像我们的另一张身份证，它们就代表了数字化之后的你和我。*/
		private java.lang.String oaid;


		/*条件必填，设备MAC信息。当竞价请求发自Android设备时，会要求填充did、dpid、mac三类信息中至少一类；
		当竞价请求发自Apple设备时，会要求填充idfa、mac中至少一类信息；当竞价请求发自其他设备时，会推荐填充mac信息*/
		private java.lang.String mac;
		/*条件必填，设备MAC信息的sha1哈希值，在必须填充mac的时候，可以通过填充macsha1代替*/
		private java.lang.String macsha1;
		/*条件必填，设备MAC信息的md5哈希值，在必须填充mac的时候，可以通过填充macmd5代替*/
		private java.lang.String macmd5;


		/*条件必填，Apple设备的IDFA信息。当竞价请求发自Apple设备时，会要求填充idfa、mac中至少一类信息*/
		private java.lang.String idfa;
		/*条件必填，Apple设备的IDFA信息的sha1哈希值，在必须填充idfa的时候，可以通过填充idfasha1代替*/
		private java.lang.String idfasha1;
		/*条件必填，Apple设备的IDFA信息的md5哈希值，在必须填充idfa的时候，可以通过填充idfamd5代替*/
		private java.lang.String idfamd5;
		/*条件必填，当竞价诉求发自移动设备时，需要提供完整的Carrier对象来描述当前运营商信息*/
		private int carrier;
		/*推荐，当前竞价请求发自移动设备时，推荐填充完整的make信息来描述当前设备的制造商信息*/
		private java.lang.String make;
		/*推荐，当前竞价请求发自移动设备时，推荐填充完整的model信息来描述当前设备的型号信息*/
		private java.lang.String model;
		/*推荐，当前设备显示屏的高度*/
		private Integer w;
		/*推荐，当前设备显示屏的宽度*/
		private Integer h;
		private Short os;
		/*推荐，当前设备操作系统的版本号信息*/
/*	WINDOWS	Windows操作系统，包含PC和移动版本
	MACOS	Apple PC设备的操作系统
	LINUX	Linux操作系统
	IOS	Apple移动设备的操作系统
	ANDROID	Android操作系统*/
		private java.lang.String osv;
		/*必填，发起当前竞价请求的设备网络连接类型信息*/
/*	WIFI	Wi-Fi无线网络
	CELL_2G	移动网络2G
	CELL_3G	移动网络3G
	CELL_4G	移动网络4G
	ETHERNET	有线网络*/
		private short connectiontype;
		/*必填，发起当前竞价请求的设备类型信息*/
/*	PERSONAL_COMPUTER	个人计算机
	PHONE	手机设备
	TABLET	平板设备*/
		private int devicetype;

		// ua字段涉及到Cloud-DSP的浏览器定向相关业务
		// ip字段涉及到Cloud-DSP的地域定向、运营商定向等相关业务
		// geo字段设计到Cloud-DSP的地域定向、商圈定向等相关业务
		// carrier字段涉及到Cloud-DSP的运营商定向相关业务
		// make字段涉及到Cloud-DSP的制造商定向、机型定向等相关业务
		// model字段涉及到Cloud-DSP的机型定向等相关业务
		// os、osv字段涉及到Cloud-DSP的操作系统定向等相关业务
		// connectiontype字段涉及到Cloud-DSP的网络类型定向相关业务
		// devicetype字段涉及到Cloud-DSP的设备类型定向相关业务
		// did、dpid、mac、idfa字段涉及到Cloud-DSP的人群定向及各类人群特征相关业务

	}

	@lombok.Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class User {
		/**
		 * 条件必填，当前竞价请求发起方持有的用户ID，在网页环境下，该ID一般为用户的cookie
		 */
		private java.lang.String id;
		/*推荐，当前用户的出生年份信息，四位数字表示*/
		private Integer yob;
		/*
			推荐，当前用户的性别信息
				M - 男
				F - 女
				缺省 - 未知
		*/
		private java.lang.Integer gender;
		/*推荐，当前用户的关键词、兴趣点信息，通过逗号分割表述多个关键词信息*/
		private java.lang.String keyword;
	}

	@lombok.Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	/*Asset对象描述了原生广告位的一组物料元素诉求。*/
	public static class Assets {
		/*必填，标识物料元素诉求的唯一ID*/
		private Integer id;
		/*必填，标识该物料元素诉求是否必须满足，如果设置为True，则会过滤所有不满足诉求的原生物料*/
		private boolean required;
		/*条件必填，当前诉求描述的是广告标题相关信息时，必须提供完整的Title对象*/
		private Title title;
		/*条件必填，当前诉求描述的是广告图片相关信息时，必须提供完整的Image对象*/
		private Img img;
		/*条件必填，当前诉求描述的是其他元素信息时，必须提供完整的Data对象*/
		private Data data;
	}

	@lombok.Data
	@AllArgsConstructor
	@NoArgsConstructor
	/**
	 * Banner对象描述了一个横幅类广告位的基本信息。
	 */
	public static class Banner {
		/*必填，广告位宽度；如果wmax和wmin均未设置，则表示请求广告物料宽度必须等于该值；如果设置了wmax或wmin，则表示请求广告物料宽度推荐等于该值*/
		private Integer w;
		/*必填，广告位高度；如果hmax和hmin均未设置，则表示请求广告物料高度必须等于该值；如果设置了hmax或hmin，则表示请求广告物料高度推荐等于该值*/
		private Integer h;
		/*可选，广告位允许的最大物料宽度，缺省状态标识不限制*/
		private Integer wmax;
		/*可选，广告位允许的最大物料高度，缺省状态标识不限制*/
		private Integer hmax;
		/*可选，广告位允许的最小物料宽度，缺省状态标识不限制*/
		private Integer wmin;
		/*可选，广告位允许的最小物料高度，缺省状态标识不限制*/
		private Integer hmin;
		/*	推荐，广告位允许的物料内容类型，当前主流的mimes包括如下：
				- image/jpg
				- image/gif
				- application/x-shockwave-flash
				缺省状态表示允许所有类型
		*/
		private List<java.lang.String> mimes;
	}

	@lombok.Data
	@AllArgsConstructor
	@NoArgsConstructor
	/*BidInfo对象描述了当前广告位对竞价类型、底价的诉求信息*/
	public static class BidInfo {
	/*
		CPM	按展现计费
		CPC	按点击计费
		CPD	按下载计费
		CPT	按时间包断计费
	说明

	按下载计费（CPD）中的下载动作，需要在系统中进行具体定义，当前系统默认的实现方式是下载行为开始即计费。
	可选的动作类型包括了下载开始、下载进行中、下载完成，这些动作类型均需要用户端能够及时的回传事件日志才可以获取。
	按时间包断计费（CPT）中的时间段长度可以在系统中自行定义，当前系统默认的实现方式是按天包断计费。
	*/

		/*必填，描述当前广告位可以接受的竞价类型信息，具体值定义参见BidType对象*/
		private Integer bidtype;
		/*推荐，描述当前广告位可以接受的对应竞价类型的底价信息，单位：分。其中CPT竞价方式不能设置底价。缺省状态标识不对底价进行限制。*/
		private Integer bidfloor;
	}

	/*Data对象描述了原生广告竞价诉求中对其他类型元素的诉求信息。*/
	public static class Data {
		/*
			1   SPONSORED	赞助商信息
			2	DESC	创意描述信息
			3	RATING	应用、商品推广时所需的排序信息
			4	LIKES	应用、商品推广时所需的‘赞’数量信息
			5	DOWNLOADS	应用推广时所需的下载量信息
			6	PRICE	商品推广的原始售价信息
			7	SALEPRICE	商品推广的打折后售价信息
			8	PHONE	创意中可用到的电话信息
			9	ADDRESS	创意中可展示的地址信息
			10	DESC2	创意描述信息，用于对DESC的补充，或用于显式在两段描述中换行
			11	DISPLAYURL	展示在创意中的URL信息
			12	CTATEXT	创意的CTA文本信息
		*/
		/*描述当前元素类型*/
		private Integer type;
		/*当前对象描述类型为可显示文本类型时，必须提供len信息用于描述最长可接受文本长度*/
		private Integer len;
	}

	/**
	 * Geo对象描述了当前设备的定位信息。
	 */
	@lombok.Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Geo {
		/*
		GPS_LOCATION	通过GPS信息定位
		IP	通过用户IP辅助定位
		USER_PROVIDED	用户自主提供定位信息
		*/
		/*必填，LocationType对象，描述当前定位信息的消息来源类型*/
		private int type;
		/*条件必填，当前定位信息通过GPS获取时，必须提供完整的纬度信息*/
		private Float lat;
		/*条件必填，当前定位信息通过GPS获取时，必须提供完整的经度信息*/
		private Float lon;
		/*推荐，发起请求时设备所在国家信息*/
		private java.lang.String country;
		/*推荐，发起请求时设备所在省份信息*/
		private java.lang.String prov;
		/*推荐，发起请求时设备所在城市信息*/
		private java.lang.String city;
	}

	/*Image对象描述了原生广告图片元素的竞价诉求信息。*/
	public static class Img {
		/*
		1	ICON	图标，小图片
		2	LOGO	标志、商标等
		3	MAIN	主图，大图片
		*/
		/*必填，描述当前图片的用途信息*/
		private Integer type;
		/*必填，图片宽度；如果未设置wmin，则表示图片物料宽度必须等于该值；如果设置了wmin，则表示图片物料宽度推荐等于该值*/
		private Integer w;
		/*必填，图片高度；如果未设置hmin，则表示图片物料高度必须等于该值；如果设置了hmin，则表示图片物料高度推荐等于该值*/
		private Integer h;
		/*可选，允许的最小图片宽度，缺省状态标识不限制*/
		private Integer wmin;
		/*可选，允许的最小图片高度，缺省状态标识不限制*/
		private Integer hmin;
		/*可选，允许的最大图片宽度，缺省状态标识不限制*/
		private Integer wmax;
		/*可选，允许的最大图片高度，缺省状态标识不限制*/
		private Integer hmax;
		/*	推荐，允许的图片内容类型，当前主流的mimes包括如下：
				- image/jpg
				- image/gif
				缺省状态表示允许所有类型
		*/
		private List<java.lang.String> mimes;
	}

	@lombok.Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class SdkInfo {
		private java.lang.String sdkVersion;
		private Boolean isInit;
		private String uuid;
	}

	@lombok.Data
	@Builder
	@AllArgsConstructor
	/*Title对象描述了原生广告标题元素的竞价诉求信息。*/
	@NoArgsConstructor
	public static class Title {
		/*必填，可以接受的最大标题长度*/
		private Integer len;

	}

	@lombok.Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Video {
		/*必填，广告位宽度*/
		private Integer w;
		/*必填，广告位高度*/
		private Integer h;
		/*推荐，广告位允许的最大展示时长，单位：秒，缺省状态标识不限制*/
		private Integer maxduration;
		/*推荐，广告位允许的最小展示时长，单位：秒，缺省状态标识不限制*/
		private Integer minduration;
		/*推荐，广告位允许的最大播放比特率，单位：Kbps，缺省状态标识不限制*/
		private Integer maxbitrate;
		/*推荐，广告位允许的最小播放比特率，单位：Kbps，缺省状态标识不限制*/
		private Integer minbitrate;
		/*	推荐，广告位允许的物料内容类型，当前主流的mimes包括如下：
				- video/x-ms-wmv
				- video/x-flv
				缺省状态标识允许所有类型
		*/
		private List<java.lang.String> mimes;
		/*描述广告在当前视频中的展现形式
		 *
		 *
		 *   */
		private Integer linearity;
		/**
		 * 推荐，广告播放时机：
		 * -2: 视频播放完成时
		 * -1: 视频播放中间
		 * 0: 视频播放开始前
		 * >0: 视频播放开始后延迟时间，单位：秒
		 */
		private Integer startdelay;
	}
}
