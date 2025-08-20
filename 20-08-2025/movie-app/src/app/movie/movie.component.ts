import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';   // needed for *ngFor, *ngIf
import { MovieService } from '../movie.service';
import { Movie } from '../movie';

@Component({
  selector: 'app-movie',
  standalone: true,          // ⚡ standalone component
  imports: [FormsModule, CommonModule],  // 👈 important
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent {
  movies: Movie[] = [];
  newMovie: Movie = { movieId: 0, movieName: '', language: '', imdbRating: 0 };
  editMode: boolean = false;

  constructor(private movieService: MovieService) {}

  ngOnInit() {
    this.loadMovies();
  }

  loadMovies() {
    this.movies = this.movieService.getMovies();
  }

  addMovie() {
    if (!this.editMode) {
      this.movieService.addMovie({ ...this.newMovie });
    } else {
      this.movieService.updateMovie({ ...this.newMovie });
      this.editMode = false;
    }
    this.newMovie = { movieId: 0, movieName: '', language: '', imdbRating: 0 };
    this.loadMovies();
  }

  editMovie(movie: Movie) {
    this.newMovie = { ...movie };
    this.editMode = true;
  }

  deleteMovie(id: number) {
    this.movieService.deleteMovie(id);
    this.loadMovies();
  }
}
