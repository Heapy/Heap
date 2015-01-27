(function() {
    var app = angular.module("natrus.bookmarks", []);

    app.directive("smartBookmarksList", ["$log", "$http", function($log, $http) {
        return {
            restrict: "C",
            templateUrl: "app/bookmarks/bookmarks-list.html",
            controller: function() {
                var that = this;
                this.bookmarks = [];

                $http.get("http://localhost:8808/api/http://localhost:8080/bookmarks/")
                    .success(function(data) {
                        that.bookmarks = data;
                    });
            },
            controllerAs: "bookmark"
        };
    }]);

    //app.directive("bookmarksSearch", ["$log", "$http", function($log, $http) {
    //    return {
    //        restrict: "E",
    //        templateUrl: "app/bookmarks/bookmarks-list.html",
    //        controller: function() {
    //            var that = this;
    //            this.bookmarks = [];
    //
    //            $http.get("http://localhost:8808/api/http://localhost:8080/bookmarks/")
    //                .success(function(data) {
    //                    that.bookmarks = data;
    //                });
    //
    //            var data = {title: "Title", url: "lol", note: "note", tags: [{name: "Test", bookmarks: []}]};
    //
    //            $http.post("http://localhost:8808/api/http://localhost:8080/bookmarks/", data);
    //        },
    //        controllerAs: "bookmark"
    //    };
    //}]);


    app.directive("newBookmarkForm", ["$log", "$http", function($log, $http) {
        return {
            restrict: "C",
            templateUrl: "app/bookmarks/new-bookmark-form.html",
            controller: function() {

                this.newBookmark = {title: "Title", url: "lol", note: "note", tags: [{name: "Test"}, {name: "Other"}]};

                //
            },
            link: function($scope, element, attrs) {
                $scope.submit = function(){
                    $http.post("http://localhost:8808/api/http://localhost:8080/bookmarks/", this.bookmarkForm.newBookmark);
                }
            },
            controllerAs: "bookmarkForm"
        };
    }]);

    app.directive("addNote", ["$log", "$http", function($log, $http) {
        return {
            restrict: "E",
            templateUrl: "app/bookmarks/add-note.html",
            controller: function() {


                //var data = {title: "Title", url: "lol", note: "note", tags: [{name: "Test", bookmarks: []}]};

                //$http.post("http://localhost:8808/api/http://localhost:8080/bookmarks/", data);
            },
            controllerAs: "note"
        };
    }]);

})();