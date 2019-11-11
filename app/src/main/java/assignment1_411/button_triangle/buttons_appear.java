package assignment1_411.button_triangle;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Zarco on 11/2/2019.
 */

public class buttons_appear extends button_triangle{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons_appear);
        LinearLayout hv = new LinearLayout(this);
        LinearLayout.LayoutParams hvParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT

        );
        hv.setOrientation(LinearLayout.HORIZONTAL);
        Button btn;
        LinearLayout lv = new LinearLayout(this);
        LinearLayout.LayoutParams lvParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT

        );

        LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(
                50,
                50
        );
        lv.setOrientation(LinearLayout.VERTICAL);
        params.weight = 1;
        params.setMargins(10,10,10,10);


        Bundle b = getIntent().getExtras();


        int entry_size = b.getInt("key");

        System.out.println(entry_size);

        btn = new Button(this);
        btn.setLayoutParams(params);
        btn.setBackgroundColor(Color.BLUE);

        hv.setWeightSum(1);
        hv.addView(btn, hv.getChildCount(), params);
        hv = new LinearLayout(this);
        lv.setLayoutParams(lvParams);
        hv.setGravity(Gravity.CENTER_HORIZONTAL);
        lv.addView(hv, lv.getChildCount());
            for(int j = 1; j < entry_size + 1; j++){
                for(int i = 0; i < j; i++){
                    if(i < j) {
                        btn = new Button(this);
                        btn.setLayoutParams(params);
                        btn.setBackgroundColor(Color.BLUE);
                        hv.setWeightSum(j);
                        hv.addView(btn, hv.getChildCount(), params);
                    }
                    if (i == j - 1) {
                        hv = new LinearLayout(this);
                        hv.setLayoutParams(hvParams);
                        lv.setLayoutParams(lvParams);
                        hv.setGravity(Gravity.CENTER_HORIZONTAL);
                        lv.setGravity(Gravity.CENTER);
                        lv.addView(hv, lv.getChildCount());
                    }

                }
            }
        setContentView(lv);




    }
}
