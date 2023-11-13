package com.example.mostri_in_tasca.Profile;

public class UserProfileModel {
    private String username;
    private Integer lifePoints;
    private Integer experiencePoints;

    public UserProfileModel (String username, Integer lifePoints, Integer experiencePoints) {
        this.username = username;
        this.lifePoints = (lifePoints);
        this.experiencePoints = (experiencePoints);
    }

    public String getUsername() {
        return username;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public String getExperiencePointsString() {
        return Integer.toString(experiencePoints) ;
    }
}
