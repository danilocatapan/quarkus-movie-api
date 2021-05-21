
package com.catapan.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MovieIMDB {

    @JsonProperty("d")
    private List<DescriptionIMDB> DescriptionIMDBList;

    @JsonProperty("q")
    private String query;

    public List<DescriptionIMDB> getDescriptionIMDBList() {
        return DescriptionIMDBList;
    }

    public void setDescriptionIMDBList(
        List<DescriptionIMDB> descriptionIMDBList) {
        DescriptionIMDBList = descriptionIMDBList;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
