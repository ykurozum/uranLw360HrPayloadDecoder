package com.cisco.japan.as.uran.payloaddecoderLW360HR.decoder;

import com.cisco.japan.as.uran.payloaddecoder.util.CommonUtils;
import com.cisco.japan.as.uran.payloaddecoderLW360HR.constants.GpsFixStatus;
import com.cisco.japan.as.uran.payloaddecoderLW360HR.constants.UnknownStatus;

public class GpsFixStatusDecoder {

	/** ステータス算出時の値 */
	private static final int DIVISION_VALUE = 32;

	/**
	 * GPSFixStatus取得処理
	 * 
	 * @param hexStr デコード用文字列
	 * @return gpsFixStatus
	 */
	public static String decodeGpsFixStatus(String hexStr) {

		String gpsFixStatus = null;

		// GPSFixStatus取得用の計算
		long dNum = CommonUtils.toDecimalNumber(hexStr);
		String dNumStr = String.valueOf(dNum / DIVISION_VALUE);

		// GPSFixStatus取得
		gpsFixStatus = getGpsFixStatus(dNumStr);

		return gpsFixStatus;
	}

	/**
	 * GPSFixStatusの取得処理
	 * 
	 * @param dNumStr GPSFixStatus取得用の値
	 * @return gpsFixStatus
	 */
	public static String getGpsFixStatus(String dNumStr) {

		// 初期値:unknown
		String gpsFixStatus = UnknownStatus.UNKNOWN_GPS_FIX_STATUS.getCode();

		// 定義済みのGpsFixStatusに一致するものを取得
		for (GpsFixStatus gpsFixStatusVal : GpsFixStatus.values()) {
			if (gpsFixStatusVal.getCode().equals(dNumStr)) {
				gpsFixStatus = gpsFixStatusVal.getTagName();
			}
		}

		return gpsFixStatus;
	}
}
