package com.kitri.haksa.service;

import com.kitri.haksa.data.HaksaDto;

public interface HaksaService {
	
	void menu();
	
	void registerMenu();
	
	void register(HaksaDto haska);
	
	void findNameMenu();
	
	HaksaDto findName(String name);
	
	void deleteMenu();
	
	int delete(String name);
	
	void selectAll();
	
	void processExit();
	
}
