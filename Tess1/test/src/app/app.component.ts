import { Component } from '@angular/core';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'test';
  text: string = '';

  coppyText() {
    navigator.clipboard.writeText(this.text)
      .then(() => {
        Swal.fire({
          position: 'top',
          icon: 'success',
          title: 'Đã sao chép',
          showConfirmButton: false,
          timer: 1500
        })      })
      .catch(err => {
        Swal.fire({
          icon: 'error',
          title: 'Sao chép thất bại',
        })
      });
  }
}
