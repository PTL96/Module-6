import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Category} from "../../entity/category";
import {Product} from "../../entity/product";
import {ProductService} from "../../service/product.service";
import {CategoryService} from "../../service/category.service";
import {ToastrService} from "ngx-toastr";
import {AngularFireStorage} from "@angular/fire/storage";
import {finalize} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'app-shoe-create',
  templateUrl: './shoe-create.component.html',
  styleUrls: ['./shoe-create.component.css'],
})
export class ShoeCreateComponent implements OnInit {

  category: Category[] = [];
  selectedImage: any = null;
  selectedFileUrl: any;
  createForm: FormGroup = new FormGroup({
    productId: new FormControl(),
    productName: new FormControl(),
    description: new FormControl(),
    price: new FormControl(),
    avatar: new FormControl(),
    flagDelete: new FormControl(),
    category: new FormControl(),
  });

  constructor(private storage: AngularFireStorage,
              private productService: ProductService,
              private categoryService: CategoryService,
              private toast: ToastrService,
              private  router: Router) {
    this.categoryService.getAll().subscribe(data => {
      this.category = data;
    });

  }

  ngOnInit(): void {
    window.scrollTo(0,600)
  }

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
    const reader = new FileReader();
    reader.onload = () => {
      this.selectedFileUrl = reader.result as string;
    };
    reader.readAsDataURL(this.selectedImage);
  }

  createProduct() {
    const nameImg = this.selectedImage.name;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
          this.createForm.controls.avatar.setValue('');
          this.createForm.controls.avatar.markAsTouched();
          this.createForm.controls.avatar.updateValueAndValidity();
          const product = {
            ...this.createForm.value,
            avatar: url
          };
          console.log(url)
          this.productService.save(product).subscribe(ok => {


            this.createForm.reset();
          });
        });
      })
    ).subscribe(url => {
      if (url) {
        console.log(url)
      }
    });
  }

}
