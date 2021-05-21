package com.catapan.restclient.model;

import java.util.List;
import javax.json.bind.annotation.JsonbProperty;

public class MovieIMDB {

    private List<DescriptionIMDB> DescriptionIMDBList;

    private String query;

    public List<DescriptionIMDB> getDescriptionIMDBList() {
        return DescriptionIMDBList;
    }

    @JsonbProperty("d")
    public void setDescriptionIMDBList(List<DescriptionIMDB> descriptionIMDBList) {
        DescriptionIMDBList = descriptionIMDBList;
    }

    public String getQuery() {
        return query;
    }

    @JsonbProperty("q")
    public void setQuery(String query) {
        this.query = query;
    }
}
