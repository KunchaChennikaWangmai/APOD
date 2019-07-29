package com.chennikawangmai.chenproject;

public class near_earth_objects {
    public class linlks
    {
        public String self;
    }

    public String id;public Long neo_reference_id;
    public String name;
    public String designation;
    public String nasa_jpl_url;
    public Double absolute_magnitude_h;
    public class estimated_diameter
    {
        public class kilometers
        {
            public Double estimated_diameter_min;
            public Double estimated_diameter_max;
        }
        public class meters
        {
            public Double estimated_diameter_min;
            public Double estimated_diameter_max;
        }
        public class miles
        {
            public Double estimated_diameter_min;
            public Double estimated_diameter_max;
        }
        public class feet
        {
            public Double estimated_diameter_min;
            public Double estimated_diameter_max;
        }
    }
    public  estimated_diameter estimatedDiameter;
    Boolean is_potentially_hazardous_asteroid;
    public  estimated_diameter.kilometers Kilometers;
}
