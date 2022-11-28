use furamaresort;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
-- Lấy theo tên
select * 
from nhan_vien
where (ho_va_ten like '% h%' or ho_va_ten like '% t%' or ho_va_ten like '% k%') and char_length(ho_va_ten)<=15;
-- Lấy theo họ
select * 
from nhan_vien
where (ho_va_ten like 'h%' or ho_va_ten like 't%' or ho_va_ten like 'k%') and char_length(ho_va_ten)<=15;
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * 
from khach_hang 
where (timestampdiff(year,ngay_sinh,curdate()) between 18 and 50) and (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.ma_khach_hang,kh.ho_va_ten,count(hd.ma_khach_hang) as tong_so_lan
from khach_hang kh join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang 
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
where lk.ten_loai_khach ='Diamond'
group by kh.ma_khach_hang,kh.ho_va_ten
order by tong_so_lan;
-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang,kh.ho_va_ten,lk.ten_loai_khach,hd.ma_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,dv.chi_phi_thue + hdct.so_luong*dvdk.gia as tong_tien
from khach_hang kh  join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach 
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang   
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu 
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong  
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
order by kh.ma_khach_hang;
-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select dv.ma_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where not exists (
select * 
from hop_dong hd  
where hd.ma_dich_vu = dv.ma_dich_vu and (hd.ngay_lam_hop_dong  between '2021-01-01' and '2021-03-31')
);
-- 7.Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select dv.ma_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.so_nguoi_toi_da,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
-- join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where 
-- (hd.ngay_lam_hop_dong between '2020-01-01' and '2020-12-31') and (hd.ngay_lam_hop_dong  not between '2021-01-01' and '2021-12-31')
 exists (select 1
from hop_dong hd
where hd.ma_dich_vu = dv.ma_dich_vu and (year(ngay_lam_hop_dong)=2020))
 and 
 not exists(
select 1
from hop_dong hd
where hd.ma_dich_vu = dv.ma_dich_vu and (year(ngay_lam_hop_dong)=2021)
);
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
select  distinct(ho_va_ten) from khach_hang;
select  ho_va_ten from khach_hang union select  ho_va_ten from khach_hang;
select  ho_va_ten from khach_hang group by ho_va_ten;
-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as thang, count(kh.ma_khach_hang) as so_luong_khach_hang
from hop_dong hd join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang 
where year(ngay_lam_hop_dong)=2021
group by thang
order by thang;
-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem)
select hd.ma_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc,sum(hdct.so_luong) as so_luong_dich_di_kem
from hop_dong hd left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong 
group by hd.ma_hop_dong
order by hd.ma_hop_dong;
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dvdk.ma_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem
from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
where lk.ten_loai_khach = 'Diamond' and (kh.dia_chi like '%Vinh%' or kh.dia_chi like '%Quảng Ngãi%'); 
-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hd.ma_hop_dong,nv.ho_va_ten as ho_ten_nhan_vien,kh.ho_va_ten as ho_ten_khach_hang,kh.so_dien_thoai,dv.ma_dich_Vu,dv.ten_dich_vu,sum(hdct.so_luong)as so_luong_dich_vu_di_kem,
hd.tien_dat_coc
from hop_dong hd
join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
where (hd.ngay_lam_hop_dong between '2020-09-01' and '2020-12-31') and (hd.ngay_lam_hop_dong not between '2021-01-01' and '2021-06-30' )
group by ma_hop_dong;
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau
select dvdk.ma_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as tong_so_luong
from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct using(ma_dich_vu_di_kem)
group by dvdk.ma_dich_vu_di_kem
having tong_so_luong >=( select sum(hdct.so_luong)from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct using(ma_dich_vu_di_kem)
group by dvdk.ma_dich_vu_di_kem
order by sum(hdct.so_luong) desc
limit 1);
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select hd.ma_hop_dong,ldv.ten_loai_dich_vu,dvdk.ten_dich_vu_di_kem,count(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong hd join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
join hop_dong_chi_tiet hdct on  hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having so_lan_su_dung =1
order by hd.ma_hop_dong;
-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, 
-- dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021
select nv.ma_nhan_vien,nv.ho_va_ten,td.ten_trinh_do,bp.ten_bo_phan,nv.so_dien_thoai,nv.dia_chi
from nhan_vien nv
join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
group by hd.ma_nhan_vien
having count(hd.ma_hop_dong) <=3
order by nv.ma_nhan_vien;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021
-- cach1
select * 
from nhan_vien nv 
left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where (year(hd.ngay_lam_hop_dong) not between 2019 and 2021) or hd.ma_hop_dong is null
order by nv.ma_nhan_vien;
-- cach2
delete
from nhan_vien nv 
where nv.ma_nhan_vien  not in (select ma_nhan_vien from hop_dong where year(ngay_lam_hop_dong)  between 2019 and 2021 group by ma_nhan_vien);
-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ
update khach_hang 
set ma_loai_khach=1
where ma_khach_hang in (select tmp.ma_khach_hang from (select kh.ma_khach_hang
from khach_hang kh
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu 
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
where (kh.ma_loai_khach =2) and (year(hd.ngay_lam_hop_dong)=2021)
group by kh.ma_khach_hang
having sum(dv.chi_phi_thue + hdct.so_luong*dvdk.gia) >10000000) tmp);
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
delete from khach_hang kh
where kh.ma_khach_hang in
(select ma_khach_hang from hop_dong 
where year(ngay_lam_hop_dong)<2021);
-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi
update dich_vu_di_kem dvdk
set dvdk.gia = dvdk.gia* 2
where dvdk.ma_dich_vu_di_kem in( select tmp.ma_dich_vu_di_kem from (select dvdk.ma_dich_vu_di_kem
from hop_dong hd 
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong)=2020
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong)>=10) tmp
);
-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_nhan_vien as id, ho_va_ten, email,so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union all
select ma_khach_hang as id, ho_va_ten, email,so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;