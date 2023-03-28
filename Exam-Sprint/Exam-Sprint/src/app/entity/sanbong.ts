import {KhachHang} from "./khach-hang";
import {ThongTinSan} from "./thong-tin-san";

export interface Sanbong {
  id?: number;
  tenSan?: string;
  diaChi?: string;
  khachHang?: KhachHang;
  thongTinSan?: ThongTinSan
}
