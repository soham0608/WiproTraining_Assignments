import { Injectable } from '@angular/core';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private movies: Movie[] = [
    { movieId: 1, movieName: 'Inception', language: 'English', imdbRating: 8.8 },
    { movieId: 2, movieName: '3 Idiots', language: 'Hindi', imdbRating: 8.4 },
  ];

  getMovies(): Movie[] {
    return this.movies;
  }

  addMovie(movie: Movie) {
    this.movies.push(movie);
  }

  updateMovie(movie: Movie) {
    const index = this.movies.findIndex(m => m.movieId === movie.movieId);
    if (index !== -1) {
      this.movies[index] = movie;
    }
  }

  deleteMovie(id: number) {
    this.movies = this.movies.filter(m => m.movieId !== id);
  }
}
