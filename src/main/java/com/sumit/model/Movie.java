package com.sumit.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.sumit.common.Rating;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@JsonAutoDetect
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date releaseDate;
    private Rating mpaaRating;
    private Integer runtime;

    @OneToMany(mappedBy = "movie")
    private Collection<CastMember> castMembers;

    public Collection<CastMember> getCast() {
        return castMembers;
    }

    public void setCast(Collection<CastMember> cast) {
        this.castMembers = cast;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Rating getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(Rating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
}
