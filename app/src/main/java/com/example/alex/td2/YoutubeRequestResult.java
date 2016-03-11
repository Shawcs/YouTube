package com.example.alex.td2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
/**
 * Created by alex on 26/02/2016.
 */
public class YoutubeRequestResult implements Serializable {
    @JsonProperty("kind")
    public String kind ;
    @JsonProperty("etag")
    public String eTag;
    @JsonProperty("nextPageToken")
    public String nextPageToken ;
    @JsonProperty("prevPageToken")
    public String prevPageToken;
    public String regionCode;
    @JsonProperty("pageInfo")
    public PageInfo pageInfo;

    @JsonProperty("items")
    public youtubeJSON[] items;
}
