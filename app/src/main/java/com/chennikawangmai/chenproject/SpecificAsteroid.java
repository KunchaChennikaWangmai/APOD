package com.chennikawangmai.chenproject;

import com.google.gson.annotations.SerializedName;

public class SpecificAsteroid {

    public class links
{
    public String self;
}
    @SerializedName("id")
    public String idi;public Long neo_reference_id;
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
        @SerializedName("kilometers")
        public kilometers k;

    }
    @SerializedName("estimated_diameter")
    public estimated_diameter estimatedDiameter;

    Boolean is_potentially_hazardous_asteroid;
    public class close_approach_data{
       String close_approach_date;
       String close_approach_date_full;
        long  epoch_date_close_approach;
         public class relative_velocity {
             String kilometers_per_second;
             String kilometers_per_hour;
             String miles_per_hour;
        }
        public class  miss_distance {
         String  astronomical;
         String lunar;
         String kilometers;
         String miles;
        }
    String orbiting_body ;

    }
}
/*   {
  "links": {
    "self": "http://www.neowsapp.com/rest/v1/neo/3478348?api_key=DEMO_KEY"
  },
  "id": "3478348",
  "neo_reference_id": "3478348",
  "name": "(2009 WA52)",
  "designation": "2009 WA52",
  "nasa_jpl_url": "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3478348",
  "absolute_magnitude_h": 26.3,
  "estimated_diameter": {
    "kilometers": {
      "estimated_diameter_min": 0.0146067964,
      "estimated_diameter_max": 0.0326617897
    },
    "meters": {
      "estimated_diameter_min": 14.6067964271,
      "estimated_diameter_max": 32.6617897446
    },
    "miles": {
      "estimated_diameter_min": 0.0090762397,
      "estimated_diameter_max": 0.020295089
    },
    "feet": {
      "estimated_diameter_min": 47.92256199,
      "estimated_diameter_max": 107.1581062656
    }
  },
  "is_potentially_hazardous_asteroid": false,
  "close_approach_data": [
    {
      "close_approach_date": "2009-12-05",
      "close_approach_date_full": "2009-Dec-05 04:12",
      "epoch_date_close_approach": 1259986320000,
      "relative_velocity": {
        "kilometers_per_second": "8.598383377",
        "kilometers_per_hour": "30954.1801570906",
        "miles_per_hour": "19233.7237759433"
      },
      "miss_distance": {
        "astronomical": "0.021237339",
        "lunar": "8.261324871",
        "kilometers": "3177060.67886793",
        "miles": "1974133.964040234"
      },
      "orbiting_body": "Earth"
    }
  ],
  "orbital_data": {
    "orbit_id": "8",
    "orbit_determination_date": "2017-04-06 08:58:59",
    "first_observation_date": "2009-11-22",
    "last_observation_date": "2009-12-01",
    "data_arc_in_days": 9,
    "observations_used": 43,
    "orbit_uncertainty": "8",
    "minimum_orbit_intersection": ".00257368",
    "jupiter_tisserand_invariant": "3.924",
    "epoch_osculation": "2455159.5",
    "eccentricity": ".4754273113756286",
    "semi_major_axis": "1.80109738362075",
    "inclination": "1.789081962231787",
    "ascending_node_longitude": "253.3990322229958",
    "orbital_period": "882.885165805141",
    "perihelion_distance": ".9448064970002573",
    "perihelion_argument": "213.9984905321241",
    "aphelion_distance": "2.657388270241242",
    "perihelion_time": "2455197.248213965316",
    "mean_anomaly": "344.6080129626812",
    "mean_motion": ".4077540476871649",
    "equinox": "J2000",
    "orbit_class": {
      "orbit_class_type": "APO",
      "orbit_class_description": "Near-Earth asteroid orbits which cross the Earth’s orbit similar to that of 1862 Apollo",
      "orbit_class_range": "a (semi-major axis) > 1.0 AU; q (perihelion) < 1.017 AU"
    }
  },
  "is_sentry_object": false
}
 */