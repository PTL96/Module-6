import {Component, OnInit} from '@angular/core';
import {BlogService} from "../../service/blog.service";
import {Blog} from "../../entity/blog/blog";

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  pageBlog: Blog[] = [];
  pageNumber: number = 0;

  constructor(private blogService: BlogService) {
    }


  ngOnInit(): void {
  this.getAllBlog()
  }
  getAllBlog(){
  this.blogService.getAllPage(this.pageNumber).subscribe(data=>{
    this.pageBlog = data.content;
    console.log(this.pageBlog)
    this.pageNumber = data.number;
  })
}

}
