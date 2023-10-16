package com.example.greenmate;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
// 아이디 중복 확인
// 수정 필요!
public class ValidateRequest extends StringRequest {
    //서버 url 설정(php파일 연동)
    final static  private String URL="http://dodam123.dothome.co.kr/UserValidate.php";
    private Map<String, String> map;

    public ValidateRequest(String Name, String UserValue, Response.Listener<String> listener){
        super(Method.POST, URL, listener,null);

        if(Name == "UserId"){
            map = new HashMap<>();
            map.put("UserId", UserValue);
        }else if(Name == "UserEmail"){
            map = new HashMap<>();
            map.put("UserEmail", UserValue);
        }
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}