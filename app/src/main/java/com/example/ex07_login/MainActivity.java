package com.example.ex07_login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvEmail;
    Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        button1 = (Button) findViewById(R.id.button1);

        //1.메인화면에서 버튼을 누르면, 다이얼로그 생성한다.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.다이얼로그 생성
                AlertDialog.Builder dlg1 = new AlertDialog.Builder(MainActivity.this);

                dlg1.setTitle("사용자 정보 입력");
                dlg1.setIcon(R.drawable.ic_menu_allfriends);

                View view1 = View.inflate(MainActivity.this, R.layout.dialog1,null);
//                dlg1.setMessage("adfasf");
                dlg1.setView(view1);

                dlg1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText edt1 = view1.findViewById(R.id.dlgEdt1);
                        EditText edt2 = view1.findViewById(R.id.dlgEdt2);

                        String str1 = edt1.getText().toString();
                        String str2 = edt2.getText().toString();

                        tvName.setText(str1);
                        tvEmail.setText(str2);
                    }
                });


                dlg1.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //다이얼로그 위에서, 취소버튼 누르면 토스트 생성

//                        Toast.makeText(MainActivity.this,"취소했음",Toast.LENGTH_SHORT).show();
                        Toast toast1 = new Toast(MainActivity.this);

                        View view1 = View.inflate(MainActivity.this,R.layout.toast1,null);

                        TextView tvToast1 = view1.findViewById(R.id.toastText1);
                        tvToast1.setText("취소했음~!!!!");

                        toast1.setView(view1);

                        toast1.show();
                    }
                });
                dlg1.show();

            }
        });



    }
}
