package com.example.leaderboard.controllers;

import java.util.List;

import com.example.leaderboard.models.Score;
import com.example.leaderboard.repositories.ScoreRepo;
import com.example.leaderboard.services.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Leaderboard")
public class ScoreController 
{
    @Autowired
    ScoreRepo repo;
    
    @Autowired
    ScoreService scoreService;

    @GetMapping("/score")
    public List<Score> getScoreList() {
        return scoreService.getScoreList();
    }

    @PostMapping("/score")
    public Score addScore(@RequestBody Score score) {
        return scoreService.addScore(score);
    }

    @PutMapping("/score/{id}")
    public Score editPerson(@RequestBody Score score, @PathVariable int id) {
        return scoreService.editScore(score, id);
    }

    @DeleteMapping("/score/{id}")
    public void deletePerson(@PathVariable int id) {
        scoreService.deleteScore(id);
    }

   
}