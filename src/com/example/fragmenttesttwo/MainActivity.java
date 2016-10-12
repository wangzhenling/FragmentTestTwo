package com.example.fragmenttesttwo;

import com.example.fragmenttesttwo.FragmentTwo.fragmentBtnClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements fragmentBtnClickListener {

	private Button btnClick,btnMain;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentOne frgOne=new FragmentOne();
		final FragmentManager fm = getFragmentManager();
		FragmentTransaction tx = fm.beginTransaction();
		
		Bundle args1=new Bundle();
		args1.putString("frgOne", "����ʡ");
		frgOne.setArguments(args1);
		
	    tx.add(R.id.flcontent,frgOne,"ONE");
	    tx.addToBackStack(null);
	    tx.commit();
	    
	    btnClick=(Button) this.findViewById(R.id.btnClick);  
	    btnClick.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				FragmentTwo frgTwo=new FragmentTwo();
				FragmentTransaction tx2 = fm.beginTransaction(); 
				tx2.replace(R.id.flcontent,frgTwo,"TWO");  
				tx2.addToBackStack(null);
			    tx2.commit();
			}
		});
	    
	    btnMain=(Button) this.findViewById(R.id.btnMain);
	    btnMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				FragmentOne f1=(FragmentOne) fm.findFragmentByTag("ONE");
				//System.out.println(f1.isVisible());
				if(f1.isVisible()){
					TextView tvFrg1=(TextView) fm.findFragmentByTag("ONE").getView().findViewById(R.id.tvFragmentShow1);
					tvFrg1.setText("2016");
				}
		
			}
		});
	    		
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	@Override
	public void changActivity(String data) {
		// TODO Auto-generated method stub

		 TextView tvActivity=(TextView) this.findViewById(R.id.tvShowText);
		 tvActivity.setText("����");
	}

}
