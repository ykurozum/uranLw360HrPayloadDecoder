package com.cisco.japan.as.uran.payloaddecoderLW360HR.decoder;

import com.cisco.japan.as.uran.payloaddecoder.util.CommonUtils;

public class BatteryCapacityDecoder {

	/**
	 * BatteryCapacityデコード処理
	 * 
	 * @param hexStr デコード用文字列
	 * @return BatteryCapacity
	 */
	public static String decodeBatteryCapacity(String hexStr) {

		// 10進数へ変換
		return String.valueOf(CommonUtils.toDecimalNumber(hexStr));

	}

}
