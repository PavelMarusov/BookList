package com.example.booklist.models.cats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Status implements Serializable {
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("sentCount")
    @Expose
    private Integer sentCount;

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getSentCount() {
        return sentCount;
    }

    public void setSentCount(Integer sentCount) {
        this.sentCount = sentCount;
    }

}

