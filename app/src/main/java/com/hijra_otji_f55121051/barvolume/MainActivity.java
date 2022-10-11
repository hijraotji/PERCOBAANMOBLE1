package com.hijra_otji_f55121051.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidht;
    private EditText edtHeight;
    private EditText edtLength;
    private Button btn_calculate;
    private TextView tv_result;
    private static final String STATE_RESULT = "state_result";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            edtWidht = findViewById(R.id.edt_width);
            edtHeight = findViewById(R.id.edt_height);
            edtLength = findViewById(R.id.edt_length);
            btn_calculate = findViewById(R.id.btn_calculate);
            tv_result = findViewById(R.id.tv_result);
            btn_calculate.setOnClickListener(this);

            if (savedInstanceState != null) {
                String result = savedInstanceState.getString(STATE_RESULT);
                tv_result.setText(result);
            }
        }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputLenght = edtLength.getText().toString().trim();
            String inputWidth = edtWidht.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputLenght)) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kurang");
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtWidht.setError("Field ini tidak boleh kurang");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kurang");
            }

            if (!isEmptyFields) {
                Double volume = Double.parseDouble(inputLenght) * Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
                tv_result.setText(String.valueOf(volume));
            }
        }
    }
}