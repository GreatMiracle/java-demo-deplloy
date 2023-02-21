app.controller("authority-ctrl",function($scope,$http,$location){
    $scope.roles=[];
    $scope.admins=[];
    $scope.authorities=[];

    $scope.initialize = function(){
        //tim cac role
        $http.get("/rest/roles").then(resp => {
            $scope.roles=resp.data;

        })
        //tim theo  nhan vien va giam doc
        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admins=resp.data;
        })
        //
        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities=resp.data;
        })

            .catch(error => {
                $location.path("/unauthorized");
                swal("ERROR","Bạn không có đủ thẩm quyền để vào mục này" ,"error")
            })

    }

    $scope.initialize();
    $scope.authority_of = function (acc,role){
        if ($scope.authorities){

            return $scope.authorities.find(ur => ur.account.username === acc.username && ur.role.id===role.id );
        }else {
            $location.path("/unauthorized");
        }
    }

    $scope.authority_changed= function (acc,role){
        var authority=$scope.authority_of(acc,role);
        if (authority){
            $scope.revoke_authority(authority);
        }
        else {
            authority={account:  acc,role:role};
            $scope.grant_authority(authority);
        }
    }


    $scope.revoke_authority = function(authority){
        $http.delete(`/rest/authorities/${authority.id}`).then(resp =>{
            var index = $scope.authorities.findIndex(a => a.id === authority.id);
            $scope.authorities.splice(index, 1);
            swal("Thành công!", "Bạn đã thu hồi quyền!", "success");
        }).catch(error =>{
            swal("Lỗi!", "Thu hồi quyền thất bại!", "error");
            console.log("ERROR" ,error);
        })
    }
    $scope.grant_authority = function (authority){
        $http.post(`/rest/authorities`,authority).then(resp =>{
            $scope.authorities.push(resp.data)
            swal("Success!!", "Cấp quyền thành công!", "success");
        }).catch(error =>{
            swal("Lỗi!", "Cấp quyền thất bại!", "error");
            console.log("ERROR : " ,error)
        })
    }
})