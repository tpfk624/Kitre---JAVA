package com.kitri.awt.event;

import java.awt.Checkbox;
import java.awt.event.*;

public class ItemLogic implements ItemListener, ActionListener {
	
	ItemTest itemtest;//itemtest�� �ִ� �ֵ��� ����ϱ� ���Ͽ�
	
	public ItemLogic(ItemTest itemTest) { //�ҷ������� ��ü�� �ּҰ��� ����?(���ѷε��� �������Ͽ�)
		this.itemtest = itemTest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0); //����
	}

	@Override 
	public void itemStateChanged(ItemEvent e) {
		
		Object ob = e.getSource();//�̺�Ʈ�� �߻��� �ҽ�ã�� //��ưüũ�ڽ�����Ʈ �� ó�������ؼ� ������Ʈ 
		if(ob == itemtest.ch) { //�̺�Ʈ�ҽ�(�̺�Ʈ�� �߻��� ��ü)�� ���̽����?
			String str = itemtest.ch.getSelectedItem();
			if(str.equals("��ħ")) {
				itemtest.mor.setState(true);//���¸� �ٲ��
			}else if(str.equals("����")) {
				itemtest.aft.setState(true);
			}else {
				itemtest.eve.setState(true);
			}
		}
		Checkbox sel = itemtest.cg.getSelectedCheckbox();
		String selStr = sel.getLabel();
		//System.out.println(selStr);
		itemtest.ta.setText("---" + selStr + "---\n"); //�����Ŵ� ����� �ϳ��� ������ϴϱ� setText
		itemtest.ta.append("1. ��� : "  + eat(itemtest.app.getState()) + "\n" );
		itemtest.ta.append("2. �ٳ��� : "  + eat(itemtest.banana.getState())+ "\n");
		itemtest.ta.append("3. ���� : " + eat(itemtest.straw.getState()) + "\n");
		itemtest.ch.select(selStr);	
	}
	
	private String eat(boolean flag) {
		return flag ? "�Ծ���" : "�ȸԾ���" ;
	}
}
