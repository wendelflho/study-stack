import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ShoppingListComponent } from './feature/shopping-list/shopping-list.component';
import { HeaderComponent } from './feature/header/header.component';
import { RecipeComponent } from './feature/recipe/recipe.component';
import { RecipeListComponent } from './feature/recipe/recipe-list/recipe-list.component';
import { RecipeDetailComponent } from './feature/recipe/recipe-detail/recipe-detail.component';
import { RecipeItemComponent } from './feature/recipe/recipe-list/recipe-item/recipe-item.component';
import { ShoppingEditComponent } from './feature/shopping-list/shopping-edit/shopping-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ShoppingListComponent,
    HeaderComponent,
    RecipeComponent,
    RecipeListComponent,
    RecipeDetailComponent,
    RecipeItemComponent,
    ShoppingEditComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
