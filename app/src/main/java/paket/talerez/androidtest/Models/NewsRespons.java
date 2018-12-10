package paket.talerez.androidtest.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

//Model : Gson object - Json Resphonse
public class NewsRespons
{
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResults")
    @Expose
    private String totalResults;

    @SerializedName("articles")
    @Expose
    private List<Results> articles = null;


    public NewsRespons() {

    }

    public NewsRespons(String status, String totalResults, List<Results> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Results> getArticles() {
        return articles;
    }

    public void setArticles(List<Results> articles) {
        this.articles = articles;
    }
}
