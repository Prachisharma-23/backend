package com.example.moodtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moodtracker.entity.Mood;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
}

