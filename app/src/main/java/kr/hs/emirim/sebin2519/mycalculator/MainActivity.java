package kr.hs.emirim.sebin2519.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //메인엑티비티에 이벤트 핸들러를 만든다(OnClickListener인터페이스를 상속받는다)


    Button butPlus, butMinus, butDivide, butMultiply;//버튼 객체 생성(R의 클래스에서 참조값을 이용해 객체를 반환받음)
    EditText editNum1, editNum2;
    TextView textresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //레이아웃에 만든 요소이름(클래스로 존재)을 가진것, 객체생성을 위해 이것을 메모리에 올려줌
        butPlus=(Button)findViewById(R.id.but_plus);//findViewById(): ()안에 있는 id로 인해서 View를 찾아라 /객체참조(주소)값을 반환 -> 형변환
        butMinus=(Button)findViewById(R.id.but_minus);
        butDivide=(Button)findViewById(R.id.but_divide);
        butMultiply=(Button)findViewById(R.id.but_multiply);
        editNum1=(EditText)findViewById(R.id.edit_num1);
        editNum2=(EditText)findViewById(R.id.edit_num2);
        textresult=(TextView)findViewById(R.id.text_result);//결과값
        butPlus.setOnClickListener(this);//버튼 감시, onClick메서드 실행
        butMinus.setOnClickListener(this);
        butDivide.setOnClickListener(this);
        butMultiply.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) { //OnClickListener인터페이스를 상속받는다 -> 인터페이스에 onClick 추상메서드가 있으므로 onClick메서드 구현
        //2개의 EditText에 입력된 값을 반환 받는다(String)
        String num1Str=editNum1.getText().toString();
        String num2Str=editNum2.getText().toString();

        //정수값으로 변환
        int num1=Integer.parseInt(num1Str);
        int num2=Integer.parseInt(num2Str);
        double result=0; //결과값을 저장할 지역변수 선언

        //버튼 4개를 구분해서 계산 -> switch-case이용
        switch(v.getId()){ //객체가 가지고 있는 id값을 반환받음
            case R.id.but_plus:
                result=num1+num2;
                break;
            case R.id.but_minus:
                result=num1-num2;
                break;
            case R.id.but_divide:
                result=num1/(double)num2; //정확한 값을 위한 형변환
                break;
            case R.id.but_multiply:
                result=num1*num2;
                break;
        }

        //TextView에 result설정
        textresult.setText("*계산 결과: "+result);
    }
}
