import {Component, HostListener, OnInit} from '@angular/core';
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  pageYoffSet: number = 0;



  constructor(private scroll: ViewportScroller) { }

  ngOnInit(): void {
  }
@HostListener('window:scroll', ['$event']) onScroll(){
    this.pageYoffSet = window.pageYOffset;
}


  scrollToTop() {
    this.scroll.scrollToPosition([0,0])
  }
}
