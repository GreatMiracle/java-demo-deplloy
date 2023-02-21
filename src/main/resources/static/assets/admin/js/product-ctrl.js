app.controller("product-ctrl", function($scope, $http){
    $scope.items= [];
    $scope.cates=[];
    $scope.form={};

    $scope.initialize = function(){
        $http.get("/rest/products").then(resp =>{
            $scope.items = resp.data;
            $scope.items.forEach(item =>{
                item.createDate = new Date(item.createDate)
            })
        })
        //load product
        //load categories
        $http.get("/rest/categories").then(resp =>{
            $scope.cates = resp.data;
        })
    };
    //START
    $scope.initialize();

    //Xóa form
    $scope.reset=function(){
        $scope.form={
            createDate: new Date(),
            image:'cloud-upload.jpg',
            available:true,

        }
    }
    //Hiển thị lên form
    $scope.edit=function(item){
        $scope.form=angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }
    //Thêm sản phẩm
    $scope.create=function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/products`,item).then(resp =>{
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            swal("Success!", "Thêm mới thành công", "success");
        }).catch(error =>{
            swal("Error!", "Thêm mới thất bại", "error");
            console.log("Error: ",error);
        });
    }
    //Cập nhật sản phẩm
    $scope.update=function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            swal("Success!", "Cập nhật thành công", "success");
        })
            .catch(error => {
                swal("Error!", "Cập nhật thất bại", "error");
                console.log("Error", error);
            })
        }
    //Xóa sản phẩm
    $scope.delete=function(item){

        $http.delete(`/rest/products/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            swal("Success!", "Xóa thành công", "success");
        })
            .catch(error => {
                swal("Error!", "Xóa thất bại", "error");
                console.log("Error", error);
            })
    }
    $scope.imageChanged=function(files){
        var data= new FormData();
        data.append('file',files[0]);
        $http.post('/rest/upload/images',data,{
            transformRequest: angular.identity,
            headers:{'Content-Type':undefined}
        }).then(rest =>{
            $scope.form.image = rest.data.name;
        }).catch(error =>{
            swal("Error!", "Lỗi upload hình ảnh", "error");
            console.log("Error",error);
        })
    }
    $scope.pager={
        page:0,
        size:10,
        get items(){
            const start= this.page*this.size;
            console.log(start)
            return  $scope.items.slice(start,start+this.size);
        },
        get count(){
            return Math.ceil(1.0*$scope.items.length/this.size)
        },
        first(){
            this.page=0;
        },
        prev(){
            this.page--;
            if (this.page<0){
                this.last();
            }
        },
        next(){
            this.page++;
            if (this.page>=this.count){
                this.first();
            }
        },
        last(){
            this.page=this.count-1;
        }
    }
})