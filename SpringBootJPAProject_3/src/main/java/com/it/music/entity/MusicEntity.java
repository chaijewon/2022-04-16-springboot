package com.it.music.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="music")
public class MusicEntity {
    @Id
	private int no;
    private String title,singer,album,poster,mkey;
}
