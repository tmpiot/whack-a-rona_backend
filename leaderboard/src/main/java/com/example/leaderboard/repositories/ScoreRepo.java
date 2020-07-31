package com.example.leaderboard.repositories;

import com.example.leaderboard.models.Score;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScoreRepo extends CrudRepository<Score, Integer> {
    List<Score> findAllByOrderByIdAsc();
    Score findOneById(int id);
}