package com.example.moodtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moodtracker.entity.Mood;
import com.example.moodtracker.repository.MoodRepository;

@CrossOrigin(origins = "https://mood-tracker-prachi-sharmas-projects-48fa5fdc.vercel.app") // ✅ allows frontend requests
@RestController
@RequestMapping("/api/moods")
public class MoodController {

    @Autowired
    private MoodRepository moodRepository;

    @GetMapping
    public List<Mood> getAllMoods() {
        return moodRepository.findAll();
    }

    @SuppressWarnings("null")
    @PostMapping
    public Mood addMood(@RequestBody Mood mood) {
        return moodRepository.save(mood);
    }
}

