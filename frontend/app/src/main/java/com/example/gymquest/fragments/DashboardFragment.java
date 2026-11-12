package com.example.gymquest.fragments; // Update package name

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.gymquest.models.User;
import com.example.gymquest.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("Fetching data from server...");
        textView.setTextSize(24);
        textView.setPadding(50, 50, 50, 50);

        // 1. Build Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.4.199.180:8080/") // Connects to your PC's Spring Boot server
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 2. Create API Service
        ApiService apiService = retrofit.create(ApiService.class);

        // 3. Make the network call in the background
        apiService.getTestUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body();
                    String successText = "Connection Successful!\n\n" +
                            "Username: " + user.username + "\n" +
                            "Level: " + user.level + "\n" +
                            "XP: " + user.current_xp;
                    textView.setText(successText);
                } else {
                    textView.setText("Server Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textView.setText("Network Failed: " + t.getMessage());
            }
        });

        return textView;
    }
}