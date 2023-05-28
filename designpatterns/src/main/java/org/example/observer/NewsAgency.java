package org.example.observer;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private String news;
    private List<Channel> channelList = new ArrayList<>();

    // subscribe
    public void addObserver(Channel channel) {
        this.channelList.add(channel);
    }

    public void removeObserver(Channel channel) {
        this.channelList.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        // notify
        for (Channel ch: this.channelList) {
//            ch.update(this.news);
        }
    }
}
