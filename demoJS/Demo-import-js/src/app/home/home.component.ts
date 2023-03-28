import {AfterViewInit, Component, OnInit} from '@angular/core';
declare var $: any;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {

  constructor() { }

  ngAfterViewInit() {
    $(document).ready(function(){
      var count_group = $(".list .item").length;
      var active = 0;
      var deg_bg = 0;
      var begin= true;
      function Load(){
        // ...
      }
      Load();

      $('#next').on('click', function(){
        active = active + 1 >= count_group ? 0 : active + 1;
        Load();
      })
      $('#prev').on('click', function(){
        active = active - 1 < 0 ? count_group - 1 : active - 1;
      })
    });
    $('.button').hover(function(){
        // ...
      }
      ,function(){
        beginPosition();
      });

    function beginPosition(){
      // ...
    }

    $('.item').hover(function(){
      // ...
    }, function(){
      beginPosition();
    });
  }
}
