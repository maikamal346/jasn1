/**
 * This class file was automatically generated by jASN1 v1.11.1-SNAPSHOT (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pkix1implicit88;

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

import com.beanit.jasn1.compiler.pkix1explicit88.Attribute;
import com.beanit.jasn1.compiler.pkix1explicit88.CertificateSerialNumber;
import com.beanit.jasn1.compiler.pkix1explicit88.DirectoryString;
import com.beanit.jasn1.compiler.pkix1explicit88.Name;
import com.beanit.jasn1.compiler.pkix1explicit88.ORAddress;
import com.beanit.jasn1.compiler.pkix1explicit88.RelativeDistinguishedName;

public class GeneralName implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public AnotherName otherName = null;
	public BerIA5String rfc822Name = null;
	public BerIA5String dNSName = null;
	public ORAddress x400Address = null;
	public Name directoryName = null;
	public EDIPartyName ediPartyName = null;
	public BerIA5String uniformResourceIdentifier = null;
	public BerOctetString iPAddress = null;
	public BerObjectIdentifier registeredID = null;
	
	public GeneralName() {
	}

	public GeneralName(byte[] code) {
		this.code = code;
	}

	public GeneralName(AnotherName otherName, BerIA5String rfc822Name, BerIA5String dNSName, ORAddress x400Address, Name directoryName, EDIPartyName ediPartyName, BerIA5String uniformResourceIdentifier, BerOctetString iPAddress, BerObjectIdentifier registeredID) {
		this.otherName = otherName;
		this.rfc822Name = rfc822Name;
		this.dNSName = dNSName;
		this.x400Address = x400Address;
		this.directoryName = directoryName;
		this.ediPartyName = ediPartyName;
		this.uniformResourceIdentifier = uniformResourceIdentifier;
		this.iPAddress = iPAddress;
		this.registeredID = registeredID;
	}

	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		int sublength;

		if (registeredID != null) {
			codeLength += registeredID.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 8
			reverseOS.write(0x88);
			codeLength += 1;
			return codeLength;
		}
		
		if (iPAddress != null) {
			codeLength += iPAddress.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 7
			reverseOS.write(0x87);
			codeLength += 1;
			return codeLength;
		}
		
		if (uniformResourceIdentifier != null) {
			codeLength += uniformResourceIdentifier.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 6
			reverseOS.write(0x86);
			codeLength += 1;
			return codeLength;
		}
		
		if (ediPartyName != null) {
			codeLength += ediPartyName.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			reverseOS.write(0xA5);
			codeLength += 1;
			return codeLength;
		}
		
		if (directoryName != null) {
			sublength = directoryName.encode(reverseOS);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
			reverseOS.write(0xA4);
			codeLength += 1;
			return codeLength;
		}
		
		if (x400Address != null) {
			codeLength += x400Address.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			reverseOS.write(0xA3);
			codeLength += 1;
			return codeLength;
		}
		
		if (dNSName != null) {
			codeLength += dNSName.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			reverseOS.write(0x82);
			codeLength += 1;
			return codeLength;
		}
		
		if (rfc822Name != null) {
			codeLength += rfc822Name.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			reverseOS.write(0x81);
			codeLength += 1;
			return codeLength;
		}
		
		if (otherName != null) {
			codeLength += otherName.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			reverseOS.write(0xA0);
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

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			otherName = new AnotherName();
			codeLength += otherName.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			rfc822Name = new BerIA5String();
			codeLength += rfc822Name.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			dNSName = new BerIA5String();
			codeLength += dNSName.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			x400Address = new ORAddress();
			codeLength += x400Address.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
			codeLength += BerLength.skip(is);
			directoryName = new Name();
			codeLength += directoryName.decode(is, null);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
			ediPartyName = new EDIPartyName();
			codeLength += ediPartyName.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 6)) {
			uniformResourceIdentifier = new BerIA5String();
			codeLength += uniformResourceIdentifier.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 7)) {
			iPAddress = new BerOctetString();
			codeLength += iPAddress.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
			registeredID = new BerObjectIdentifier();
			codeLength += registeredID.decode(is, false);
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

		if (otherName != null) {
			sb.append("otherName: ");
			otherName.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (rfc822Name != null) {
			sb.append("rfc822Name: ").append(rfc822Name);
			return;
		}

		if (dNSName != null) {
			sb.append("dNSName: ").append(dNSName);
			return;
		}

		if (x400Address != null) {
			sb.append("x400Address: ");
			x400Address.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (directoryName != null) {
			sb.append("directoryName: ");
			directoryName.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (ediPartyName != null) {
			sb.append("ediPartyName: ");
			ediPartyName.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (uniformResourceIdentifier != null) {
			sb.append("uniformResourceIdentifier: ").append(uniformResourceIdentifier);
			return;
		}

		if (iPAddress != null) {
			sb.append("iPAddress: ").append(iPAddress);
			return;
		}

		if (registeredID != null) {
			sb.append("registeredID: ").append(registeredID);
			return;
		}

		sb.append("<none>");
	}

}

