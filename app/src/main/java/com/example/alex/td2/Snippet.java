package com.example.alex.td2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by alex on 26/02/2016.
 */
//another classe to store the data
public class Snippet implements Serializable {
    String publishedAt;
    String channelId;
    String title;
    String description;
    thumbnails thumbnails;

    public class  thumbnails implements Serializable{
    @JsonProperty("default")
        defaults defaults;
        medium medium;
        high high;
    }
    public class defaults{
        String url;
        double width;
        double height;
    }
    public class medium{
        String url;
        double width;
        double height;
}
    public class high{
        String url;
        double width;
        double height;
    }

    String channelTitle;
    String liveBroadcastContent;

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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



    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }
}
/*
"snippet": {
        "publishedAt": "2016-01-19T18:00:00.000Z",
        "channelId": "UCdUth5xByWogqrnjKmTAlIw",
        "title": "AAA 2 - Latest Yoruba Nollywood movie  2016 [ODUNLADE MOVIE]",
        "description": "Adebayo Aremu Abere is a very notorious criminal that dares anyone to get what he wants including security personnels of all ranks. This is just the beginning ...",
        "thumbnails": {
        "default": {
        "url": "https://i.ytimg.com/vi/FmBTvjgIGmw/default.jpg",
        "width": 120,
        "height": 90
        },
        "medium": {
        "url": "https://i.ytimg.com/vi/FmBTvjgIGmw/mqdefault.jpg",
        "width": 320,
        "height": 180
        },
        "high": {
        "url": "https://i.ytimg.com/vi/FmBTvjgIGmw/hqdefault.jpg",
        "width": 480,
        "height": 360
        }
        },
        "channelTitle": "",
        "liveBroadcastContent": "none"
        }
*/