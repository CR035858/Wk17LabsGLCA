package com.gl.tdms.labwk17d01dem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.tdms.labwk17d01dem1.entity.TeacherDetails;


public interface TeacherRepository extends JpaRepository<TeacherDetails, Integer> {

}
