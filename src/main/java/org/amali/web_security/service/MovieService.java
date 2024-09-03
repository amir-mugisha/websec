package org.amali.web_security.service;

import org.amali.web_security.dto.MovieDto;
import org.amali.web_security.model.Movie;
import org.amali.web_security.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setName(movieDto.getName());
        movie.setGenre(movieDto.getGenre());
        movie.setYear(movieDto.getYear());
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        return movieOptional.orElse(null); // or throw an exception
    }
}
