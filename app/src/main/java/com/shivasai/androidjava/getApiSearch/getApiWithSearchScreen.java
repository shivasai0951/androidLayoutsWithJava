package com.shivasai.androidjava.getApiSearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shivasai.androidjava.R;
import com.shivasai.androidjava.retrofit.retrofit;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class getApiWithSearchScreen extends AppCompatActivity {

    EditText editTextTextPersonName;
    TextView textView2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_api_with_search_screen);
        editTextTextPersonName=findViewById(R.id.editTextTextPersonName);
        textView2=findViewById(R.id.textView2);
        btn=(Button)findViewById(R.id.searchBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextTextPersonName.getText().toString().isEmpty()){
                    Toast.makeText(getApiWithSearchScreen.this, "please enter a number", Toast.LENGTH_SHORT).show();
                }else{
                    searchData(editTextTextPersonName.getText().toString());
                }
            }
        });

    }
   private void searchData(String id){
       InterfaceSearch interfaceSearch= retrofit.getClient().create(InterfaceSearch.class);

      Call<userModel> call=interfaceSearch.getUserData(Integer.parseInt(id));

      call.enqueue(new Callback<userModel>() {
          @Override
          public void onResponse(Call<userModel> call, Response<userModel> response) {
            try{
                if(response.body().email.isEmpty()){
                    textView2.setText("No Data Found");
                }else{
                    textView2.setText(response.body().email);
                }
            }catch (Exception e){
                Toast.makeText(getApiWithSearchScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
          }

          @Override
          public void onFailure(Call<userModel> call, Throwable t) {

          }
      });
    }


}