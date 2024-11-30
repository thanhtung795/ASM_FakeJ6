let app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    $scope.cart = {
        items: [],
        add(id) {
            var item = this.items.find(item => item.id === id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        remove(id) {
            var index = this.items.findIndex(item => item.id === id);
            if (this.items[index].qty <= 1) {
                this.items.splice(index, 1);
                this.saveToLocalStorage();
            } else {
                this.items[index].qty -= 1;
                this.saveToLocalStorage();
            }

        },
        clear() {
            this.items = []
            this.saveToLocalStorage();
        },
        // thanh tien 1 sp
        amt_of(item) {
        },
        // tong so luong sp trong gio hang
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        // tong tien cac mat hang trong gio hang
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },

        // luu gio hang vao
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }

    $scope.cart.loadFromLocalStorage();

    $scope.order = {
        createDate: new Date(),
        address: "",
        account: {username: $("#username").text()},
        paymentMethod: "",
        status: "PENDING",
        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {
                    product: {id: item.id},
                    price: item.price,
                    quantity: item.qty
                }
            })
        },
        purchase() {
            var order = angular.copy(this);
            if (order.paymentMethod.valueOf() === "") {
                alert("Vui lồng chọn phuong thuc thanh toan")
                return
            }
            if (order.paymentMethod.valueOf() === "CASH") {
                $http.post("/rest/orders", order).then(resp => {
                    alert("Đặt hàng thành công")
                    $scope.cart.clear();
                    location.href = "/order/detail/" + resp.data.id;
                }).catch(error => {
                    alert("Đặt hàng lỗi")
                    console.log(error)
                })
            }
            if (order.paymentMethod.valueOf() === "BANK_TRANSFER") {
                const amount = $scope.cart.amount;  // Lấy giá trị amount từ cart

                // Kiểm tra xem amount có hợp lệ không
                if (!amount || amount <= 0) {
                    alert("Số tiền thanh toán không hợp lệ.");
                    return;  // Dừng lại nếu amount không hợp lệ
                }

                // Gửi yêu cầu POST để lưu đơn hàng
                $http.post("/rest/orders", order).then(resp => {
                    $scope.cart.clear();
                    // Sau khi lưu đơn hàng, chuyển hướng người dùng đến trang thanh toán
                    $http.get("/api/payment/vnpay?amount=" + amount + "&orderId=" + resp.data.id).then(resp => {
                        window.location.href = resp.data.url;  // Chuyển hướng tới URL thanh toán
                    }).catch(error => {
                        alert("Lỗi khi tạo yêu cầu thanh toán");
                        console.log(error);
                    });
                }).catch(error => {
                    alert("Đặt hàng lỗi");
                    console.log(error);
                });
            }
        }
    }
})