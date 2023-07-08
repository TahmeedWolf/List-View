package com.tahmeed.listapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tahmeed.listapp.R;
import com.tahmeed.listapp.adapter.RvPostAdapter;
import com.tahmeed.listapp.connection.ApiConnection;
import com.tahmeed.listapp.model.Posts;
import com.tahmeed.listapp.service.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.id_rc_view);

        getPost();
    }


    private void getPost() {

        ApiService service = ApiConnection.getRetrofit().create(ApiService.class);
        Call<List<Posts>> call = service.getPostAll();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                List<Posts> allPost = response.body();

                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getApplicationContext());
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setLayoutManager(layoutManager);



                 RvPostAdapter rvPostAdapter ;

                 rvPostAdapter =new RvPostAdapter(getApplicationContext(),allPost);
                 recyclerView.setAdapter(rvPostAdapter);
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}