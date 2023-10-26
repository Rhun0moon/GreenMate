package com.example.greenmate;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity extends AppCompatActivity {
    private EditText join_id, join_email, join_pw, join_pwck, join_name, join_phone, join_birth;
    private Button back_button, join_button, check_button, delete_button;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_join );

        //아이디값 찾아주기
        join_id = findViewById(R.id.join_id);
        join_email = findViewById( R.id.join_email );
        join_pw = findViewById( R.id.join_pw );
        join_pwck = findViewById(R.id.join_pwck);
        join_name = findViewById( R.id.join_name );
        join_phone = findViewById(R.id.join_phone);
        join_birth = findViewById(R.id.join_birth);

        // 뒤로가기 버튼
        back_button = findViewById(R.id.back_btn);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class );
                startActivity(intent);
            }
        });

        // 중복확인 버튼 - 아이디 중복 체크 -> 코드수정필요
        check_button = findViewById(R.id.check_button_id);
        /*
        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m_id = join_id.getText().toString();
                if (validate) {
                    return; //검증 완료
                }

                if (m_id.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("아이디를 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
                                dialog.show();
                                join_id.setEnabled(false); //아이디값 고정
                                validate = true; //검증 완료
                                check_button.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("이미 존재하는 아이디입니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                ValidateRequest validateRequest = new ValidateRequest("UserId", m_id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
                queue.add(validateRequest);
            }
        });
        */

        // 중복확인 버튼 - 이메일 중복 체크 -> 코드수정필요
        check_button = findViewById(R.id.check_button_email);
        /*
        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m_email = join_email.getText().toString();
                if (validate) {
                    return; //검증 완료
                }

                if (m_email.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("이메일을 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("사용할 수 있는 이메일입니다.").setPositiveButton("확인", null).create();
                                dialog.show();
                                join_email.setEnabled(false); //아이디값 고정
                                validate = true; //검증 완료
                                check_button.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("이미 존재하는 이메일입니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                ValidateRequest validateRequest = new ValidateRequest("UserEmail", m_email, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
                queue.add(validateRequest);
            }
        });
        */

        // 가입 버튼
        join_button = findViewById( R.id.join_btn );
        join_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(JoinActivity.this, MainActivity.class );
                startActivity(intent);

                /*
                final String m_id = join_id.getText().toString();
                final String m_pw = join_pw.getText().toString();
                final String PassCk = join_pwck.getText().toString();
                final String m_name = join_name.getText().toString();
                final String m_email = join_email.getText().toString();
                final String m_birth = join_birth.getText().toString();
                final String m_phone = join_phone.getText().toString();

                //아이디 중복체크 했는지 확인
                if (!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("중복된 아이디가 있는지 확인하세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //한 칸이라도 입력 안했을 경우
                if (m_id.equals("") || m_pw.equals("") || m_name.equals("") || m_email.equals("")  || m_birth.equals("")  || m_phone.equals("") ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //비밀번호, 비밀번호 확인이 일치하지 않을 경우
                if(!(m_pw.equals(PassCk))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("비밀번호가 동일하지 않습니다.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //DB등록
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );
                            //회원가입 성공시
                            if (success) {

                                Toast.makeText(getApplicationContext(), String.format("%s님 가입을 환영합니다.", m_name), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                                startActivity(intent);

                                //회원가입 실패시
                            } else {
                                Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다. 형식에 맞게 정보를 입력해주세요.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청
                RegisterRequest registerRequest = new RegisterRequest( m_id, m_pw, m_name, m_email, m_birth, m_phone, responseListener);
                RequestQueue queue = Volley.newRequestQueue( JoinActivity.this );
                queue.add( registerRequest );
                */
            }
        });


        // 취소 버튼
        delete_button = findViewById(R.id.delte_btn);
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class );
                startActivity(intent);
            }
        });
    }
}
