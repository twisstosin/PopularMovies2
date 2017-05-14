package com.twisstosin.popularmovies2.DataModels;

import java.util.List;

public class MoviesResponse {

    public double page;
    public List<MovieList> results = null;
    public double totalResults;
    public double totalPages;

    public double getPage() {
        return page;
    }

    public void setPage(double page) {
        this.page = page;
    }

    public List<MovieList> getResults() {
        return results;
    }

    public void setResults(List<MovieList> results) {
        this.results = results;
    }

    public double getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(double totalPages) {
        this.totalPages = totalPages;
    }

    public double getTotalResults() {

        return totalResults;
    }

    public void setTotalResults(double totalResults) {
        this.totalResults = totalResults;
    }
}
