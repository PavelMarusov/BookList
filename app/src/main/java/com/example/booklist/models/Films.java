package com.example.booklist.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
@Entity
public class Films implements Serializable {
    @SerializedName("id")
    @Expose
    @NonNull
    @PrimaryKey
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("producer")
    @Expose
    private String producer;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("rt_score")
    @Expose
    private String rtScore;
//    @SerializedName("people")
//    @Expose
//    private List<String> people;
//    @SerializedName("species")
//    @Expose
//    private List<String> species ;
//    @SerializedName("locations")
//    @Expose
//    private List<String> locations ;
//    @SerializedName("vehicles")
//    @Expose
//    private List<String> vehicles ;
    @SerializedName("url")
    @Expose
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }

//    public List<String> getPeople() {
//        return people;
//    }
//
//    public void setPeople(List<String> people) {
//        this.people = people;
//    }
//
//    public List<String> getSpecies() {
//        return species;
//    }
//
//    public void setSpecies(List<String> species) {
//        this.species = species;
//    }
//
//    public List<String> getLocations() {
//        return locations;
//    }
//
//    public void setLocations(List<String> locations) {
//        this.locations = locations;
//    }
//
//    public List<String> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(List<String> vehicles) {
//        this.vehicles = vehicles;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Films{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
