Tên: Phạm Đình Quý

Lớp: 17IT2

Đề số: 11

Câu 1: WindowsExplorer

Câu 2: Chức năng: Tạo thư mục mới.

Chức năng làm thêm: Mở, xóa, di chuyển, copy và xem thông tin tập tin/thư mục.

-Video hương dẫn sử dụng: https://www.youtube.com/watch?v=838bUd9vx3A&feature=youtu.be

CÁCH CHẠY CODE:

Tải project từ github

Mở cmd

Dùng lệnh cd chuyển đến thư mục chưa source code

Ví dụ: cd C:\Users\Administrator\Desktop\thigiuaki2\src
Biên dịch bằng lệnh javac:

javac thigiuaki2\FileExplorer.java
Chạy bằng lệnh java:

java thigiuaki2.FileExplorer
HƯỚNG DẪN SỬ DỤNG:

Mở các thư mục bằng cách click 2 lần vào thư mục trong JTree

Chức năng chính:

Tạo tập tin mới:

Đầu tiên: Click vào "CreateNewFile"

Tiếp theo: Gõ tên và định dạng cho tập tin cần tạo

Sau đó: Nhấn "OK"

Chức năng làm thêm:

Mở tập tin:

Chọn tập tin cần mở

Sau đó: click vào "OpenFile"

Biên dịch các dòng lệnh:

public Container getGui():

Hiển thị các thành phần và chức năng của phần mềm
public void showRootFile():

Hiển thị các tệp lên jtree và jtable từ lớp FileTableModel.
private void showErrorMessage():

Hàm dùng để hiển thị tin nhắn báo lỗi
private void setTableData(final File[] files):

Dùng để cài đặt dự liệu cho table
private void setColumnWidth(int column, int width):

Dùng để cài đặt kích cỡ cho table
private void showChildren(final DefaultMutableTreeNode node):

Hiển thị các cành con của Tree
private void setFileDetails(File file):

Cài đặt thông tin cho file
class FileTableModel extends AbstractTableModel

Thực hiện chứ năng hiển thị các cột thông tin lên Table
public Component getTreeCellRendererComponent():

Thực hiện chức năng cài đặt icon, tên file và lấy đường dẫn cho các Node của JTree
public Object getValueAt(int row, int column):

Thực hiện chức năng cài đặt thông tin cho các file
private void newFile():

Thực hiện chức năng tạo mới tập tin.
Button openFile:

Thực hiện chức năng mở tập tin.

