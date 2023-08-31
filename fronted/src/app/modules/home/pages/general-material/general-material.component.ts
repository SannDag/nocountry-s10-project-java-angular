import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Title } from 'src/app/models/title';

@Component({
  selector: 'app-general-material',
  templateUrl: './general-material.component.html',
  styleUrls: ['./general-material.component.scss']
})
export class GeneralMaterialComponent {
  panelColor = new FormControl('red');
  tiles: Title[] = [

    {text: 'Dos', cols: 1, rows: 6, color: 'lightgreen'},

    {text: 'Six', cols: 2, rows: 1, color: 'white'},
    {text: 'Cinco', cols: 2, rows: 1, color: 'lightblue'},
    {text: 'Uno', cols: 0.5, rows: 1, color: 'lightblue'},
    {text: 'Three', cols: 0.5, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 0.5, rows: 1, color: '#DDBDF1'},
    {text: 'Six', cols: 2, rows: 1, color: 'white'},
    {text: 'Five', cols: 2, rows: 1, color: 'lightblue'},
    {text: 'Seven', cols: 4, rows: 1, color: 'lightblue'},
    {text: 'One', cols: 1, rows: 1, color: 'lightblue'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'One', cols: 1, rows: 1, color: 'lightblue'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
  ];
}
