package com.catapan.restclient.model;

import javax.json.bind.annotation.JsonbProperty;

public class DescriptionIMDB {

    private ImageIMDB image;

    private String idIMDB;

    private String longName;

    private String qualifier;

    private Long rank;

    private String staff;

    private Long year;

    public ImageIMDB getImage() {
        return image;
    }

    @JsonbProperty("i")
    public void setImage(ImageIMDB image) {
        this.image = image;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    @JsonbProperty("id")
    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
    }

    public String getLongName() {
        return longName;
    }

    @JsonbProperty("l")
    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getQualifier() {
        return qualifier;
    }

    @JsonbProperty("q")
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

    @JsonbProperty("s")
    public void setStaff(String staff) {
        this.staff = staff;
    }

    public Long getYear() {
        return year;
    }

    @JsonbProperty("y")
    public void setYear(Long year) {
        this.year = year;
    }

}
