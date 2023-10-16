package com.example.greenmate;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
// 회원가입 값 요청
// 수정필요!
public class RegisterRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://ftp 아이디.dothome.co.kr/Register.php";
    private Map<String, String> map;
    //private Map<String, String>parameters;

    public RegisterRequest(String UserId, String UserPw, String UserName, String UserEmail, String UserBirth, String UserPhone, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("UserId", UserId);
        map.put("UserPw", UserPw);
        map.put("UserName", UserName);
        map.put("UserEmail", UserEmail);
        map.put("UserBirth", UserBirth);
        map.put("UserPhone", UserPhone);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}