
package com.it.music.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.it.music.entity.MusicEntity;

public interface MusicDAO extends JpaRepository<MusicEntity, Integer>{
    public MusicEntity findByNo(Integer no);
}
