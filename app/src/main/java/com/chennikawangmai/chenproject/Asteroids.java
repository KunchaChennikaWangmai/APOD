package com.chennikawangmai.chenproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Asteroids {
    public class links
    {@SerializedName("next")
    @Expose
    public String next;
        @SerializedName("self")
        @Expose

        public String self;


    }
    public class page
    {@SerializedName("body")
    int size;
        long total_elements;
        int total_pages;

        public int getSize() {
            return size;
        }

        public long getTotal_elements() {
            return total_elements;
        }

        public int getTotal_pages() {
            return total_pages;
        }
    }

    @SerializedName("links")
    public links link;
    @SerializedName("page")
    public  page Page;
    @SerializedName("near_earth_objects")
    public List<near_earth_objects> nearEarthObjects;
    public String getNext() {
        return link.next;
    }

    public String getSelf() {
        return link.self;
    }

}
