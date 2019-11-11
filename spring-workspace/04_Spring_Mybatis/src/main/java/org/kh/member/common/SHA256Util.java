package org.kh.member.common;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component("SHA256Util")
public class SHA256Util {
	public String encData(String data) throws Exception{
		// MessageDigest 클래스를 이용한 암호화
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		// password 값을 바이트 배열로 바꿔서 MessageDigest에 넣어줌
		mDigest.update(data.getBytes());
		// SHA-256으로 변환된 데이터가 Byte 배열 형태로 가지고 있음
		// 값을 꺼내서 1Byte당 16진수로 바꿔 저장
		byte[] msgStr = mDigest.digest();
		// byte -> -128 ~ 127
		// 0 ~ 255범위가 필요함 -> 00 ~ FF 까지 데이터가 필요함
		// 음수가 나오지 않게 변환하는 작업
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < msgStr.length ; i++) {
			byte strByte = msgStr[i];
			String tmpTest = Integer.toString((strByte & 0xff) + 0x100, 16).substring(1);
			sb.append(tmpTest);
		}
		return sb.toString();
	}
}
