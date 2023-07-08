package com.tahmeed.listapp.service;



import com.tahmeed.listapp.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET ("/posts")
    Call<List<Posts>> getPostAll(

    );
}
