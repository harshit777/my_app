package com.technoworld.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.name;
import static com.technoworld.calculator.R.id.click_btn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)this.findViewById(click_btn);
        b.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view)  {
                TextView resp = (TextView) findViewById(R.id.response);
                EditText name = (EditText) findViewById(R.id.user_name);
                EditText name2 = (EditText) findViewById(R.id.user_name2);

                String n1 = name.getText().toString();
                String n2 = name2.getText().toString();
                int i;

                String s10="",s11="";
                for(i=0;i<n1.length();i++)
                {
                    char q1=n1.charAt(i);
                    if(q1==' ')
                    {
                    }
                    else
                    {
                        s10=s10+q1;
                    }
                }
                for(i=0;i<n2.length();i++)
                {
                    char q1=n2.charAt(i);
                    if(q1==' ')
                    {
                    }
                    else
                    {
                        s11=s11+q1;
                    }
                }




                String f= s10 +" loves "+ s11 +" ";
                f=f.toLowerCase();
                int n=f.indexOf(' ',0);
                String m,v;
                int a[]=new int[100];
                int b[]=new int[100];
                int k=0,j,c=1,z=0,q=0,u=0,h=0;
                String pop,pop2,pop3="";
                m=f;
                v=f;
                h=n;
                while(f.indexOf(" ")!=0)
                {
                    m=f;
                    char g=m.charAt(0);
                    f="";
                    for(j=0;j<m.length()-1;j++)
                    {
                        char x=m.charAt(j+1);
                        if(g==x&&g!=' ')
                        {
                            c++;
                        }
                        else
                        {
                            f=f+x;
                        }
                    }
                    a[k]=c;
                    c=1;
                    k++;
                    n=-1;
                    j=n;
                }
                int c1[]=new int[100];int x1,x2,k1=0;
                int h1=k;
                int d1[]=new int[100];
                for(i=0;i<k;i++)
                {
                    d1[i]=a[i];
                }

                while(k1!=2)
                {
                    k1=0;
                    for(i=0;i<h1;i++)
                    {
                        if(d1[i]>=10)
                        {
                            x1=d1[i]/10;
                            x2=d1[i]%10;
                            c1[k1]=x1;
                            c1[++k1]=x2;
                            k1++;
                        }
                        else
                        {
                            c1[k1]=d1[i];
                            k1++;
                        }
                    }
                    if(k1%2==0)
                    {
                        for(i=0;i<(k1/2);i++)
                        {
                            b[q]=c1[i]+c1[k1-i-1];
                            //System.out.print(b[q]);
                            q++;
                        }
                    }
                    else
                    {
                        for(i=0;i<((k1+1)/2);i++)
                        {
                            if(i!=((k1-1)/2))
                            {
                                b[q]=c1[i]+c1[k1-i-1];
                                //System.out.print(b[q]);
                                q++;
                            }
                            else
                            {
                                b[q]=c1[(k1-1)/2];
                                //System.out.print(b[q]);
                                q++;
                            }
                        }
                    }
                    //System.out.println();
                    int t=0;
                    for(i=0;i<q;i++)
                    {
                        d1[i]=b[i];
                    }
                    k1=q;
                    h1=k1;
                    q=0;
                    //System.out.println();
                }
                for(i=0;i<k1;i++)
                {
                    int p=0,y=0;
                    if(b[i]>=10||b[i+1]>=10)
                    {
                        if(b[i]>=10)
                        {
                            p=b[i]/10;
                            y=p+b[k-1];
                            pop = Integer.toString(y);
                            pop2 = Integer.toString(b[i]%10);
                            pop3 = pop+pop2;
                            break;
                        }
                        else
                        {
                            p=b[i+1]%10;
                            y=p+b[0];
                            pop = Integer.toString(y);
                            pop2 = Integer.toString(b[i+1]/10);
                            pop3 = pop+pop2;
                            break;
                        }
                    }
                    else
                    {
                        pop3 =pop3 + Integer.toString(b[i]);
                    }

                }
                String str = name.getText().toString() + " loves " + name2.getText().toString() +" "+ pop3 + " %";
                resp.setText(str);


                //To hide Keyboard after pressing button

                LinearLayout mainLayout;

                // Get your layout set up, this is just an example
                mainLayout = (LinearLayout)findViewById(R.id.myLinearLayout);

                // Then just use the following:
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);


            }




        });
    }
}
