package com.example.commonlibrary.http;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by yc on 2018/4/3.
 */
public interface BaseApiService {
    @GET()
    Flowable<ResponseBody> get(@Url String url);
    @GET()
    Flowable<ResponseBody> get(@Url String url,@Query("phoneNumber") String phoneNumber);

    @GET()
    Flowable<ResponseBody> get(@Url String url, @QueryMap Map<String, String> maps);

    @POST()
    @FormUrlEncoded
    Flowable<ResponseBody> post(@Url String url, @FieldMap Map<String, String> maps);
    @POST()
    Flowable<ResponseBody> login(@Url String url,@Query("username") String username,@Query("password") String password);
    @POST()
    Flowable<ResponseBody> postBody(@Url String url, @Body Object object);

    @DELETE()
    Flowable<ResponseBody> delete(@Url String url, @QueryMap Map<String, String> maps);

    @PUT()
    Flowable<ResponseBody> put(@Url String url, @QueryMap Map<String, String> maps);

    @POST()
    Flowable<ResponseBody> putBody(@Url String url, @Body Object object);

    @Multipart
    @POST()
    Flowable<ResponseBody> uploadFlie(@Url String fileUrl, @Part("description") RequestBody description, @Part("files") MultipartBody.Part file);

    @Multipart
    @POST()
    Flowable<ResponseBody> uploadFiles(@Url String url, @PartMap() Map<String, RequestBody> maps);

    @Multipart
    @POST()
    Flowable<ResponseBody> uploadFiles(@Url String url, @Part() List<MultipartBody.Part> parts);

    @Streaming
    @GET
    Flowable<ResponseBody> downloadFile(@Url String fileUrl);

    @POST()
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Flowable<ResponseBody> postJson(@Url String url, @Body RequestBody jsonBody);

    @POST()
    Flowable<ResponseBody> postBody(@Url String url, @Body RequestBody body);


}
