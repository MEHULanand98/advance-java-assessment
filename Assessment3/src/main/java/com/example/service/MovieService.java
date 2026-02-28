package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Movie;
import com.example.repository.MovieRepository;

@Service
public class MovieService {
	private MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}
	public Movie getMovieById(int id) {
		return movieRepository.findById(id).orElse(null);
	}
	public void deleteMovie(int id) {
		movieRepository.deleteById(id);
	}
}
