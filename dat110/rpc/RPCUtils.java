package no.hvl.dat110.rpc;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return
	// values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the
	// RPC message syntax [rpcid,parameter/return value]

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[1 + str.getBytes().length];

		// TODO: marshall RPC identifier and string into byte array
		try {
			encoded[0] = rpcid;
			for (int i = 0; i < str.getBytes().length; i++) {
				encoded[i + 1] = str.getBytes()[i];

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = "";

		// TODO: unmarshall String contained in data into decoded
		try {
			decoded = new String(Arrays.copyOfRange(data, 1, data.length));

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		// TODO: marshall RPC identifier in case of void type

		try {
			encoded[0] = rpcid;

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type

	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[1 + 4];

		// TODO: marshall RPC identifier and string into byte array
		try {
			encoded[0] = rpcid;
			encoded[1] = (byte) (x >> 24);
			encoded[2] = (byte) (x >> 16);
			encoded[3] = (byte) (x >> 8);
			encoded[4] = (byte) (x >> 0);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded = 0;
		// TODO: unmarshall integer contained in data

		try {
			decoded = (data[1]) << 24 | (data[2] & 0xFF) << 16 | (data[3] & 0xFF) << 8 | (data[4] & 0xFF);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return decoded;

	}
}
