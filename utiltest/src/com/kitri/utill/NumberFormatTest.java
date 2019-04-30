package com.kitri.utill;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberFormatTest {

	public static void main(String[] args) {
		double number = 3563242365453.126;
		//3,563,242,365,453.13
		Format f = new DecimalFormat("##,###,###,###,###,###.##");
		String numStr = f.format(number);
		System.out.println(number);
		System.out.println(numStr);
	}
}
