const app=angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl", function($scope,$http){

    $scope.cart= {
        items: [],
        //THêm sản phẩm vào giỏ hàng
        add(id) {
            var item = this.items.find(item => item.id === id);

            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                var link = "/rest/products/" + id;
                $http.get(link).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    swal("Success","Thêm vào giỏ hàng thành công" ,"success")
                    this.saveToLocalStorage();

                })
            }
        },
        //Xóa sản phẩm khỏi giỏ hàng
        remove(id) {
            console.log("Removing item: " + id);
            var index = this.items.findIndex(item => item.id === id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
            swal("ERROR","Gỡ thành công" ,"error")
        },
        //Xóa sạch các mặt hàng trong giỏ hàng
        clear() {
            this.items = [];
            this.saveToLocalStorage();
        },
        //tÍNH THÀNH TIỀN CỦA 1 SẢN PHẨM
        amt_of(item) {
        },
        //Tính tổng số lượng các mặt hàng trong giỏ
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0)
        },
        //Tổng thành tiền các mặt hàng trong giỏ
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0)
        },
        //Lưu giỏ hàng vào trong Local Storage
        saveToLocalStorage() {

            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);

        },
        //Đọc giỏ hàng vào trong Local Storage
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart")
            this.items = json ? JSON.parse(json) : [];
        }

    }

    $scope.cart.loadFromLocalStorage();

    $scope.order={
        createDate: new Date(),
        address:"",
        account: {username: $("#username").text()},

        get orderDetails(){
            return $scope.cart.items.map(item =>{
                return{
                    product:{id:item.id},
                    price: item.price,
                    quantity: item.qty
                }
            })
        },
        purchase(){
            var order = angular.copy(this);
            //Thực hiện đặt hàng


            if (order.orderDetails.length<=0){
                alert("Chưa có mặt hàng nào")
                location.href="/home/index"
            }else {
            $http.post("/rest/orders",order).then(resp =>{
                alert("Đặt hàng thành công")
                $scope.cart.clear();
                location.href = "/order/detail/"+resp.data.id;
            }).catch(error =>{
                alert("Đặt hàng lỗi")
                console.log(error);
            })
            }
        }
    }

})