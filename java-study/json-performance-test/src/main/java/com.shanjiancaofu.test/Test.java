package com.shanjiancaofu.test;

import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Test {
	private Integer age;
	private String name;
	private String code;

	public static void main(String[] args) throws JsonProcessingException, InterruptedException {

		String json = "{\"id\":\"{{requestId}}\",\"imp\":[{\"id\":\"1\",\"banner\":{},\"video\":{},\"native\":{},\"slottype\":1,\"slotid\":10001}],\"site\":{\"id\":\"\",\"name\":\"String\",\"domain\":\"String\",\"cat\":[],\"quality\":\"String\",\"page\":\"String\",\"pagecat\":[],\"pagequality\":\"String\",\"pagetype\":\"String\",\"ref\":\"String\",\"keywords\":\"String\"},\"app\":{\"id\":\"\",\"name\":\"String\",\"domain\":\"String\",\"cat\":[],\"quality\":\"String\",\"pagequality\":[],\"ver\":\"String\",\"bundle\":\"String\",\"paid\":false,\"keywords\":\"String\",\"storeurl\":\"String\"},\"device\":{\"dnt\":false,\"ua\":\"String\",\"ip\":\"117.107.139.22\",\"ipv6\":\"String\",\"geo\":{\"type\":1,\"lat\":0.0,\"lon\":0.0,\"country\":\"String\",\"prov\":\"String\",\"city\":\"String\"},\"did\":\"String\",\"didsha1\":\"String\",\"didmd5\":\"String\",\"dpid\":\"String\",\"dpidsha1\":\"String\",\"dpidmd5\":\"String\",\"oaid\":\"String\",\"mac\":\"String\",\"macsha1\":\"String\",\"macmd5\":\"String\",\"idfa\":\"String\",\"idfasha1\":\"String\",\"idfamd5\":\"String\",\"carrier\":1,\"make\":\"String\",\"model\":\"String\",\"w\":0,\"h\":0,\"os\":1,\"osv\":\"String\",\"connectiontype\":1,\"devicetype\":1},\"user\":{\"id\":\"String\",\"yob\":0,\"gender\":1,\"keyword\":\"\"},\"bcat\":[],\"badv\":[],\"query\":\"String\",\"sdkInfo\":{\"sdkVersion\":\"String\"}}".replaceAll("\n", "");
		int number = 1000000;

		fastjson(json, number);
		gson(json, number);
		jackson(json, number);
		hutoolJson(json, number);
		Thread.sleep(2000);
	}

	public static void fastjson(String json, int runCount) {
		long start = System.currentTimeMillis();
		RtbBidRequest rtbBidRequest = null;
		for (int i = 0; i < runCount; i++) {
			rtbBidRequest = JSON.parseObject(json, RtbBidRequest.class);
		}
		String costTimeDesc = "fastjson %s %s cost %s ms";
		System.out.println(String.format(costTimeDesc, "parse", runCount, (System.currentTimeMillis() - start)));
		for (int i = 0; i < runCount; i++) {
			String s = JSON.toJSONString(rtbBidRequest);
		}
		System.out.println(String.format(costTimeDesc, "toString", runCount, (System.currentTimeMillis() - start)));
	}

	public static void gson(String json, int runCount) {

		long start = System.currentTimeMillis();
		RtbBidRequest rtbBidRequest = null;
		Gson gson = new Gson();
		for (int i = 0; i < runCount; i++) {
			rtbBidRequest = gson.fromJson(json, RtbBidRequest.class);
		}
		System.out.println(String.format("gson parse %s cost %s ms", runCount, (System.currentTimeMillis() - start)));
		for (int i = 0; i < runCount; i++) {
			String s = gson.toJson(rtbBidRequest);
		}
		System.out.println(String.format("gson toString %s cost %s ms", runCount, (System.currentTimeMillis() - start)));
	}

	public static void jackson(String json, int runCount) throws JsonProcessingException {

		long start = System.currentTimeMillis();
		RtbBidRequest rtbBidRequest = null;
		ObjectMapper objectMapper = new ObjectMapper();
		for (int i = 0; i < runCount; i++) {
			rtbBidRequest = objectMapper.readValue(json, RtbBidRequest.class);
		}
		System.out.println(String.format("jackson parse %s cost %s ms", runCount, (System.currentTimeMillis() - start)));
		for (int i = 0; i < runCount; i++) {
			String s = objectMapper.writeValueAsString(rtbBidRequest);
		}
		System.out.println(String.format("jackson toString %s cost %s ms", runCount, (System.currentTimeMillis() - start)));
	}

	public static void hutoolJson(String json, int runCount) throws JsonProcessingException {

		long start = System.currentTimeMillis();
		RtbBidRequest rtbBidRequest = null;

		for (int i = 0; i < runCount; i++) {

			rtbBidRequest = JSONUtil.toBean(json, RtbBidRequest.class);
		}
		System.out.println(String.format("hutoolJson parse %s cost %s ms", runCount, (System.currentTimeMillis() - start)));
		for (int i = 0; i < runCount; i++) {
			String s = JSONUtil.toJsonStr(rtbBidRequest);
		}
		System.out.println(String.format("hutoolJson toString %s cost %s ms", runCount, (System.currentTimeMillis() - start)));
	}

}
