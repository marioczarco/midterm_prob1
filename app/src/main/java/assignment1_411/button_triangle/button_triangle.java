package assignment1_411.button_triangle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class button_triangle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_triangle);

        LinearLayout lv = new LinearLayout(this);
        LinearLayout hv = new LinearLayout(this);
        hv.setOrientation(LinearLayout.HORIZONTAL);
        lv.setOrientation(LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        lv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        tv.setText("Enter the amount of rows needed in buttons: ");
        final EditText et = new EditText(this);
        hv.addView(tv);
        hv.addView(et);
        lv.addView(hv);
        Button btn = new Button(this);
        btn.setText("Submit");
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int content = Integer.parseInt(et.getText().toString()); //gets you the contents of edit text
                Intent intent = new Intent(button_triangle.this, buttons_appear.class);
                Bundle b = new Bundle();
                b.putInt("key", content); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                finish();
            }
        });
        lv.addView(btn);
        setContentView(lv);

    }
}
