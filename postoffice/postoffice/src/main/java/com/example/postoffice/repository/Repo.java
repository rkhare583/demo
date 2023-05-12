package com.example.postoffice.repository;

import com.example.postoffice.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<PostEntity, String>{
}
