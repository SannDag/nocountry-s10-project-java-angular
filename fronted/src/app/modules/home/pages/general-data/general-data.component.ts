import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Title } from 'src/app/models/title';

@Component({
  selector: 'app-general-data',
  templateUrl: './general-data.component.html',
  styleUrls: ['./general-data.component.scss']
})
export class GeneralDataComponent {
  panelColor = new FormControl('red');
  tiles: Title[] = [

    {text: 'Two', cols: 1, rows: 4, color: 'lightgreen'},

    {text: 'Six', cols: 2, rows: 1, color: 'white'},
    {text: 'Five', cols: 2, rows: 1, color: 'lightblue'},
    {text: 'One', cols: 0.5, rows: 1, color: 'lightblue'},
    {text: 'Three', cols: 0.5, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 0.5, rows: 1, color: '#DDBDF1'},
    {text: 'Six', cols: 2, rows: 1, color: 'white'},
    {text: 'Five', cols: 2, rows: 1, color: 'lightblue'},
  ];
}
