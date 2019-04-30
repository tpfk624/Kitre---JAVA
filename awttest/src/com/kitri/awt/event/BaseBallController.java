package com.kitri.awt.event;

import java.awt.event.*;

//로직만 만들어놓고 어떨때는 이거 호출
//어떨때는 이거 호출 하는 역할만 함(서비스가 처리)

public class BaseBallController extends WindowAdapter implements ActionListener, AdjustmentListener{

	BaseBall baseBall;
	BaseBallService baseBallService;
	
	public BaseBallController(BaseBall baseBall) {
		this.baseBall = baseBall;
		baseBallService = new BaseBallService(this); //객체생성 //서비스에서 쓸 수 있게this로 
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
	
	
	//윈도우리스너를 implements하면 너무 많은 메소드들을 오버라이딩 해야하므로
	//WindowAdapter를 상속받아 사용하려는 것만 오버라이드해준다.
	@Override
	public void windowClosing(WindowEvent e) {
		baseBallService.exit();
	}

	
}
