package com.arichafamily.jsonandxml;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YnetDataSource {
    public interface OnYnetArrivedListener{
        void onYnetArrived(List<Ynet> data);
    }

    public static void getYnet(OnYnetArrivedListener listener){
        new AsyncTask<Void, Void, List<Ynet>>() {
            @Override
            protected List<Ynet> doInBackground(Void... params) {
                try {
                    String xml = IO.readWebSite("http://www.ynet.co.il/Integration/StoryRss2.xml");
                    List<Ynet> data = parse(xml);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<Ynet> ynets) {

            }
        }.execute();
    }

    private static List<Ynet> parse(String xml) {
        ArrayList<Ynet> data = new ArrayList<>();
        Log.d("HackerU", xml);
        return data;
    }

    public static class Ynet{
        private String title;
        private String link;
        private String thumbnail;
        private String content;

        public Ynet(String title, String link, String thumbnail, String content) {
            this.title = title;
            this.link = link;
            this.thumbnail = thumbnail;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public String getContent() {
            return content;
        }

        @Override
        public String toString() {
            return "Ynet{" +
                    "title='" + title + '\'' +
                    ", link='" + link + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
