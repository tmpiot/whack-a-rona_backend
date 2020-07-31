package com.example.leaderboard.services;

import java.util.List;

import com.example.leaderboard.models.Score;
import com.example.leaderboard.repositories.ScoreRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepo scoreRepo;


    public List<Score> getScoreList(){
        return scoreRepo.findAllByOrderByIdAsc();
    }

    public Score addScore(Score score) {
        String userName = score.getUserName().trim();
        if (!userName.equals("")) {
            Score newScore = new Score(score.getUserName(), score.getScore());
            return(scoreRepo.save(newScore));
        }
        else{
            return new Score(-1);
            }
    }

    public Score editScore(Score score, int id) {
        String userName = score.getUserName().trim();
        int userScore = score.getScore();

        if (!userName.equals(null)){
            Score savedScore = scoreRepo.findOneById(id);
            savedScore.setUserName(userName);
            savedScore.setScore(userScore);
            return(scoreRepo.save(savedScore));
        } else {
            return new Score(-1);
        }      
    }

    public void deleteScore(int id) {
        scoreRepo.deleteById(id);
    }

}