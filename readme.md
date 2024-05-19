Helu mn, lời đầu tiên, cho mình cảm ơn các bạn dã dành bỏ chút thời gian để đọc bài viết này. Hy vọng bài viết này có thể mang đến cái nhìn mới về hệ thống cho mọi người, mọi sự góp ý và câu hỏi đều rất vui lòng đón nhận . Không lằng nhằng nữa. Let’s go

## 1.Introduce – What is monolithic?
-Ngày xưa có một anh dev A, anh hằng ngày hì hục vào phát triển hệ thống bán hàng, anh miệt mài làm các chức năng đặt hàng, thanh toán, giao hàng. App anh thì khỏi chê, số lượng người dùng luôn phản ánh tích cực nhưng đến một ngày khi hệ thống đạt ngưỡng hang triệu người dùng, hệ thống đột nhiên trở nên chậm và khó triển khai, khó bảo trì. Không chỉ thế, app thường xuyên gặp lỗi và thời gian để giải quyết cũng như mò mẫm làm anh chán nản.
Lúc này, anh mới nhận ra mình đang sủ dụng **monolithic service**, nói nôm na nó là 1 cấu trúc phần mềm nguyên khối, nơi mà bạn sẽ nhồi nhéc toàn bộ service, domain database, interface vào trong cùng 1 nơi. Mọi sự thay đổi, chỉnh sửa đều thực hiện trên cùng 1 nơi . Vậy các bạn có thể thấy rõ issue ở đây là : 
 
+ Scalable (tính mở rộng): Khi tải lưu lượng truy cập tăng lên, việc mở rộng monolithic application có thể gặp phải hạn chế do phải tăng cường tài nguyên cho toàn bộ ứng dụng thay vì chỉ một phần cụ thể. Việc mở rộng cũng có thể gặp phải vấn đề về hiệu suất do kiến trúc monolithic có thể không linh hoạt trong việc tận dụng tài nguyên và phân phối tải đồng đều.

+ Maintainable ( khả năng bảo trì): Việc bảo trì có thể trở nên khó khăn do mọi thứ được tích hợp vào một ứng dụng lớn. Mỗi lần thay đổi, cải tiến hoặc sửa lỗi có thể ảnh hưởng đến toàn bộ hệ thống, làm tăng nguy cơ gây ra lỗi không mong muốn. Việc phát triển và triển khai các tính năng mới cũng có thể trở nên đắt đỏ và phức tạp do phải thay đổi trong mã nguồn lớn và phải kiểm thử toàn bộ ứng dụng.

+ Code reuseable ( tái sử dụng): Trong monolithic architecture, việc tái sử dụng mã có thể bị hạn chế do mã được viết cho một ứng dụng cụ thể và không dễ dàng phân chia hoặc tái sử dụng cho các dự án khác.

+ Long development (thời gian phát triển dài): Kiến trúc monolithic có thể dẫn đến thời gian phát triển dài do tính phức tạp của việc phát triển, kiểm thử và triển khai toàn bộ ứng dụng.

+ Potential risk ( nguy cơ tiềm ẩn): Network, system ,… . Tất nhiên nó có thể giải quyết 1 phần từ việc deployment nhiều instances nhưng mình sẽ không đi sâu về cái này

+ Integrable(khả năng tích hợp nhiều công nghệ): Bạn có thể mường tượng bạn có 1 đống feature, ví dụ chức năng  A thì golang hỗ trợ rất tốt nhưng hệ thống bạn phải dùng .net.

## 2. Microservice là gì ?
Ok đi sơ một vài disadvantage vậy thui ha, vậy thì câu hỏi đăt ra là làm sao giải quyết bài toán này ? Như 1 bậc hiền nhân đã nói:
>  Gặp cái nào khó thì mình băm nhỏ nó ra.

 Bạn có lẽ sẽ gặp câu này khi làm về các bài toán dynamic programming, microservice cũng như vậy nhưng cái nó chia là **system** 😊.

> Microservice =  micro + service ( hệ thống vi mô) hiểu nôm na là gồm nhiều hệ thống nhỏ và độc lập có thể hoạt động độc lập, được phát triển và triển khai một cách độc lập không dính dáng gì tới nhau và giao tiếp với nhau thông qua restful api, message queues, rpc ( remote procedure call) , async communication ,… Còn về cách chúng giao tiếp như thế nào thì mình sẽ có 1 bài viết về service discovery sử dụng eureka, một thành phần của Netflix oss.

Có 1 lưu ý nhỏ, trong kiến trúc miroservice, có 1 vài bạn sẽ nghĩ là chúng ta sẽ tiến hành expose một grained endpoint tương ứng với từng microservice. Không nha, chúng ta sẽ dùng ** API gateway** (sẽ có ở bài viết sau, mình sẽ không đi sâu trong bài viết này).
 
Tổng hợp lại, sự khác nhau giữa 2 kiến trúc sẽ được thể hiện ở mô hình dưới đây:  
Như các bạn thấy ở trên, mỗi microservice sẽ thực hiện một chức năng cụ thể, riêng biệt và chạy độc lập với nhau trên các server được deployment riêng rẽ. 

Quay lai bài toán bán hang ở trên, thay vì gom một đống chức năng vô một hệ thống , bạn A có thể tách các chức năng thành nhiều phần lẻ khác nhau ( order, payment, deliver, customer care, … )

Và đừng quên, bất kì hệ thống nào cũng đều có ưu nhược điểm
## 2.1. Ưu và nhược điểm
#### 2.1.1: Ưu điểm
- Tính Linh Hoạt (Flexibility):
•Microservice cho phép các dịch vụ được phát triển, triển khai và mở rộng độc lập, giúp tăng tính linh hoạt trong việc quản lý và phát triển ứng dụng.
•Các nhóm phát triển có thể chịu trách nhiệm cho các dịch vụ riêng biệt, tăng khả năng phát triển đồng thời và giảm thời gian lên kế hoạch.
-Tính Tích Hợp Dễ Dàng (Easy Integration):
•Microservice cho phép tích hợp và kết nối với các hệ thống và dịch vụ bên ngoài một cách dễ dàng hơn.
•Mỗi dịch vụ có thể được xây dựng bằng ngôn ngữ và công nghệ phù hợp nhất cho nhiệm vụ cụ thể của nó.
-Khả Năng Mở Rộng (Scalability):
•	Có thể mở rộng mỗi dịch vụ microservice độc lập, chỉ cần tăng cường tài nguyên (scale) cho dịch vụ đó mà không ảnh hưởng đến các dịch vụ khác.
-Dễ Dàng Triển Khai và Quản Lý (Easy Deployment and Management):
•	Microservice cho phép triển khai liên tục và tự động hóa quy trình triển khai và vận hành.
#### 2.1.2. Nhược điểm:
-Phức tạp hóa quản lý: 
Microservices tạo ra nhiều dịch vụ nhỏ độc lập, mỗi dịch vụ có thể được xây dựng, triển khai và quản lý một cách độc lập. Tuy nhiên, điều này cũng tạo ra một môi trường phức tạp hơn cho việc quản lý và vận hành. Cần có các công cụ và quy trình quản lý phức tạp để giám sát, gỡ lỗi, triển khai và mở rộng các dịch vụ.
Tăng chi phí vận hành: Mặc dù microservices có thể giúp giảm thiểu chi phí phát triển, nhưng chi phí vận hành có thể tăng lên do việc triển khai và quản lý nhiều dịch vụ khác nhau. Hệ thống vận hành cần có khả năng tự động hóa và công cụ giám sát mạnh mẽ để giảm thiểu những áp lực này.


Và có 1 bài toán cần lưu ý là ta cần đảm bảo tính consistency và accuracy cho dữ liệu thông qua distributed transaction. Và một trong những cách để đảm bảo consen**sus ( đồng thuận) trong hệ thống two-phase commit.

## 3. Two phase commit  (2pc)
Two phase commit ( 2pc) là thuật toán để đảm bảo tính **consistency** ( nhất quán) thông qua việc thực hiện **atomic transaction commit** ( giao dịch nguyên tử ) trải trên nhiều node. Bằng cách này, mỗi transaction luôn được đảm bảo **success** hoặc **rollback** lại toàn bộ. 


Một node sẽ đóng vai là **coordinator** ( người điều phối ). Chúng ta sẽ chia ra làm 2 giai đoạn:

1. Giai đoạn chuẩn bị (Prepare Phase): **coordinator** sẽ hỏi các node xem chúng có sẵn sàng thực hiện giao dịch hay chưa.
2. Giai đoạn thực hiện (Commit Phase hoặc Abort Phase): Sau khi tất cả các nút đã chuẩn bị xong, quản lý sẽ gửi một tin nhắn "xác nhận" (commit message) cho tất cả các nút để yêu cầu họ thực hiện giao dịch. Nếu tất cả các nút đều đồng ý thực hiện giao dịch, họ sẽ thực hiện nó và thông báo cho quản lý khi đã hoàn thành. Ngược lại, nếu có bất kỳ vấn đề gì xảy ra (ví dụ: một nút không thể thực hiện giao dịch), các nút có thể từ chối thực hiện và thông báo cho quản lý.

Lý thuyết đủ rồi, mình đi vào ví dụ cho dễ nhìn nhé: 
 
Chúng ta có hai giao dịch **Txn Credit & Txn Debit**. Txn Credit chạy trên Shard A & Txn Debit tương ứng chạy trên Shard B. Khách hàng bắt đầu cả hai giao dịch và gửi chúng đến hai phân đoạn. Sơ đồ dưới đây minh họa quá trình này. Cả hai máy chủ cơ sở dữ liệu đều bắt đầu thực hiện giao dịch.

Sau đó, khách hàng gửi một tin nhắn **commit** đến **coordinator**. **commit** giao dịch hiện được **coordinator** giao dịch chia thành hai giai đoạn.

Trong giai đoạn đầu tiên, **request commit** được gửi đến tất cả các máy chủ của **coordinator**. Mọi máy chủ phải phản hồi thông báo này bằng thông báo OK hoặc FAIL. Máy chủ trả lời bằng OK nếu nó có thể thực hiện giao dịch thành công. Thông báo FAIL sẽ được trả về nếu có bất kỳ lỗi nào trong quá trình thực thi. Ví dụ: Nếu số dư tài khoản bị âm trong quá trình giao dịch ghi nợ.

**Coordinator** chờ phản hồi từ tất cả các máy chủ. Sau khi nhận được phản hồi, nó sẽ quyết định **commit** hoặc **abort** và **rollback** giao dịch. Điều này trở thành giai đoạn thứ hai của **commit**. Giao dịch sẽ chỉ được thực hiện nếu mọi máy chủ trả lời bằng thông báo **OK**. Nếu ít nhất một máy chủ phản hồi bằng thông báo **FAIL**, giao dịch sẽ bị hủy bỏ.
 
Trong trường hợp Thông báo **FAIL**, **coordinator** sẽ gửi thông báo hủy bỏ cho tất cả những **coordinator**. Kết quả là, các giao dịch riêng lẻ sẽ quay về trạng thái ban đầu.

Quá trình trên đảm bảo **atomicity** của **distributed transaction** trải trê nhiều node. Giao dịch sẽ được thực hiện trên tất cả các máy chủ hoặc được khôi phục trên tất cả.

### 3.1 Hạn chế của 2 phase commit
Tất nhiên, không có gì là hoàn hảo cả. Cái gì cũng có 2 mặt của nó, đây là những hạn chế của **2-PC** : 
- Độ trễ: Như chúng ta đã thấy coordinator chờ phản hồi từ tất cả các máy chủ của **coordinator**. Chỉ sau đó nó mới tiếp tục với giai đoạn thứ hai commit. Điều này làm tăng độ trễ và khách hàng có thể gặp phải tình trạng thực thi chậm. Do đó, **2-PC** không phải là lựa chọn tốt cho các ứng dụng quan trọng về hiệu năng.

- important of coordinator: coordinator trở thành **single point of failture (SPOF)**. Coordinator hoàn toàn có thể bị sập hoặc gặp lỗi, trong những trường hợp như vậy, tất cả các **transaction** đang chạy sẽ bị chặn. Họ sẽ chỉ action khi điều phối viên xuất hiện và gửi tín hiệu. Tất nhiên chúng ta có thể giải quyết bằng deploy multiple instances.

- Sự phụ thuộc của coordinator: **coordinator** chậm ảnh hưởng đến hiệu suất chung. Tổng thời gian giao dịch tỷ lệ thuận với thời gian của máy chủ chậm nhất. Nếu giao dịch không thành công trên một máy chủ, nó phải được khôi phục trên tất cả các máy chủ khác. Điều này có thể dẫn đến lãng phí tài nguyên.

Vậy khi nào nên dùng 2 phase commit ? sẽ có ở bài sau 

## Conclusion

Kết hợp giữa kiến trúc **microservice** và **2PC** sẽ mang lại sự cân bằng giữa tính linh hoạt và tính nhất quán trong việc xây dựng và triển khai các hệ thống phân tán. Sự kết hợp này giúp giải quyết các thách thức liên quan đến tính nhất quán của dữ liệu và giao dịch trong một môi trường microservice phức tạp, đồng thời tạo ra một nền tảng vững chắc cho việc phát triển các ứng dụng phân tán trong tương lai.

Ref: 
1.https://www.openlegacy.com/blog/monolithic-application
2. https://www.xme.digital/post/xme-advice-is-it-worth-moving-from-monolithic-to-microservices-architecture
3. https://medium.com/geekculture/distributed-transactions-two-phase-commit-c82752d69324
