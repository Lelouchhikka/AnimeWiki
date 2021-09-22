package org.itstep.exam.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

public class AnimeTitle extends BaseEntity implements GrantedAuthority {
    @Column(name = "email", unique = true)
    private String Title;

    private String Description;

    private Integer NumberOfEpisodes;

    private Integer Year;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> genres;
    @Override
    public String getAuthority() {
        return null;
    }
}
