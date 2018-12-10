package paket.talerez.androidtest.Network;

import io.reactivex.Observable;
import paket.talerez.androidtest.Models.NewsRespons;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewtworkInterface
{
    // Query request for data from a API.
    @GET("top-headlines")
    Observable<NewsRespons> getNews(@Query("country") String country,@Query("apiKey") String apiKey);
}
