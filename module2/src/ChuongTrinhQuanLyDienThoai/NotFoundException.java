package ChuongTrinhQuanLyDienThoai;

import java.util.List;

public class NotFoundException extends Throwable {
    public NotFoundException(String s) {
        super(s);
    }
//    public static void isExistIdInPhone(List<Mobile> list, int id) throws NotFoundException {
//        if (list.stream().noneMatch(x -> x.id == id)) throw new NotFoundException("Not found id");
//    }
}
