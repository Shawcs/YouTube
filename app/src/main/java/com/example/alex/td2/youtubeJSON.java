package com.example.alex.td2;

import java.io.Serializable;

/**
 * Created by alex on 22/01/2016.
 */
//here is the classe to store the data from youtube get query
    //i actually have a problem it sound like my constructor is not well made and something don't
//fit with the recuperated datas
public class youtubeJSON implements Serializable {
    String kind;
    String etag;
    String nextPageToken;
    String regionCode;

    public class id {
       String kind;
        String  videoId;
    }
    public class pageInfo{
        double totalResults;
        double resultsPerPage;
    }
    public class item{
        String kind;
        String etag;
        id id;
        Snippet snippet;

    }
}
/*
"kind": "youtube#searchListResponse",
        "etag": "\"q5k97EMVGxODeKcDgp8gnMu79wM/zv77NITQBVWmrnpp7NufWLR7Llc\"",
        "nextPageToken": "CAUQAA",
        "regionCode": "FR",
        "pageInfo": {
        "totalResults": 1000000,
        "resultsPerPage": 5
        },
        "items": [
        {
        "kind": "youtube#searchResult",
        "etag": "\"q5k97EMVGxODeKcDgp8gnMu79wM/9GUO0Pek0yOaWpQ2xJ6cLPD34Wc\"",
        "id": {
        "kind": "youtube#video",
        "videoId": "FmBTvjgIGmw"
        },

        },*/