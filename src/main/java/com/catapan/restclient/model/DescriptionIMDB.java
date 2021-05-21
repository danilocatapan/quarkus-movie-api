
package com.catapan.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DescriptionIMDB {

    @JsonProperty("i")
    private ImageIMDB image;

    @JsonProperty("id")
    private String idIMDB;

    @JsonProperty("l")
    private String longName;

    @JsonProperty("q")
    private String qualifier;

    private Long rank;

    @JsonProperty("s")
    private String staff;

    @JsonProperty("y")
    private Long year;

    public ImageIMDB getImage() {
        return image;
    }

    public void setImage(ImageIMDB image) {
        this.image = image;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

}
