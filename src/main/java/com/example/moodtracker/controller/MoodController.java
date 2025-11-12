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
@RestController
@RequestMapping("/api/moods")
@CrossOrigin(origins = {"https://mood-tracker-prachi-sharmas-projects-48fa5fdc.vercel.app","http://localhost:3000"}) // ✅ allows frontend requests

public class MoodController {

    @Autowired
    private MoodRepository moodRepository;

    @GetMapping
    public List<Mood> getAllMoods() {
        return moodRepository.findAll();
    }

    @PostMapping
    public Mood addMood(@RequestBody Mood mood) {
        System.out.println("🟢 Received mood: " + mood.getMood() + " - " + mood.getNote());
        return moodRepository.save(mood);
    }

  
}

