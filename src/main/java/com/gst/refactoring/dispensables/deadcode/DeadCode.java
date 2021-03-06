package com.gst.refactoring.dispensables.deadcode;

import java.util.ArrayList;
import java.util.List;

public class DeadCode {
    //field
    private String title;
    private String description;
    private String category;
    private List<NewsEntity> listNews = new ArrayList<>();


    private void addNews(NewsEntity newsEntity) {
        listNews.add(newsEntity);
    }

    public NewsEntity getNews(String title) {
        //variable
        String name = "Nguyễn Văn A";
        for (NewsEntity news : listNews) {
            if (news.getTitle().equals(title)) {
                return news;
            }
        }
        return new NewsEntity();
    }

    //    parameter
    public NewsEntity getNewsByCategory(String title, String category) {
        for (NewsEntity news : listNews) {
            if (news.getCateName().equals(category)) {
                return news;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DeadCode deadCode = new DeadCode();
        NewsEntity newsEntity = getNewsEntity();
        deadCode.addNews(newsEntity);
        NewsEntity news = deadCode.getNews("Chào ngày mới");
        System.out.println(news);
    }

    private String getCateName() {
        return "Tin mới";
    }

    private static NewsEntity getNewsEntity() {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setTitle("Chào ngày mới");
        newsEntity.setDescription("không có gì");
        return newsEntity;
    }

    //unused class
    public class StringUtil {

        public String rename(String name) {
            return name.replace(" ", "");
        }
    }

    //inline class
    public static class Category {

        private String source;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getCateName() {
            return "tin mới";
        }
    }


    public static class NewsEntity {
        private String title;
        private String description;
        private Category category;

        public NewsEntity() {
            category = new Category();
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

        public String getCateName(){
            return category.getCateName();
        }
    }

    //Collapse hierarchy
    public static class InternationalNews extends NewsEntity{
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
