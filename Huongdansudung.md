Họ và tên sinh viên: Phạm Đình Quý
Lớp 17IT2 - Java Nâng cao (2)
Mã SV: 17IT092
Email: phdinhquy@gmail.com
Mã đề: 11
Nội dung hướng dẫn:
Lời đầu tiên, em xin cảm ơn thầy đã đến với chương trình Windows Explorer – bài thi giữa kỳ môn Java nâng cao của sinh viên Phạm Đình Quý – Lớp Java Nâng cao (2).
Để chương trình của em có thể chạy hoàn chỉnh, vui lòng Thầy làm theo các bước sau.
Trong link bài em nộp sẽ có 4 file, Thầy có thể load về máy tính của thầy đủ cả 4 hoặc có thể ít hơn, tuy nhiên file TreeInJava.java và LibraryBonus.rar thì phải load về để chương trình của em có thể chạy tốt, 4 file đó là: 
File TreeInJava.java là đoạn code em viết để thực hiện chương trình trên
File Huongdansudung.md là file Thầy đang đọc
File LibraryBonus.rar là file chứa thêm các thư viện, hình ảnh em immport vào để hỗ trợ đoạn chương trình em đã viết.
File README.md chứa đề bài của bài thi.
Đầu tiên Thầy giải nén file LibraryBonus.rar thì sẽ được 1 file commons-io-2.6.jar và 1 thư mục Images.
Sau đó, thầy mở chương trình Eclipse, tạo mới 1 Java Project bằng cách vào menu File, chọn New, chọn Java Project hoặc nhấn tổ hợp phím Ctrl + Shift + N. Sau đó cửa sổ mới (New Java Project) xuất hiện. Tại trường Project Name: Nhập MidTest. Bỏ dấu tick trong tùy chọn Use default location. Tại nút Browser Thầy chỉ đến nơi lưu project. Ví dụ: E:\MidTestJava và sau đó nhấn nút Finish để hoàn thành bước này.
Sau đó tại trường Navigator, Click chuột phải vào Java Project MidTest. Chọn New Chọn Package. Một cửa sổ mới (New Java Package) xuất hiện. Tại trường Name, điền vào ô trống đó có nội dung sau: windowsExplorer và sau đó nhấn nút Finish.
Bước tiếp theo, cũng  tại trường Navigator, Click chuột phải vào windowsExplorer . Chọn New Jframe (Nếu không có, chọn Other/WindowsBuilder/Swing Designer/Jframe). Một cửa sổ mới (New Java Package) xuất hiện. Tại trường Name, điền vào ô trống đó có nội dung sau: TreeInJava và sau đó nhấn nút Finish.
Tiếp theo, trong thư mục giải nén được ở trên, copy các file trong thư mục Images dán trực tiếp vào thư mục cùng cấp lưu trữ Java Project. Ví dụ: Dán trực tiếp vào: This PC\E:\MidTestJava.
Quay lại Eclipse, click chuột phải vào MidTest trong trường Navigator chọn Properties, Chọn Java Build Path, Chọn Libraries, Chọn Add External JARs, sau đó chỉ đến file commons-io-2.6.jar đã giải nén ban đầu. Sau đó chọn Apply and Close.
Mở Class TreeInJava.java lên, sau đó copy toàn bộ đoạn code trong file TreeInJava.java download về được, dán vào class này. Và sau đó chạy Class này để thực thi chương trình.
Giao diện cơ bản của chương trình Windows Explorer sau khi chạy:
Bên tay trái là cây thư mục liệt kê tất cả các tài nguyên của máy: các ổ đĩa, thư mục. Bên tay phải là các thư mực, tập tin tương ứng khi click vào thư mục trong cây thư mục bên. Phía trên là các nút chức năng như Lùi lại thư mục qua, hay Bước đến thư mục mình đã hủy trước đó, ngoài ra còn thông tin đường dẫn đến thư mục hay tập tin đang chọn, cũng như ô tìm kiếm kế bên.
+ Click trái vào dấu (+) đứng trước một đối tượng thì trong cây thư mục sẽ hiện tiếp các thư mục con của đối tượng này. 
+ Click trái vào dấu (-) đứng trước một đối tượng thì trong cây thư mục sẽ được ẩn.
Khi click các thư mục tương ứng thì thanh địa chỉ ở trên cũng sẽ thể hiện vị trí con trỏ chuột đang ở thư mục nào.
Cũng từ đây, có thể lùi lại thư mục trước đó, hoặc đi tới 1 thư mục đã đi trước đó thông qua 2 nút chức năng có hình ảnh mũi tên thể hiện.
Tại của sổ bên tay phải, có thể mở 1 thư mục hay tập tin bằng cách click chuột đôi và thư mục hay tập tin tương ứng.
Có thể click chuột phải lên thư mục hoặc tập tin hoặc khoảng trống bên cửa sổ tay phải để sổ menu con chức năng ra như Cut, Copy, Paste, Delete, New Folder hoặc Properties. Tương ứng các chức năng trên sẽ thực hiện các chức năng đó. Như: Cut là di chuyển thư mực hay tập tin, Copy là sao chép, Paste là dán, Delete là xóa và Properties xem thông tin thư mục hay file đó.
Các chức năng có trong chương trình: 
Chức năng chính để thi câu 2 của đề thi: Tạo mới 1 thư mục.
Sau khi mở các thư mục, xác định được vị trí đặt thư mục mới thì click chuột phải vào khoản trống bên của sổ bên phải, chọn New Folder, 1 của sổ thông báo (Input) xuất hiện. Tại trường: Input name of folder, nhập tên thư mục cần tạo mới, sau đó nhấn OK để chương trình thực thi, hoặc nhấn Cancel nếu muốn hủy thao tác trên. Và thư mục tương sẽ được tạo ra ngay trong trường trống bên tay phải của chương trình.
Chức năng thêm:
1.	Di chuyển thư mục hay tập tin: Click chuột phải vào thư mục nguồn hay tập tin muốn di chuyển, chọn Cut, Sau đó di chuyển đến thư mục đích và click chuột phải, chọn Paste.
2.	Sao chép thư mục hay tập tin: Click chuột phải vào thư mục nguồn hay tập tin muốn sao chép, chọn Copy. Sau đó di chuyển đến thư mục đích và click chuột phải, chọn Paste.
3.	Xóa thư mục hay tập tin: Click chuột phải vào thư mục hay tập tin muốn xóa, chọn Delete. Hộp thoại Select an Option xác nhận xóa xuất hiện với dòng thông báo: Are you sure want to delete [tên file hay thư mục cần xóa]? Chọn Yes để xóa, No hay Cancel để Hủy thao tác này. Sau khi xóa thành công, sẽ xuất hiện 1 thông báo: Message: Delete Successfully.
4.	Xem thông tin của thư mục hay tập tin: Click chuột phải vào thư mục hay tập tin muốn xem thông tin, chọn Properties. Hộp thọa Properties xuất hiện cũng với các thông tin về file hay folder cần xem.
