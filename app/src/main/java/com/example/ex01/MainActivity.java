package com.example.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rutbai;
    ImageView labai1;
    ImageView labai2;
    ImageView labai3;
    TextView thongbao;
    int sonut=0;//de xet xem duoc may nut
    int darut=0;//chi cho rut 3 la
    boolean batay=true;//de xet truong hop 3 tay
    String chuoithongbao="";
    ArrayList<String> cacladarut=new ArrayList<String>();//chua ten la da rut;
    //de de lam nen cho mang[][0] khong co y nghia (chi dung mang[][1]tro di
    int manghinhbai[][]={
            {R.drawable.cards,
                    R.drawable.a_1,R.drawable.la2_1,
                    R.drawable.la3_1,R.drawable.la4_1,R.drawable.la5_1,R.drawable.la6_1,R.drawable.la7_1,
                    R.drawable.la8_1,R.drawable.la9_1,R.drawable.la10_1, R.drawable.j_1,R.drawable.q_1,R.drawable.k_1},
            {R.drawable.cards,
                    R.drawable.a_2,R.drawable.la2_2,
                    R.drawable.la3_2,R.drawable.la4_2,R.drawable.la5_2,R.drawable.la6_2,R.drawable.la7_2,
                    R.drawable.la8_2,R.drawable.la9_2,R.drawable.la10_2,R.drawable.j_2,R.drawable.q_2,R.drawable.k_2},
            {R.drawable.cards,
                    R.drawable.a_3,R.drawable.la2_3,
                    R.drawable.la3_3,R.drawable.la4_3,R.drawable.la5_3,R.drawable.la6_3,R.drawable.la7_3,
                    R.drawable.la8_3,R.drawable.la9_3,R.drawable.la10_3,R.drawable.j_3,R.drawable.q_3,R.drawable.k_3},
            {R.drawable.cards,
                    R.drawable.a_4,R.drawable.la2_4,
                    R.drawable.la3_4,R.drawable.la4_4,R.drawable.la5_4,R.drawable.la6_4,R.drawable.la7_4,
                    R.drawable.la8_4,R.drawable.la9_4,R.drawable.la10_4,R.drawable.j_4,R.drawable.q_4,R.drawable.k_4},
    };
    String mangtenbai[][]= {
            {"rong",
                    "ách cơ","hai cơ","ba cơ","bốn cơ","năm cơ",
                    "sáu cơ","bảy cơ","tám cơ","chín cơ","mười cơ",
                    "bồi cơ","đầm cơ","già cơ"},
            {"rong",
                    "ách bích","hai bích","ba bích","bốn bích","năm bích",
                    "sáu bích","bảy bích","tám bích","chín bích","mười bích",
                    "bồi bích","đầm bích","già bích"},
            {"rong",
                    "ách rô","hai rô","ba rô","bốn rô","năm rô",
                    "sáu rô","bảy rô","tám ro","chín rô","mười rô",
                    "bồi rô","đầm ro","già rô"},
            {"rong",
                    "ách chuồn","hai chuồn","ba chuồn","bốn chuồn","năm chuồn",
                    "sáu chuồn","bảy chuồn","tám chuồn","chín chuồn","mười chuồn",
                    "bồi chuồn","đầm chuồn","già chuồn"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rutbai=(Button)findViewById(R.id.rutbai);
        labai1=(ImageView)findViewById(R.id.ivlabai1);
        labai2=(ImageView)findViewById(R.id.ivlabai2);
        labai3=(ImageView)findViewById(R.id.ivlabai3);
        thongbao=(TextView)findViewById(R.id.txtthongbao);
        rutbai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(darut==0)//lan dau hoac rut lai
                {
                    darut=0;
                    sonut=0;
                    batay=true;
                    chuoithongbao="";
                    labai1.setImageResource(R.drawable.cards);
                    labai2.setImageResource(R.drawable.cards);
                    labai3.setImageResource(R.drawable.cards);
                    cacladarut.clear();
                }
                darut++; //dem so lan rut
                //tao ngau nhien
                Random rd=new Random();
                int x,y;
                //tao ngau nhien bao vao ArrayList de xet xem co bi trung khong
                while(true)
                {
                    x=rd.nextInt(4);//0->3 (b-a+1)+a;
                    y=rd.nextInt(13)+1;//1->13
                    if(cacladarut.contains(mangtenbai[x][y])==false)
                    {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }
                //chi can y<11 lap tuc khong con la batay nua
                if(y<11)
                    batay=false;
                if(darut==1)
                {
                    sonut+=(y<10)?y:0;
                    labai1.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==2)
                {
                    sonut+=(y<10)?y:0;
                    labai2.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==3)
                {
                    sonut+=(y<10)?y:0;
                    int kq=sonut%10;
                    darut=0;
                    labai3.setImageResource(manghinhbai[x][y]);
                    chuoithongbao+="\n\nSố nút là "+ kq;
                }
                String kq_batay = "Không";
                if(batay)
                {
                    kq_batay ="Có";
                }
                thongbao.setText("Các lá đã rút : "+cacladarut.toString()
                        +chuoithongbao +"\n\nBa tay: "+kq_batay);
            }
        });
    }
}