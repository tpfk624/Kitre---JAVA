package com.kitri.awt.event;

import java.awt.Checkbox;
import java.awt.event.*;

public class ItemLogic implements ItemListener, ActionListener {
	
	ItemTest itemtest;//itemtest에 있는 애들을 사용하기 위하여
	
	public ItemLogic(ItemTest itemTest) { //불러오려는 객체의 주소값을 지정?(무한로딩을 막기위하여)
		this.itemtest = itemTest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0); //종료
	}

	@Override 
	public void itemStateChanged(ItemEvent e) {
		
		Object ob = e.getSource();//이벤트가 발생한 소스찾기 //버튼체크박스리스트 다 처리가능해서 오브젝트 
		if(ob == itemtest.ch) { //이벤트소스(이벤트가 발생한 객체)가 초이스라면?
			String str = itemtest.ch.getSelectedItem();
			if(str.equals("아침")) {
				itemtest.mor.setState(true);//상태를 바꿔라
			}else if(str.equals("점심")) {
				itemtest.aft.setState(true);
			}else {
				itemtest.eve.setState(true);
			}
		}
		Checkbox sel = itemtest.cg.getSelectedCheckbox();
		String selStr = sel.getLabel();
		//System.out.println(selStr);
		itemtest.ta.setText("---" + selStr + "---\n"); //기존거는 지우고 하나만 띄워야하니까 setText
		itemtest.ta.append("1. 사과 : "  + eat(itemtest.app.getState()) + "\n" );
		itemtest.ta.append("2. 바나나 : "  + eat(itemtest.banana.getState())+ "\n");
		itemtest.ta.append("3. 딸기 : " + eat(itemtest.straw.getState()) + "\n");
		itemtest.ch.select(selStr);	
	}
	
	private String eat(boolean flag) {
		return flag ? "먹었다" : "안먹었다" ;
	}
}
