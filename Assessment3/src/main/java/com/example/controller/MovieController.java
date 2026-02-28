package com.example.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Movie;
import com.example.service.MovieService;

@Controller
public class MovieController {
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	@RequestMapping(value="/movies",method=RequestMethod.GET)
	public String getMovieDetails(Model model) {
		List<Movie> movies=movieService.getAllMovies();
		model.addAttribute("movies",movies);
		return "movie";
	}
	@GetMapping("/addMovie")
	public String addMovie(Model model) {
		model.addAttribute("movie",new Movie());
		return "addMovie";
	}
	@PostMapping("/saveMovie")
	public String saveMovie(Movie movie) {
		movieService.saveMovie(movie);
		return "redirect:/movies";
	}
	@GetMapping("/updateMovie/{id}")
	public String showEditForm(@PathVariable int id, Model model) {
		Movie movie=movieService.getMovieById(id);
		model.addAttribute("movie",movie);
		return "addMovie";
	}
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable int id) {
		movieService.deleteMovie(id);
		return "redirect:/movies";
	}
	
	
}