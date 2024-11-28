app.controller("report-ctrl", function ($scope, $http) {
    $scope.items = []; // Danh sách toàn bộ dữ liệu từ server
    $scope.pageSize = 5; // Số mục trên mỗi trang

    // Khởi tạo dữ liệu
    $scope.initialize = function () {
        // Gửi yêu cầu đến server để lấy danh sách tài khoản
        $http.get("/rest/accounts/getHighestSpendingCustomers").then(resp => {
            try {
                $scope.items = resp.data; // Gán dữ liệu từ server vào items
                console.log($scope.items);

                // Kiểm tra nếu không có dữ liệu
                if ($scope.items.length > 0) {
                    let categories = $scope.items.map(item => item.fullname);
                    let totals = $scope.items.map(item => item.total);

                    // Tạo biểu đồ
                    $scope.chart(categories, totals);
                    $scope.paper.count = Math.ceil($scope.items.length / $scope.pageSize); // Tính tổng số trang
                    $scope.loadPage(); // Tải trang đầu tiên
                }
            } catch (error) {
                console.log("Error", error);
            }
        });
    };

    $scope.chart = function (categories, values) {
        // Ensure the element exists before initializing
        const chartDom = document.getElementById('main-chart');
        if (!chartDom) {
            console.error('Chart container element not found');
            return;
        }

        // Check if ECharts is properly loaded
        if (typeof echarts === 'undefined') {
            console.error('ECharts library not loaded');
            return;
        }

        try {
            const myChart = echarts.init(chartDom);

            const option = {
                title: {
                    text: 'Top Spending Customers'
                },
                tooltip: {},
                xAxis: {
                    type: 'category',
                    data: categories,
                    axisLabel: {
                        rotate: 45 // Rotate labels if they are long
                    }
                },
                yAxis: {
                    type: 'value',
                    name: 'Total Spending'
                },
                series: [
                    {
                        name: 'Total',
                        data: values,
                        type: 'bar',
                        itemStyle: {
                            color: '#3398DB'
                        }
                    }
                ]
            };

            myChart.setOption(option);
        } catch (error) {
            console.error('Error creating chart:', error);
        }
    };

    // Xử lý phân trang
    $scope.paper = {
        items: [], // Danh sách sản phẩm của trang hiện tại
        page: 0, // Trang hiện tại (bắt đầu từ 0)
        count: 1, // Tổng số trang (tính khi dữ liệu đã tải)
        first: function () {
            this.page = 0; // Chuyển đến trang đầu
            $scope.loadPage();
        },
        prev: function () {
            if (this.page > 0) {
                this.page--; // Quay về trang trước
                $scope.loadPage();
            }
        },
        next: function () {
            if (this.page < this.count - 1) {
                this.page++; // Chuyển đến trang sau
                $scope.loadPage();
            }
        },
        last: function () {
            this.page = this.count - 1; // Chuyển đến trang cuối
            $scope.loadPage();
        }
    };

    // Hàm tải dữ liệu của trang hiện tại
    $scope.loadPage = function () {
        // Xác định index bắt đầu và kết thúc cho trang hiện tại
        const start = $scope.paper.page * $scope.pageSize;
        const end = start + $scope.pageSize;
        $scope.paper.items = $scope.items.slice(start, end); // Lấy dữ liệu trang hiện tại
        console.log(`Loading page ${$scope.paper.page + 1}`);
    };

    // Gọi hàm khởi tạo
    $scope.initialize();
});
