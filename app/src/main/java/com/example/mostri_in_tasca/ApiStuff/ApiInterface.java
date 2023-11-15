package com.example.mostri_in_tasca.ApiStuff;

import com.example.mostri_in_tasca.ApiStuff.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("users/")
    Call<SignUpResponse> register();

    @GET("objects/")
    Call<List<NearestVirtualObjects>> nearestVirtualObjects(@Query("sid") String sid, @Query("lat") String lat, @Query("lon") String lon);

    @GET("objects/{id}/")
    @FormUrlEncoded
    Call<VirtualObjectDetails> virtualObjectDetails(@Path("id")int id, @Query("sid") String sid);

    @GET("objects/{id}/activate")
    @FormUrlEncoded
    Call<ActivateObject> activateObjectById(@Path("id")int id);

    @POST("users/")
    Call<NearestUsers> nearestUsers();

    @GET("users/id/")
    Call<UserDetails> userDetails(@Path("id")int id, @Query("sid"));

    @PATCH("users/id/")
    Call<UpdateUserDetails>


}
