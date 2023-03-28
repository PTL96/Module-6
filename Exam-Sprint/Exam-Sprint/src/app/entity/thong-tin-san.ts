import {KhuVuc} from "./khu-vuc";
import {LoaiSan} from "./loai-san";

export interface ThongTinSan {
  id?: number
  khuVuc?: KhuVuc;
  loaiSans?: LoaiSan;
  khungGio?: string;
  giaThue?: number;
}
