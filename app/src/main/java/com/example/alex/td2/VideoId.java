package com.example.alex.td2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by alex on 11/03/2016.
 */
public class VideoId implements Serializable {
    @JsonProperty("kind")
    public String kind ;
    @JsonProperty("videoId")
    public String videoId;
}