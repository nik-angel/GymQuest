package com.example.gymquest.network; // Update package name

import com.example.gymquest.models.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/user/test")
    Call<User> getTestUser();
}