package com.arichafamily.jsonandxml;

public class YnetDataSource {
    
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
