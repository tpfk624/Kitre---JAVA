package com.kitri.haksa.test;

import java.util.*;

import com.kitri.haksa.data.HaksaDto;
import com.kitri.haksa.service.HaksaService;
import com.kitri.haksa.service.HaksaServiceImpl;

public class HaksaMain {
	public static void main(String[] args) {
		
		HaksaServiceImpl haksa =  new HaksaServiceImpl();
		haksa.menu();
		
	}
}
