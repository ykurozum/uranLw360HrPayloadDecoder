package com.cisco.japan.as.uran.payloaddecoderLW360HR.decoder;

import com.cisco.japan.as.uran.payloaddecoderLW360HR.constants.BeaconType;

public class BeaconIdDecoder {

	/**
	 * BeaconIdデコード処理
	 * 
	 * @param hexStr デコード用文字列
	 * @param beaconType BeaconType
	 * @return beaconId
	 */
	public static String[] decodeBeaconId(String hexStr, String beaconType) {

		String[] beaconId = new String[3];

		if (BeaconType.IBEACON.getTagName().equals(beaconType)) { // iBeacon
			beaconId[0] = hexStr.substring(0, 32);
			beaconId[1] = hexStr.substring(32, 36);
			beaconId[2] = hexStr.substring(36,40);
		} else if (BeaconType.EDDYSOTNE_BEACON.getTagName().equals(beaconType)) { // Eddystone Beacon
			beaconId[0] = hexStr;
		} else { // ALT Beacon
			beaconId[0] = hexStr;
		}
		return beaconId;
	}

}
