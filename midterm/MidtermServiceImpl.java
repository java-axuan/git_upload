package com.midterm.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.StreamsBuilderFactoryBeanCustomizer;
import org.springframework.stereotype.Service;

import com.midterm.service.MidtermService;

@Service
public class MidtermServiceImpl implements MidtermService {

	@Autowired
	private DataSource dataSource;

	/**
	 * 範例程式
	 * 
	 * @param demoMap
	 * @return
	 */
	@Override
	public Map<String, Object> demoCode(Map<String, String> demoMap) {
		/* 1. 將前端傳入值取出：使用前端傳入物件的key值，從Map中取得對應value，例如： */
		String id = demoMap.get("id");
		String keyword = demoMap.get("keyword");
		System.err.println("id--->" + id);
		System.err.println("keyword--->" + keyword);

		/*
		 * 2. 業務邏輯：檢核、題目要求邏輯實作，如需使用DB連線，請參考下列程式碼 try (Connection conn =
		 * dataSource.getConnection(); PreparedStatement pstmt =
		 * conn.prepareStatement(DEMOCODE_QUERY_SQL_STRING);) {
		 * 
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 */

		/* 3. 把要回傳給前端的值包裝成Map後return，例如： */
		Map<String, Object> rtnMap = new HashMap<>();
		rtnMap.put("success", true);
		rtnMap.put("returnMessage", "驗證成功");
		rtnMap.put("metro_fee", 100);
		rtnMap.put("pokerA", new ArrayList<>());
		return rtnMap;
	}

	/**
	 * 第一題：發撲克牌
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> deal(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 第二題：證件號碼驗證
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> checkId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;

	}

	/**
	 * 第二題：證件號碼驗證_加分題
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getRandomId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;

	}

	/**
	 * 第三題：Wordle
	 * 
	 * @param map
	 * @return
	 */

	// 從資料庫裏面取出 排除字母E以外的資料
	public static final String INSERT_CARS_SQL = "select * from EX_WORDLE where VOCAB not like 'E%' and VOCAB not like '%E%' and VOCAB not like '%E'";
	private static final char A = 0;

	@Override
	public Map<String, Object> wordle(Map<String, String> map) {

		System.out.println(123);
		/* 1. 將前端傳入值取出：使用前端傳入物件的key值，從Map中取得對應value，例如： */
		String keyword = map.get("keyword");
		System.err.println("keyword--->" + keyword);
		
//    	 2. 業務邏輯：檢核、題目要求邏輯實作，如需使用DB連線，請參考下列程式碼
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT_CARS_SQL);) {

			ResultSet rs = pstmt.executeQuery();

			// 建List裝題目
			List<String> questionsList = new ArrayList<String>();
			while (rs.next()) {
				questionsList.add(rs.getString("VOCAB"));
			}

			// 從List取出一個題目
			int questionsTotal = questionsList.size(); // 總共有幾個題目
			Random rand = new Random();

			int questionsNum = rand.nextInt(questionsTotal); // 隨機產生變數
			String thisQuestion = questionsList.get(questionsNum); // 取到題目

			// 確認取到題目
			System.out.println(questionsList);
			System.out.println(questionsNum);
			System.out.println(thisQuestion);
			
			// 按送出只要對答案不要一直重新出題
			
			
			
			// 連接到前端的輸入作為myAnswer
			String myAnswer = keyword;

			// 把單字拆分成字元
			char[] answerCharArr = thisQuestion.toCharArray();
			char[] myAnswerCharArr = myAnswer.toCharArray();

			// 裝結果的sb
			StringBuilder resultSb = new StringBuilder();
			
			System.out.println(myAnswer);
			System.out.println(thisQuestion);

			int i = 1;

			// 從我的答案依序抓字元去一一比對答案
			for (char charMyAnswer : myAnswerCharArr) {

				int j = 1;

				for (char charAnswer : answerCharArr) {
					if (charMyAnswer == charAnswer && i == j) {
						System.out.print("A");
						resultSb.append("A");
						break;
					} else if (charMyAnswer == charAnswer) {
						System.out.print("B");
						resultSb.append("B");
						break;
					}

					if (j == 5) {
						System.out.print("X");
						resultSb.append("X");
					}
					j++;
				}
				i++;
			}
			
			
			
//			3. 把要回傳給前端的值包裝成Map後return，例如： 
			Map<String, Object> rtnMap = new HashMap<>();
			rtnMap.put("result", resultSb);
			return rtnMap;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/* 3. 把要回傳給前端的值包裝成Map後return，例如： */
//		Map<String, Object> rtnMap = new HashMap<>();
//		rtnMap.put("answer", "WORLD");
//		return rtnMap;
//	}

	/**
	 * 第四題：對對碰
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> matchingGame(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 第五題：捷運車資計算
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> metro(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
