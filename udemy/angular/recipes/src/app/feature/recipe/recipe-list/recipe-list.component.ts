import { Component } from '@angular/core';
import { RecipeModel } from '../recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent {
  recipes: RecipeModel[] = [
    new RecipeModel(
      'A Test Recipe',
      'This is a simply test',
      'https://img.taste.com.au/iCntbupq/w720-h480-cfill-q80/taste/2019/04/indian-lentil-and-egg-curry-148613-1.jpg'
    )
  ];
}
