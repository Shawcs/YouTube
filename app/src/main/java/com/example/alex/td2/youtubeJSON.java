package com.example.alex.td2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by alex on 22/01/2016.
 */
//here is the class to store the data from youtube get query
public class youtubeJSON implements Serializable {
    @JsonProperty("kind")
    public String kind ;
    @JsonProperty("etag")
    public String eTag;
    @JsonProperty("id")
    public com.example.alex.td2.VideoId id;
    @JsonProperty("snippet")
    public com.example.alex.td2.Snippet snippet;
}