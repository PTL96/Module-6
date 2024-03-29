import {Component, HostListener, OnInit} from '@angular/core';
import {OderService} from "../../service/oder.service";
import {TokenStorageService} from "../../service/security/token-storage.service";
import {HistoryDto} from "../../entity/history-dto";
import {ViewportScroller} from "@angular/common";
import {ShareService} from "../../service/security/share.service";

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  idAccount: any;
  historyDto: HistoryDto[] = [];
  p=0;
  pageYoffSet = 0;
  constructor(private oderService: OderService,
              private tokenStorageService: TokenStorageService,
              private shareService:ShareService) {
    this.shareService.getClickEvent()
  }


  ngOnInit(): void {
    if (this.tokenStorageService.getToken()) {
      this.idAccount = this.tokenStorageService.getIdAccount()
      console.log(this.idAccount)
    }
    this.shareService.getClickEvent().subscribe(next => {
      this.getAllHistory();
    })
    this.getAllHistory();
    window.scrollTo(0,530)
  }

  getAllHistory() {
    this.oderService.getAllHistory(this.idAccount).subscribe(data => {
      this.historyDto = data;
      console.log(data)
    })
    this.shareService.sendClickEvent()
  }



  @HostListener('window:scroll', ['$event']) onScroll() {
    this.pageYoffSet = window.pageYOffset;
  }

  scrollProductBack() {
    window.scrollTo(0, 690)
  }
}
