package com.kitri.awt.event;

import java.awt.event.*;

//������ �������� ����� �̰� ȣ��
//����� �̰� ȣ�� �ϴ� ���Ҹ� ��(���񽺰� ó��)

public class BaseBallController extends WindowAdapter implements ActionListener, AdjustmentListener{

	BaseBall baseBall;
	BaseBallService baseBallService;
	
	public BaseBallController(BaseBall baseBall) {
		this.baseBall = baseBall;
		baseBallService = new BaseBallService(this); //��ü���� //���񽺿��� �� �� �ְ�this�� 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == baseBall.newG) {
			baseBallService.newGame();
		}else if(ob == baseBall.clear) {
			baseBallService.clear();
		}else if(ob == baseBall.dap) {
			baseBallService.showDap();
		}else if(ob == baseBall.fontC) {
			baseBallService.fontColorChange();
		}else if(ob == baseBall.exit) {
			baseBallService.exit();
		}else if(ob == baseBall.tf) {
			baseBallService.game();
		}else if(ob == baseBall.fontColorChooser.ok) {
			baseBallService.selectColor();
		}
	}
	
	
	

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {	
		baseBallService.changeColor();	
	}
	
	
	//�����츮���ʸ� implements�ϸ� �ʹ� ���� �޼ҵ���� �������̵� �ؾ��ϹǷ�
	//WindowAdapter�� ��ӹ޾� ����Ϸ��� �͸� �������̵����ش�.
	@Override
	public void windowClosing(WindowEvent e) {
		baseBallService.exit();
	}

	
}
