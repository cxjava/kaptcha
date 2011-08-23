package com.google.code.kaptcha.text.impl;

import java.util.Random;

import com.google.code.kaptcha.text.TextProducer;
import com.google.code.kaptcha.util.Configurable;

/**
 * TextProducer Implementation that will return Chinese characters..
 */
public class ChineseTextProducer  extends Configurable implements TextProducer {
	private String[] simplifiedChineseTexts = new String[] { "宝贝", "背背", "必备", "川贝", "后备", "后背", "湖北", "世界", "拷贝",
			"藏龙", "三杯", "设备", "手背", "火焰", "以备", "预备", "长辈", "装备", "准备", "正准", "自卑", "版本", "新版", "最新", "行版", "两大", "副本",
			"根本", "基本", "笔记", "日记", "脚本", "课本", "户口", "老本", "那本", "把那", "日本", "三本", "山本", "投奔", "关闭", "何必", "回避", "人民",
			"好牛", "很牛", "攀比", "屏蔽", "手臂", "台币", "逃避", "五笔", "就无", "下笔", "总比", "病变", "答辩", "耳边", "放鞭", "不方", "用谷", "改变",
			"改编", "攻辩", "诡辩", "即便", "简便", "两边", "那边", "哪边", "你那", "方正", "旁边", "普遍", "墙边", "三辩", "身边", "顺便", "四辩", "随便",
			"右边", "邮编", "这边", "主编", "左边", "注册", "此表", "代表", "发表", "发飙", "多个", "计划", "数据", "列表", "目标", "申请", "鼠标", "图标",
			"下标", "武学", "交易", "志愿", "张表", "汇总" };

	/**
	 * @return random Chinese text
	 */
	public String getText() {
		int length = getConfig().getTextProducerCharLength();
		Random rand = new Random();
		StringBuffer text = new StringBuffer();
		for (int i = 0; i < length; i++)
		{
			text.append(simplifiedChineseTexts[rand.nextInt(simplifiedChineseTexts.length)]);
		}
		return text.toString();
	}
}
