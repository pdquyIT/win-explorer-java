Tên: Phạm Đình Quý

Lớp: 17IT2

Đề số: 11

Câu 1: WindowsExplorer

Câu 2: Chức năng: Tạo thư mục mới.

Chức năng làm thêm: Mở, xóa, di chuyển, copy và xem thông tin tập tin/thư mục.

-Video hướng dẫn sử dụng: https://youtu.be/XrnW9vVPZaw


-------------------------------


CÁCH CHẠY CODE:

Tải project từ github

Mở cmd

Dùng lệnh cd chuyển đến thư mục chứa source code

Ví dụ: cd C:\Users\Admin\eclipse-workspace\WindowsExplorer\src


Biên dịch bằng lệnh javac:

javac FileExplorer.java


Chạy bằng lệnh java:

java FileExplorer


-------------------------------


HƯỚNG DẪN SỬ DỤNG:

Mở các thư mục bằng cách click chuột trái 1 lần vào thư mục trong JTree cũng như trong cửa sổ bên cạnh.

Chức năng chính:

Tạo mới thư mực:

Đầu tiên: Chọn nơi chứa thư mục cần tạo ở khung JTree hoặc  bên cửa sổ bên cạnh JTree chọn Nút New. 


Cửa sổ xuất hiện, chọn Directory

Tiếp theo: Gõ tên cho thư mục cần tạo  vào ô trống Name

Sau đó: Chọn Ok để xác nhận tạo thư mục mới hoặc nhấn Cancel để hủy thao tác vừa làm. 


Chức năng làm thêm:


Mở 1 tập tin hay thư mục: Click chuột trái vào thư mục hay tập tin cần mở, chọn nút Open để mở tập tin hay thư mục tương ứng đã chọn.


Đổi tên tập tin: Click chuột trái vào tập tin cần thay đổi tên, chọn nút Rename File để mở cửa sổ mới. Khi cửa sổ mới xuất hiện, ta nhập tên mới của tập tin cần thay đổi tên vào khoảng trống của ô New Name, Sau đó: Chọn Ok để xác nhận thực thi đổi tên mới cho tập tin đã chọn hoặc nhấn Cancel để hủy thao tác vừa làm.   


Xóa tập tin: Click chuột trái vào tập tin cần xóa, chọn Delete File. Một cửa sổ mới xuất hiện, để xóa tập tin đang chọn ta nhấn Ok hoặc nhấn Cancel để hủy thao tác vừa làm.   


-------------------------------


Biên dịch các dòng lệnh:



public class FileExplorer (): Hiển thị các thành phần và chức năng của phần mềm


public Container getGui(): Hiển thị giao diện của phần mềm, gồm: Khung chương trình, các thành phần cũng như các nút chức  năng của chương trình.


newFile.addActionListener(new ActionListener() Hàm thực hiện bắt sự kiện cho chức năng tạo mới tập tin hay thư mục, khi ta click vào nút.

private void newFile() Hàm thực hiện chức năng tạo mới tập tin hay thư mục


openFile.addActionListener(new ActionListener() Hàm thực hiện bắt sự kiện cho chức năng mở tập tin hay thư mục, khi ta click vào nút.


deleteFile.addActionListener(new ActionListener() Hàm thực hiện bắt sự kiện cho chức năng xóa tập tin, khi ta click vào nút.


private void deleteFile()Hàm thực hiện chức năng xóa tập tin.


remaneFile.addActionListener(new ActionListener() Hàm thực hiện bắt sự kiện cho chức năng thay đổi tên tập tin, khi ta click vào nút.


private void renameFile() Hàm thực hiện chức năng thay đổi tên tập tin
