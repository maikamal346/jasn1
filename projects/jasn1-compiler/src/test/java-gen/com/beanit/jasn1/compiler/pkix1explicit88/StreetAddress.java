/**
 * This class file was automatically generated by jASN1 v1.11.1-SNAPSHOT (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pkix1explicit88;

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


public class StreetAddress extends PDSParameter {

	private static final long serialVersionUID = 1L;

	public StreetAddress() {
	}

	public StreetAddress(byte[] code) {
		super(code);
	}

	public StreetAddress(BerPrintableString printableString, BerTeletexString teletexString) {
		super(printableString, teletexString);
	}

}
