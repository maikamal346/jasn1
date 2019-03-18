/**
 * This class file was automatically generated by jASN1 v1.11.1-SNAPSHOT (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.iso8823_presentation;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class UserData implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public SimplyEncodedData simplyEncodedData = null;
	public FullyEncodedData fullyEncodedData = null;
	
	public UserData() {
	}

	public UserData(byte[] code) {
		this.code = code;
	}

	public UserData(SimplyEncodedData simplyEncodedData, FullyEncodedData fullyEncodedData) {
		this.simplyEncodedData = simplyEncodedData;
		this.fullyEncodedData = fullyEncodedData;
	}

	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (fullyEncodedData != null) {
			codeLength += fullyEncodedData.encode(reverseOS, false);
			// write tag: APPLICATION_CLASS, CONSTRUCTED, 1
			reverseOS.write(0x61);
			codeLength += 1;
			return codeLength;
		}
		
		if (simplyEncodedData != null) {
			codeLength += simplyEncodedData.encode(reverseOS, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 0
			reverseOS.write(0x40);
			codeLength += 1;
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 0)) {
			simplyEncodedData = new SimplyEncodedData();
			codeLength += simplyEncodedData.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 1)) {
			fullyEncodedData = new FullyEncodedData();
			codeLength += fullyEncodedData.decode(is, false);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (simplyEncodedData != null) {
			sb.append("simplyEncodedData: ").append(simplyEncodedData);
			return;
		}

		if (fullyEncodedData != null) {
			sb.append("fullyEncodedData: ");
			fullyEncodedData.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

