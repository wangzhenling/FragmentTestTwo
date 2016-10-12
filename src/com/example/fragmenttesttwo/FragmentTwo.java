package com.example.fragmenttesttwo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTwo extends Fragment {

	public fragmentBtnClickListener fbcl;
	
	public interface fragmentBtnClickListener{
		public void changActivity(String data);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		fbcl=(fragmentBtnClickListener) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view=inflater.inflate(R.layout.fragment_two, container, false);
		
		Button btnFragment2=(Button) view.findViewById(R.id.btnFragment2);
	    btnFragment2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				fbcl.changActivity("Ñþºþ");
			}
		});
		
		return view;
	}

}
