package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lab_2 extends AppCompatActivity {

    private TextView primary_display;
    private TextView result;
    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button dec;
    private Button equ;
    private Button clr;
    private int flag=1,decflag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        getSupportActionBar().setTitle("Lab 2");
        getSupportActionBar().setHomeButtonEnabled(true);

        result = findViewById(R.id.result);

        primary_display = findViewById(R.id.primary_display);
        clr = findViewById(R.id.clr);
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText("");
                result.setText("");
                flag++;
                decflag=0;
            }
        });
        b0 = findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"0");
                flag=0;
            }
        });
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"1");
                flag=0;
            }
        });
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"2");
                flag=0;
            }
        });
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"3");
                flag=0;
            }
        });
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"4");
                flag=0;
            }
        });
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"5");
                flag=0;
            }
        });
        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"6");
                flag=0;
            }
        });
        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"7");
                flag=0;
            }
        });
        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"8");
                flag=0;
            }
        });
        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"9");
                flag=0;
            }
        });
        add = findViewById(R.id.b_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    primary_display.setText(primary_display.getText()+"+");
                    flag++;
                    decflag=0;
                }
            }
        });
        mul = findViewById(R.id.b_mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    primary_display.setText(primary_display.getText()+"x");
                    flag++;
                    decflag=0;
                }
            }
        });
        div = findViewById(R.id.b_div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    primary_display.setText(primary_display.getText()+"/");
                    flag++;
                    decflag=0;
                }
            }
        });
        sub = findViewById(R.id.b_sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    primary_display.setText(primary_display.getText()+"-");
                    flag++;
                    decflag=0;
                }
            }
        });
        dec = findViewById(R.id.b_dec);
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(decflag==0)
                {
                    if(flag==0)
                    {
                        primary_display.setText(primary_display.getText()+".");
                    }
                    else
                    {
                        primary_display.setText(primary_display.getText()+"0.");
                    }
                    flag++;
                    decflag++;
                }
            }
        });
        equ = findViewById(R.id.b_equ);
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    calculate();
                }
                else
                {
                    Toast.makeText(Lab_2.this, "Invalid equation", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void calculate()
    {
        double answer = 0.0;
        String s = primary_display.getText().toString().trim();
        String t = "";
        char oper='+';
        int i=0;
        for(i=0;i<s.length();i++)
        {
            if((s.charAt(i)>='0'&&s.charAt(i)<='9')||s.charAt(i)=='.')
            {
                t+=s.charAt(i);
            }
            else
            {
                if (oper == '+')
                {
                    answer += Double.parseDouble(t);
                    t = "";
                } else if (oper == '-')
                {
                    answer -= Double.parseDouble(t);
                    t = "";
                } else if (oper == 'x')
                {
                    answer *= Double.parseDouble(t);
                    t = "";
                } else if (oper == '/')
                {
                    answer /= Double.parseDouble(t);
                    t = "";
                }
                oper = s.charAt(i);
            }
        }
        if (oper == '+')
        {
            answer += Double.parseDouble(t);
            t = "";
        } else if (oper == '-')
        {
            answer -= Double.parseDouble(t);
            t = "";
        } else if (oper == 'x')
        {
            answer *= Double.parseDouble(t);
            t = "";
        } else if (oper == '/')
        {
            answer /= Double.parseDouble(t);
            t = "";
        }
        //Toast.makeText(Lab_2.this, answer+"", Toast.LENGTH_SHORT).show();
        result.setText(answer+"");
    }

}